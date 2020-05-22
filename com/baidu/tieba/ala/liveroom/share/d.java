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
    private IShareCallback fYL;
    private View ged;
    private AlaDoubleStateImageView gee;
    private AlaDoubleStateImageView gef;
    private AlaDoubleStateImageView geg;
    private AlaDoubleStateImageView geh;
    private View gei;
    private TextView gej;
    private int gek = -1;
    private Runnable gel = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bGi();
        }
    };
    private View.OnClickListener gem = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.gee.isSelected();
                d.this.gee.setSelect(z2);
                d.this.gef.setSelect(false);
                d.this.geg.setSelect(false);
                d.this.geh.setSelect(false);
                d.this.lo(false);
                if (z2) {
                    d.this.gek = 1;
                    d.this.gee.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.gee);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.gek = -1;
                d.this.bGi();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.gef.isSelected() ? false : true;
                d.this.gef.setSelect(z);
                d.this.gee.setSelect(false);
                d.this.geg.setSelect(false);
                d.this.geh.setSelect(false);
                d.this.lo(false);
                if (z) {
                    d.this.gek = 2;
                    d.this.gef.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.gef);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.gek = -1;
                d.this.bGi();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.geg.isSelected();
                d.this.geg.setSelect(z3);
                d.this.gee.setSelect(false);
                d.this.gef.setSelect(false);
                d.this.geh.setSelect(false);
                d.this.lo(true);
                if (z3) {
                    d.this.gek = 3;
                    d.this.geg.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.geg);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.gek = -1;
                d.this.bGi();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.geh.isSelected() ? false : true;
                d.this.geh.setSelect(z);
                d.this.gee.setSelect(false);
                d.this.geg.setSelect(false);
                d.this.gef.setSelect(false);
                d.this.lo(false);
                if (z) {
                    d.this.gek = 4;
                    d.this.geh.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.geh);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.gek = -1;
                d.this.bGi();
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
        bGi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(boolean z) {
        this.gei.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bGg();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void l(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bE(View view) {
        this.ged = view;
        this.gee = (AlaDoubleStateImageView) this.ged.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.gee.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.gee.setOnClickListener(this.gem);
        this.gef = (AlaDoubleStateImageView) this.ged.findViewById(a.g.ala_prepare_share_img_weixin);
        this.gef.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.gef.setOnClickListener(this.gem);
        this.geg = (AlaDoubleStateImageView) this.ged.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.geg.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.geg.setOnClickListener(this.gem);
        this.geh = (AlaDoubleStateImageView) this.ged.findViewById(a.g.ala_prepare_share_img_qq);
        this.geh.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.geh.setOnClickListener(this.gem);
        switch (this.gek) {
            case 1:
                this.gee.setSelect(true);
                break;
            case 2:
                this.gef.setSelect(true);
                break;
            case 3:
                this.geg.setSelect(true);
                break;
            case 4:
                this.geh.setSelect(true);
                break;
        }
        this.gei = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gej = (TextView) this.gei.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.fYL = iShareCallback;
    }

    public boolean bBc() {
        return this.mShareChannel != null && this.gek >= 1 && this.gek <= 4;
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
            switch (this.gek) {
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
        shareEntity.shareType = this.gek;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.fYL);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.fYL);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.fYL);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.fYL);
    }

    private void bGg() {
        this.gek = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bGh();
        if (this.gei.getParent() != null) {
            ((ViewGroup) this.gei.getParent()).removeView(this.gei);
        }
        this.mRootView.addView(this.gei);
        this.gei.setVisibility(4);
        this.gei.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gei.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.gei.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.gei.setLayoutParams(layoutParams);
                    d.this.gei.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.gel);
        this.mHandler.postDelayed(this.gel, 5000L);
    }

    private void bGh() {
        String str = null;
        switch (this.gek) {
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
        this.gej.setText(str);
    }

    public void bGi() {
        if (this.gei.getParent() != null) {
            ((ViewGroup) this.gei.getParent()).removeView(this.gei);
        }
    }

    public void bGj() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.gek);
    }

    public void release() {
        this.gek = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
