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
/* loaded from: classes7.dex */
public class d {
    private IShareCallback gDT;
    private View gIH;
    private AlaDoubleStateImageView gII;
    private AlaDoubleStateImageView gIJ;
    private AlaDoubleStateImageView gIK;
    private AlaDoubleStateImageView gIL;
    private View gIM;
    private TextView gIN;
    private int gIO = -1;
    private Runnable gIP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bWu();
        }
    };
    private View.OnClickListener gIQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.gII.isSelected();
                d.this.gII.setSelect(z2);
                d.this.gIJ.setSelect(false);
                d.this.gIK.setSelect(false);
                d.this.gIL.setSelect(false);
                d.this.mE(false);
                if (z2) {
                    d.this.gIO = 1;
                    d.this.gII.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.gII);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.gIO = -1;
                d.this.bWu();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.gIJ.isSelected() ? false : true;
                d.this.gIJ.setSelect(z);
                d.this.gII.setSelect(false);
                d.this.gIK.setSelect(false);
                d.this.gIL.setSelect(false);
                d.this.mE(false);
                if (z) {
                    d.this.gIO = 2;
                    d.this.gIJ.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.gIJ);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.gIO = -1;
                d.this.bWu();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.gIK.isSelected();
                d.this.gIK.setSelect(z3);
                d.this.gII.setSelect(false);
                d.this.gIJ.setSelect(false);
                d.this.gIL.setSelect(false);
                d.this.mE(true);
                if (z3) {
                    d.this.gIO = 3;
                    d.this.gIK.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.gIK);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.gIO = -1;
                d.this.bWu();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.gIL.isSelected() ? false : true;
                d.this.gIL.setSelect(z);
                d.this.gII.setSelect(false);
                d.this.gIK.setSelect(false);
                d.this.gIJ.setSelect(false);
                d.this.mE(false);
                if (z) {
                    d.this.gIO = 4;
                    d.this.gIL.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.gIL);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.gIO = -1;
                d.this.bWu();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.AD().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.AD().putBoolean(str, false);
            return;
        }
        bWu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(boolean z) {
        this.gIM.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bWs();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void o(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bQ(View view) {
        this.gIH = view;
        this.gII = (AlaDoubleStateImageView) this.gIH.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.gII.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.gII.setOnClickListener(this.gIQ);
        this.gIJ = (AlaDoubleStateImageView) this.gIH.findViewById(a.g.ala_prepare_share_img_weixin);
        this.gIJ.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.gIJ.setOnClickListener(this.gIQ);
        this.gIK = (AlaDoubleStateImageView) this.gIH.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.gIK.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.gIK.setOnClickListener(this.gIQ);
        this.gIL = (AlaDoubleStateImageView) this.gIH.findViewById(a.g.ala_prepare_share_img_qq);
        this.gIL.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.gIL.setOnClickListener(this.gIQ);
        switch (this.gIO) {
            case 1:
                this.gII.setSelect(true);
                break;
            case 2:
                this.gIJ.setSelect(true);
                break;
            case 3:
                this.gIK.setSelect(true);
                break;
            case 4:
                this.gIL.setSelect(true);
                break;
        }
        this.gIM = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gIN = (TextView) this.gIM.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.gDT = iShareCallback;
    }

    public boolean bQX() {
        return this.mShareChannel != null && this.gIO >= 1 && this.gIO <= 4;
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
        ShareEntity Gz = Gz(str);
        if (Gz != null) {
            switch (this.gIO) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Gz.content = str3.replace("直播标题", str2);
                        } else {
                            Gz.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Gz.title = "腻害了";
                    }
                    a(Gz);
                    return;
                case 2:
                    Gz.content = str2;
                    Gz.title = str4;
                    b(Gz);
                    return;
                case 3:
                    Gz.content = str2;
                    Gz.title = str4;
                    c(Gz);
                    return;
                case 4:
                    Gz.content = str2;
                    Gz.title = str4;
                    d(Gz);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Gz(String str) {
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
        shareEntity.shareType = this.gIO;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.gDT);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.gDT);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.gDT);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.gDT);
    }

    private void bWs() {
        this.gIO = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        bWt();
        if (this.gIM.getParent() != null) {
            ((ViewGroup) this.gIM.getParent()).removeView(this.gIM);
        }
        this.mRootView.addView(this.gIM);
        this.gIM.setVisibility(4);
        this.gIM.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gIM.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.gIM.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.gIM.setLayoutParams(layoutParams);
                    d.this.gIM.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.gIP);
        this.mHandler.postDelayed(this.gIP, 5000L);
    }

    private void bWt() {
        String str = null;
        switch (this.gIO) {
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
        this.gIN.setText(str);
    }

    public void bWu() {
        if (this.gIM.getParent() != null) {
            ((ViewGroup) this.gIM.getParent()).removeView(this.gIM);
        }
    }

    public void bWv() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.gIO);
    }

    public void release() {
        this.gIO = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
