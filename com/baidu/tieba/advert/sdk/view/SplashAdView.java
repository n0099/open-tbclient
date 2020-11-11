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
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.g;
import java.io.File;
/* loaded from: classes23.dex */
public class SplashAdView extends BCAdView {
    private b fVR;
    public boolean fVS;
    public ScalableVideoView fVT;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fVO = redirectType;
        this.fVN = new c(tbPageContext.getPageActivity());
        this.fVK = new AdInfo();
    }

    public boolean bKA() {
        loadAd();
        this.fVK = AdInfo.jsonToObject(this.fVN.bKs());
        this.fVK.placeId = this.placeId;
        if (this.fVK.advisible == 0) {
            d.dBp().a(g.u(this.fVK.extraParam, 3, this.fVK.placeId));
        }
        this.fVR = b.FK(a.bKy());
        if (this.fVR.isValidate()) {
            if (this.fVR.bku()) {
                this.fVS = true;
                String str = this.fVR.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.W(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fVT = new ScalableVideoView(this.mContext);
                    this.fVT.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fVT.setDataSource(str);
                        this.fVT.setVolume(0.0f, 0.0f);
                        this.fVT.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fVT.start();
                            }
                        });
                        this.fVT.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bKx();
                                SplashAdView.this.fVR.videoLocalPath = "";
                                a.a(SplashAdView.this.fVR);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fVT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fVT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fVK.advisible != 0) {
                                        d.dBp().a(g.d(SplashAdView.this.fVK.extraParam, 2, SplashAdView.this.fVK.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fVH != null && !TextUtils.isEmpty(SplashAdView.this.fVR.videoJumpUrl)) {
                                        SplashAdView.this.fVH.FI(SplashAdView.this.fVR.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fVT, layoutParams);
                        d.dBp().a(g.d(this.fVK.extraParam, 3, this.fVK.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bKx();
                        this.fVR.videoLocalPath = "";
                        a.a(this.fVR);
                        return false;
                    }
                }
                a.bKx();
                this.fVR.videoLocalPath = "";
                a.a(this.fVR);
                return false;
            } else if (!TextUtils.isEmpty(this.fVR.adImgUrl)) {
                if (this.fVJ != null) {
                    this.fVJ = null;
                }
                this.fVJ = new TbImageView(this.mContext);
                this.fVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fVK.advisible != 0) {
                                d.dBp().a(g.d(SplashAdView.this.fVK.extraParam, 2, SplashAdView.this.fVK.placeId, "image"));
                            }
                            if (SplashAdView.this.fVH != null && !TextUtils.isEmpty(SplashAdView.this.fVR.redirectUrl)) {
                                SplashAdView.this.fVH.FI(SplashAdView.this.fVR.redirectUrl);
                            }
                        }
                    }
                });
                this.fVJ.startLoad(this.fVK.adImgUrl, 10, false);
                this.fVJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fVJ, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dBp().a(g.d(this.fVK.extraParam, 3, this.fVK.placeId, "image"));
                return true;
            } else {
                a.bKx();
            }
        } else {
            a.bKw();
            a.bKx();
        }
        return false;
    }

    public String bKB() {
        if (this.fVK == null) {
            if (this.fVL == null) {
                return null;
            }
            return this.fVL.displayName;
        }
        return this.fVK.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fVT != null) {
            this.fVT.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fVR;
    }
}
