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
/* loaded from: classes10.dex */
public class SplashAdView extends BCAdView {
    private b ecP;
    public boolean ecQ;
    public ScalableVideoView ecR;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.ecM = redirectType;
        this.ecL = new c(tbPageContext.getPageActivity());
        this.ecI = new AdInfo();
    }

    public boolean aZp() {
        loadAd();
        this.ecI = AdInfo.jsonToObject(this.ecL.aZh());
        this.ecI.placeId = this.placeId;
        if (this.ecI.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cDn().a(f.u(this.ecI.extraParam, 3, this.ecI.placeId));
        }
        this.ecP = b.xz(a.aZn());
        if (this.ecP.isValidate()) {
            if (this.ecP.aZg()) {
                this.ecQ = true;
                String str = this.ecP.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.K(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.ecR = new ScalableVideoView(this.mContext);
                    this.ecR.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.ecR.setDataSource(str);
                        this.ecR.setVolume(0.0f, 0.0f);
                        this.ecR.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.ecR.start();
                            }
                        });
                        this.ecR.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aZm();
                                SplashAdView.this.ecP.videoLocalPath = "";
                                a.a(SplashAdView.this.ecP);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.ecR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.ecR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.ecI.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cDn().a(f.c(SplashAdView.this.ecI.extraParam, 2, SplashAdView.this.ecI.placeId, "video"));
                                    }
                                    if (SplashAdView.this.ecF != null && !TextUtils.isEmpty(SplashAdView.this.ecP.videoJumpUrl)) {
                                        SplashAdView.this.ecF.xx(SplashAdView.this.ecP.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.ecR, layoutParams);
                        com.baidu.tieba.recapp.report.c.cDn().a(f.c(this.ecI.extraParam, 3, this.ecI.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aZm();
                        this.ecP.videoLocalPath = "";
                        a.a(this.ecP);
                        return false;
                    }
                }
                a.aZm();
                this.ecP.videoLocalPath = "";
                a.a(this.ecP);
                return false;
            } else if (!TextUtils.isEmpty(this.ecP.adImgUrl)) {
                if (this.ecH != null) {
                    this.ecH = null;
                }
                this.ecH = new TbImageView(this.mContext);
                this.ecH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.ecI.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cDn().a(f.c(SplashAdView.this.ecI.extraParam, 2, SplashAdView.this.ecI.placeId, "image"));
                            }
                            if (SplashAdView.this.ecF != null && !TextUtils.isEmpty(SplashAdView.this.ecP.redirectUrl)) {
                                SplashAdView.this.ecF.xx(SplashAdView.this.ecP.redirectUrl);
                            }
                        }
                    }
                });
                this.ecH.startLoad(this.ecI.adImgUrl, 10, false);
                this.ecH.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.ecH, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cDn().a(f.c(this.ecI.extraParam, 3, this.ecI.placeId, "image"));
                return true;
            } else {
                a.aZm();
            }
        } else {
            a.aZl();
            a.aZm();
        }
        return false;
    }

    public String aZq() {
        if (this.ecI == null) {
            if (this.ecJ == null) {
                return null;
            }
            return this.ecJ.displayName;
        }
        return this.ecI.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ecR != null) {
            this.ecR.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.ecP;
    }
}
