package com.baidu.tieba.advert.sdk.view;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes5.dex */
public class SplashAdView extends BCAdView {
    public boolean daA;
    public ScalableVideoView daB;
    private b daz;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.dav = redirectType;
        this.dau = new c(tbPageContext.getPageActivity());
        this.dar = new AdInfo();
    }

    public boolean aEb() {
        loadAd();
        this.dar = AdInfo.jsonToObject(this.dau.aDS());
        this.dar.placeId = this.placeId;
        if (this.dar.advisible == 0) {
            com.baidu.tieba.recapp.report.c.ciy().a(f.s(this.dar.extraParam, 3, this.dar.placeId));
        }
        this.daz = b.sN(a.aDY());
        if (this.daz.aDQ()) {
            if (this.daz.aDR()) {
                this.daA = true;
                String str = this.daz.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.J(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.daB = new ScalableVideoView(this.mContext);
                    this.daB.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.daB.setDataSource(str);
                        this.daB.setVolume(0.0f, 0.0f);
                        this.daB.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.daB.start();
                            }
                        });
                        this.daB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aDX();
                                SplashAdView.this.daz.videoLocalPath = "";
                                a.a(SplashAdView.this.daz);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.daB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                            }
                        });
                        this.daB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.dar.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.ciy().a(f.b(SplashAdView.this.dar.extraParam, 2, SplashAdView.this.dar.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dao != null && !TextUtils.isEmpty(SplashAdView.this.daz.videoJumpUrl)) {
                                        SplashAdView.this.dao.sL(SplashAdView.this.daz.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.daB, layoutParams);
                        com.baidu.tieba.recapp.report.c.ciy().a(f.b(this.dar.extraParam, 3, this.dar.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aDX();
                        this.daz.videoLocalPath = "";
                        a.a(this.daz);
                        return false;
                    }
                }
                a.aDX();
                this.daz.videoLocalPath = "";
                a.a(this.daz);
                return false;
            } else if (!TextUtils.isEmpty(this.daz.adImgUrl)) {
                if (this.daq != null) {
                    this.daq = null;
                }
                this.daq = new TbImageView(this.mContext);
                this.daq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.dar.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.ciy().a(f.b(SplashAdView.this.dar.extraParam, 2, SplashAdView.this.dar.placeId, "image"));
                            }
                            if (SplashAdView.this.dao != null && !TextUtils.isEmpty(SplashAdView.this.daz.redirectUrl)) {
                                SplashAdView.this.dao.sL(SplashAdView.this.daz.redirectUrl);
                            }
                        }
                    }
                });
                this.daq.startLoad(this.dar.adImgUrl, 10, false);
                this.daq.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.daq, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.ciy().a(f.b(this.dar.extraParam, 3, this.dar.placeId, "image"));
                return true;
            } else {
                a.aDX();
            }
        } else {
            a.aDW();
            a.aDX();
        }
        return false;
    }

    public String aEc() {
        if (this.dar == null) {
            if (this.das == null) {
                return null;
            }
            return this.das.displayName;
        }
        return this.dar.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.daB != null) {
            this.daB.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.daz;
    }
}
