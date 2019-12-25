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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.view.AlaDoubleStateImageView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class d {
    private IShareCallback eZN;
    private View fdW;
    private AlaDoubleStateImageView fdX;
    private AlaDoubleStateImageView fdY;
    private AlaDoubleStateImageView fdZ;
    private AlaDoubleStateImageView fea;
    private View feb;
    private TextView fec;
    private int fed = -1;
    private Runnable fee = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.bnM();
        }
    };
    private View.OnClickListener fef = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.share.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            int[] iArr = new int[2];
            if (view.getId() == a.g.ala_prepare_share_img_sina_weibo) {
                boolean z2 = !d.this.fdX.isSelected();
                d.this.fdX.setSelect(z2);
                d.this.fdY.setSelect(false);
                d.this.fdZ.setSelect(false);
                d.this.fea.setSelect(false);
                d.this.jy(false);
                if (z2) {
                    d.this.fed = 1;
                    d.this.fdX.getLocationOnScreen(iArr);
                    d.this.a("weibo_show", iArr, d.this.fdX);
                    LogManager.getLiveRecordLogger().doClickLiveShareToWeiboButtonLog("");
                    return;
                }
                d.this.fed = -1;
                d.this.bnM();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin) {
                z = d.this.fdY.isSelected() ? false : true;
                d.this.fdY.setSelect(z);
                d.this.fdX.setSelect(false);
                d.this.fdZ.setSelect(false);
                d.this.fea.setSelect(false);
                d.this.jy(false);
                if (z) {
                    d.this.fed = 2;
                    d.this.fdY.getLocationOnScreen(iArr);
                    d.this.a("weixin_show", iArr, d.this.fdY);
                    LogManager.getLiveRecordLogger().doClickLiveShareWeixinButtonLog("");
                    return;
                }
                d.this.fed = -1;
                d.this.bnM();
            } else if (view.getId() == a.g.ala_prepare_share_img_weixin_circle) {
                boolean z3 = !d.this.fdZ.isSelected();
                d.this.fdZ.setSelect(z3);
                d.this.fdX.setSelect(false);
                d.this.fdY.setSelect(false);
                d.this.fea.setSelect(false);
                d.this.jy(true);
                if (z3) {
                    d.this.fed = 3;
                    d.this.fdZ.getLocationOnScreen(iArr);
                    d.this.a("circle_show", iArr, d.this.fdZ);
                    LogManager.getLiveRecordLogger().doClickLiveShareToTimeLineButtonLog("");
                    return;
                }
                d.this.fed = -1;
                d.this.bnM();
            } else if (view.getId() == a.g.ala_prepare_share_img_qq) {
                z = d.this.fea.isSelected() ? false : true;
                d.this.fea.setSelect(z);
                d.this.fdX.setSelect(false);
                d.this.fdZ.setSelect(false);
                d.this.fdY.setSelect(false);
                d.this.jy(false);
                if (z) {
                    d.this.fed = 4;
                    d.this.fea.getLocationOnScreen(iArr);
                    d.this.a("qq_show", iArr, d.this.fea);
                    LogManager.getLiveRecordLogger().doClickLiveShareToQQButtonLog("");
                    return;
                }
                d.this.fed = -1;
                d.this.bnM();
            }
        }
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private IShareChannel mShareChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int[] iArr, View view) {
        if (com.baidu.live.c.oI().getBoolean(str, true)) {
            c(iArr, view.getWidth(), view.getHeight());
            com.baidu.live.c.oI().putBoolean(str, false);
            return;
        }
        bnM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(boolean z) {
        this.feb.setBackgroundResource(z ? a.f.pic_live_beginshow_bubble_3 : a.f.pic_live_beginshow_bubble_2);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bnK();
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
    }

    public void ai(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    public void bv(View view) {
        this.fdW = view;
        this.fdX = (AlaDoubleStateImageView) this.fdW.findViewById(a.g.ala_prepare_share_img_sina_weibo);
        this.fdX.setImageSrc(a.f.icon_live_share_sina_n, a.f.icon_live_share_sina_s);
        this.fdX.setOnClickListener(this.fef);
        this.fdY = (AlaDoubleStateImageView) this.fdW.findViewById(a.g.ala_prepare_share_img_weixin);
        this.fdY.setImageSrc(a.f.icon_live_share_weixin_n, a.f.icon_live_share_weixin_s);
        this.fdY.setOnClickListener(this.fef);
        this.fdZ = (AlaDoubleStateImageView) this.fdW.findViewById(a.g.ala_prepare_share_img_weixin_circle);
        this.fdZ.setImageSrc(a.f.icon_live_share_quan_n, a.f.icon_live_share_quan_s);
        this.fdZ.setOnClickListener(this.fef);
        this.fea = (AlaDoubleStateImageView) this.fdW.findViewById(a.g.ala_prepare_share_img_qq);
        this.fea.setImageSrc(a.f.icon_live_share_qq_n, a.f.icon_live_share_qq_s);
        this.fea.setOnClickListener(this.fef);
        switch (this.fed) {
            case 1:
                this.fdX.setSelect(true);
                break;
            case 2:
                this.fdY.setSelect(true);
                break;
            case 3:
                this.fdZ.setSelect(true);
                break;
            case 4:
                this.fea.setSelect(true);
                break;
        }
        this.feb = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_prepare_share_tip_view, this.mRootView, false);
        this.fec = (TextView) this.feb.findViewById(a.g.tip_tv);
    }

    public void a(IShareCallback iShareCallback) {
        this.eZN = iShareCallback;
    }

    public boolean bjg() {
        return this.mShareChannel != null && this.fed >= 1 && this.fed <= 4;
    }

    public void s(String str, String str2, String str3, String str4) {
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
        ShareEntity yS = yS(str);
        if (yS != null) {
            switch (this.fed) {
                case 1:
                    if (!TextUtils.isEmpty(str3) && str3.contains("直播标题")) {
                        if (!TextUtils.isEmpty(str2)) {
                            yS.content = str3.replace("直播标题", str2);
                        } else {
                            yS.content = str3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        yS.title = "腻害了";
                    }
                    a(yS);
                    return;
                case 2:
                    yS.content = str2;
                    yS.title = str4;
                    b(yS);
                    return;
                case 3:
                    yS.content = str2;
                    yS.title = str4;
                    c(yS);
                    return;
                case 4:
                    yS.content = str2;
                    yS.title = str4;
                    d(yS);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareEntity yS(String str) {
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
        String yT = yT(currentAccountName);
        if (shareUrl.contains("?")) {
            str2 = shareUrl + "&uname=" + yT;
        } else {
            str2 = shareUrl + "?uname=" + yT;
        }
        Log.i("AlaShareController", "@@  " + str2);
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = str2;
        shareEntity.shareType = this.fed;
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

    private String yT(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(ShareEntity shareEntity) {
        this.mShareChannel.shareToSinaWeibo(shareEntity, this.eZN);
    }

    private void b(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixin(shareEntity, this.eZN);
    }

    private void c(ShareEntity shareEntity) {
        this.mShareChannel.shareToWeixinCircle(shareEntity, this.eZN);
    }

    private void d(ShareEntity shareEntity) {
        this.mShareChannel.shareToQQ(shareEntity, this.eZN);
    }

    private void bnK() {
        this.fed = SharedPrefHelper.getInstance().getInt("prepare_share_type", -1);
    }

    private void c(final int[] iArr, final int i, final int i2) {
        bnL();
        if (this.feb.getParent() != null) {
            ((ViewGroup) this.feb.getParent()).removeView(this.feb);
        }
        this.mRootView.addView(this.feb);
        this.feb.setVisibility(4);
        this.feb.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.d.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                d.this.mRootView.getLocationOnScreen(iArr2);
                if (iArr[0] > 0 && iArr[1] > 0) {
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - iArr2[1];
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.feb.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    }
                    layoutParams.leftMargin = (iArr[0] + (i / 2)) - (d.this.feb.getWidth() / 2);
                    layoutParams.topMargin = iArr[1] + i2;
                    d.this.feb.setLayoutParams(layoutParams);
                    d.this.feb.setVisibility(0);
                }
            }
        });
        this.mHandler.removeCallbacks(this.fee);
        this.mHandler.postDelayed(this.fee, 5000L);
    }

    private void bnL() {
        String str = null;
        switch (this.fed) {
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
        this.fec.setText(str);
    }

    public void bnM() {
        if (this.feb.getParent() != null) {
            ((ViewGroup) this.feb.getParent()).removeView(this.feb);
        }
    }

    public void bnN() {
        SharedPrefHelper.getInstance().putInt("prepare_share_type", this.fed);
    }

    public void release() {
        this.fed = -1;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
