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
/* loaded from: classes10.dex */
public class d {
    private IShareCallback hEe;
    private View hJr;
    private AlaDoubleStateImageView hJs;
    private AlaDoubleStateImageView hJt;
    private AlaDoubleStateImageView hJu;
    private AlaDoubleStateImageView hJv;
    private View hJw;
    private TextView hJx;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;
    private int hJy = -1;
    private Runnable hJz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.cju();
        }
    };
    private View.OnClickListener hJA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.f.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.hJs.isSelected();
                d.this.hJs.setSelect(z2);
                d.this.hJt.setSelect(false);
                d.this.hJu.setSelect(false);
                d.this.hJv.setSelect(false);
                d.this.oB(false);
                if (z2) {
                    d.this.hJy = 1;
                    d.this.hJs.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.hJs);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.hJy = -1;
                d.this.cju();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin) {
                z = d.this.hJt.isSelected() ? false : true;
                d.this.hJt.setSelect(z);
                d.this.hJs.setSelect(false);
                d.this.hJu.setSelect(false);
                d.this.hJv.setSelect(false);
                d.this.oB(false);
                if (z) {
                    d.this.hJy = 2;
                    d.this.hJt.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.hJt);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.hJy = -1;
                d.this.cju();
            } else if (view.getId() == a.f.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.hJu.isSelected();
                d.this.hJu.setSelect(z3);
                d.this.hJs.setSelect(false);
                d.this.hJt.setSelect(false);
                d.this.hJv.setSelect(false);
                d.this.oB(true);
                if (z3) {
                    d.this.hJy = 3;
                    d.this.hJu.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.hJu);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.hJy = -1;
                d.this.cju();
            } else if (view.getId() == a.f.ala_prepare_share_img_qq) {
                z = d.this.hJv.isSelected() ? false : true;
                d.this.hJv.setSelect(z);
                d.this.hJs.setSelect(false);
                d.this.hJu.setSelect(false);
                d.this.hJt.setSelect(false);
                d.this.oB(false);
                if (z) {
                    d.this.hJy = 4;
                    d.this.hJv.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.hJv);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.hJy = -1;
                d.this.cju();
            }
        }
    };
    private Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.d.xf().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.d.xf().putBoolean(str, false);
            return;
        }
        cju();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oB(boolean z) {
        this.hJw.setBackgroundResource(z ? a.e.pic_live_beginshow_bubble_3 : a.e.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cjs();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void o(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void cB(View view) {
        this.hJr = view;
        this.hJs = (AlaDoubleStateImageView) this.hJr.findViewById(a.f.ala_prepare_share_img_sina_weibo);
        this.hJs.setImageSrc(a.e.icon_live_share_sina_n, a.e.icon_live_share_sina_s);
        this.hJs.setOnClickListener(this.hJA);
        this.hJt = (AlaDoubleStateImageView) this.hJr.findViewById(a.f.ala_prepare_share_img_weixin);
        this.hJt.setImageSrc(a.e.icon_live_share_weixin_n, a.e.icon_live_share_weixin_s);
        this.hJt.setOnClickListener(this.hJA);
        this.hJu = (AlaDoubleStateImageView) this.hJr.findViewById(a.f.ala_prepare_share_img_weixin_circle);
        this.hJu.setImageSrc(a.e.icon_live_share_quan_n, a.e.icon_live_share_quan_s);
        this.hJu.setOnClickListener(this.hJA);
        this.hJv = (AlaDoubleStateImageView) this.hJr.findViewById(a.f.ala_prepare_share_img_qq);
        this.hJv.setImageSrc(a.e.icon_live_share_qq_n, a.e.icon_live_share_qq_s);
        this.hJv.setOnClickListener(this.hJA);
        switch (this.hJy) {
            case 1:
                this.hJs.setSelect(true);
                break;
            case 2:
                this.hJt.setSelect(true);
                break;
            case 3:
                this.hJu.setSelect(true);
                break;
            case 4:
                this.hJv.setSelect(true);
                break;
        }
        this.hJw = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_prepare_share_tip_view, this.mRootView, false);
        this.hJx = (TextView) this.hJw.findViewById(a.f.tip_tv);
        if (TbadkCoreApplication.getInst().isYinbo()) {
            this.hJv.setVisibility(8);
        } else {
            this.hJv.setVisibility(0);
        }
    }

    public void a(IShareCallback iShareCallback) {
        this.hEe = iShareCallback;
    }

    public boolean cdB() {
        return this.mShareChannel != null && this.hJy >= 1 && this.hJy <= 4;
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
        ShareEntity Hw = Hw(str);
        if (Hw != null) {
            switch (this.hJy) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Hw.content = str3.replace("直播标题", str2);
                        } else {
                            Hw.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Hw.title = "腻害了";
                    }
                    a(Hw);
                    return;
                case 2:
                    Hw.content = str2;
                    Hw.title = str4;
                    b(Hw);
                    return;
                case 3:
                    Hw.content = str2;
                    Hw.title = str4;
                    c(Hw);
                    return;
                case 4:
                    Hw.content = str2;
                    Hw.title = str4;
                    d(Hw);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Hw(String str) {
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
        shareEntity.shareType = this.hJy;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.hEe);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.hEe);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.hEe);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.hEe);
    }

    private void cjs() {
        this.hJy = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        cjt();
        if (this.hJw.getParent() != null) {
            ((ViewGroup) this.hJw.getParent()).removeView(this.hJw);
        }
        this.mRootView.addView(this.hJw);
        this.hJw.setVisibility(4);
        this.hJw.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.hJw.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.hJw.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.hJw.setLayoutParams(layoutParams);
                    d.this.hJw.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.hJz);
        this.mHandler.postDelayed(this.hJz, 5000L);
    }

    private void cjt() {
        String str = null;
        switch (this.hJy) {
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
        this.hJx.setText(str);
    }

    public void cju() {
        if (this.hJw.getParent() != null) {
            ((ViewGroup) this.hJw.getParent()).removeView(this.hJw);
        }
    }

    public void cjv() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.hJy);
    }

    public void release() {
        this.hJy = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
