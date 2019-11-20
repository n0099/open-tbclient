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
    private b dkX;
    public boolean dkY;
    public ScalableVideoView dkZ;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.dkU = redirectType;
        this.dkT = new c(tbPageContext.getPageActivity());
        this.dkQ = new AdInfo();
    }

    public boolean aEQ() {
        aEN();
        this.dkQ = AdInfo.jsonToObject(this.dkT.aEG());
        this.dkQ.placeId = this.placeId;
        if (this.dkQ.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cgG().a(f.q(this.dkQ.extraParam, 3, this.dkQ.placeId));
        }
        this.dkX = b.rV(a.aEM());
        if (this.dkX.aEE()) {
            if (this.dkX.aEF()) {
                this.dkY = true;
                String str = this.dkX.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.v(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.dkZ = new ScalableVideoView(this.mContext);
                    this.dkZ.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.dkZ.setDataSource(str);
                        this.dkZ.setVolume(0.0f, 0.0f);
                        this.dkZ.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.dkZ.start();
                            }
                        });
                        this.dkZ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aEL();
                                SplashAdView.this.dkX.videoLocalPath = "";
                                a.a(SplashAdView.this.dkX);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.dkZ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.dkZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.dkQ.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cgG().a(f.b(SplashAdView.this.dkQ.extraParam, 2, SplashAdView.this.dkQ.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dkN != null && !TextUtils.isEmpty(SplashAdView.this.dkX.videoJumpUrl)) {
                                        SplashAdView.this.dkN.rT(SplashAdView.this.dkX.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.dkZ, layoutParams);
                        com.baidu.tieba.recapp.report.c.cgG().a(f.b(this.dkQ.extraParam, 3, this.dkQ.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aEL();
                        this.dkX.videoLocalPath = "";
                        a.a(this.dkX);
                        return false;
                    }
                }
                a.aEL();
                this.dkX.videoLocalPath = "";
                a.a(this.dkX);
                return false;
            } else if (!TextUtils.isEmpty(this.dkX.adImgUrl)) {
                if (this.dkP != null) {
                    this.dkP = null;
                }
                this.dkP = new TbImageView(this.mContext);
                this.dkP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.dkQ.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cgG().a(f.b(SplashAdView.this.dkQ.extraParam, 2, SplashAdView.this.dkQ.placeId, "image"));
                            }
                            if (SplashAdView.this.dkN != null && !TextUtils.isEmpty(SplashAdView.this.dkX.redirectUrl)) {
                                SplashAdView.this.dkN.rT(SplashAdView.this.dkX.redirectUrl);
                            }
                        }
                    }
                });
                this.dkP.startLoad(this.dkQ.adImgUrl, 10, false);
                this.dkP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.dkP, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cgG().a(f.b(this.dkQ.extraParam, 3, this.dkQ.placeId, "image"));
                return true;
            } else {
                a.aEL();
            }
        } else {
            a.aEK();
            a.aEL();
        }
        return false;
    }

    public String aER() {
        if (this.dkQ == null) {
            if (this.dkR == null) {
                return null;
            }
            return this.dkR.displayName;
        }
        return this.dkQ.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dkZ != null) {
            this.dkZ.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.dkX;
    }
}
