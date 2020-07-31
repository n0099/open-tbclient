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
    private IShareCallback gqV;
    private View gwE;
    private AlaDoubleStateImageView gwF;
    private AlaDoubleStateImageView gwG;
    private AlaDoubleStateImageView gwH;
    private AlaDoubleStateImageView gwI;
    private View gwJ;
    private TextView gwK;
    private int gwL = -1;
    private Runnable gwM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bMw();
        }
    };
    private View.OnClickListener gwN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.gwF.isSelected();
                d.this.gwF.setSelect(z2);
                d.this.gwG.setSelect(false);
                d.this.gwH.setSelect(false);
                d.this.gwI.setSelect(false);
                d.this.ma(false);
                if (z2) {
                    d.this.gwL = 1;
                    d.this.gwF.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.gwF);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.gwL = -1;
                d.this.bMw();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.gwG.isSelected() ? false : true;
                d.this.gwG.setSelect(z);
                d.this.gwF.setSelect(false);
                d.this.gwH.setSelect(false);
                d.this.gwI.setSelect(false);
                d.this.ma(false);
                if (z) {
                    d.this.gwL = 2;
                    d.this.gwG.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.gwG);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.gwL = -1;
                d.this.bMw();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.gwH.isSelected();
                d.this.gwH.setSelect(z3);
                d.this.gwF.setSelect(false);
                d.this.gwG.setSelect(false);
                d.this.gwI.setSelect(false);
                d.this.ma(true);
                if (z3) {
                    d.this.gwL = 3;
                    d.this.gwH.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.gwH);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.gwL = -1;
                d.this.bMw();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.gwI.isSelected() ? false : true;
                d.this.gwI.setSelect(z);
                d.this.gwF.setSelect(false);
                d.this.gwH.setSelect(false);
                d.this.gwG.setSelect(false);
                d.this.ma(false);
                if (z) {
                    d.this.gwL = 4;
                    d.this.gwI.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.gwI);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.gwL = -1;
                d.this.bMw();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.vf().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.vf().putBoolean(str, false);
            return;
        }
        bMw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(boolean z) {
        this.gwJ.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bMu();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void n(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bO(View view) {
        this.gwE = view;
        this.gwF = (AlaDoubleStateImageView) this.gwE.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.gwF.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.gwF.setOnClickListener(this.gwN);
        this.gwG = (AlaDoubleStateImageView) this.gwE.findViewById(a.g.ala_prepare_share_img_weixin);
        this.gwG.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.gwG.setOnClickListener(this.gwN);
        this.gwH = (AlaDoubleStateImageView) this.gwE.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.gwH.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.gwH.setOnClickListener(this.gwN);
        this.gwI = (AlaDoubleStateImageView) this.gwE.findViewById(a.g.ala_prepare_share_img_qq);
        this.gwI.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.gwI.setOnClickListener(this.gwN);
        switch (this.gwL) {
            case 1:
                this.gwF.setSelect(true);
                break;
            case 2:
                this.gwG.setSelect(true);
                break;
            case 3:
                this.gwH.setSelect(true);
                break;
            case 4:
                this.gwI.setSelect(true);
                break;
        }
        this.gwJ = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gwK = (TextView) this.gwJ.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.gqV = iShareCallback;
    }

    public boolean bHs() {
        return this.mShareChannel != null && this.gwL >= 1 && this.gwL <= 4;
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
        ShareEntity DZ = DZ(str);
        if (DZ != null) {
            switch (this.gwL) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            DZ.content = str3.replace("直播标题", str2);
                        } else {
                            DZ.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        DZ.title = "腻害了";
                    }
                    a(DZ);
                    return;
                case 2:
                    DZ.content = str2;
                    DZ.title = str4;
                    b(DZ);
                    return;
                case 3:
                    DZ.content = str2;
                    DZ.title = str4;
                    c(DZ);
                    return;
                case 4:
                    DZ.content = str2;
                    DZ.title = str4;
                    d(DZ);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity DZ(String str) {
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
        shareEntity.shareType = this.gwL;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.gqV);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.gqV);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.gqV);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.gqV);
    }

    private void bMu() {
        this.gwL = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bMv();
        if (this.gwJ.getParent() != null) {
            ((ViewGroup) this.gwJ.getParent()).removeView(this.gwJ);
        }
        this.mRootView.addView(this.gwJ);
        this.gwJ.setVisibility(4);
        this.gwJ.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gwJ.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.gwJ.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.gwJ.setLayoutParams(layoutParams);
                    d.this.gwJ.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.gwM);
        this.mHandler.postDelayed(this.gwM, 5000L);
    }

    private void bMv() {
        String str = null;
        switch (this.gwL) {
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
        this.gwK.setText(str);
    }

    public void bMw() {
        if (this.gwJ.getParent() != null) {
            ((ViewGroup) this.gwJ.getParent()).removeView(this.gwJ);
        }
    }

    public void bMx() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.gwL);
    }

    public void release() {
        this.gwL = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
