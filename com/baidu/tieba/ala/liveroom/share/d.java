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
    private IShareCallback hIE;
    private View hOd;
    private AlaDoubleStateImageView hOe;
    private AlaDoubleStateImageView hOf;
    private AlaDoubleStateImageView hOg;
    private AlaDoubleStateImageView hOh;
    private View hOi;
    private TextView hOj;
    private int hOk = -1;
    private Runnable hOl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.ckA();
        }
    };
    private View.OnClickListener hOm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hOe.isSelected();
                d.this.hOe.setSelect(z2);
                d.this.hOf.setSelect(false);
                d.this.hOg.setSelect(false);
                d.this.hOh.setSelect(false);
                d.this.oL(false);
                if (z2) {
                    d.this.hOk = 1;
                    d.this.hOe.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hOe);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hOk = -1;
                d.this.ckA();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hOf.isSelected() ? false : true;
                d.this.hOf.setSelect(z);
                d.this.hOe.setSelect(false);
                d.this.hOg.setSelect(false);
                d.this.hOh.setSelect(false);
                d.this.oL(false);
                if (z) {
                    d.this.hOk = 2;
                    d.this.hOf.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hOf);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hOk = -1;
                d.this.ckA();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hOg.isSelected();
                d.this.hOg.setSelect(z3);
                d.this.hOe.setSelect(false);
                d.this.hOf.setSelect(false);
                d.this.hOh.setSelect(false);
                d.this.oL(true);
                if (z3) {
                    d.this.hOk = 3;
                    d.this.hOg.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hOg);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hOk = -1;
                d.this.ckA();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hOh.isSelected() ? false : true;
                d.this.hOh.setSelect(z);
                d.this.hOe.setSelect(false);
                d.this.hOg.setSelect(false);
                d.this.hOf.setSelect(false);
                d.this.oL(false);
                if (z) {
                    d.this.hOk = 4;
                    d.this.hOh.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hOh);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hOk = -1;
                d.this.ckA();
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
        ckA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL(boolean z) {
        this.hOi.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cky();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void o(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cx(View view) {
        this.hOd = view;
        this.hOe = (AlaDoubleStateImageView) this.hOd.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hOe.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hOe.setOnClickListener(this.hOm);
        this.hOf = (AlaDoubleStateImageView) this.hOd.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hOf.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hOf.setOnClickListener(this.hOm);
        this.hOg = (AlaDoubleStateImageView) this.hOd.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hOg.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hOg.setOnClickListener(this.hOm);
        this.hOh = (AlaDoubleStateImageView) this.hOd.findViewById(a.f.ala_prepare_share_img_qq);
        this.hOh.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hOh.setOnClickListener(this.hOm);
        switch (this.hOk) {
            case 1:
                this.hOe.setSelect(true);
                break;
            case 2:
                this.hOf.setSelect(true);
                break;
            case 3:
                this.hOg.setSelect(true);
                break;
            case 4:
                this.hOh.setSelect(true);
                break;
        }
        this.hOi = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hOj = (TextView) this.hOi.findViewById(a.f.tip_tv);
        if (TbadkCoreApplication.getInst().isYinbo()) {
            this.hOh.setVisibility(8);
        } else {
            this.hOh.setVisibility(0);
        }
    }

    public void a(IShareCallback iShareCallback) {
        this.hIE = iShareCallback;
    }

    public boolean ceD() {
        return this.mShareChannel != null && this.hOk >= 1 && this.hOk <= 4;
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
        ShareEntity Ib = Ib(str);
        if (Ib != null) {
            switch (this.hOk) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Ib.content = str3.replace("直播标题", str2);
                        } else {
                            Ib.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Ib.title = "腻害了";
                    }
                    a(Ib);
                    return;
                case 2:
                    Ib.content = str2;
                    Ib.title = str4;
                    b(Ib);
                    return;
                case 3:
                    Ib.content = str2;
                    Ib.title = str4;
                    c(Ib);
                    return;
                case 4:
                    Ib.content = str2;
                    Ib.title = str4;
                    d(Ib);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Ib(String str) {
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
        shareEntity.shareType = this.hOk;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hIE);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hIE);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hIE);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hIE);
    }

    private void cky() {
        this.hOk = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        ckz();
        if (this.hOi.getParent() != null) {
            ((ViewGroup) this.hOi.getParent()).removeView(this.hOi);
        }
        this.mRootView.addView(this.hOi);
        this.hOi.setVisibility(4);
        this.hOi.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hOi.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hOi.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hOi.setLayoutParams(layoutParams);
                    d.this.hOi.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hOl);
        this.mHandler.postDelayed(this.hOl, 5000L);
    }

    private void ckz() {
        String str = null;
        switch (this.hOk) {
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
        this.hOj.setText(str);
    }

    public void ckA() {
        if (this.hOi.getParent() != null) {
            ((ViewGroup) this.hOi.getParent()).removeView(this.hOi);
        }
    }

    public void ckB() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hOk);
    }

    public void release() {
        this.hOk = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
