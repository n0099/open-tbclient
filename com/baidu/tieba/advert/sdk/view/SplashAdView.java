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
import com.baidu.tieba.advert.sdk.d.a;
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
/* loaded from: classes7.dex */
public class SplashAdView extends BCAdView {
    private b gmX;
    public boolean gmY;
    public ScalableVideoView gmZ;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gmU = redirectType;
        this.gmT = new c(tbPageContext.getPageActivity());
        this.gmQ = new AdInfo();
    }

    public boolean bMS() {
        loadAd();
        this.gmQ = AdInfo.jsonToObject(this.gmT.bMG());
        this.gmQ.placeId = this.placeId;
        if (this.gmQ.advisible == 0) {
            e.dEC().a(h.u(this.gmQ.extraParam, 3, this.gmQ.placeId));
        }
        this.gmX = b.Fr(a.bMP());
        if (this.gmX.bMF()) {
            if (this.gmX.isVideoAd()) {
                this.gmY = true;
                String str = this.gmX.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.U(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.gmZ = new ScalableVideoView(this.mContext);
                    this.gmZ.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.gmZ.setDataSource(str);
                        this.gmZ.setVolume(0.0f, 0.0f);
                        this.gmZ.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.gmZ.start();
                            }
                        });
                        this.gmZ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bMO();
                                SplashAdView.this.gmX.videoLocalPath = "";
                                a.a(SplashAdView.this.gmX);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.gmZ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.gmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.gmQ.advisible != 0) {
                                        e.dEC().a(h.d(SplashAdView.this.gmQ.extraParam, 2, SplashAdView.this.gmQ.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gmN != null && !TextUtils.isEmpty(SplashAdView.this.gmX.videoJumpUrl)) {
                                        SplashAdView.this.gmN.Fp(SplashAdView.this.gmX.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.gmZ, layoutParams);
                        e.dEC().a(h.d(this.gmQ.extraParam, 3, this.gmQ.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bMO();
                        this.gmX.videoLocalPath = "";
                        a.a(this.gmX);
                        return false;
                    }
                }
                a.bMO();
                this.gmX.videoLocalPath = "";
                a.a(this.gmX);
                return false;
            } else if (!TextUtils.isEmpty(this.gmX.adImgUrl)) {
                if (this.gmP != null) {
                    this.gmP = null;
                }
                this.gmP = new TbImageView(this.mContext);
                this.gmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.gmQ.advisible != 0) {
                                e.dEC().a(h.d(SplashAdView.this.gmQ.extraParam, 2, SplashAdView.this.gmQ.placeId, "image"));
                            }
                            if (SplashAdView.this.gmN != null && !TextUtils.isEmpty(SplashAdView.this.gmX.redirectUrl)) {
                                SplashAdView.this.gmN.Fp(SplashAdView.this.gmX.redirectUrl);
                            }
                        }
                    }
                });
                this.gmP.startLoad(this.gmQ.adImgUrl, 10, false);
                this.gmP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.gmP, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                e.dEC().a(h.d(this.gmQ.extraParam, 3, this.gmQ.placeId, "image"));
                return true;
            } else {
                a.bMO();
            }
        } else {
            a.bMN();
            a.bMO();
        }
        return false;
    }

    public String bMT() {
        if (this.gmQ == null) {
            if (this.gmR == null) {
                return null;
            }
            return this.gmR.displayName;
        }
        return this.gmQ.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gmZ != null) {
            this.gmZ.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.gmX;
    }
}
