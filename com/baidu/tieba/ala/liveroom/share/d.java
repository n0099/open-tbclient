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
    private IShareCallback hhH;
    private View hmL;
    private AlaDoubleStateImageView hmM;
    private AlaDoubleStateImageView hmN;
    private AlaDoubleStateImageView hmO;
    private AlaDoubleStateImageView hmP;
    private View hmQ;
    private TextView hmR;
    private int hmS = -1;
    private Runnable hmT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.ceG();
        }
    };
    private View.OnClickListener hmU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hmM.isSelected();
                d.this.hmM.setSelect(z2);
                d.this.hmN.setSelect(false);
                d.this.hmO.setSelect(false);
                d.this.hmP.setSelect(false);
                d.this.nB(false);
                if (z2) {
                    d.this.hmS = 1;
                    d.this.hmM.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hmM);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hmS = -1;
                d.this.ceG();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.hmN.isSelected() ? false : true;
                d.this.hmN.setSelect(z);
                d.this.hmM.setSelect(false);
                d.this.hmO.setSelect(false);
                d.this.hmP.setSelect(false);
                d.this.nB(false);
                if (z) {
                    d.this.hmS = 2;
                    d.this.hmN.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hmN);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hmS = -1;
                d.this.ceG();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hmO.isSelected();
                d.this.hmO.setSelect(z3);
                d.this.hmM.setSelect(false);
                d.this.hmN.setSelect(false);
                d.this.hmP.setSelect(false);
                d.this.nB(true);
                if (z3) {
                    d.this.hmS = 3;
                    d.this.hmO.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hmO);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hmS = -1;
                d.this.ceG();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.hmP.isSelected() ? false : true;
                d.this.hmP.setSelect(z);
                d.this.hmM.setSelect(false);
                d.this.hmO.setSelect(false);
                d.this.hmN.setSelect(false);
                d.this.nB(false);
                if (z) {
                    d.this.hmS = 4;
                    d.this.hmP.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hmP);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hmS = -1;
                d.this.ceG();
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
        ceG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(boolean z) {
        this.hmQ.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ceE();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void p(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cd(View view) {
        this.hmL = view;
        this.hmM = (AlaDoubleStateImageView) this.hmL.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.hmM.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.hmM.setOnClickListener(this.hmU);
        this.hmN = (AlaDoubleStateImageView) this.hmL.findViewById(a.g.ala_prepare_share_img_weixin);
        this.hmN.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.hmN.setOnClickListener(this.hmU);
        this.hmO = (AlaDoubleStateImageView) this.hmL.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.hmO.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.hmO.setOnClickListener(this.hmU);
        this.hmP = (AlaDoubleStateImageView) this.hmL.findViewById(a.g.ala_prepare_share_img_qq);
        this.hmP.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.hmP.setOnClickListener(this.hmU);
        switch (this.hmS) {
            case 1:
                this.hmM.setSelect(true);
                break;
            case 2:
                this.hmN.setSelect(true);
                break;
            case 3:
                this.hmO.setSelect(true);
                break;
            case 4:
                this.hmP.setSelect(true);
                break;
        }
        this.hmQ = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.hmR = (TextView) this.hmQ.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.hhH = iShareCallback;
    }

    public boolean bYL() {
        return this.mShareChannel != null && this.hmS >= 1 && this.hmS <= 4;
    }

    public void y(String str, String str2, String str3, String str4) {
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
        ShareEntity If = If(str);
        if (If != null) {
            switch (this.hmS) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            If.content = str3.replace("直播标题", str2);
                        } else {
                            If.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        If.title = "腻害了";
                    }
                    a(If);
                    return;
                case 2:
                    If.content = str2;
                    If.title = str4;
                    b(If);
                    return;
                case 3:
                    If.content = str2;
                    If.title = str4;
                    c(If);
                    return;
                case 4:
                    If.content = str2;
                    If.title = str4;
                    d(If);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity If(String str) {
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
        shareEntity.shareType = this.hmS;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hhH);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hhH);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hhH);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hhH);
    }

    private void ceE() {
        this.hmS = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void b(final int[] iArr, final int i, final int i2) {
        ceF();
        if (this.hmQ.getParent() != null) {
            ((ViewGroup) this.hmQ.getParent()).removeView(this.hmQ);
        }
        this.mRootView.addView(this.hmQ);
        this.hmQ.setVisibility(4);
        this.hmQ.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hmQ.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hmQ.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hmQ.setLayoutParams(layoutParams);
                    d.this.hmQ.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hmT);
        this.mHandler.postDelayed(this.hmT, 5000L);
    }

    private void ceF() {
        String str = null;
        switch (this.hmS) {
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
        this.hmR.setText(str);
    }

    public void ceG() {
        if (this.hmQ.getParent() != null) {
            ((ViewGroup) this.hmQ.getParent()).removeView(this.hmQ);
        }
    }

    public void ceH() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hmS);
    }

    public void release() {
        this.hmS = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
