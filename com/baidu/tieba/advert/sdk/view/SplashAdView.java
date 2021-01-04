package com.baidu.tieba.advert.sdk.view;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.c.a;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.data.b;
import com.baidu.tieba.advert.sdk.data.c;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableType;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableVideoView;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.report.h;
import java.io.File;
/* loaded from: classes8.dex */
public class SplashAdView extends BCAdView {
    private b gnb;
    public boolean gnc;
    public ScalableVideoView gnd;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gmY = redirectType;
        this.gmX = new c(tbPageContext.getPageActivity());
        this.gmU = new AdInfo();
    }

    public boolean bPV() {
        loadAd();
        this.gmU = AdInfo.jsonToObject(this.gmX.bPN());
        this.gmU.placeId = this.placeId;
        if (this.gmU.advisible == 0) {
            e.dFV().a(h.t(this.gmU.extraParam, 3, this.gmU.placeId));
        }
        this.gnb = b.FX(a.bPT());
        if (this.gnb.bPM()) {
            if (this.gnb.isVideoAd()) {
                this.gnc = true;
                String str = this.gnb.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.Y(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.gnd = new ScalableVideoView(this.mContext);
                    this.gnd.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.gnd.setDataSource(str);
                        this.gnd.setVolume(0.0f, 0.0f);
                        this.gnd.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.gnd.start();
                            }
                        });
                        this.gnd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bPS();
                                SplashAdView.this.gnb.videoLocalPath = "";
                                a.a(SplashAdView.this.gnb);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.gnd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.gnd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.gmU.advisible != 0) {
                                        e.dFV().a(h.d(SplashAdView.this.gmU.extraParam, 2, SplashAdView.this.gmU.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gmR != null && !TextUtils.isEmpty(SplashAdView.this.gnb.videoJumpUrl)) {
                                        SplashAdView.this.gmR.FV(SplashAdView.this.gnb.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.gnd, layoutParams);
                        e.dFV().a(h.d(this.gmU.extraParam, 3, this.gmU.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bPS();
                        this.gnb.videoLocalPath = "";
                        a.a(this.gnb);
                        return false;
                    }
                }
                a.bPS();
                this.gnb.videoLocalPath = "";
                a.a(this.gnb);
                return false;
            } else if (!TextUtils.isEmpty(this.gnb.adImgUrl)) {
                if (this.gmT != null) {
                    this.gmT = null;
                }
                this.gmT = new TbImageView(this.mContext);
                this.gmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.gmU.advisible != 0) {
                                e.dFV().a(h.d(SplashAdView.this.gmU.extraParam, 2, SplashAdView.this.gmU.placeId, "image"));
                            }
                            if (SplashAdView.this.gmR != null && !TextUtils.isEmpty(SplashAdView.this.gnb.redirectUrl)) {
                                SplashAdView.this.gmR.FV(SplashAdView.this.gnb.redirectUrl);
                            }
                        }
                    }
                });
                this.gmT.startLoad(this.gmU.adImgUrl, 10, false);
                this.gmT.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.gmT, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                e.dFV().a(h.d(this.gmU.extraParam, 3, this.gmU.placeId, "image"));
                return true;
            } else {
                a.bPS();
            }
        } else {
            a.bPR();
            a.bPS();
        }
        return false;
    }

    public String bPW() {
        if (this.gmU == null) {
            if (this.gmV == null) {
                return null;
            }
            return this.gmV.displayName;
        }
        return this.gmU.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gnd != null) {
            this.gnd.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.gnb;
    }
}
