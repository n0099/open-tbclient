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
    private b fQb;
    public boolean fQc;
    public ScalableVideoView fQd;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fPY = redirectType;
        this.fPX = new c(tbPageContext.getPageActivity());
        this.fPU = new AdInfo();
    }

    public boolean bIb() {
        loadAd();
        this.fPU = AdInfo.jsonToObject(this.fPX.bHT());
        this.fPU.placeId = this.placeId;
        if (this.fPU.advisible == 0) {
            d.dyN().a(g.t(this.fPU.extraParam, 3, this.fPU.placeId));
        }
        this.fQb = b.Fw(a.bHZ());
        if (this.fQb.isValidate()) {
            if (this.fQb.bhU()) {
                this.fQc = true;
                String str = this.fQb.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.W(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fQd = new ScalableVideoView(this.mContext);
                    this.fQd.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fQd.setDataSource(str);
                        this.fQd.setVolume(0.0f, 0.0f);
                        this.fQd.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fQd.start();
                            }
                        });
                        this.fQd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bHY();
                                SplashAdView.this.fQb.videoLocalPath = "";
                                a.a(SplashAdView.this.fQb);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fQd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fPU.advisible != 0) {
                                        d.dyN().a(g.d(SplashAdView.this.fPU.extraParam, 2, SplashAdView.this.fPU.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fPR != null && !TextUtils.isEmpty(SplashAdView.this.fQb.videoJumpUrl)) {
                                        SplashAdView.this.fPR.Fu(SplashAdView.this.fQb.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fQd, layoutParams);
                        d.dyN().a(g.d(this.fPU.extraParam, 3, this.fPU.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bHY();
                        this.fQb.videoLocalPath = "";
                        a.a(this.fQb);
                        return false;
                    }
                }
                a.bHY();
                this.fQb.videoLocalPath = "";
                a.a(this.fQb);
                return false;
            } else if (!TextUtils.isEmpty(this.fQb.adImgUrl)) {
                if (this.fPT != null) {
                    this.fPT = null;
                }
                this.fPT = new TbImageView(this.mContext);
                this.fPT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fPU.advisible != 0) {
                                d.dyN().a(g.d(SplashAdView.this.fPU.extraParam, 2, SplashAdView.this.fPU.placeId, "image"));
                            }
                            if (SplashAdView.this.fPR != null && !TextUtils.isEmpty(SplashAdView.this.fQb.redirectUrl)) {
                                SplashAdView.this.fPR.Fu(SplashAdView.this.fQb.redirectUrl);
                            }
                        }
                    }
                });
                this.fPT.startLoad(this.fPU.adImgUrl, 10, false);
                this.fPT.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fPT, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dyN().a(g.d(this.fPU.extraParam, 3, this.fPU.placeId, "image"));
                return true;
            } else {
                a.bHY();
            }
        } else {
            a.bHX();
            a.bHY();
        }
        return false;
    }

    public String bIc() {
        if (this.fPU == null) {
            if (this.fPV == null) {
                return null;
            }
            return this.fPV.displayName;
        }
        return this.fPU.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fQd != null) {
            this.fQd.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fQb;
    }
}
