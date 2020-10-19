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
    private IShareCallback gVS;
    private View haV;
    private AlaDoubleStateImageView haW;
    private AlaDoubleStateImageView haX;
    private AlaDoubleStateImageView haY;
    private AlaDoubleStateImageView haZ;
    private View hba;
    private TextView hbb;
    private int hbc = -1;
    private Runnable hbd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.cbC();
        }
    };
    private View.OnClickListener hbe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.haW.isSelected();
                d.this.haW.setSelect(z2);
                d.this.haX.setSelect(false);
                d.this.haY.setSelect(false);
                d.this.haZ.setSelect(false);
                d.this.nl(false);
                if (z2) {
                    d.this.hbc = 1;
                    d.this.haW.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.haW);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hbc = -1;
                d.this.cbC();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.haX.isSelected() ? false : true;
                d.this.haX.setSelect(z);
                d.this.haW.setSelect(false);
                d.this.haY.setSelect(false);
                d.this.haZ.setSelect(false);
                d.this.nl(false);
                if (z) {
                    d.this.hbc = 2;
                    d.this.haX.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.haX);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hbc = -1;
                d.this.cbC();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.haY.isSelected();
                d.this.haY.setSelect(z3);
                d.this.haW.setSelect(false);
                d.this.haX.setSelect(false);
                d.this.haZ.setSelect(false);
                d.this.nl(true);
                if (z3) {
                    d.this.hbc = 3;
                    d.this.haY.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.haY);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hbc = -1;
                d.this.cbC();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.haZ.isSelected() ? false : true;
                d.this.haZ.setSelect(z);
                d.this.haW.setSelect(false);
                d.this.haY.setSelect(false);
                d.this.haX.setSelect(false);
                d.this.nl(false);
                if (z) {
                    d.this.hbc = 4;
                    d.this.haZ.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.haZ);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hbc = -1;
                d.this.cbC();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.AZ().getBoolean(str, true)) {
            b(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.AZ().putBoolean(str, false);
            return;
        }
        cbC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(boolean z) {
        this.hba.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cbA();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void p(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bZ(View view) {
        this.haV = view;
        this.haW = (AlaDoubleStateImageView) this.haV.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.haW.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.haW.setOnClickListener(this.hbe);
        this.haX = (AlaDoubleStateImageView) this.haV.findViewById(a.g.ala_prepare_share_img_weixin);
        this.haX.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.haX.setOnClickListener(this.hbe);
        this.haY = (AlaDoubleStateImageView) this.haV.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.haY.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.haY.setOnClickListener(this.hbe);
        this.haZ = (AlaDoubleStateImageView) this.haV.findViewById(a.g.ala_prepare_share_img_qq);
        this.haZ.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.haZ.setOnClickListener(this.hbe);
        switch (this.hbc) {
            case 1:
                this.haW.setSelect(true);
                break;
            case 2:
                this.haX.setSelect(true);
                break;
            case 3:
                this.haY.setSelect(true);
                break;
            case 4:
                this.haZ.setSelect(true);
                break;
        }
        this.hba = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.hbb = (TextView) this.hba.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.gVS = iShareCallback;
    }

    public boolean bVM() {
        return this.mShareChannel != null && this.hbc >= 1 && this.hbc <= 4;
    }

    public void x(String str, String str2, String str3, String str4) {
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
        ShareEntity HG = HG(str);
        if (HG != null) {
            switch (this.hbc) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            HG.content = str3.replace("直播标题", str2);
                        } else {
                            HG.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        HG.title = "腻害了";
                    }
                    a(HG);
                    return;
                case 2:
                    HG.content = str2;
                    HG.title = str4;
                    b(HG);
                    return;
                case 3:
                    HG.content = str2;
                    HG.title = str4;
                    c(HG);
                    return;
                case 4:
                    HG.content = str2;
                    HG.title = str4;
                    d(HG);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity HG(String str) {
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
        shareEntity.shareType = this.hbc;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.gVS);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.gVS);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.gVS);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.gVS);
    }

    private void cbA() {
        this.hbc = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        cbB();
        if (this.hba.getParent() != null) {
            ((ViewGroup) this.hba.getParent()).removeView(this.hba);
        }
        this.mRootView.addView(this.hba);
        this.hba.setVisibility(4);
        this.hba.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hba.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hba.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hba.setLayoutParams(layoutParams);
                    d.this.hba.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hbd);
        this.mHandler.postDelayed(this.hbd, 5000L);
    }

    private void cbB() {
        String str = null;
        switch (this.hbc) {
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
        this.hbb.setText(str);
    }

    public void cbC() {
        if (this.hba.getParent() != null) {
            ((ViewGroup) this.hba.getParent()).removeView(this.hba);
        }
    }

    public void cbD() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hbc);
    }

    public void release() {
        this.hbc = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
