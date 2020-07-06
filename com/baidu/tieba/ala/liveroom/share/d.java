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
/* loaded from: classes3.dex */
public class d {
    private IShareCallback glX;
    private View gri;
    private AlaDoubleStateImageView grj;
    private AlaDoubleStateImageView grk;
    private AlaDoubleStateImageView grl;
    private AlaDoubleStateImageView grm;
    private View grn;
    private TextView gro;
    private int grp = -1;
    private Runnable grq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bJq();
        }
    };
    private View.OnClickListener grr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "share_clk"));
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.grj.isSelected();
                d.this.grj.setSelect(z2);
                d.this.grk.setSelect(false);
                d.this.grl.setSelect(false);
                d.this.grm.setSelect(false);
                d.this.lw(false);
                if (z2) {
                    d.this.grp = 1;
                    d.this.grj.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.grj);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.grp = -1;
                d.this.bJq();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.grk.isSelected() ? false : true;
                d.this.grk.setSelect(z);
                d.this.grj.setSelect(false);
                d.this.grl.setSelect(false);
                d.this.grm.setSelect(false);
                d.this.lw(false);
                if (z) {
                    d.this.grp = 2;
                    d.this.grk.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.grk);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.grp = -1;
                d.this.bJq();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.grl.isSelected();
                d.this.grl.setSelect(z3);
                d.this.grj.setSelect(false);
                d.this.grk.setSelect(false);
                d.this.grm.setSelect(false);
                d.this.lw(true);
                if (z3) {
                    d.this.grp = 3;
                    d.this.grl.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.grl);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.grp = -1;
                d.this.bJq();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.grm.isSelected() ? false : true;
                d.this.grm.setSelect(z);
                d.this.grj.setSelect(false);
                d.this.grl.setSelect(false);
                d.this.grk.setSelect(false);
                d.this.lw(false);
                if (z) {
                    d.this.grp = 4;
                    d.this.grm.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.grm);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.grp = -1;
                d.this.bJq();
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
        bJq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(boolean z) {
        this.grn.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bJo();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void m(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bI(View view) {
        this.gri = view;
        this.grj = (AlaDoubleStateImageView) this.gri.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.grj.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.grj.setOnClickListener(this.grr);
        this.grk = (AlaDoubleStateImageView) this.gri.findViewById(a.g.ala_prepare_share_img_weixin);
        this.grk.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.grk.setOnClickListener(this.grr);
        this.grl = (AlaDoubleStateImageView) this.gri.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.grl.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.grl.setOnClickListener(this.grr);
        this.grm = (AlaDoubleStateImageView) this.gri.findViewById(a.g.ala_prepare_share_img_qq);
        this.grm.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.grm.setOnClickListener(this.grr);
        switch (this.grp) {
            case 1:
                this.grj.setSelect(true);
                break;
            case 2:
                this.grk.setSelect(true);
                break;
            case 3:
                this.grl.setSelect(true);
                break;
            case 4:
                this.grm.setSelect(true);
                break;
        }
        this.grn = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.gro = (TextView) this.grn.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.glX = iShareCallback;
    }

    public boolean bEh() {
        return this.mShareChannel != null && this.grp >= 1 && this.grp <= 4;
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
        ShareEntity Dn = Dn(str);
        if (Dn != null) {
            switch (this.grp) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            Dn.content = str3.replace("直播标题", str2);
                        } else {
                            Dn.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        Dn.title = "腻害了";
                    }
                    a(Dn);
                    return;
                case 2:
                    Dn.content = str2;
                    Dn.title = str4;
                    b(Dn);
                    return;
                case 3:
                    Dn.content = str2;
                    Dn.title = str4;
                    c(Dn);
                    return;
                case 4:
                    Dn.content = str2;
                    Dn.title = str4;
                    d(Dn);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity Dn(String str) {
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
        shareEntity.shareType = this.grp;
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
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.glX);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.glX);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.glX);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.glX);
    }

    private void bJo() {
        this.grp = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bJp();
        if (this.grn.getParent() != null) {
            ((ViewGroup) this.grn.getParent()).removeView(this.grn);
        }
        this.mRootView.addView(this.grn);
        this.grn.setVisibility(4);
        this.grn.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.grn.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.grn.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.grn.setLayoutParams(layoutParams);
                    d.this.grn.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.grq);
        this.mHandler.postDelayed(this.grq, 5000L);
    }

    private void bJp() {
        String str = null;
        switch (this.grp) {
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
        this.gro.setText(str);
    }

    public void bJq() {
        if (this.grn.getParent() != null) {
            ((ViewGroup) this.grn.getParent()).removeView(this.grn);
        }
    }

    public void bJr() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.grp);
    }

    public void release() {
        this.grp = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
