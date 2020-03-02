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
    private b ecQ;
    public boolean ecR;
    public ScalableVideoView ecS;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.ecN = redirectType;
        this.ecM = new c(tbPageContext.getPageActivity());
        this.ecJ = new AdInfo();
    }

    public boolean aZr() {
        loadAd();
        this.ecJ = AdInfo.jsonToObject(this.ecM.aZj());
        this.ecJ.placeId = this.placeId;
        if (this.ecJ.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cDp().a(f.u(this.ecJ.extraParam, 3, this.ecJ.placeId));
        }
        this.ecQ = b.xz(a.aZp());
        if (this.ecQ.isValidate()) {
            if (this.ecQ.aZi()) {
                this.ecR = true;
                String str = this.ecQ.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.K(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.ecS = new ScalableVideoView(this.mContext);
                    this.ecS.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.ecS.setDataSource(str);
                        this.ecS.setVolume(0.0f, 0.0f);
                        this.ecS.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.ecS.start();
                            }
                        });
                        this.ecS.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aZo();
                                SplashAdView.this.ecQ.videoLocalPath = "";
                                a.a(SplashAdView.this.ecQ);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.ecS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.ecS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.ecJ.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cDp().a(f.c(SplashAdView.this.ecJ.extraParam, 2, SplashAdView.this.ecJ.placeId, "video"));
                                    }
                                    if (SplashAdView.this.ecG != null && !TextUtils.isEmpty(SplashAdView.this.ecQ.videoJumpUrl)) {
                                        SplashAdView.this.ecG.xx(SplashAdView.this.ecQ.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.ecS, layoutParams);
                        com.baidu.tieba.recapp.report.c.cDp().a(f.c(this.ecJ.extraParam, 3, this.ecJ.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aZo();
                        this.ecQ.videoLocalPath = "";
                        a.a(this.ecQ);
                        return false;
                    }
                }
                a.aZo();
                this.ecQ.videoLocalPath = "";
                a.a(this.ecQ);
                return false;
            } else if (!TextUtils.isEmpty(this.ecQ.adImgUrl)) {
                if (this.ecI != null) {
                    this.ecI = null;
                }
                this.ecI = new TbImageView(this.mContext);
                this.ecI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.ecJ.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cDp().a(f.c(SplashAdView.this.ecJ.extraParam, 2, SplashAdView.this.ecJ.placeId, "image"));
                            }
                            if (SplashAdView.this.ecG != null && !TextUtils.isEmpty(SplashAdView.this.ecQ.redirectUrl)) {
                                SplashAdView.this.ecG.xx(SplashAdView.this.ecQ.redirectUrl);
                            }
                        }
                    }
                });
                this.ecI.startLoad(this.ecJ.adImgUrl, 10, false);
                this.ecI.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.ecI, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cDp().a(f.c(this.ecJ.extraParam, 3, this.ecJ.placeId, "image"));
                return true;
            } else {
                a.aZo();
            }
        } else {
            a.aZn();
            a.aZo();
        }
        return false;
    }

    public String aZs() {
        if (this.ecJ == null) {
            if (this.ecK == null) {
                return null;
            }
            return this.ecK.displayName;
        }
        return this.ecJ.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ecS != null) {
            this.ecS.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.ecQ;
    }
}
