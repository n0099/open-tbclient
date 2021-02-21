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
    private b glo;
    public boolean glp;
    public ScalableVideoView glq;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.gll = redirectType;
        this.glk = new c(tbPageContext.getPageActivity());
        this.glh = new AdInfo();
    }

    public boolean bMM() {
        loadAd();
        this.glh = AdInfo.jsonToObject(this.glk.bMD());
        this.glh.placeId = this.placeId;
        if (this.glh.advisible == 0) {
            e.dEu().a(h.t(this.glh.extraParam, 3, this.glh.placeId));
        }
        this.glo = b.Fk(a.bMJ());
        if (this.glo.bMC()) {
            if (this.glo.isVideoAd()) {
                this.glp = true;
                String str = this.glo.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.U(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.glq = new ScalableVideoView(this.mContext);
                    this.glq.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.glq.setDataSource(str);
                        this.glq.setVolume(0.0f, 0.0f);
                        this.glq.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.glq.start();
                            }
                        });
                        this.glq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bMI();
                                SplashAdView.this.glo.videoLocalPath = "";
                                a.a(SplashAdView.this.glo);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.glq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.glq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.glh.advisible != 0) {
                                        e.dEu().a(h.d(SplashAdView.this.glh.extraParam, 2, SplashAdView.this.glh.placeId, "video"));
                                    }
                                    if (SplashAdView.this.gle != null && !TextUtils.isEmpty(SplashAdView.this.glo.videoJumpUrl)) {
                                        SplashAdView.this.gle.Fi(SplashAdView.this.glo.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.glq, layoutParams);
                        e.dEu().a(h.d(this.glh.extraParam, 3, this.glh.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bMI();
                        this.glo.videoLocalPath = "";
                        a.a(this.glo);
                        return false;
                    }
                }
                a.bMI();
                this.glo.videoLocalPath = "";
                a.a(this.glo);
                return false;
            } else if (!TextUtils.isEmpty(this.glo.adImgUrl)) {
                if (this.glg != null) {
                    this.glg = null;
                }
                this.glg = new TbImageView(this.mContext);
                this.glg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.glh.advisible != 0) {
                                e.dEu().a(h.d(SplashAdView.this.glh.extraParam, 2, SplashAdView.this.glh.placeId, "image"));
                            }
                            if (SplashAdView.this.gle != null && !TextUtils.isEmpty(SplashAdView.this.glo.redirectUrl)) {
                                SplashAdView.this.gle.Fi(SplashAdView.this.glo.redirectUrl);
                            }
                        }
                    }
                });
                this.glg.startLoad(this.glh.adImgUrl, 10, false);
                this.glg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.glg, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                e.dEu().a(h.d(this.glh.extraParam, 3, this.glh.placeId, "image"));
                return true;
            } else {
                a.bMI();
            }
        } else {
            a.bMH();
            a.bMI();
        }
        return false;
    }

    public String bMN() {
        if (this.glh == null) {
            if (this.gli == null) {
                return null;
            }
            return this.gli.displayName;
        }
        return this.glh.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.glq != null) {
            this.glq.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.glo;
    }
}
