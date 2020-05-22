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
    private b eRO;
    public boolean eRP;
    public ScalableVideoView eRQ;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.eRL = redirectType;
        this.eRK = new c(tbPageContext.getPageActivity());
        this.eRH = new AdInfo();
    }

    public boolean bnJ() {
        loadAd();
        this.eRH = AdInfo.jsonToObject(this.eRK.bnB());
        this.eRH.placeId = this.placeId;
        if (this.eRH.advisible == 0) {
            d.cVk().a(g.s(this.eRH.extraParam, 3, this.eRH.placeId));
        }
        this.eRO = b.Aw(a.bnH());
        if (this.eRO.isValidate()) {
            if (this.eRO.bnA()) {
                this.eRP = true;
                String str = this.eRO.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.O(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.eRQ = new ScalableVideoView(this.mContext);
                    this.eRQ.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.eRQ.setDataSource(str);
                        this.eRQ.setVolume(0.0f, 0.0f);
                        this.eRQ.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.eRQ.start();
                            }
                        });
                        this.eRQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bnG();
                                SplashAdView.this.eRO.videoLocalPath = "";
                                a.a(SplashAdView.this.eRO);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.eRQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.eRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.eRH.advisible != 0) {
                                        d.cVk().a(g.c(SplashAdView.this.eRH.extraParam, 2, SplashAdView.this.eRH.placeId, "video"));
                                    }
                                    if (SplashAdView.this.eRE != null && !TextUtils.isEmpty(SplashAdView.this.eRO.videoJumpUrl)) {
                                        SplashAdView.this.eRE.Au(SplashAdView.this.eRO.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.eRQ, layoutParams);
                        d.cVk().a(g.c(this.eRH.extraParam, 3, this.eRH.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bnG();
                        this.eRO.videoLocalPath = "";
                        a.a(this.eRO);
                        return false;
                    }
                }
                a.bnG();
                this.eRO.videoLocalPath = "";
                a.a(this.eRO);
                return false;
            } else if (!TextUtils.isEmpty(this.eRO.adImgUrl)) {
                if (this.eRG != null) {
                    this.eRG = null;
                }
                this.eRG = new TbImageView(this.mContext);
                this.eRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.eRH.advisible != 0) {
                                d.cVk().a(g.c(SplashAdView.this.eRH.extraParam, 2, SplashAdView.this.eRH.placeId, "image"));
                            }
                            if (SplashAdView.this.eRE != null && !TextUtils.isEmpty(SplashAdView.this.eRO.redirectUrl)) {
                                SplashAdView.this.eRE.Au(SplashAdView.this.eRO.redirectUrl);
                            }
                        }
                    }
                });
                this.eRG.startLoad(this.eRH.adImgUrl, 10, false);
                this.eRG.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.eRG, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.cVk().a(g.c(this.eRH.extraParam, 3, this.eRH.placeId, "image"));
                return true;
            } else {
                a.bnG();
            }
        } else {
            a.bnF();
            a.bnG();
        }
        return false;
    }

    public String bnK() {
        if (this.eRH == null) {
            if (this.eRI == null) {
                return null;
            }
            return this.eRI.displayName;
        }
        return this.eRH.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eRQ != null) {
            this.eRQ.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.eRO;
    }
}
