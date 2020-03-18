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
    private b edt;
    public boolean edu;
    public ScalableVideoView edv;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.edq = redirectType;
        this.edp = new c(tbPageContext.getPageActivity());
        this.edm = new AdInfo();
    }

    public boolean aZw() {
        loadAd();
        this.edm = AdInfo.jsonToObject(this.edp.aZo());
        this.edm.placeId = this.placeId;
        if (this.edm.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cDK().a(f.u(this.edm.extraParam, 3, this.edm.placeId));
        }
        this.edt = b.xA(a.aZu());
        if (this.edt.isValidate()) {
            if (this.edt.aZn()) {
                this.edu = true;
                String str = this.edt.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.K(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.edv = new ScalableVideoView(this.mContext);
                    this.edv.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.edv.setDataSource(str);
                        this.edv.setVolume(0.0f, 0.0f);
                        this.edv.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.edv.start();
                            }
                        });
                        this.edv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aZt();
                                SplashAdView.this.edt.videoLocalPath = "";
                                a.a(SplashAdView.this.edt);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.edv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.edv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.edm.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cDK().a(f.c(SplashAdView.this.edm.extraParam, 2, SplashAdView.this.edm.placeId, "video"));
                                    }
                                    if (SplashAdView.this.edj != null && !TextUtils.isEmpty(SplashAdView.this.edt.videoJumpUrl)) {
                                        SplashAdView.this.edj.xy(SplashAdView.this.edt.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.edv, layoutParams);
                        com.baidu.tieba.recapp.report.c.cDK().a(f.c(this.edm.extraParam, 3, this.edm.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aZt();
                        this.edt.videoLocalPath = "";
                        a.a(this.edt);
                        return false;
                    }
                }
                a.aZt();
                this.edt.videoLocalPath = "";
                a.a(this.edt);
                return false;
            } else if (!TextUtils.isEmpty(this.edt.adImgUrl)) {
                if (this.edl != null) {
                    this.edl = null;
                }
                this.edl = new TbImageView(this.mContext);
                this.edl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.edm.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cDK().a(f.c(SplashAdView.this.edm.extraParam, 2, SplashAdView.this.edm.placeId, "image"));
                            }
                            if (SplashAdView.this.edj != null && !TextUtils.isEmpty(SplashAdView.this.edt.redirectUrl)) {
                                SplashAdView.this.edj.xy(SplashAdView.this.edt.redirectUrl);
                            }
                        }
                    }
                });
                this.edl.startLoad(this.edm.adImgUrl, 10, false);
                this.edl.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.edl, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cDK().a(f.c(this.edm.extraParam, 3, this.edm.placeId, "image"));
                return true;
            } else {
                a.aZt();
            }
        } else {
            a.aZs();
            a.aZt();
        }
        return false;
    }

    public String aZx() {
        if (this.edm == null) {
            if (this.edn == null) {
                return null;
            }
            return this.edn.displayName;
        }
        return this.edm.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.edv != null) {
            this.edv.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.edt;
    }
}
