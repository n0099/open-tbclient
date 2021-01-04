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
    private IShareCallback hIK;
    private View hNX;
    private AlaDoubleStateImageView hNY;
    private AlaDoubleStateImageView hNZ;
    private AlaDoubleStateImageView hOa;
    private AlaDoubleStateImageView hOb;
    private View hOc;
    private TextView hOd;
    private int hOe = -1;
    private Runnable hOf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.cnl();
        }
    };
    private View.OnClickListener hOg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hNY.isSelected();
                d.this.hNY.setSelect(z2);
                d.this.hNZ.setSelect(false);
                d.this.hOa.setSelect(false);
                d.this.hOb.setSelect(false);
                d.this.oF(false);
                if (z2) {
                    d.this.hOe = 1;
                    d.this.hNY.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hNY);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hOe = -1;
                d.this.cnl();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hNZ.isSelected() ? false : true;
                d.this.hNZ.setSelect(z);
                d.this.hNY.setSelect(false);
                d.this.hOa.setSelect(false);
                d.this.hOb.setSelect(false);
                d.this.oF(false);
                if (z) {
                    d.this.hOe = 2;
                    d.this.hNZ.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hNZ);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hOe = -1;
                d.this.cnl();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hOa.isSelected();
                d.this.hOa.setSelect(z3);
                d.this.hNY.setSelect(false);
                d.this.hNZ.setSelect(false);
                d.this.hOb.setSelect(false);
                d.this.oF(true);
                if (z3) {
                    d.this.hOe = 3;
                    d.this.hOa.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hOa);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hOe = -1;
                d.this.cnl();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hOb.isSelected() ? false : true;
                d.this.hOb.setSelect(z);
                d.this.hNY.setSelect(false);
                d.this.hOa.setSelect(false);
                d.this.hNZ.setSelect(false);
                d.this.oF(false);
                if (z) {
                    d.this.hOe = 4;
                    d.this.hOb.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hOb);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hOe = -1;
                d.this.cnl();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.d.Ba().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.d.Ba().putBoolean(str, false);
            return;
        }
        cnl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(boolean z) {
        this.hOc.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cnj();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void o(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cB(View view) {
        this.hNX = view;
        this.hNY = (AlaDoubleStateImageView) this.hNX.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hNY.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hNY.setOnClickListener(this.hOg);
        this.hNZ = (AlaDoubleStateImageView) this.hNX.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hNZ.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hNZ.setOnClickListener(this.hOg);
        this.hOa = (AlaDoubleStateImageView) this.hNX.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hOa.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hOa.setOnClickListener(this.hOg);
        this.hOb = (AlaDoubleStateImageView) this.hNX.findViewById(a.f.ala_prepare_share_img_qq);
        this.hOb.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hOb.setOnClickListener(this.hOg);
        switch (this.hOe) {
            case 1:
                this.hNY.setSelect(true);
                break;
            case 2:
                this.hNZ.setSelect(true);
                break;
            case 3:
                this.hOa.setSelect(true);
                break;
            case 4:
                this.hOb.setSelect(true);
                break;
        }
        this.hOc = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hOd = (TextView) this.hOc.findViewById(a.f.tip_tv);
        if (TbadkCoreApplication.getInst().isYinbo()) {
            this.hOb.setVisibility(8);
        } else {
            this.hOb.setVisibility(0);
        }
    }

    public void a(IShareCallback iShareCallback) {
        this.hIK = iShareCallback;
    }

    public boolean chs() {
        return this.mShareChannel != null && this.hOe >= 1 && this.hOe <= 4;
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
        ShareEntity II = II(str);
        if (II != null) {
            switch (this.hOe) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            II.content = str3.replace("直播标题", str2);
                        } else {
                            II.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        II.title = "腻害了";
                    }
                    a(II);
                    return;
                case 2:
                    II.content = str2;
                    II.title = str4;
                    b(II);
                    return;
                case 3:
                    II.content = str2;
                    II.title = str4;
                    c(II);
                    return;
                case 4:
                    II.content = str2;
                    II.title = str4;
                    d(II);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity II(String str) {
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
        shareEntity.shareType = this.hOe;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hIK);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hIK);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hIK);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hIK);
    }

    private void cnj() {
        this.hOe = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        cnk();
        if (this.hOc.getParent() != null) {
            ((ViewGroup) this.hOc.getParent()).removeView(this.hOc);
        }
        this.mRootView.addView(this.hOc);
        this.hOc.setVisibility(4);
        this.hOc.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hOc.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hOc.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hOc.setLayoutParams(layoutParams);
                    d.this.hOc.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hOf);
        this.mHandler.postDelayed(this.hOf, 5000L);
    }

    private void cnk() {
        String str = null;
        switch (this.hOe) {
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
        this.hOd.setText(str);
    }

    public void cnl() {
        if (this.hOc.getParent() != null) {
            ((ViewGroup) this.hOc.getParent()).removeView(this.hOc);
        }
    }

    public void cnm() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hOe);
    }

    public void release() {
        this.hOe = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
