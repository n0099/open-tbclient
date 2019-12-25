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
/* loaded from: classes7.dex */
public class SplashAdView extends BCAdView {
    private b dYC;
    public boolean dYD;
    public ScalableVideoView dYE;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.dYz = redirectType;
        this.dYy = new c(tbPageContext.getPageActivity());
        this.dYv = new AdInfo();
    }

    public boolean aWG() {
        loadAd();
        this.dYv = AdInfo.jsonToObject(this.dYy.aWy());
        this.dYv.placeId = this.placeId;
        if (this.dYv.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cAJ().a(f.t(this.dYv.extraParam, 3, this.dYv.placeId));
        }
        this.dYC = b.xb(a.aWE());
        if (this.dYC.isValidate()) {
            if (this.dYC.aWx()) {
                this.dYD = true;
                String str = this.dYC.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.I(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.dYE = new ScalableVideoView(this.mContext);
                    this.dYE.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.dYE.setDataSource(str);
                        this.dYE.setVolume(0.0f, 0.0f);
                        this.dYE.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.dYE.start();
                            }
                        });
                        this.dYE.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aWD();
                                SplashAdView.this.dYC.videoLocalPath = "";
                                a.a(SplashAdView.this.dYC);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.dYE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.dYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.dYv.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cAJ().a(f.c(SplashAdView.this.dYv.extraParam, 2, SplashAdView.this.dYv.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dYs != null && !TextUtils.isEmpty(SplashAdView.this.dYC.videoJumpUrl)) {
                                        SplashAdView.this.dYs.wZ(SplashAdView.this.dYC.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.dYE, layoutParams);
                        com.baidu.tieba.recapp.report.c.cAJ().a(f.c(this.dYv.extraParam, 3, this.dYv.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aWD();
                        this.dYC.videoLocalPath = "";
                        a.a(this.dYC);
                        return false;
                    }
                }
                a.aWD();
                this.dYC.videoLocalPath = "";
                a.a(this.dYC);
                return false;
            } else if (!TextUtils.isEmpty(this.dYC.adImgUrl)) {
                if (this.dYu != null) {
                    this.dYu = null;
                }
                this.dYu = new TbImageView(this.mContext);
                this.dYu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.dYv.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cAJ().a(f.c(SplashAdView.this.dYv.extraParam, 2, SplashAdView.this.dYv.placeId, "image"));
                            }
                            if (SplashAdView.this.dYs != null && !TextUtils.isEmpty(SplashAdView.this.dYC.redirectUrl)) {
                                SplashAdView.this.dYs.wZ(SplashAdView.this.dYC.redirectUrl);
                            }
                        }
                    }
                });
                this.dYu.startLoad(this.dYv.adImgUrl, 10, false);
                this.dYu.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.dYu, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cAJ().a(f.c(this.dYv.extraParam, 3, this.dYv.placeId, "image"));
                return true;
            } else {
                a.aWD();
            }
        } else {
            a.aWC();
            a.aWD();
        }
        return false;
    }

    public String aWH() {
        if (this.dYv == null) {
            if (this.dYw == null) {
                return null;
            }
            return this.dYw.displayName;
        }
        return this.dYv.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dYE != null) {
            this.dYE.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.dYC;
    }
}
