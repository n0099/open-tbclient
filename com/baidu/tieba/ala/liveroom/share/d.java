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
    private IShareCallback fgw;
    private View fkV;
    private AlaDoubleStateImageView fkW;
    private AlaDoubleStateImageView fkX;
    private AlaDoubleStateImageView fkY;
    private AlaDoubleStateImageView fkZ;
    private View fla;
    private TextView flb;
    private int flc = -1;
    private Runnable fld = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bqA();
        }
    };
    private View.OnClickListener fle = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.fkW.isSelected();
                d.this.fkW.setSelect(z2);
                d.this.fkX.setSelect(false);
                d.this.fkY.setSelect(false);
                d.this.fkZ.setSelect(false);
                d.this.jN(false);
                if (z2) {
                    d.this.flc = 1;
                    d.this.fkW.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.fkW);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.flc = -1;
                d.this.bqA();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.fkX.isSelected() ? false : true;
                d.this.fkX.setSelect(z);
                d.this.fkW.setSelect(false);
                d.this.fkY.setSelect(false);
                d.this.fkZ.setSelect(false);
                d.this.jN(false);
                if (z) {
                    d.this.flc = 2;
                    d.this.fkX.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.fkX);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.flc = -1;
                d.this.bqA();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.fkY.isSelected();
                d.this.fkY.setSelect(z3);
                d.this.fkW.setSelect(false);
                d.this.fkX.setSelect(false);
                d.this.fkZ.setSelect(false);
                d.this.jN(true);
                if (z3) {
                    d.this.flc = 3;
                    d.this.fkY.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.fkY);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.flc = -1;
                d.this.bqA();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.fkZ.isSelected() ? false : true;
                d.this.fkZ.setSelect(z);
                d.this.fkW.setSelect(false);
                d.this.fkY.setSelect(false);
                d.this.fkX.setSelect(false);
                d.this.jN(false);
                if (z) {
                    d.this.flc = 4;
                    d.this.fkZ.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.fkZ);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.flc = -1;
                d.this.bqA();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.pw().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.pw().putBoolean(str, false);
            return;
        }
        bqA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN(boolean z) {
        this.fla.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bqy();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void g(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bA(View view) {
        this.fkV = view;
        this.fkW = (AlaDoubleStateImageView) this.fkV.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.fkW.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.fkW.setOnClickListener(this.fle);
        this.fkX = (AlaDoubleStateImageView) this.fkV.findViewById(a.g.ala_prepare_share_img_weixin);
        this.fkX.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.fkX.setOnClickListener(this.fle);
        this.fkY = (AlaDoubleStateImageView) this.fkV.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.fkY.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.fkY.setOnClickListener(this.fle);
        this.fkZ = (AlaDoubleStateImageView) this.fkV.findViewById(a.g.ala_prepare_share_img_qq);
        this.fkZ.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.fkZ.setOnClickListener(this.fle);
        switch (this.flc) {
            case 1:
                this.fkW.setSelect(true);
                break;
            case 2:
                this.fkX.setSelect(true);
                break;
            case 3:
                this.fkY.setSelect(true);
                break;
            case 4:
                this.fkZ.setSelect(true);
                break;
        }
        this.fla = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.flb = (TextView) this.fla.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.fgw = iShareCallback;
    }

    public boolean blO() {
        return this.mShareChannel != null && this.flc >= 1 && this.flc <= 4;
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
        ShareEntity zv = zv(str);
        if (zv != null) {
            switch (this.flc) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            zv.content = str3.replace("直播标题", str2);
                        } else {
                            zv.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        zv.title = "腻害了";
                    }
                    a(zv);
                    return;
                case 2:
                    zv.content = str2;
                    zv.title = str4;
                    b(zv);
                    return;
                case 3:
                    zv.content = str2;
                    zv.title = str4;
                    c(zv);
                    return;
                case 4:
                    zv.content = str2;
                    zv.title = str4;
                    d(zv);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity zv(String str) {
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
        String zw = zw(currentAccountName);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uname=" + zw;
        } else {
            str2 = shareUrl + "?uname=" + zw;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.flc;
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

    private String zw(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.fgw);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.fgw);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.fgw);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.fgw);
    }

    private void bqy() {
        this.flc = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bqz();
        if (this.fla.getParent() != null) {
            ((ViewGroup) this.fla.getParent()).removeView(this.fla);
        }
        this.mRootView.addView(this.fla);
        this.fla.setVisibility(4);
        this.fla.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fla.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.fla.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.fla.setLayoutParams(layoutParams);
                    d.this.fla.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.fld);
        this.mHandler.postDelayed(this.fld, 5000L);
    }

    private void bqz() {
        String str = null;
        switch (this.flc) {
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
        this.flb.setText(str);
    }

    public void bqA() {
        if (this.fla.getParent() != null) {
            ((ViewGroup) this.fla.getParent()).removeView(this.fla);
        }
    }

    public void bqB() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.flc);
    }

    public void release() {
        this.flc = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
