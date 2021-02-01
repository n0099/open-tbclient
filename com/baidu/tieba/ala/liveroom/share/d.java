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
/* loaded from: classes11.dex */
public class d {
    private IShareCallback hIq;
    private View hNP;
    private AlaDoubleStateImageView hNQ;
    private AlaDoubleStateImageView hNR;
    private AlaDoubleStateImageView hNS;
    private AlaDoubleStateImageView hNT;
    private View hNU;
    private TextView hNV;
    private int hNW = -1;
    private Runnable hNX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.ckt();
        }
    };
    private View.OnClickListener hNY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hNQ.isSelected();
                d.this.hNQ.setSelect(z2);
                d.this.hNR.setSelect(false);
                d.this.hNS.setSelect(false);
                d.this.hNT.setSelect(false);
                d.this.oL(false);
                if (z2) {
                    d.this.hNW = 1;
                    d.this.hNQ.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hNQ);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hNW = -1;
                d.this.ckt();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hNR.isSelected() ? false : true;
                d.this.hNR.setSelect(z);
                d.this.hNQ.setSelect(false);
                d.this.hNS.setSelect(false);
                d.this.hNT.setSelect(false);
                d.this.oL(false);
                if (z) {
                    d.this.hNW = 2;
                    d.this.hNR.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hNR);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hNW = -1;
                d.this.ckt();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hNS.isSelected();
                d.this.hNS.setSelect(z3);
                d.this.hNQ.setSelect(false);
                d.this.hNR.setSelect(false);
                d.this.hNT.setSelect(false);
                d.this.oL(true);
                if (z3) {
                    d.this.hNW = 3;
                    d.this.hNS.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hNS);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hNW = -1;
                d.this.ckt();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hNT.isSelected() ? false : true;
                d.this.hNT.setSelect(z);
                d.this.hNQ.setSelect(false);
                d.this.hNS.setSelect(false);
                d.this.hNR.setSelect(false);
                d.this.oL(false);
                if (z) {
                    d.this.hNW = 4;
                    d.this.hNT.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hNT);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hNW = -1;
                d.this.ckt();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.d.xc().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.d.xc().putBoolean(str, false);
            return;
        }
        ckt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL(boolean z) {
        this.hNU.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ckr();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void o(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cx(View view) {
        this.hNP = view;
        this.hNQ = (AlaDoubleStateImageView) this.hNP.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hNQ.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hNQ.setOnClickListener(this.hNY);
        this.hNR = (AlaDoubleStateImageView) this.hNP.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hNR.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hNR.setOnClickListener(this.hNY);
        this.hNS = (AlaDoubleStateImageView) this.hNP.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hNS.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hNS.setOnClickListener(this.hNY);
        this.hNT = (AlaDoubleStateImageView) this.hNP.findViewById(a.f.ala_prepare_share_img_qq);
        this.hNT.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hNT.setOnClickListener(this.hNY);
        switch (this.hNW) {
            case 1:
                this.hNQ.setSelect(true);
                break;
            case 2:
                this.hNR.setSelect(true);
                break;
            case 3:
                this.hNS.setSelect(true);
                break;
            case 4:
                this.hNT.setSelect(true);
                break;
        }
        this.hNU = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hNV = (TextView) this.hNU.findViewById(a.f.tip_tv);
        if (TbadkCoreApplication.getInst().isYinbo()) {
            this.hNT.setVisibility(8);
        } else {
            this.hNT.setVisibility(0);
        }
    }

    public void a(IShareCallback iShareCallback) {
        this.hIq = iShareCallback;
    }

    public boolean cew() {
        return this.mShareChannel != null && this.hNW >= 1 && this.hNW <= 4;
    }

    public void x(String str, String str2, String str3, String str4) {
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
        ShareEntity Ia = Ia(str);
        if (Ia != null) {
            switch (this.hNW) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Ia.content = str3.replace("直播标题", str2);
                        } else {
                            Ia.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Ia.title = "腻害了";
                    }
                    a(Ia);
                    return;
                case 2:
                    Ia.content = str2;
                    Ia.title = str4;
                    b(Ia);
                    return;
                case 3:
                    Ia.content = str2;
                    Ia.title = str4;
                    c(Ia);
                    return;
                case 4:
                    Ia.content = str2;
                    Ia.title = str4;
                    d(Ia);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Ia(String str) {
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
        shareEntity.shareType = this.hNW;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hIq);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hIq);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hIq);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hIq);
    }

    private void ckr() {
        this.hNW = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        cks();
        if (this.hNU.getParent() != null) {
            ((ViewGroup) this.hNU.getParent()).removeView(this.hNU);
        }
        this.mRootView.addView(this.hNU);
        this.hNU.setVisibility(4);
        this.hNU.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hNU.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hNU.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hNU.setLayoutParams(layoutParams);
                    d.this.hNU.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hNX);
        this.mHandler.postDelayed(this.hNX, 5000L);
    }

    private void cks() {
        String str = null;
        switch (this.hNW) {
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
        this.hNV.setText(str);
    }

    public void ckt() {
        if (this.hNU.getParent() != null) {
            ((ViewGroup) this.hNU.getParent()).removeView(this.hNU);
        }
    }

    public void cku() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hNW);
    }

    public void release() {
        this.hNW = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
