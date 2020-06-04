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
import com.baidu.live.u.a;
import com.baidu.live.view.AlaDoubleStateImageView;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class d {
    private IShareCallback fYW;
    private View gep;
    private AlaDoubleStateImageView geq;
    private AlaDoubleStateImageView ger;
    private AlaDoubleStateImageView ges;
    private AlaDoubleStateImageView get;
    private View geu;
    private TextView gev;
    private int gew = -1;
    private Runnable gex = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bGk();
        }
    };
    private View.OnClickListener gey = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.geq.isSelected();
                d.this.geq.setSelect(z2);
                d.this.ger.setSelect(false);
                d.this.ges.setSelect(false);
                d.this.get.setSelect(false);
                d.this.lo(false);
                if (z2) {
                    d.this.gew = 1;
                    d.this.geq.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.geq);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.gew = -1;
                d.this.bGk();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.ger.isSelected() ? false : true;
                d.this.ger.setSelect(z);
                d.this.geq.setSelect(false);
                d.this.ges.setSelect(false);
                d.this.get.setSelect(false);
                d.this.lo(false);
                if (z) {
                    d.this.gew = 2;
                    d.this.ger.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.ger);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.gew = -1;
                d.this.bGk();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.ges.isSelected();
                d.this.ges.setSelect(z3);
                d.this.geq.setSelect(false);
                d.this.ger.setSelect(false);
                d.this.get.setSelect(false);
                d.this.lo(true);
                if (z3) {
                    d.this.gew = 3;
                    d.this.ges.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.ges);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.gew = -1;
                d.this.bGk();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.get.isSelected() ? false : true;
                d.this.get.setSelect(z);
                d.this.geq.setSelect(false);
                d.this.ges.setSelect(false);
                d.this.ger.setSelect(false);
                d.this.lo(false);
                if (z) {
                    d.this.gew = 4;
                    d.this.get.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.get);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.gew = -1;
                d.this.bGk();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.uN().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.uN().putBoolean(str, false);
            return;
        }
        bGk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(boolean z) {
        this.geu.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bGi();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void l(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bE(View view) {
        this.gep = view;
        this.geq = (AlaDoubleStateImageView) this.gep.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.geq.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.geq.setOnClickListener(this.gey);
        this.ger = (AlaDoubleStateImageView) this.gep.findViewById(a.g.ala_prepare_share_img_weixin);
        this.ger.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.ger.setOnClickListener(this.gey);
        this.ges = (AlaDoubleStateImageView) this.gep.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.ges.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.ges.setOnClickListener(this.gey);
        this.get = (AlaDoubleStateImageView) this.gep.findViewById(a.g.ala_prepare_share_img_qq);
        this.get.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.get.setOnClickListener(this.gey);
        switch (this.gew) {
            case 1:
                this.geq.setSelect(true);
                break;
            case 2:
                this.ger.setSelect(true);
                break;
            case 3:
                this.ges.setSelect(true);
                break;
            case 4:
                this.get.setSelect(true);
                break;
        }
        this.geu = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gev = (TextView) this.geu.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.fYW = iShareCallback;
    }

    public boolean bBe() {
        return this.mShareChannel != null && this.gew >= 1 && this.gew <= 4;
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
        ShareEntity CM = CM(str);
        if (CM != null) {
            switch (this.gew) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            CM.content = str3.replace("直播标题", str2);
                        } else {
                            CM.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        CM.title = "腻害了";
                    }
                    a(CM);
                    return;
                case 2:
                    CM.content = str2;
                    CM.title = str4;
                    b(CM);
                    return;
                case 3:
                    CM.content = str2;
                    CM.title = str4;
                    c(CM);
                    return;
                case 4:
                    CM.content = str2;
                    CM.title = str4;
                    d(CM);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity CM(String str) {
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
        shareEntity.shareType = this.gew;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.fYW);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.fYW);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.fYW);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.fYW);
    }

    private void bGi() {
        this.gew = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bGj();
        if (this.geu.getParent() != null) {
            ((ViewGroup) this.geu.getParent()).removeView(this.geu);
        }
        this.mRootView.addView(this.geu);
        this.geu.setVisibility(4);
        this.geu.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.geu.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.geu.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.geu.setLayoutParams(layoutParams);
                    d.this.geu.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.gex);
        this.mHandler.postDelayed(this.gex, 5000L);
    }

    private void bGj() {
        String str = null;
        switch (this.gew) {
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
        this.gev.setText(str);
    }

    public void bGk() {
        if (this.geu.getParent() != null) {
            ((ViewGroup) this.geu.getParent()).removeView(this.geu);
        }
    }

    public void bGl() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.gew);
    }

    public void release() {
        this.gew = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
