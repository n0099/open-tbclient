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
    private b gdI;
    public boolean gdJ;
    public ScalableVideoView gdK;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gdF = redirectType;
        this.gdE = new c(tbPageContext.getPageActivity());
        this.gdB = new AdInfo();
    }

    public boolean bNB() {
        loadAd();
        this.gdB = AdInfo.jsonToObject(this.gdE.bNt());
        this.gdB.placeId = this.placeId;
        if (this.gdB.advisible == 0) {
            d.dGf().a(g.u(this.gdB.extraParam, 3, this.gdB.placeId));
        }
        this.gdI = b.FZ(a.bNz());
        if (this.gdI.isValidate()) {
            if (this.gdI.bmG()) {
                this.gdJ = true;
                String str = this.gdI.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.V(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.gdK = new ScalableVideoView(this.mContext);
                    this.gdK.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.gdK.setDataSource(str);
                        this.gdK.setVolume(0.0f, 0.0f);
                        this.gdK.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.gdK.start();
                            }
                        });
                        this.gdK.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bNy();
                                SplashAdView.this.gdI.videoLocalPath = "";
                                a.a(SplashAdView.this.gdI);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.gdK.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.gdK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.gdB.advisible != 0) {
                                        d.dGf().a(g.d(SplashAdView.this.gdB.extraParam, 2, SplashAdView.this.gdB.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gdy != null && !TextUtils.isEmpty(SplashAdView.this.gdI.videoJumpUrl)) {
                                        SplashAdView.this.gdy.FX(SplashAdView.this.gdI.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.gdK, layoutParams);
                        d.dGf().a(g.d(this.gdB.extraParam, 3, this.gdB.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bNy();
                        this.gdI.videoLocalPath = "";
                        a.a(this.gdI);
                        return false;
                    }
                }
                a.bNy();
                this.gdI.videoLocalPath = "";
                a.a(this.gdI);
                return false;
            } else if (!TextUtils.isEmpty(this.gdI.adImgUrl)) {
                if (this.gdA != null) {
                    this.gdA = null;
                }
                this.gdA = new TbImageView(this.mContext);
                this.gdA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.gdB.advisible != 0) {
                                d.dGf().a(g.d(SplashAdView.this.gdB.extraParam, 2, SplashAdView.this.gdB.placeId, "image"));
                            }
                            if (SplashAdView.this.gdy != null && !TextUtils.isEmpty(SplashAdView.this.gdI.redirectUrl)) {
                                SplashAdView.this.gdy.FX(SplashAdView.this.gdI.redirectUrl);
                            }
                        }
                    }
                });
                this.gdA.startLoad(this.gdB.adImgUrl, 10, false);
                this.gdA.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.gdA, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dGf().a(g.d(this.gdB.extraParam, 3, this.gdB.placeId, "image"));
                return true;
            } else {
                a.bNy();
            }
        } else {
            a.bNx();
            a.bNy();
        }
        return false;
    }

    public String bNC() {
        if (this.gdB == null) {
            if (this.gdC == null) {
                return null;
            }
            return this.gdC.displayName;
        }
        return this.gdB.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gdK != null) {
            this.gdK.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.gdI;
    }
}
