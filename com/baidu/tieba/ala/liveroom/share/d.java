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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class d {
    private IShareCallback fcC;
    private View fhc;
    private AlaDoubleStateImageView fhd;
    private AlaDoubleStateImageView fhe;
    private AlaDoubleStateImageView fhf;
    private AlaDoubleStateImageView fhg;
    private View fhh;
    private TextView fhi;
    private int fhj = -1;
    private Runnable fhk = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.boM();
        }
    };
    private View.OnClickListener fhl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.fhd.isSelected();
                d.this.fhd.setSelect(z2);
                d.this.fhe.setSelect(false);
                d.this.fhf.setSelect(false);
                d.this.fhg.setSelect(false);
                d.this.jJ(false);
                if (z2) {
                    d.this.fhj = 1;
                    d.this.fhd.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.fhd);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.fhj = -1;
                d.this.boM();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.fhe.isSelected() ? false : true;
                d.this.fhe.setSelect(z);
                d.this.fhd.setSelect(false);
                d.this.fhf.setSelect(false);
                d.this.fhg.setSelect(false);
                d.this.jJ(false);
                if (z) {
                    d.this.fhj = 2;
                    d.this.fhe.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.fhe);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.fhj = -1;
                d.this.boM();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.fhf.isSelected();
                d.this.fhf.setSelect(z3);
                d.this.fhd.setSelect(false);
                d.this.fhe.setSelect(false);
                d.this.fhg.setSelect(false);
                d.this.jJ(true);
                if (z3) {
                    d.this.fhj = 3;
                    d.this.fhf.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.fhf);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.fhj = -1;
                d.this.boM();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.fhg.isSelected() ? false : true;
                d.this.fhg.setSelect(z);
                d.this.fhd.setSelect(false);
                d.this.fhf.setSelect(false);
                d.this.fhe.setSelect(false);
                d.this.jJ(false);
                if (z) {
                    d.this.fhj = 4;
                    d.this.fhg.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.fhg);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.fhj = -1;
                d.this.boM();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.oJ().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.oJ().putBoolean(str, false);
            return;
        }
        boM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        this.fhh.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        boK();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void am(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bA(View view) {
        this.fhc = view;
        this.fhd = (AlaDoubleStateImageView) this.fhc.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.fhd.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.fhd.setOnClickListener(this.fhl);
        this.fhe = (AlaDoubleStateImageView) this.fhc.findViewById(a.g.ala_prepare_share_img_weixin);
        this.fhe.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.fhe.setOnClickListener(this.fhl);
        this.fhf = (AlaDoubleStateImageView) this.fhc.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.fhf.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.fhf.setOnClickListener(this.fhl);
        this.fhg = (AlaDoubleStateImageView) this.fhc.findViewById(a.g.ala_prepare_share_img_qq);
        this.fhg.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.fhg.setOnClickListener(this.fhl);
        switch (this.fhj) {
            case 1:
                this.fhd.setSelect(true);
                break;
            case 2:
                this.fhe.setSelect(true);
                break;
            case 3:
                this.fhf.setSelect(true);
                break;
            case 4:
                this.fhg.setSelect(true);
                break;
        }
        this.fhh = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.fhi = (TextView) this.fhh.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.fcC = iShareCallback;
    }

    public boolean bjS() {
        return this.mShareChannel != null && this.fhj >= 1 && this.fhj <= 4;
    }

    public void s(String str, String str2, String str3, String str4) {
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
        ShareEntity zb = zb(str);
        if (zb != null) {
            switch (this.fhj) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            zb.content = str3.replace("直播标题", str2);
                        } else {
                            zb.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        zb.title = "腻害了";
                    }
                    a(zb);
                    return;
                case 2:
                    zb.content = str2;
                    zb.title = str4;
                    b(zb);
                    return;
                case 3:
                    zb.content = str2;
                    zb.title = str4;
                    c(zb);
                    return;
                case 4:
                    zb.content = str2;
                    zb.title = str4;
                    d(zb);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity zb(String str) {
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
        String zc = zc(currentAccountName);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uname=" + zc;
        } else {
            str2 = shareUrl + "?uname=" + zc;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.fhj;
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

    private String zc(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.fcC);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.fcC);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.fcC);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.fcC);
    }

    private void boK() {
        this.fhj = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        boL();
        if (this.fhh.getParent() != null) {
            ((ViewGroup) this.fhh.getParent()).removeView(this.fhh);
        }
        this.mRootView.addView(this.fhh);
        this.fhh.setVisibility(4);
        this.fhh.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fhh.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.fhh.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.fhh.setLayoutParams(layoutParams);
                    d.this.fhh.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.fhk);
        this.mHandler.postDelayed(this.fhk, 5000L);
    }

    private void boL() {
        String str = null;
        switch (this.fhj) {
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
        this.fhi.setText(str);
    }

    public void boM() {
        if (this.fhh.getParent() != null) {
            ((ViewGroup) this.fhh.getParent()).removeView(this.fhh);
        }
    }

    public void boN() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.fhj);
    }

    public void release() {
        this.fhj = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
