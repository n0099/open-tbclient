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
    private View hBW;
    private AlaDoubleStateImageView hBX;
    private AlaDoubleStateImageView hBY;
    private AlaDoubleStateImageView hBZ;
    private AlaDoubleStateImageView hCa;
    private View hCb;
    private TextView hCc;
    private IShareCallback hwN;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;
    private int hCd = -1;
    private Runnable hCe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.ckx();
        }
    };
    private View.OnClickListener hCf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hBX.isSelected();
                d.this.hBX.setSelect(z2);
                d.this.hBY.setSelect(false);
                d.this.hBZ.setSelect(false);
                d.this.hCa.setSelect(false);
                d.this.og(false);
                if (z2) {
                    d.this.hCd = 1;
                    d.this.hBX.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hBX);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hCd = -1;
                d.this.ckx();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hBY.isSelected() ? false : true;
                d.this.hBY.setSelect(z);
                d.this.hBX.setSelect(false);
                d.this.hBZ.setSelect(false);
                d.this.hCa.setSelect(false);
                d.this.og(false);
                if (z) {
                    d.this.hCd = 2;
                    d.this.hBY.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hBY);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hCd = -1;
                d.this.ckx();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hBZ.isSelected();
                d.this.hBZ.setSelect(z3);
                d.this.hBX.setSelect(false);
                d.this.hBY.setSelect(false);
                d.this.hCa.setSelect(false);
                d.this.og(true);
                if (z3) {
                    d.this.hCd = 3;
                    d.this.hBZ.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hBZ);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hCd = -1;
                d.this.ckx();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hCa.isSelected() ? false : true;
                d.this.hCa.setSelect(z);
                d.this.hBX.setSelect(false);
                d.this.hBZ.setSelect(false);
                d.this.hBY.setSelect(false);
                d.this.og(false);
                if (z) {
                    d.this.hCd = 4;
                    d.this.hCa.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hCa);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hCd = -1;
                d.this.ckx();
            }
        }
    };
    private Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.d.BM().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.d.BM().putBoolean(str, false);
            return;
        }
        ckx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(boolean z) {
        this.hCb.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ckv();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void l(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cs(View view) {
        this.hBW = view;
        this.hBX = (AlaDoubleStateImageView) this.hBW.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hBX.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hBX.setOnClickListener(this.hCf);
        this.hBY = (AlaDoubleStateImageView) this.hBW.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hBY.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hBY.setOnClickListener(this.hCf);
        this.hBZ = (AlaDoubleStateImageView) this.hBW.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hBZ.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hBZ.setOnClickListener(this.hCf);
        this.hCa = (AlaDoubleStateImageView) this.hBW.findViewById(a.f.ala_prepare_share_img_qq);
        this.hCa.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hCa.setOnClickListener(this.hCf);
        switch (this.hCd) {
            case 1:
                this.hBX.setSelect(true);
                break;
            case 2:
                this.hBY.setSelect(true);
                break;
            case 3:
                this.hBZ.setSelect(true);
                break;
            case 4:
                this.hCa.setSelect(true);
                break;
        }
        this.hCb = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hCc = (TextView) this.hCb.findViewById(a.f.tip_tv);
        if (TbadkCoreApplication.getInst().isYinbo()) {
            this.hCa.setVisibility(8);
        } else {
            this.hCa.setVisibility(0);
        }
    }

    public void a(IShareCallback iShareCallback) {
        this.hwN = iShareCallback;
    }

    public boolean ceC() {
        return this.mShareChannel != null && this.hCd >= 1 && this.hCd <= 4;
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
        ShareEntity IM = IM(str);
        if (IM != null) {
            switch (this.hCd) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            IM.content = str3.replace("直播标题", str2);
                        } else {
                            IM.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        IM.title = "腻害了";
                    }
                    a(IM);
                    return;
                case 2:
                    IM.content = str2;
                    IM.title = str4;
                    b(IM);
                    return;
                case 3:
                    IM.content = str2;
                    IM.title = str4;
                    c(IM);
                    return;
                case 4:
                    IM.content = str2;
                    IM.title = str4;
                    d(IM);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity IM(String str) {
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
        shareEntity.shareType = this.hCd;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hwN);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hwN);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hwN);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hwN);
    }

    private void ckv() {
        this.hCd = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        ckw();
        if (this.hCb.getParent() != null) {
            ((ViewGroup) this.hCb.getParent()).removeView(this.hCb);
        }
        this.mRootView.addView(this.hCb);
        this.hCb.setVisibility(4);
        this.hCb.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hCb.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hCb.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hCb.setLayoutParams(layoutParams);
                    d.this.hCb.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hCe);
        this.mHandler.postDelayed(this.hCe, 5000L);
    }

    private void ckw() {
        String str = null;
        switch (this.hCd) {
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
        this.hCc.setText(str);
    }

    public void ckx() {
        if (this.hCb.getParent() != null) {
            ((ViewGroup) this.hCb.getParent()).removeView(this.hCb);
        }
    }

    public void cky() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hCd);
    }

    public void release() {
        this.hCd = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
