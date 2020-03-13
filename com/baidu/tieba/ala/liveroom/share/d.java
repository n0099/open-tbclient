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
    private IShareCallback ffX;
    private AlaDoubleStateImageView fkA;
    private View fkB;
    private TextView fkC;
    private View fkw;
    private AlaDoubleStateImageView fkx;
    private AlaDoubleStateImageView fky;
    private AlaDoubleStateImageView fkz;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;
    private int fkD = -1;
    private Runnable fkE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bqv();
        }
    };
    private View.OnClickListener fkF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.fkx.isSelected();
                d.this.fkx.setSelect(z2);
                d.this.fky.setSelect(false);
                d.this.fkz.setSelect(false);
                d.this.fkA.setSelect(false);
                d.this.jL(false);
                if (z2) {
                    d.this.fkD = 1;
                    d.this.fkx.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.fkx);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.fkD = -1;
                d.this.bqv();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.fky.isSelected() ? false : true;
                d.this.fky.setSelect(z);
                d.this.fkx.setSelect(false);
                d.this.fkz.setSelect(false);
                d.this.fkA.setSelect(false);
                d.this.jL(false);
                if (z) {
                    d.this.fkD = 2;
                    d.this.fky.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.fky);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.fkD = -1;
                d.this.bqv();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.fkz.isSelected();
                d.this.fkz.setSelect(z3);
                d.this.fkx.setSelect(false);
                d.this.fky.setSelect(false);
                d.this.fkA.setSelect(false);
                d.this.jL(true);
                if (z3) {
                    d.this.fkD = 3;
                    d.this.fkz.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.fkz);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.fkD = -1;
                d.this.bqv();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.fkA.isSelected() ? false : true;
                d.this.fkA.setSelect(z);
                d.this.fkx.setSelect(false);
                d.this.fkz.setSelect(false);
                d.this.fky.setSelect(false);
                d.this.jL(false);
                if (z) {
                    d.this.fkD = 4;
                    d.this.fkA.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.fkA);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.fkD = -1;
                d.this.bqv();
            }
        }
    };
    private Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.pr().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.pr().putBoolean(str, false);
            return;
        }
        bqv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(boolean z) {
        this.fkB.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bqt();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void g(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bA(View view) {
        this.fkw = view;
        this.fkx = (AlaDoubleStateImageView) this.fkw.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.fkx.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.fkx.setOnClickListener(this.fkF);
        this.fky = (AlaDoubleStateImageView) this.fkw.findViewById(a.g.ala_prepare_share_img_weixin);
        this.fky.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.fky.setOnClickListener(this.fkF);
        this.fkz = (AlaDoubleStateImageView) this.fkw.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.fkz.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.fkz.setOnClickListener(this.fkF);
        this.fkA = (AlaDoubleStateImageView) this.fkw.findViewById(a.g.ala_prepare_share_img_qq);
        this.fkA.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.fkA.setOnClickListener(this.fkF);
        switch (this.fkD) {
            case 1:
                this.fkx.setSelect(true);
                break;
            case 2:
                this.fky.setSelect(true);
                break;
            case 3:
                this.fkz.setSelect(true);
                break;
            case 4:
                this.fkA.setSelect(true);
                break;
        }
        this.fkB = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.fkC = (TextView) this.fkB.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.ffX = iShareCallback;
    }

    public boolean blJ() {
        return this.mShareChannel != null && this.fkD >= 1 && this.fkD <= 4;
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
        ShareEntity zu = zu(str);
        if (zu != null) {
            switch (this.fkD) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            zu.content = str3.replace("直播标题", str2);
                        } else {
                            zu.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        zu.title = "腻害了";
                    }
                    a(zu);
                    return;
                case 2:
                    zu.content = str2;
                    zu.title = str4;
                    b(zu);
                    return;
                case 3:
                    zu.content = str2;
                    zu.title = str4;
                    c(zu);
                    return;
                case 4:
                    zu.content = str2;
                    zu.title = str4;
                    d(zu);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity zu(String str) {
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
        String zv = zv(currentAccountName);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uname=" + zv;
        } else {
            str2 = shareUrl + "?uname=" + zv;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.fkD;
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

    private String zv(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.ffX);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.ffX);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.ffX);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.ffX);
    }

    private void bqt() {
        this.fkD = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bqu();
        if (this.fkB.getParent() != null) {
            ((ViewGroup) this.fkB.getParent()).removeView(this.fkB);
        }
        this.mRootView.addView(this.fkB);
        this.fkB.setVisibility(4);
        this.fkB.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fkB.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.fkB.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.fkB.setLayoutParams(layoutParams);
                    d.this.fkB.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.fkE);
        this.mHandler.postDelayed(this.fkE, 5000L);
    }

    private void bqu() {
        String str = null;
        switch (this.fkD) {
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
        this.fkC.setText(str);
    }

    public void bqv() {
        if (this.fkB.getParent() != null) {
            ((ViewGroup) this.fkB.getParent()).removeView(this.fkB);
        }
    }

    public void bqw() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.fkD);
    }

    public void release() {
        this.fkD = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
