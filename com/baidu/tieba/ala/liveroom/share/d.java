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
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.u.a;
import com.baidu.live.view.AlaDoubleStateImageView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class d {
    private IShareCallback ffJ;
    private View fki;
    private AlaDoubleStateImageView fkj;
    private AlaDoubleStateImageView fkk;
    private AlaDoubleStateImageView fkl;
    private AlaDoubleStateImageView fkm;
    private View fkn;
    private TextView fko;
    private int fkp = -1;
    private Runnable fkq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bqs();
        }
    };
    private View.OnClickListener fkr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.fkj.isSelected();
                d.this.fkj.setSelect(z2);
                d.this.fkk.setSelect(false);
                d.this.fkl.setSelect(false);
                d.this.fkm.setSelect(false);
                d.this.jL(false);
                if (z2) {
                    d.this.fkp = 1;
                    d.this.fkj.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.fkj);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.fkp = -1;
                d.this.bqs();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.fkk.isSelected() ? false : true;
                d.this.fkk.setSelect(z);
                d.this.fkj.setSelect(false);
                d.this.fkl.setSelect(false);
                d.this.fkm.setSelect(false);
                d.this.jL(false);
                if (z) {
                    d.this.fkp = 2;
                    d.this.fkk.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.fkk);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.fkp = -1;
                d.this.bqs();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.fkl.isSelected();
                d.this.fkl.setSelect(z3);
                d.this.fkj.setSelect(false);
                d.this.fkk.setSelect(false);
                d.this.fkm.setSelect(false);
                d.this.jL(true);
                if (z3) {
                    d.this.fkp = 3;
                    d.this.fkl.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.fkl);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.fkp = -1;
                d.this.bqs();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.fkm.isSelected() ? false : true;
                d.this.fkm.setSelect(z);
                d.this.fkj.setSelect(false);
                d.this.fkl.setSelect(false);
                d.this.fkk.setSelect(false);
                d.this.jL(false);
                if (z) {
                    d.this.fkp = 4;
                    d.this.fkm.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.fkm);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.fkp = -1;
                d.this.bqs();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.pr().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.pr().putBoolean(str, false);
            return;
        }
        bqs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(boolean z) {
        this.fkn.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bqq();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void g(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bA(View view) {
        this.fki = view;
        this.fkj = (AlaDoubleStateImageView) this.fki.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.fkj.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.fkj.setOnClickListener(this.fkr);
        this.fkk = (AlaDoubleStateImageView) this.fki.findViewById(a.g.ala_prepare_share_img_weixin);
        this.fkk.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.fkk.setOnClickListener(this.fkr);
        this.fkl = (AlaDoubleStateImageView) this.fki.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.fkl.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.fkl.setOnClickListener(this.fkr);
        this.fkm = (AlaDoubleStateImageView) this.fki.findViewById(a.g.ala_prepare_share_img_qq);
        this.fkm.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.fkm.setOnClickListener(this.fkr);
        switch (this.fkp) {
            case 1:
                this.fkj.setSelect(true);
                break;
            case 2:
                this.fkk.setSelect(true);
                break;
            case 3:
                this.fkl.setSelect(true);
                break;
            case 4:
                this.fkm.setSelect(true);
                break;
        }
        this.fkn = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.fko = (TextView) this.fkn.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.ffJ = iShareCallback;
    }

    public boolean blG() {
        return this.mShareChannel != null && this.fkp >= 1 && this.fkp <= 4;
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
        ShareEntity zt = zt(str);
        if (zt != null) {
            switch (this.fkp) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            zt.content = str3.replace("直播标题", str2);
                        } else {
                            zt.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        zt.title = "腻害了";
                    }
                    a(zt);
                    return;
                case 2:
                    zt.content = str2;
                    zt.title = str4;
                    b(zt);
                    return;
                case 3:
                    zt.content = str2;
                    zt.title = str4;
                    c(zt);
                    return;
                case 4:
                    zt.content = str2;
                    zt.title = str4;
                    d(zt);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity zt(String str) {
        String str2;
        ShareEntity shareEntity = new ShareEntity();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getCurrentPortrait();
            if (TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                str = TbadkCoreApplication.getInst().getBigHeaderPhotoUrlPrefix() + str + ".jpg";
            }
        }
        String shareUrl = getShareUrl();
        String zu = zu(currentAccountName);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uname=" + zu;
        } else {
            str2 = shareUrl + "?uname=" + zu;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.fkp;
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

    private String zu(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.ffJ);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.ffJ);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.ffJ);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.ffJ);
    }

    private void bqq() {
        this.fkp = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bqr();
        if (this.fkn.getParent() != null) {
            ((ViewGroup) this.fkn.getParent()).removeView(this.fkn);
        }
        this.mRootView.addView(this.fkn);
        this.fkn.setVisibility(4);
        this.fkn.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fkn.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.fkn.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.fkn.setLayoutParams(layoutParams);
                    d.this.fkn.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.fkq);
        this.mHandler.postDelayed(this.fkq, 5000L);
    }

    private void bqr() {
        String str = null;
        switch (this.fkp) {
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
        this.fko.setText(str);
    }

    public void bqs() {
        if (this.fkn.getParent() != null) {
            ((ViewGroup) this.fkn.getParent()).removeView(this.fkn);
        }
    }

    public void bqt() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.fkp);
    }

    public void release() {
        this.fkp = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
