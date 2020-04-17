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
/* loaded from: classes10.dex */
public class SplashAdView extends BCAdView {
    private b eDk;
    public boolean eDl;
    public ScalableVideoView eDm;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.eDh = redirectType;
        this.eDg = new c(tbPageContext.getPageActivity());
        this.eDd = new AdInfo();
    }

    public boolean bhA() {
        loadAd();
        this.eDd = AdInfo.jsonToObject(this.eDg.bhs());
        this.eDd.placeId = this.placeId;
        if (this.eDd.advisible == 0) {
            d.cOl().a(g.u(this.eDd.extraParam, 3, this.eDd.placeId));
        }
        this.eDk = b.yN(a.bhy());
        if (this.eDk.isValidate()) {
            if (this.eDk.bhr()) {
                this.eDl = true;
                String str = this.eDk.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.K(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.eDm = new ScalableVideoView(this.mContext);
                    this.eDm.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.eDm.setDataSource(str);
                        this.eDm.setVolume(0.0f, 0.0f);
                        this.eDm.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.eDm.start();
                            }
                        });
                        this.eDm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bhx();
                                SplashAdView.this.eDk.videoLocalPath = "";
                                a.a(SplashAdView.this.eDk);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.eDm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.eDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.eDd.advisible != 0) {
                                        d.cOl().a(g.c(SplashAdView.this.eDd.extraParam, 2, SplashAdView.this.eDd.placeId, "video"));
                                    }
                                    if (SplashAdView.this.eDa != null && !TextUtils.isEmpty(SplashAdView.this.eDk.videoJumpUrl)) {
                                        SplashAdView.this.eDa.yL(SplashAdView.this.eDk.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.eDm, layoutParams);
                        d.cOl().a(g.c(this.eDd.extraParam, 3, this.eDd.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bhx();
                        this.eDk.videoLocalPath = "";
                        a.a(this.eDk);
                        return false;
                    }
                }
                a.bhx();
                this.eDk.videoLocalPath = "";
                a.a(this.eDk);
                return false;
            } else if (!TextUtils.isEmpty(this.eDk.adImgUrl)) {
                if (this.eDc != null) {
                    this.eDc = null;
                }
                this.eDc = new TbImageView(this.mContext);
                this.eDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.eDd.advisible != 0) {
                                d.cOl().a(g.c(SplashAdView.this.eDd.extraParam, 2, SplashAdView.this.eDd.placeId, "image"));
                            }
                            if (SplashAdView.this.eDa != null && !TextUtils.isEmpty(SplashAdView.this.eDk.redirectUrl)) {
                                SplashAdView.this.eDa.yL(SplashAdView.this.eDk.redirectUrl);
                            }
                        }
                    }
                });
                this.eDc.startLoad(this.eDd.adImgUrl, 10, false);
                this.eDc.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.eDc, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.cOl().a(g.c(this.eDd.extraParam, 3, this.eDd.placeId, "image"));
                return true;
            } else {
                a.bhx();
            }
        } else {
            a.bhw();
            a.bhx();
        }
        return false;
    }

    public String bhB() {
        if (this.eDd == null) {
            if (this.eDe == null) {
                return null;
            }
            return this.eDe.displayName;
        }
        return this.eDd.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eDm != null) {
            this.eDm.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.eDk;
    }
}
