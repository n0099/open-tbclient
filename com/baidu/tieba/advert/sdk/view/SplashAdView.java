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
import com.baidu.tieba.recapp.report.f;
import java.io.File;
/* loaded from: classes8.dex */
public class SplashAdView extends BCAdView {
    private b dYL;
    public boolean dYM;
    public ScalableVideoView dYN;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.dYI = redirectType;
        this.dYH = new c(tbPageContext.getPageActivity());
        this.dYE = new AdInfo();
    }

    public boolean aXa() {
        loadAd();
        this.dYE = AdInfo.jsonToObject(this.dYH.aWS());
        this.dYE.placeId = this.placeId;
        if (this.dYE.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cBP().a(f.t(this.dYE.extraParam, 3, this.dYE.placeId));
        }
        this.dYL = b.xf(a.aWY());
        if (this.dYL.isValidate()) {
            if (this.dYL.aWR()) {
                this.dYM = true;
                String str = this.dYL.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.I(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.dYN = new ScalableVideoView(this.mContext);
                    this.dYN.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.dYN.setDataSource(str);
                        this.dYN.setVolume(0.0f, 0.0f);
                        this.dYN.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.dYN.start();
                            }
                        });
                        this.dYN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aWX();
                                SplashAdView.this.dYL.videoLocalPath = "";
                                a.a(SplashAdView.this.dYL);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.dYN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.dYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.dYE.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cBP().a(f.c(SplashAdView.this.dYE.extraParam, 2, SplashAdView.this.dYE.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dYB != null && !TextUtils.isEmpty(SplashAdView.this.dYL.videoJumpUrl)) {
                                        SplashAdView.this.dYB.xd(SplashAdView.this.dYL.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.dYN, layoutParams);
                        com.baidu.tieba.recapp.report.c.cBP().a(f.c(this.dYE.extraParam, 3, this.dYE.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aWX();
                        this.dYL.videoLocalPath = "";
                        a.a(this.dYL);
                        return false;
                    }
                }
                a.aWX();
                this.dYL.videoLocalPath = "";
                a.a(this.dYL);
                return false;
            } else if (!TextUtils.isEmpty(this.dYL.adImgUrl)) {
                if (this.dYD != null) {
                    this.dYD = null;
                }
                this.dYD = new TbImageView(this.mContext);
                this.dYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.dYE.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cBP().a(f.c(SplashAdView.this.dYE.extraParam, 2, SplashAdView.this.dYE.placeId, "image"));
                            }
                            if (SplashAdView.this.dYB != null && !TextUtils.isEmpty(SplashAdView.this.dYL.redirectUrl)) {
                                SplashAdView.this.dYB.xd(SplashAdView.this.dYL.redirectUrl);
                            }
                        }
                    }
                });
                this.dYD.startLoad(this.dYE.adImgUrl, 10, false);
                this.dYD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.dYD, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cBP().a(f.c(this.dYE.extraParam, 3, this.dYE.placeId, "image"));
                return true;
            } else {
                a.aWX();
            }
        } else {
            a.aWW();
            a.aWX();
        }
        return false;
    }

    public String aXb() {
        if (this.dYE == null) {
            if (this.dYF == null) {
                return null;
            }
            return this.dYF.displayName;
        }
        return this.dYE.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dYN != null) {
            this.dYN.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.dYL;
    }
}
