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
    private b gla;
    public boolean glb;
    public ScalableVideoView glc;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gkX = redirectType;
        this.gkW = new c(tbPageContext.getPageActivity());
        this.gkT = new AdInfo();
    }

    public boolean bMF() {
        loadAd();
        this.gkT = AdInfo.jsonToObject(this.gkW.bMw());
        this.gkT.placeId = this.placeId;
        if (this.gkT.advisible == 0) {
            e.dEm().a(h.t(this.gkT.extraParam, 3, this.gkT.placeId));
        }
        this.gla = b.Fj(a.bMC());
        if (this.gla.bMv()) {
            if (this.gla.isVideoAd()) {
                this.glb = true;
                String str = this.gla.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.U(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.glc = new ScalableVideoView(this.mContext);
                    this.glc.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.glc.setDataSource(str);
                        this.glc.setVolume(0.0f, 0.0f);
                        this.glc.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.glc.start();
                            }
                        });
                        this.glc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bMB();
                                SplashAdView.this.gla.videoLocalPath = "";
                                a.a(SplashAdView.this.gla);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.glc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.glc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.gkT.advisible != 0) {
                                        e.dEm().a(h.d(SplashAdView.this.gkT.extraParam, 2, SplashAdView.this.gkT.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gkQ != null && !TextUtils.isEmpty(SplashAdView.this.gla.videoJumpUrl)) {
                                        SplashAdView.this.gkQ.Fh(SplashAdView.this.gla.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.glc, layoutParams);
                        e.dEm().a(h.d(this.gkT.extraParam, 3, this.gkT.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bMB();
                        this.gla.videoLocalPath = "";
                        a.a(this.gla);
                        return false;
                    }
                }
                a.bMB();
                this.gla.videoLocalPath = "";
                a.a(this.gla);
                return false;
            } else if (!TextUtils.isEmpty(this.gla.adImgUrl)) {
                if (this.gkS != null) {
                    this.gkS = null;
                }
                this.gkS = new TbImageView(this.mContext);
                this.gkS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.gkT.advisible != 0) {
                                e.dEm().a(h.d(SplashAdView.this.gkT.extraParam, 2, SplashAdView.this.gkT.placeId, "image"));
                            }
                            if (SplashAdView.this.gkQ != null && !TextUtils.isEmpty(SplashAdView.this.gla.redirectUrl)) {
                                SplashAdView.this.gkQ.Fh(SplashAdView.this.gla.redirectUrl);
                            }
                        }
                    }
                });
                this.gkS.startLoad(this.gkT.adImgUrl, 10, false);
                this.gkS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.gkS, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                e.dEm().a(h.d(this.gkT.extraParam, 3, this.gkT.placeId, "image"));
                return true;
            } else {
                a.bMB();
            }
        } else {
            a.bMA();
            a.bMB();
        }
        return false;
    }

    public String bMG() {
        if (this.gkT == null) {
            if (this.gkU == null) {
                return null;
            }
            return this.gkU.displayName;
        }
        return this.gkT.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.glc != null) {
            this.glc.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.gla;
    }
}
