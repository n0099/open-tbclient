package com.baidu.tieba.ala.liveroom.share;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.view.AlaDoubleStateImageView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class d {
    private IShareCallback ekr;
    private View eon;
    private AlaDoubleStateImageView eoo;
    private AlaDoubleStateImageView eop;
    private AlaDoubleStateImageView eoq;
    private AlaDoubleStateImageView eor;
    private View eos;
    private TextView eot;
    private int eou = -1;
    private Runnable eov = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.aVZ();
        }
    };
    private View.OnClickListener eow = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.eoo.isSelected();
                d.this.eoo.setSelect(z2);
                d.this.eop.setSelect(false);
                d.this.eoq.setSelect(false);
                d.this.eor.setSelect(false);
                d.this.ih(false);
                if (z2) {
                    d.this.eou = 1;
                    d.this.eoo.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.eoo);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.eou = -1;
                d.this.aVZ();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.eop.isSelected() ? false : true;
                d.this.eop.setSelect(z);
                d.this.eoo.setSelect(false);
                d.this.eoq.setSelect(false);
                d.this.eor.setSelect(false);
                d.this.ih(false);
                if (z) {
                    d.this.eou = 2;
                    d.this.eop.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.eop);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.eou = -1;
                d.this.aVZ();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.eoq.isSelected();
                d.this.eoq.setSelect(z3);
                d.this.eoo.setSelect(false);
                d.this.eop.setSelect(false);
                d.this.eor.setSelect(false);
                d.this.ih(true);
                if (z3) {
                    d.this.eou = 3;
                    d.this.eoq.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.eoq);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.eou = -1;
                d.this.aVZ();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.eor.isSelected() ? false : true;
                d.this.eor.setSelect(z);
                d.this.eoo.setSelect(false);
                d.this.eoq.setSelect(false);
                d.this.eop.setSelect(false);
                d.this.ih(false);
                if (z) {
                    d.this.eou = 4;
                    d.this.eor.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.eor);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.eou = -1;
                d.this.aVZ();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.np().getBoolean(str, true)) {
            d(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.np().putBoolean(str, false);
            return;
        }
        aVZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(boolean z) {
        this.eos.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        aVX();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void aj(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void by(View view) {
        this.eon = view;
        this.eoo = (AlaDoubleStateImageView) this.eon.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.eoo.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.eoo.setOnClickListener(this.eow);
        this.eop = (AlaDoubleStateImageView) this.eon.findViewById(a.g.ala_prepare_share_img_weixin);
        this.eop.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.eop.setOnClickListener(this.eow);
        this.eoq = (AlaDoubleStateImageView) this.eon.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.eoq.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.eoq.setOnClickListener(this.eow);
        this.eor = (AlaDoubleStateImageView) this.eon.findViewById(a.g.ala_prepare_share_img_qq);
        this.eor.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.eor.setOnClickListener(this.eow);
        switch (this.eou) {
            case 1:
                this.eoo.setSelect(true);
                break;
            case 2:
                this.eop.setSelect(true);
                break;
            case 3:
                this.eoq.setSelect(true);
                break;
            case 4:
                this.eor.setSelect(true);
                break;
        }
        this.eos = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.eot = (TextView) this.eos.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.ekr = iShareCallback;
    }

    public boolean aRH() {
        return this.mShareChannel != null && this.eou >= 1 && this.eou <= 4;
    }

    public void q(String str, String str2, String str3, String str4) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.share_on_no_network);
            return;
        }
        if (this.mShareChannel == null) {
            this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        }
        if (this.mShareChannel == null) {
            this.mPageContext.showToast(a.i.share_no_channel);
            return;
        }
        ShareEntity ub = ub(str);
        if (ub != null) {
            switch (this.eou) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            ub.content = str3.replace("直播标题", str2);
                        } else {
                            ub.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        ub.title = "腻害了";
                    }
                    a(ub);
                    return;
                case 2:
                    ub.content = str2;
                    ub.title = str4;
                    b(ub);
                    return;
                case 3:
                    ub.content = str2;
                    ub.title = str4;
                    c(ub);
                    return;
                case 4:
                    ub.content = str2;
                    ub.title = str4;
                    d(ub);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity ub(String str) {
        String str2;
        ShareEntity shareEntity = new ShareEntity();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getCurrentPortrait();
            if (TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                str = TbadkCoreApplication.getInst().getBigHeaderPhotoUrlPrefix() + str + ".jpg";
            }
        }
        String shareUrl = getShareUrl();
        String uc = uc(currentAccountName);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uname=" + uc;
        } else {
            str2 = shareUrl + "?uname=" + uc;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.eou;
        return shareEntity;
    }

    private String getShareUrl() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return "https://haokan.baidu.com/haokan/wisesharelive";
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            return "https://haokan.baidu.com/haokan/wisesharelive?source=mvideo&pd=mvideo";
        }
        return "http://tieba.baidu.com/ala/share/index";
    }

    private String uc(String str) {
        try {
            return URLEncoder.encode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.ekr);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.ekr);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.ekr);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.ekr);
    }

    private void aVX() {
        this.eou = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void d(final int[] iArr, final int i, final int i2) {
        aVY();
        if (this.eos.getParent() != null) {
            ((ViewGroup) this.eos.getParent()).removeView(this.eos);
        }
        this.mRootView.addView(this.eos);
        this.eos.setVisibility(4);
        this.eos.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.eos.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.eos.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.eos.setLayoutParams(layoutParams);
                    d.this.eos.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.eov);
        this.mHandler.postDelayed(this.eov, 5000L);
    }

    private void aVY() {
        String str = null;
        switch (this.eou) {
            case 1:
                str = this.mPageContext.getPageActivity().getString(a.i.ala_share_tip_sina_weibo);
                break;
            case 2:
                str = this.mPageContext.getPageActivity().getString(a.i.ala_share_tip_weixin);
                break;
            case 3:
                str = this.mPageContext.getPageActivity().getString(a.i.ala_share_tip_weixin_circle);
                break;
            case 4:
                str = this.mPageContext.getPageActivity().getString(a.i.ala_share_tip_qq);
                break;
        }
        this.eot.setText(str);
    }

    public void aVZ() {
        if (this.eos.getParent() != null) {
            ((ViewGroup) this.eos.getParent()).removeView(this.eos);
        }
    }

    public void aWa() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.eou);
    }

    public void release() {
        this.eou = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
