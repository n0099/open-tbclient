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
    private b eRZ;
    public boolean eSa;
    public ScalableVideoView eSb;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.eRW = redirectType;
        this.eRV = new c(tbPageContext.getPageActivity());
        this.eRS = new AdInfo();
    }

    public boolean bnL() {
        loadAd();
        this.eRS = AdInfo.jsonToObject(this.eRV.bnD());
        this.eRS.placeId = this.placeId;
        if (this.eRS.advisible == 0) {
            d.cVA().a(g.s(this.eRS.extraParam, 3, this.eRS.placeId));
        }
        this.eRZ = b.Aw(a.bnJ());
        if (this.eRZ.isValidate()) {
            if (this.eRZ.bnC()) {
                this.eSa = true;
                String str = this.eRZ.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.O(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.eSb = new ScalableVideoView(this.mContext);
                    this.eSb.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.eSb.setDataSource(str);
                        this.eSb.setVolume(0.0f, 0.0f);
                        this.eSb.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.eSb.start();
                            }
                        });
                        this.eSb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bnI();
                                SplashAdView.this.eRZ.videoLocalPath = "";
                                a.a(SplashAdView.this.eRZ);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.eSb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.eSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.eRS.advisible != 0) {
                                        d.cVA().a(g.c(SplashAdView.this.eRS.extraParam, 2, SplashAdView.this.eRS.placeId, "video"));
                                    }
                                    if (SplashAdView.this.eRP != null && !TextUtils.isEmpty(SplashAdView.this.eRZ.videoJumpUrl)) {
                                        SplashAdView.this.eRP.Au(SplashAdView.this.eRZ.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.eSb, layoutParams);
                        d.cVA().a(g.c(this.eRS.extraParam, 3, this.eRS.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bnI();
                        this.eRZ.videoLocalPath = "";
                        a.a(this.eRZ);
                        return false;
                    }
                }
                a.bnI();
                this.eRZ.videoLocalPath = "";
                a.a(this.eRZ);
                return false;
            } else if (!TextUtils.isEmpty(this.eRZ.adImgUrl)) {
                if (this.eRR != null) {
                    this.eRR = null;
                }
                this.eRR = new TbImageView(this.mContext);
                this.eRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.eRS.advisible != 0) {
                                d.cVA().a(g.c(SplashAdView.this.eRS.extraParam, 2, SplashAdView.this.eRS.placeId, "image"));
                            }
                            if (SplashAdView.this.eRP != null && !TextUtils.isEmpty(SplashAdView.this.eRZ.redirectUrl)) {
                                SplashAdView.this.eRP.Au(SplashAdView.this.eRZ.redirectUrl);
                            }
                        }
                    }
                });
                this.eRR.startLoad(this.eRS.adImgUrl, 10, false);
                this.eRR.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.eRR, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.cVA().a(g.c(this.eRS.extraParam, 3, this.eRS.placeId, "image"));
                return true;
            } else {
                a.bnI();
            }
        } else {
            a.bnH();
            a.bnI();
        }
        return false;
    }

    public String bnM() {
        if (this.eRS == null) {
            if (this.eRT == null) {
                return null;
            }
            return this.eRT.displayName;
        }
        return this.eRS.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eSb != null) {
            this.eSb.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.eRZ;
    }
}
