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
/* loaded from: classes5.dex */
public class SplashAdView extends BCAdView {
    private b dlO;
    public boolean dlP;
    public ScalableVideoView dlQ;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.dlL = redirectType;
        this.dlK = new c(tbPageContext.getPageActivity());
        this.dlH = new AdInfo();
    }

    public boolean aES() {
        aEP();
        this.dlH = AdInfo.jsonToObject(this.dlK.aEI());
        this.dlH.placeId = this.placeId;
        if (this.dlH.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cgI().a(f.q(this.dlH.extraParam, 3, this.dlH.placeId));
        }
        this.dlO = b.rV(a.aEO());
        if (this.dlO.aEG()) {
            if (this.dlO.aEH()) {
                this.dlP = true;
                String str = this.dlO.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.v(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.dlQ = new ScalableVideoView(this.mContext);
                    this.dlQ.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.dlQ.setDataSource(str);
                        this.dlQ.setVolume(0.0f, 0.0f);
                        this.dlQ.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.dlQ.start();
                            }
                        });
                        this.dlQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aEN();
                                SplashAdView.this.dlO.videoLocalPath = "";
                                a.a(SplashAdView.this.dlO);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.dlQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.dlQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.dlH.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cgI().a(f.b(SplashAdView.this.dlH.extraParam, 2, SplashAdView.this.dlH.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dlE != null && !TextUtils.isEmpty(SplashAdView.this.dlO.videoJumpUrl)) {
                                        SplashAdView.this.dlE.rT(SplashAdView.this.dlO.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.dlQ, layoutParams);
                        com.baidu.tieba.recapp.report.c.cgI().a(f.b(this.dlH.extraParam, 3, this.dlH.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aEN();
                        this.dlO.videoLocalPath = "";
                        a.a(this.dlO);
                        return false;
                    }
                }
                a.aEN();
                this.dlO.videoLocalPath = "";
                a.a(this.dlO);
                return false;
            } else if (!TextUtils.isEmpty(this.dlO.adImgUrl)) {
                if (this.dlG != null) {
                    this.dlG = null;
                }
                this.dlG = new TbImageView(this.mContext);
                this.dlG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.dlH.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cgI().a(f.b(SplashAdView.this.dlH.extraParam, 2, SplashAdView.this.dlH.placeId, "image"));
                            }
                            if (SplashAdView.this.dlE != null && !TextUtils.isEmpty(SplashAdView.this.dlO.redirectUrl)) {
                                SplashAdView.this.dlE.rT(SplashAdView.this.dlO.redirectUrl);
                            }
                        }
                    }
                });
                this.dlG.startLoad(this.dlH.adImgUrl, 10, false);
                this.dlG.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.dlG, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cgI().a(f.b(this.dlH.extraParam, 3, this.dlH.placeId, "image"));
                return true;
            } else {
                a.aEN();
            }
        } else {
            a.aEM();
            a.aEN();
        }
        return false;
    }

    public String aET() {
        if (this.dlH == null) {
            if (this.dlI == null) {
                return null;
            }
            return this.dlI.displayName;
        }
        return this.dlH.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dlQ != null) {
            this.dlQ.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.dlO;
    }
}
