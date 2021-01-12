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
/* loaded from: classes7.dex */
public class SplashAdView extends BCAdView {
    private b giu;
    public boolean giv;
    public ScalableVideoView giw;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gir = redirectType;
        this.giq = new c(tbPageContext.getPageActivity());
        this.gin = new AdInfo();
    }

    public boolean bMe() {
        loadAd();
        this.gin = AdInfo.jsonToObject(this.giq.bLW());
        this.gin.placeId = this.placeId;
        if (this.gin.advisible == 0) {
            e.dCe().a(h.t(this.gin.extraParam, 3, this.gin.placeId));
        }
        this.giu = b.EL(a.bMc());
        if (this.giu.bLV()) {
            if (this.giu.isVideoAd()) {
                this.giv = true;
                String str = this.giu.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.X(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.giw = new ScalableVideoView(this.mContext);
                    this.giw.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.giw.setDataSource(str);
                        this.giw.setVolume(0.0f, 0.0f);
                        this.giw.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.giw.start();
                            }
                        });
                        this.giw.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bMb();
                                SplashAdView.this.giu.videoLocalPath = "";
                                a.a(SplashAdView.this.giu);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.giw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.giw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.gin.advisible != 0) {
                                        e.dCe().a(h.d(SplashAdView.this.gin.extraParam, 2, SplashAdView.this.gin.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gik != null && !TextUtils.isEmpty(SplashAdView.this.giu.videoJumpUrl)) {
                                        SplashAdView.this.gik.EJ(SplashAdView.this.giu.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.giw, layoutParams);
                        e.dCe().a(h.d(this.gin.extraParam, 3, this.gin.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bMb();
                        this.giu.videoLocalPath = "";
                        a.a(this.giu);
                        return false;
                    }
                }
                a.bMb();
                this.giu.videoLocalPath = "";
                a.a(this.giu);
                return false;
            } else if (!TextUtils.isEmpty(this.giu.adImgUrl)) {
                if (this.gim != null) {
                    this.gim = null;
                }
                this.gim = new TbImageView(this.mContext);
                this.gim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.gin.advisible != 0) {
                                e.dCe().a(h.d(SplashAdView.this.gin.extraParam, 2, SplashAdView.this.gin.placeId, "image"));
                            }
                            if (SplashAdView.this.gik != null && !TextUtils.isEmpty(SplashAdView.this.giu.redirectUrl)) {
                                SplashAdView.this.gik.EJ(SplashAdView.this.giu.redirectUrl);
                            }
                        }
                    }
                });
                this.gim.startLoad(this.gin.adImgUrl, 10, false);
                this.gim.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.gim, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                e.dCe().a(h.d(this.gin.extraParam, 3, this.gin.placeId, "image"));
                return true;
            } else {
                a.bMb();
            }
        } else {
            a.bMa();
            a.bMb();
        }
        return false;
    }

    public String bMf() {
        if (this.gin == null) {
            if (this.gio == null) {
                return null;
            }
            return this.gio.displayName;
        }
        return this.gin.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.giw != null) {
            this.giw.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.giu;
    }
}
