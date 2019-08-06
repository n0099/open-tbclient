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
    private b daG;
    public boolean daH;
    public ScalableVideoView daI;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.daD = redirectType;
        this.daC = new c(tbPageContext.getPageActivity());
        this.daz = new AdInfo();
    }

    public boolean aEd() {
        loadAd();
        this.daz = AdInfo.jsonToObject(this.daC.aDU());
        this.daz.placeId = this.placeId;
        if (this.daz.advisible == 0) {
            com.baidu.tieba.recapp.report.c.ciQ().a(f.s(this.daz.extraParam, 3, this.daz.placeId));
        }
        this.daG = b.sN(a.aEa());
        if (this.daG.aDS()) {
            if (this.daG.aDT()) {
                this.daH = true;
                String str = this.daG.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.J(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.daI = new ScalableVideoView(this.mContext);
                    this.daI.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.daI.setDataSource(str);
                        this.daI.setVolume(0.0f, 0.0f);
                        this.daI.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.daI.start();
                            }
                        });
                        this.daI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aDZ();
                                SplashAdView.this.daG.videoLocalPath = "";
                                a.a(SplashAdView.this.daG);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.daI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                            }
                        });
                        this.daI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.daz.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.ciQ().a(f.b(SplashAdView.this.daz.extraParam, 2, SplashAdView.this.daz.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dav != null && !TextUtils.isEmpty(SplashAdView.this.daG.videoJumpUrl)) {
                                        SplashAdView.this.dav.sL(SplashAdView.this.daG.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.daI, layoutParams);
                        com.baidu.tieba.recapp.report.c.ciQ().a(f.b(this.daz.extraParam, 3, this.daz.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aDZ();
                        this.daG.videoLocalPath = "";
                        a.a(this.daG);
                        return false;
                    }
                }
                a.aDZ();
                this.daG.videoLocalPath = "";
                a.a(this.daG);
                return false;
            } else if (!TextUtils.isEmpty(this.daG.adImgUrl)) {
                if (this.dax != null) {
                    this.dax = null;
                }
                this.dax = new TbImageView(this.mContext);
                this.dax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.daz.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.ciQ().a(f.b(SplashAdView.this.daz.extraParam, 2, SplashAdView.this.daz.placeId, "image"));
                            }
                            if (SplashAdView.this.dav != null && !TextUtils.isEmpty(SplashAdView.this.daG.redirectUrl)) {
                                SplashAdView.this.dav.sL(SplashAdView.this.daG.redirectUrl);
                            }
                        }
                    }
                });
                this.dax.startLoad(this.daz.adImgUrl, 10, false);
                this.dax.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.dax, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.ciQ().a(f.b(this.daz.extraParam, 3, this.daz.placeId, "image"));
                return true;
            } else {
                a.aDZ();
            }
        } else {
            a.aDY();
            a.aDZ();
        }
        return false;
    }

    public String aEe() {
        if (this.daz == null) {
            if (this.daA == null) {
                return null;
            }
            return this.daA.displayName;
        }
        return this.daz.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.daI != null) {
            this.daI.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.daG;
    }
}
