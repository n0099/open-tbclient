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
    private b fsl;
    public boolean fsm;
    public ScalableVideoView fsn;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fsi = redirectType;
        this.fsh = new c(tbPageContext.getPageActivity());
        this.fse = new AdInfo();
    }

    public boolean bCk() {
        loadAd();
        this.fse = AdInfo.jsonToObject(this.fsh.bCc());
        this.fse.placeId = this.placeId;
        if (this.fse.advisible == 0) {
            d.dol().a(g.r(this.fse.extraParam, 3, this.fse.placeId));
        }
        this.fsl = b.DV(a.bCi());
        if (this.fsl.isValidate()) {
            if (this.fsl.bcy()) {
                this.fsm = true;
                String str = this.fsl.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.T(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fsn = new ScalableVideoView(this.mContext);
                    this.fsn.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fsn.setDataSource(str);
                        this.fsn.setVolume(0.0f, 0.0f);
                        this.fsn.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fsn.start();
                            }
                        });
                        this.fsn.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bCh();
                                SplashAdView.this.fsl.videoLocalPath = "";
                                a.a(SplashAdView.this.fsl);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fsn.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fsn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fse.advisible != 0) {
                                        d.dol().a(g.d(SplashAdView.this.fse.extraParam, 2, SplashAdView.this.fse.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fsb != null && !TextUtils.isEmpty(SplashAdView.this.fsl.videoJumpUrl)) {
                                        SplashAdView.this.fsb.DT(SplashAdView.this.fsl.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fsn, layoutParams);
                        d.dol().a(g.d(this.fse.extraParam, 3, this.fse.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bCh();
                        this.fsl.videoLocalPath = "";
                        a.a(this.fsl);
                        return false;
                    }
                }
                a.bCh();
                this.fsl.videoLocalPath = "";
                a.a(this.fsl);
                return false;
            } else if (!TextUtils.isEmpty(this.fsl.adImgUrl)) {
                if (this.fsd != null) {
                    this.fsd = null;
                }
                this.fsd = new TbImageView(this.mContext);
                this.fsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fse.advisible != 0) {
                                d.dol().a(g.d(SplashAdView.this.fse.extraParam, 2, SplashAdView.this.fse.placeId, "image"));
                            }
                            if (SplashAdView.this.fsb != null && !TextUtils.isEmpty(SplashAdView.this.fsl.redirectUrl)) {
                                SplashAdView.this.fsb.DT(SplashAdView.this.fsl.redirectUrl);
                            }
                        }
                    }
                });
                this.fsd.startLoad(this.fse.adImgUrl, 10, false);
                this.fsd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fsd, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dol().a(g.d(this.fse.extraParam, 3, this.fse.placeId, "image"));
                return true;
            } else {
                a.bCh();
            }
        } else {
            a.bCg();
            a.bCh();
        }
        return false;
    }

    public String bCl() {
        if (this.fse == null) {
            if (this.fsf == null) {
                return null;
            }
            return this.fsf.displayName;
        }
        return this.fse.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fsn != null) {
            this.fsn.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fsl;
    }
}
