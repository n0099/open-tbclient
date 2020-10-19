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
    private b fHG;
    public boolean fHH;
    public ScalableVideoView fHI;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fHD = redirectType;
        this.fHC = new c(tbPageContext.getPageActivity());
        this.fHz = new AdInfo();
    }

    public boolean bGi() {
        loadAd();
        this.fHz = AdInfo.jsonToObject(this.fHC.bGa());
        this.fHz.placeId = this.placeId;
        if (this.fHz.advisible == 0) {
            d.dvG().a(g.t(this.fHz.extraParam, 3, this.fHz.placeId));
        }
        this.fHG = b.Fd(a.bGg());
        if (this.fHG.isValidate()) {
            if (this.fHG.bgb()) {
                this.fHH = true;
                String str = this.fHG.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.W(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fHI = new ScalableVideoView(this.mContext);
                    this.fHI.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fHI.setDataSource(str);
                        this.fHI.setVolume(0.0f, 0.0f);
                        this.fHI.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fHI.start();
                            }
                        });
                        this.fHI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bGf();
                                SplashAdView.this.fHG.videoLocalPath = "";
                                a.a(SplashAdView.this.fHG);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fHI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fHz.advisible != 0) {
                                        d.dvG().a(g.d(SplashAdView.this.fHz.extraParam, 2, SplashAdView.this.fHz.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fHw != null && !TextUtils.isEmpty(SplashAdView.this.fHG.videoJumpUrl)) {
                                        SplashAdView.this.fHw.Fb(SplashAdView.this.fHG.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fHI, layoutParams);
                        d.dvG().a(g.d(this.fHz.extraParam, 3, this.fHz.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bGf();
                        this.fHG.videoLocalPath = "";
                        a.a(this.fHG);
                        return false;
                    }
                }
                a.bGf();
                this.fHG.videoLocalPath = "";
                a.a(this.fHG);
                return false;
            } else if (!TextUtils.isEmpty(this.fHG.adImgUrl)) {
                if (this.fHy != null) {
                    this.fHy = null;
                }
                this.fHy = new TbImageView(this.mContext);
                this.fHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fHz.advisible != 0) {
                                d.dvG().a(g.d(SplashAdView.this.fHz.extraParam, 2, SplashAdView.this.fHz.placeId, "image"));
                            }
                            if (SplashAdView.this.fHw != null && !TextUtils.isEmpty(SplashAdView.this.fHG.redirectUrl)) {
                                SplashAdView.this.fHw.Fb(SplashAdView.this.fHG.redirectUrl);
                            }
                        }
                    }
                });
                this.fHy.startLoad(this.fHz.adImgUrl, 10, false);
                this.fHy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fHy, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dvG().a(g.d(this.fHz.extraParam, 3, this.fHz.placeId, "image"));
                return true;
            } else {
                a.bGf();
            }
        } else {
            a.bGe();
            a.bGf();
        }
        return false;
    }

    public String bGj() {
        if (this.fHz == null) {
            if (this.fHA == null) {
                return null;
            }
            return this.fHA.displayName;
        }
        return this.fHz.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fHI != null) {
            this.fHI.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fHG;
    }
}
