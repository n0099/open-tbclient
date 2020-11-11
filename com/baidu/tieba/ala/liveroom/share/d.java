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
    private IShareCallback hnz;
    private View hsJ;
    private AlaDoubleStateImageView hsK;
    private AlaDoubleStateImageView hsL;
    private AlaDoubleStateImageView hsM;
    private AlaDoubleStateImageView hsN;
    private View hsO;
    private TextView hsP;
    private int hsQ = -1;
    private Runnable hsR = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.chj();
        }
    };
    private View.OnClickListener hsS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hsK.isSelected();
                d.this.hsK.setSelect(z2);
                d.this.hsL.setSelect(false);
                d.this.hsM.setSelect(false);
                d.this.hsN.setSelect(false);
                d.this.nK(false);
                if (z2) {
                    d.this.hsQ = 1;
                    d.this.hsK.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hsK);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hsQ = -1;
                d.this.chj();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hsL.isSelected() ? false : true;
                d.this.hsL.setSelect(z);
                d.this.hsK.setSelect(false);
                d.this.hsM.setSelect(false);
                d.this.hsN.setSelect(false);
                d.this.nK(false);
                if (z) {
                    d.this.hsQ = 2;
                    d.this.hsL.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hsL);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hsQ = -1;
                d.this.chj();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hsM.isSelected();
                d.this.hsM.setSelect(z3);
                d.this.hsK.setSelect(false);
                d.this.hsL.setSelect(false);
                d.this.hsN.setSelect(false);
                d.this.nK(true);
                if (z3) {
                    d.this.hsQ = 3;
                    d.this.hsM.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hsM);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hsQ = -1;
                d.this.chj();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hsN.isSelected() ? false : true;
                d.this.hsN.setSelect(z);
                d.this.hsK.setSelect(false);
                d.this.hsM.setSelect(false);
                d.this.hsL.setSelect(false);
                d.this.nK(false);
                if (z) {
                    d.this.hsQ = 4;
                    d.this.hsN.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hsN);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hsQ = -1;
                d.this.chj();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.d.AZ().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.d.AZ().putBoolean(str, false);
            return;
        }
        chj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        this.hsO.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        chh();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void p(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void ci(View view) {
        this.hsJ = view;
        this.hsK = (AlaDoubleStateImageView) this.hsJ.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hsK.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hsK.setOnClickListener(this.hsS);
        this.hsL = (AlaDoubleStateImageView) this.hsJ.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hsL.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hsL.setOnClickListener(this.hsS);
        this.hsM = (AlaDoubleStateImageView) this.hsJ.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hsM.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hsM.setOnClickListener(this.hsS);
        this.hsN = (AlaDoubleStateImageView) this.hsJ.findViewById(a.f.ala_prepare_share_img_qq);
        this.hsN.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hsN.setOnClickListener(this.hsS);
        switch (this.hsQ) {
            case 1:
                this.hsK.setSelect(true);
                break;
            case 2:
                this.hsL.setSelect(true);
                break;
            case 3:
                this.hsM.setSelect(true);
                break;
            case 4:
                this.hsN.setSelect(true);
                break;
        }
        this.hsO = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hsP = (TextView) this.hsO.findViewById(a.f.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.hnz = iShareCallback;
    }

    public boolean cbn() {
        return this.mShareChannel != null && this.hsQ >= 1 && this.hsQ <= 4;
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
        ShareEntity Iw = Iw(str);
        if (Iw != null) {
            switch (this.hsQ) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Iw.content = str3.replace("直播标题", str2);
                        } else {
                            Iw.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Iw.title = "腻害了";
                    }
                    a(Iw);
                    return;
                case 2:
                    Iw.content = str2;
                    Iw.title = str4;
                    b(Iw);
                    return;
                case 3:
                    Iw.content = str2;
                    Iw.title = str4;
                    c(Iw);
                    return;
                case 4:
                    Iw.content = str2;
                    Iw.title = str4;
                    d(Iw);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Iw(String str) {
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
        shareEntity.shareType = this.hsQ;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hnz);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hnz);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hnz);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hnz);
    }

    private void chh() {
        this.hsQ = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        chi();
        if (this.hsO.getParent() != null) {
            ((ViewGroup) this.hsO.getParent()).removeView(this.hsO);
        }
        this.mRootView.addView(this.hsO);
        this.hsO.setVisibility(4);
        this.hsO.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hsO.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hsO.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hsO.setLayoutParams(layoutParams);
                    d.this.hsO.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hsR);
        this.mHandler.postDelayed(this.hsR, 5000L);
    }

    private void chi() {
        String str = null;
        switch (this.hsQ) {
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
        this.hsP.setText(str);
    }

    public void chj() {
        if (this.hsO.getParent() != null) {
            ((ViewGroup) this.hsO.getParent()).removeView(this.hsO);
        }
    }

    public void chk() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hsQ);
    }

    public void release() {
        this.hsQ = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
