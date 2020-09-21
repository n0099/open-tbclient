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
    private IShareCallback gHs;
    private View gLY;
    private AlaDoubleStateImageView gLZ;
    private AlaDoubleStateImageView gMa;
    private AlaDoubleStateImageView gMb;
    private AlaDoubleStateImageView gMc;
    private View gMd;
    private TextView gMe;
    private int gMf = -1;
    private Runnable gMg = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bYc();
        }
    };
    private View.OnClickListener gMh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.gLZ.isSelected();
                d.this.gLZ.setSelect(z2);
                d.this.gMa.setSelect(false);
                d.this.gMb.setSelect(false);
                d.this.gMc.setSelect(false);
                d.this.mI(false);
                if (z2) {
                    d.this.gMf = 1;
                    d.this.gLZ.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.gLZ);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.gMf = -1;
                d.this.bYc();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.gMa.isSelected() ? false : true;
                d.this.gMa.setSelect(z);
                d.this.gLZ.setSelect(false);
                d.this.gMb.setSelect(false);
                d.this.gMc.setSelect(false);
                d.this.mI(false);
                if (z) {
                    d.this.gMf = 2;
                    d.this.gMa.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.gMa);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.gMf = -1;
                d.this.bYc();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.gMb.isSelected();
                d.this.gMb.setSelect(z3);
                d.this.gLZ.setSelect(false);
                d.this.gMa.setSelect(false);
                d.this.gMc.setSelect(false);
                d.this.mI(true);
                if (z3) {
                    d.this.gMf = 3;
                    d.this.gMb.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.gMb);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.gMf = -1;
                d.this.bYc();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.gMc.isSelected() ? false : true;
                d.this.gMc.setSelect(z);
                d.this.gLZ.setSelect(false);
                d.this.gMb.setSelect(false);
                d.this.gMa.setSelect(false);
                d.this.mI(false);
                if (z) {
                    d.this.gMf = 4;
                    d.this.gMc.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.gMc);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.gMf = -1;
                d.this.bYc();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.AR().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.AR().putBoolean(str, false);
            return;
        }
        bYc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(boolean z) {
        this.gMd.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bYa();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void p(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bV(View view) {
        this.gLY = view;
        this.gLZ = (AlaDoubleStateImageView) this.gLY.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.gLZ.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.gLZ.setOnClickListener(this.gMh);
        this.gMa = (AlaDoubleStateImageView) this.gLY.findViewById(a.g.ala_prepare_share_img_weixin);
        this.gMa.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.gMa.setOnClickListener(this.gMh);
        this.gMb = (AlaDoubleStateImageView) this.gLY.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.gMb.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.gMb.setOnClickListener(this.gMh);
        this.gMc = (AlaDoubleStateImageView) this.gLY.findViewById(a.g.ala_prepare_share_img_qq);
        this.gMc.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.gMc.setOnClickListener(this.gMh);
        switch (this.gMf) {
            case 1:
                this.gLZ.setSelect(true);
                break;
            case 2:
                this.gMa.setSelect(true);
                break;
            case 3:
                this.gMb.setSelect(true);
                break;
            case 4:
                this.gMc.setSelect(true);
                break;
        }
        this.gMd = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gMe = (TextView) this.gMd.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.gHs = iShareCallback;
    }

    public boolean bSt() {
        return this.mShareChannel != null && this.gMf >= 1 && this.gMf <= 4;
    }

    public void w(String str, String str2, String str3, String str4) {
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
        ShareEntity GS = GS(str);
        if (GS != null) {
            switch (this.gMf) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            GS.content = str3.replace("直播标题", str2);
                        } else {
                            GS.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        GS.title = "腻害了";
                    }
                    a(GS);
                    return;
                case 2:
                    GS.content = str2;
                    GS.title = str4;
                    b(GS);
                    return;
                case 3:
                    GS.content = str2;
                    GS.title = str4;
                    c(GS);
                    return;
                case 4:
                    GS.content = str2;
                    GS.title = str4;
                    d(GS);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity GS(String str) {
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
        shareEntity.shareType = this.gMf;
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

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.gHs);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.gHs);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.gHs);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.gHs);
    }

    private void bYa() {
        this.gMf = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        bYb();
        if (this.gMd.getParent() != null) {
            ((ViewGroup) this.gMd.getParent()).removeView(this.gMd);
        }
        this.mRootView.addView(this.gMd);
        this.gMd.setVisibility(4);
        this.gMd.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gMd.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.gMd.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.gMd.setLayoutParams(layoutParams);
                    d.this.gMd.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.gMg);
        this.mHandler.postDelayed(this.gMg, 5000L);
    }

    private void bYb() {
        String str = null;
        switch (this.gMf) {
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
        this.gMe.setText(str);
    }

    public void bYc() {
        if (this.gMd.getParent() != null) {
            ((ViewGroup) this.gMd.getParent()).removeView(this.gMd);
        }
    }

    public void bYd() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.gMf);
    }

    public void release() {
        this.gMf = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
