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
/* loaded from: classes17.dex */
public class SplashAdView extends BCAdView {
    private b fgM;
    public boolean fgN;
    public ScalableVideoView fgO;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fgJ = redirectType;
        this.fgI = new c(tbPageContext.getPageActivity());
        this.fgF = new AdInfo();
    }

    public boolean bto() {
        loadAd();
        this.fgF = AdInfo.jsonToObject(this.fgI.btg());
        this.fgF.placeId = this.placeId;
        if (this.fgF.advisible == 0) {
            d.dcY().a(g.s(this.fgF.extraParam, 3, this.fgF.placeId));
        }
        this.fgM = b.BA(a.btm());
        if (this.fgM.isValidate()) {
            if (this.fgM.btf()) {
                this.fgN = true;
                String str = this.fgM.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.S(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fgO = new ScalableVideoView(this.mContext);
                    this.fgO.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fgO.setDataSource(str);
                        this.fgO.setVolume(0.0f, 0.0f);
                        this.fgO.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fgO.start();
                            }
                        });
                        this.fgO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.btl();
                                SplashAdView.this.fgM.videoLocalPath = "";
                                a.a(SplashAdView.this.fgM);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fgO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fgO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fgF.advisible != 0) {
                                        d.dcY().a(g.c(SplashAdView.this.fgF.extraParam, 2, SplashAdView.this.fgF.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fgC != null && !TextUtils.isEmpty(SplashAdView.this.fgM.videoJumpUrl)) {
                                        SplashAdView.this.fgC.By(SplashAdView.this.fgM.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fgO, layoutParams);
                        d.dcY().a(g.c(this.fgF.extraParam, 3, this.fgF.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.btl();
                        this.fgM.videoLocalPath = "";
                        a.a(this.fgM);
                        return false;
                    }
                }
                a.btl();
                this.fgM.videoLocalPath = "";
                a.a(this.fgM);
                return false;
            } else if (!TextUtils.isEmpty(this.fgM.adImgUrl)) {
                if (this.fgE != null) {
                    this.fgE = null;
                }
                this.fgE = new TbImageView(this.mContext);
                this.fgE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fgF.advisible != 0) {
                                d.dcY().a(g.c(SplashAdView.this.fgF.extraParam, 2, SplashAdView.this.fgF.placeId, "image"));
                            }
                            if (SplashAdView.this.fgC != null && !TextUtils.isEmpty(SplashAdView.this.fgM.redirectUrl)) {
                                SplashAdView.this.fgC.By(SplashAdView.this.fgM.redirectUrl);
                            }
                        }
                    }
                });
                this.fgE.startLoad(this.fgF.adImgUrl, 10, false);
                this.fgE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fgE, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dcY().a(g.c(this.fgF.extraParam, 3, this.fgF.placeId, "image"));
                return true;
            } else {
                a.btl();
            }
        } else {
            a.btk();
            a.btl();
        }
        return false;
    }

    public String btp() {
        if (this.fgF == null) {
            if (this.fgG == null) {
                return null;
            }
            return this.fgG.displayName;
        }
        return this.fgF.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fgO != null) {
            this.fgO.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fgM;
    }
}
