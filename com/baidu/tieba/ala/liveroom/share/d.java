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
    private IShareCallback gDP;
    private View gID;
    private AlaDoubleStateImageView gIE;
    private AlaDoubleStateImageView gIF;
    private AlaDoubleStateImageView gIG;
    private AlaDoubleStateImageView gIH;
    private View gII;
    private TextView gIJ;
    private int gIK = -1;
    private Runnable gIL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bWt();
        }
    };
    private View.OnClickListener gIM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.gIE.isSelected();
                d.this.gIE.setSelect(z2);
                d.this.gIF.setSelect(false);
                d.this.gIG.setSelect(false);
                d.this.gIH.setSelect(false);
                d.this.mC(false);
                if (z2) {
                    d.this.gIK = 1;
                    d.this.gIE.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.gIE);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.gIK = -1;
                d.this.bWt();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.gIF.isSelected() ? false : true;
                d.this.gIF.setSelect(z);
                d.this.gIE.setSelect(false);
                d.this.gIG.setSelect(false);
                d.this.gIH.setSelect(false);
                d.this.mC(false);
                if (z) {
                    d.this.gIK = 2;
                    d.this.gIF.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.gIF);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.gIK = -1;
                d.this.bWt();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.gIG.isSelected();
                d.this.gIG.setSelect(z3);
                d.this.gIE.setSelect(false);
                d.this.gIF.setSelect(false);
                d.this.gIH.setSelect(false);
                d.this.mC(true);
                if (z3) {
                    d.this.gIK = 3;
                    d.this.gIG.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.gIG);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.gIK = -1;
                d.this.bWt();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.gIH.isSelected() ? false : true;
                d.this.gIH.setSelect(z);
                d.this.gIE.setSelect(false);
                d.this.gIG.setSelect(false);
                d.this.gIF.setSelect(false);
                d.this.mC(false);
                if (z) {
                    d.this.gIK = 4;
                    d.this.gIH.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.gIH);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.gIK = -1;
                d.this.bWt();
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
        bWt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        this.gII.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bWr();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void o(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bQ(View view) {
        this.gID = view;
        this.gIE = (AlaDoubleStateImageView) this.gID.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.gIE.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.gIE.setOnClickListener(this.gIM);
        this.gIF = (AlaDoubleStateImageView) this.gID.findViewById(a.g.ala_prepare_share_img_weixin);
        this.gIF.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.gIF.setOnClickListener(this.gIM);
        this.gIG = (AlaDoubleStateImageView) this.gID.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.gIG.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.gIG.setOnClickListener(this.gIM);
        this.gIH = (AlaDoubleStateImageView) this.gID.findViewById(a.g.ala_prepare_share_img_qq);
        this.gIH.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.gIH.setOnClickListener(this.gIM);
        switch (this.gIK) {
            case 1:
                this.gIE.setSelect(true);
                break;
            case 2:
                this.gIF.setSelect(true);
                break;
            case 3:
                this.gIG.setSelect(true);
                break;
            case 4:
                this.gIH.setSelect(true);
                break;
        }
        this.gII = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gIJ = (TextView) this.gII.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.gDP = iShareCallback;
    }

    public boolean bQW() {
        return this.mShareChannel != null && this.gIK >= 1 && this.gIK <= 4;
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
        ShareEntity Gy = Gy(str);
        if (Gy != null) {
            switch (this.gIK) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Gy.content = str3.replace("直播标题", str2);
                        } else {
                            Gy.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Gy.title = "腻害了";
                    }
                    a(Gy);
                    return;
                case 2:
                    Gy.content = str2;
                    Gy.title = str4;
                    b(Gy);
                    return;
                case 3:
                    Gy.content = str2;
                    Gy.title = str4;
                    c(Gy);
                    return;
                case 4:
                    Gy.content = str2;
                    Gy.title = str4;
                    d(Gy);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Gy(String str) {
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
        shareEntity.shareType = this.gIK;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.gDP);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.gDP);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.gDP);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.gDP);
    }

    private void bWr() {
        this.gIK = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        bWs();
        if (this.gII.getParent() != null) {
            ((ViewGroup) this.gII.getParent()).removeView(this.gII);
        }
        this.mRootView.addView(this.gII);
        this.gII.setVisibility(4);
        this.gII.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gII.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.gII.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.gII.setLayoutParams(layoutParams);
                    d.this.gII.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.gIL);
        this.mHandler.postDelayed(this.gIL, 5000L);
    }

    private void bWs() {
        String str = null;
        switch (this.gIK) {
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
        this.gIJ.setText(str);
    }

    public void bWt() {
        if (this.gII.getParent() != null) {
            ((ViewGroup) this.gII.getParent()).removeView(this.gII);
        }
    }

    public void bWu() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.gIK);
    }

    public void release() {
        this.gIK = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
