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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.AlaDoubleStateImageView;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class d {
    private IShareCallback hng;
    private View hsq;
    private AlaDoubleStateImageView hsr;
    private AlaDoubleStateImageView hss;
    private AlaDoubleStateImageView hst;
    private AlaDoubleStateImageView hsu;
    private View hsv;
    private TextView hsw;
    private int hsx = -1;
    private Runnable hsy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.cgC();
        }
    };
    private View.OnClickListener hsz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hsr.isSelected();
                d.this.hsr.setSelect(z2);
                d.this.hss.setSelect(false);
                d.this.hst.setSelect(false);
                d.this.hsu.setSelect(false);
                d.this.nL(false);
                if (z2) {
                    d.this.hsx = 1;
                    d.this.hsr.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hsr);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hsx = -1;
                d.this.cgC();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hss.isSelected() ? false : true;
                d.this.hss.setSelect(z);
                d.this.hsr.setSelect(false);
                d.this.hst.setSelect(false);
                d.this.hsu.setSelect(false);
                d.this.nL(false);
                if (z) {
                    d.this.hsx = 2;
                    d.this.hss.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hss);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hsx = -1;
                d.this.cgC();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hst.isSelected();
                d.this.hst.setSelect(z3);
                d.this.hsr.setSelect(false);
                d.this.hss.setSelect(false);
                d.this.hsu.setSelect(false);
                d.this.nL(true);
                if (z3) {
                    d.this.hsx = 3;
                    d.this.hst.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hst);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hsx = -1;
                d.this.cgC();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hsu.isSelected() ? false : true;
                d.this.hsu.setSelect(z);
                d.this.hsr.setSelect(false);
                d.this.hst.setSelect(false);
                d.this.hss.setSelect(false);
                d.this.nL(false);
                if (z) {
                    d.this.hsx = 4;
                    d.this.hsu.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hsu);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hsx = -1;
                d.this.cgC();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.d.Aq().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.d.Aq().putBoolean(str, false);
            return;
        }
        cgC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nL(boolean z) {
        this.hsv.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cgA();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void l(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cl(View view) {
        this.hsq = view;
        this.hsr = (AlaDoubleStateImageView) this.hsq.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hsr.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hsr.setOnClickListener(this.hsz);
        this.hss = (AlaDoubleStateImageView) this.hsq.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hss.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hss.setOnClickListener(this.hsz);
        this.hst = (AlaDoubleStateImageView) this.hsq.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hst.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hst.setOnClickListener(this.hsz);
        this.hsu = (AlaDoubleStateImageView) this.hsq.findViewById(a.f.ala_prepare_share_img_qq);
        this.hsu.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hsu.setOnClickListener(this.hsz);
        switch (this.hsx) {
            case 1:
                this.hsr.setSelect(true);
                break;
            case 2:
                this.hss.setSelect(true);
                break;
            case 3:
                this.hst.setSelect(true);
                break;
            case 4:
                this.hsu.setSelect(true);
                break;
        }
        this.hsv = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hsw = (TextView) this.hsv.findViewById(a.f.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.hng = iShareCallback;
    }

    public boolean caG() {
        return this.mShareChannel != null && this.hsx >= 1 && this.hsx <= 4;
    }

    public void y(String str, String str2, String str3, String str4) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.h.share_on_no_network);
            return;
        }
        if (this.mShareChannel == null) {
            this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        }
        if (this.mShareChannel == null) {
            this.mPageContext.showToast(a.h.share_no_channel);
            return;
        }
        ShareEntity HX = HX(str);
        if (HX != null) {
            switch (this.hsx) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            HX.content = str3.replace("直播标题", str2);
                        } else {
                            HX.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        HX.title = "腻害了";
                    }
                    a(HX);
                    return;
                case 2:
                    HX.content = str2;
                    HX.title = str4;
                    b(HX);
                    return;
                case 3:
                    HX.content = str2;
                    HX.title = str4;
                    c(HX);
                    return;
                case 4:
                    HX.content = str2;
                    HX.title = str4;
                    d(HX);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity HX(String str) {
        String str2;
        ShareEntity shareEntity = new ShareEntity();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getCurrentPortrait();
            if (TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                str = TbadkCoreApplication.getInst().getBigHeaderPhotoUrlPrefix() + str + ".jpg";
            }
        }
        String shareUrl = getShareUrl();
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccount);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uk=" + encryptionUserId;
        } else {
            str2 = shareUrl + "?uk=" + encryptionUserId;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.hsx;
        return shareEntity;
    }

    private String getShareUrl() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return "https://haokan.baidu.com/haokan/wisesharelive";
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return "https://haokan.baidu.com/haokan/wisesharelive?source=mvideo&pd=mvideo";
        }
        return "http://tieba.baidu.com/ala/share/index";
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hng);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hng);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hng);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hng);
    }

    private void cgA() {
        this.hsx = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        cgB();
        if (this.hsv.getParent() != null) {
            ((ViewGroup) this.hsv.getParent()).removeView(this.hsv);
        }
        this.mRootView.addView(this.hsv);
        this.hsv.setVisibility(4);
        this.hsv.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hsv.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hsv.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hsv.setLayoutParams(layoutParams);
                    d.this.hsv.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hsy);
        this.mHandler.postDelayed(this.hsy, 5000L);
    }

    private void cgB() {
        String str = null;
        switch (this.hsx) {
            case 1:
                str = this.mPageContext.getPageActivity().getString(a.h.ala_share_tip_sina_weibo);
                break;
            case 2:
                str = this.mPageContext.getPageActivity().getString(a.h.ala_share_tip_weixin);
                break;
            case 3:
                str = this.mPageContext.getPageActivity().getString(a.h.ala_share_tip_weixin_circle);
                break;
            case 4:
                str = this.mPageContext.getPageActivity().getString(a.h.ala_share_tip_qq);
                break;
        }
        this.hsw.setText(str);
    }

    public void cgC() {
        if (this.hsv.getParent() != null) {
            ((ViewGroup) this.hsv.getParent()).removeView(this.hsv);
        }
    }

    public void cgD() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hsx);
    }

    public void release() {
        this.hsx = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
