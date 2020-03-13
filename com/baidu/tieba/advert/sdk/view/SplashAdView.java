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
/* loaded from: classes10.dex */
public class SplashAdView extends BCAdView {
    private b edd;
    public boolean ede;
    public ScalableVideoView edf;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.eda = redirectType;
        this.ecZ = new c(tbPageContext.getPageActivity());
        this.ecW = new AdInfo();
    }

    public boolean aZs() {
        loadAd();
        this.ecW = AdInfo.jsonToObject(this.ecZ.aZk());
        this.ecW.placeId = this.placeId;
        if (this.ecW.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cDq().a(f.u(this.ecW.extraParam, 3, this.ecW.placeId));
        }
        this.edd = b.xA(a.aZq());
        if (this.edd.isValidate()) {
            if (this.edd.aZj()) {
                this.ede = true;
                String str = this.edd.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.K(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.edf = new ScalableVideoView(this.mContext);
                    this.edf.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.edf.setDataSource(str);
                        this.edf.setVolume(0.0f, 0.0f);
                        this.edf.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.edf.start();
                            }
                        });
                        this.edf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aZp();
                                SplashAdView.this.edd.videoLocalPath = "";
                                a.a(SplashAdView.this.edd);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.edf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.edf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.ecW.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cDq().a(f.c(SplashAdView.this.ecW.extraParam, 2, SplashAdView.this.ecW.placeId, "video"));
                                    }
                                    if (SplashAdView.this.ecT != null && !TextUtils.isEmpty(SplashAdView.this.edd.videoJumpUrl)) {
                                        SplashAdView.this.ecT.xy(SplashAdView.this.edd.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.edf, layoutParams);
                        com.baidu.tieba.recapp.report.c.cDq().a(f.c(this.ecW.extraParam, 3, this.ecW.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aZp();
                        this.edd.videoLocalPath = "";
                        a.a(this.edd);
                        return false;
                    }
                }
                a.aZp();
                this.edd.videoLocalPath = "";
                a.a(this.edd);
                return false;
            } else if (!TextUtils.isEmpty(this.edd.adImgUrl)) {
                if (this.ecV != null) {
                    this.ecV = null;
                }
                this.ecV = new TbImageView(this.mContext);
                this.ecV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.ecW.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cDq().a(f.c(SplashAdView.this.ecW.extraParam, 2, SplashAdView.this.ecW.placeId, "image"));
                            }
                            if (SplashAdView.this.ecT != null && !TextUtils.isEmpty(SplashAdView.this.edd.redirectUrl)) {
                                SplashAdView.this.ecT.xy(SplashAdView.this.edd.redirectUrl);
                            }
                        }
                    }
                });
                this.ecV.startLoad(this.ecW.adImgUrl, 10, false);
                this.ecV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.ecV, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cDq().a(f.c(this.ecW.extraParam, 3, this.ecW.placeId, "image"));
                return true;
            } else {
                a.aZp();
            }
        } else {
            a.aZo();
            a.aZp();
        }
        return false;
    }

    public String aZt() {
        if (this.ecW == null) {
            if (this.ecX == null) {
                return null;
            }
            return this.ecX.displayName;
        }
        return this.ecW.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.edf != null) {
            this.edf.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.edd;
    }
}
