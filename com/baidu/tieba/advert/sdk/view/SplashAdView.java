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
    private b gdK;
    public boolean gdL;
    public ScalableVideoView gdM;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gdH = redirectType;
        this.gdG = new c(tbPageContext.getPageActivity());
        this.gdD = new AdInfo();
    }

    public boolean bNC() {
        loadAd();
        this.gdD = AdInfo.jsonToObject(this.gdG.bNu());
        this.gdD.placeId = this.placeId;
        if (this.gdD.advisible == 0) {
            d.dGg().a(g.u(this.gdD.extraParam, 3, this.gdD.placeId));
        }
        this.gdK = b.FZ(a.bNA());
        if (this.gdK.isValidate()) {
            if (this.gdK.bmG()) {
                this.gdL = true;
                String str = this.gdK.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.V(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.gdM = new ScalableVideoView(this.mContext);
                    this.gdM.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.gdM.setDataSource(str);
                        this.gdM.setVolume(0.0f, 0.0f);
                        this.gdM.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.gdM.start();
                            }
                        });
                        this.gdM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bNz();
                                SplashAdView.this.gdK.videoLocalPath = "";
                                a.a(SplashAdView.this.gdK);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.gdM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.gdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.gdD.advisible != 0) {
                                        d.dGg().a(g.d(SplashAdView.this.gdD.extraParam, 2, SplashAdView.this.gdD.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gdA != null && !TextUtils.isEmpty(SplashAdView.this.gdK.videoJumpUrl)) {
                                        SplashAdView.this.gdA.FX(SplashAdView.this.gdK.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.gdM, layoutParams);
                        d.dGg().a(g.d(this.gdD.extraParam, 3, this.gdD.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bNz();
                        this.gdK.videoLocalPath = "";
                        a.a(this.gdK);
                        return false;
                    }
                }
                a.bNz();
                this.gdK.videoLocalPath = "";
                a.a(this.gdK);
                return false;
            } else if (!TextUtils.isEmpty(this.gdK.adImgUrl)) {
                if (this.gdC != null) {
                    this.gdC = null;
                }
                this.gdC = new TbImageView(this.mContext);
                this.gdC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.gdD.advisible != 0) {
                                d.dGg().a(g.d(SplashAdView.this.gdD.extraParam, 2, SplashAdView.this.gdD.placeId, "image"));
                            }
                            if (SplashAdView.this.gdA != null && !TextUtils.isEmpty(SplashAdView.this.gdK.redirectUrl)) {
                                SplashAdView.this.gdA.FX(SplashAdView.this.gdK.redirectUrl);
                            }
                        }
                    }
                });
                this.gdC.startLoad(this.gdD.adImgUrl, 10, false);
                this.gdC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.gdC, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dGg().a(g.d(this.gdD.extraParam, 3, this.gdD.placeId, "image"));
                return true;
            } else {
                a.bNz();
            }
        } else {
            a.bNy();
            a.bNz();
        }
        return false;
    }

    public String bND() {
        if (this.gdD == null) {
            if (this.gdE == null) {
                return null;
            }
            return this.gdE.displayName;
        }
        return this.gdD.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gdM != null) {
            this.gdM.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.gdK;
    }
}
