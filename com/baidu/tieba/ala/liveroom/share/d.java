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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.view.AlaDoubleStateImageView;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class d {
    private IShareCallback fKN;
    private View fPt;
    private AlaDoubleStateImageView fPu;
    private AlaDoubleStateImageView fPv;
    private AlaDoubleStateImageView fPw;
    private AlaDoubleStateImageView fPx;
    private View fPy;
    private TextView fPz;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;
    private int fPA = -1;
    private Runnable fPB = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bzV();
        }
    };
    private View.OnClickListener fPC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.fPu.isSelected();
                d.this.fPu.setSelect(z2);
                d.this.fPv.setSelect(false);
                d.this.fPw.setSelect(false);
                d.this.fPx.setSelect(false);
                d.this.kR(false);
                if (z2) {
                    d.this.fPA = 1;
                    d.this.fPu.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.fPu);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.fPA = -1;
                d.this.bzV();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.fPv.isSelected() ? false : true;
                d.this.fPv.setSelect(z);
                d.this.fPu.setSelect(false);
                d.this.fPw.setSelect(false);
                d.this.fPx.setSelect(false);
                d.this.kR(false);
                if (z) {
                    d.this.fPA = 2;
                    d.this.fPv.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.fPv);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.fPA = -1;
                d.this.bzV();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.fPw.isSelected();
                d.this.fPw.setSelect(z3);
                d.this.fPu.setSelect(false);
                d.this.fPv.setSelect(false);
                d.this.fPx.setSelect(false);
                d.this.kR(true);
                if (z3) {
                    d.this.fPA = 3;
                    d.this.fPw.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.fPw);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.fPA = -1;
                d.this.bzV();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.fPx.isSelected() ? false : true;
                d.this.fPx.setSelect(z);
                d.this.fPu.setSelect(false);
                d.this.fPw.setSelect(false);
                d.this.fPv.setSelect(false);
                d.this.kR(false);
                if (z) {
                    d.this.fPA = 4;
                    d.this.fPx.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.fPx);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.fPA = -1;
                d.this.bzV();
            }
        }
    };
    private Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.tG().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.tG().putBoolean(str, false);
            return;
        }
        bzV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR(boolean z) {
        this.fPy.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bzT();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void h(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bF(View view) {
        this.fPt = view;
        this.fPu = (AlaDoubleStateImageView) this.fPt.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.fPu.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.fPu.setOnClickListener(this.fPC);
        this.fPv = (AlaDoubleStateImageView) this.fPt.findViewById(a.g.ala_prepare_share_img_weixin);
        this.fPv.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.fPv.setOnClickListener(this.fPC);
        this.fPw = (AlaDoubleStateImageView) this.fPt.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.fPw.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.fPw.setOnClickListener(this.fPC);
        this.fPx = (AlaDoubleStateImageView) this.fPt.findViewById(a.g.ala_prepare_share_img_qq);
        this.fPx.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.fPx.setOnClickListener(this.fPC);
        switch (this.fPA) {
            case 1:
                this.fPu.setSelect(true);
                break;
            case 2:
                this.fPv.setSelect(true);
                break;
            case 3:
                this.fPw.setSelect(true);
                break;
            case 4:
                this.fPx.setSelect(true);
                break;
        }
        this.fPy = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.fPz = (TextView) this.fPy.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.fKN = iShareCallback;
    }

    public boolean bvd() {
        return this.mShareChannel != null && this.fPA >= 1 && this.fPA <= 4;
    }

    public void v(String str, String str2, String str3, String str4) {
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
        ShareEntity Be = Be(str);
        if (Be != null) {
            switch (this.fPA) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Be.content = str3.replace("直播标题", str2);
                        } else {
                            Be.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Be.title = "腻害了";
                    }
                    a(Be);
                    return;
                case 2:
                    Be.content = str2;
                    Be.title = str4;
                    b(Be);
                    return;
                case 3:
                    Be.content = str2;
                    Be.title = str4;
                    c(Be);
                    return;
                case 4:
                    Be.content = str2;
                    Be.title = str4;
                    d(Be);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Be(String str) {
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
        shareEntity.shareType = this.fPA;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.fKN);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.fKN);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.fKN);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.fKN);
    }

    private void bzT() {
        this.fPA = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bzU();
        if (this.fPy.getParent() != null) {
            ((ViewGroup) this.fPy.getParent()).removeView(this.fPy);
        }
        this.mRootView.addView(this.fPy);
        this.fPy.setVisibility(4);
        this.fPy.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fPy.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.fPy.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.fPy.setLayoutParams(layoutParams);
                    d.this.fPy.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.fPB);
        this.mHandler.postDelayed(this.fPB, 5000L);
    }

    private void bzU() {
        String str = null;
        switch (this.fPA) {
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
        this.fPz.setText(str);
    }

    public void bzV() {
        if (this.fPy.getParent() != null) {
            ((ViewGroup) this.fPy.getParent()).removeView(this.fPy);
        }
    }

    public void bzW() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.fPA);
    }

    public void release() {
        this.fPA = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
