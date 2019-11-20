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
    private IShareCallback ejA;
    private AlaDoubleStateImageView enA;
    private View enB;
    private TextView enC;
    private View enw;
    private AlaDoubleStateImageView enx;
    private AlaDoubleStateImageView eny;
    private AlaDoubleStateImageView enz;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;
    private int enD = -1;
    private Runnable enE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.aVX();
        }
    };
    private View.OnClickListener enF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.enx.isSelected();
                d.this.enx.setSelect(z2);
                d.this.eny.setSelect(false);
                d.this.enz.setSelect(false);
                d.this.enA.setSelect(false);
                d.this.ih(false);
                if (z2) {
                    d.this.enD = 1;
                    d.this.enx.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.enx);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.enD = -1;
                d.this.aVX();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.eny.isSelected() ? false : true;
                d.this.eny.setSelect(z);
                d.this.enx.setSelect(false);
                d.this.enz.setSelect(false);
                d.this.enA.setSelect(false);
                d.this.ih(false);
                if (z) {
                    d.this.enD = 2;
                    d.this.eny.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.eny);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.enD = -1;
                d.this.aVX();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.enz.isSelected();
                d.this.enz.setSelect(z3);
                d.this.enx.setSelect(false);
                d.this.eny.setSelect(false);
                d.this.enA.setSelect(false);
                d.this.ih(true);
                if (z3) {
                    d.this.enD = 3;
                    d.this.enz.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.enz);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.enD = -1;
                d.this.aVX();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.enA.isSelected() ? false : true;
                d.this.enA.setSelect(z);
                d.this.enx.setSelect(false);
                d.this.enz.setSelect(false);
                d.this.eny.setSelect(false);
                d.this.ih(false);
                if (z) {
                    d.this.enD = 4;
                    d.this.enA.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.enA);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.enD = -1;
                d.this.aVX();
            }
        }
    };
    private Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.np().getBoolean(str, true)) {
            d(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.np().putBoolean(str, false);
            return;
        }
        aVX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(boolean z) {
        this.enB.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        aVV();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void aj(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void by(View view) {
        this.enw = view;
        this.enx = (AlaDoubleStateImageView) this.enw.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.enx.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.enx.setOnClickListener(this.enF);
        this.eny = (AlaDoubleStateImageView) this.enw.findViewById(a.g.ala_prepare_share_img_weixin);
        this.eny.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.eny.setOnClickListener(this.enF);
        this.enz = (AlaDoubleStateImageView) this.enw.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.enz.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.enz.setOnClickListener(this.enF);
        this.enA = (AlaDoubleStateImageView) this.enw.findViewById(a.g.ala_prepare_share_img_qq);
        this.enA.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.enA.setOnClickListener(this.enF);
        switch (this.enD) {
            case 1:
                this.enx.setSelect(true);
                break;
            case 2:
                this.eny.setSelect(true);
                break;
            case 3:
                this.enz.setSelect(true);
                break;
            case 4:
                this.enA.setSelect(true);
                break;
        }
        this.enB = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.enC = (TextView) this.enB.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.ejA = iShareCallback;
    }

    public boolean aRF() {
        return this.mShareChannel != null && this.enD >= 1 && this.enD <= 4;
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
            switch (this.enD) {
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
        shareEntity.shareType = this.enD;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.ejA);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.ejA);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.ejA);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.ejA);
    }

    private void aVV() {
        this.enD = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void d(final int[] iArr, final int i, final int i2) {
        aVW();
        if (this.enB.getParent() != null) {
            ((ViewGroup) this.enB.getParent()).removeView(this.enB);
        }
        this.mRootView.addView(this.enB);
        this.enB.setVisibility(4);
        this.enB.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.enB.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.enB.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.enB.setLayoutParams(layoutParams);
                    d.this.enB.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.enE);
        this.mHandler.postDelayed(this.enE, 5000L);
    }

    private void aVW() {
        String str = null;
        switch (this.enD) {
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
        this.enC.setText(str);
    }

    public void aVX() {
        if (this.enB.getParent() != null) {
            ((ViewGroup) this.enB.getParent()).removeView(this.enB);
        }
    }

    public void aVY() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.enD);
    }

    public void release() {
        this.enD = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
