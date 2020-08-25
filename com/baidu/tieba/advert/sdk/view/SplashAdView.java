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
    private b fsh;
    public boolean fsi;
    public ScalableVideoView fsj;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fse = redirectType;
        this.fsd = new c(tbPageContext.getPageActivity());
        this.fsa = new AdInfo();
    }

    public boolean bCj() {
        loadAd();
        this.fsa = AdInfo.jsonToObject(this.fsd.bCb());
        this.fsa.placeId = this.placeId;
        if (this.fsa.advisible == 0) {
            d.doi().a(g.s(this.fsa.extraParam, 3, this.fsa.placeId));
        }
        this.fsh = b.DU(a.bCh());
        if (this.fsh.isValidate()) {
            if (this.fsh.bcy()) {
                this.fsi = true;
                String str = this.fsh.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.T(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fsj = new ScalableVideoView(this.mContext);
                    this.fsj.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fsj.setDataSource(str);
                        this.fsj.setVolume(0.0f, 0.0f);
                        this.fsj.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fsj.start();
                            }
                        });
                        this.fsj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bCg();
                                SplashAdView.this.fsh.videoLocalPath = "";
                                a.a(SplashAdView.this.fsh);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fsj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fsj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fsa.advisible != 0) {
                                        d.doi().a(g.c(SplashAdView.this.fsa.extraParam, 2, SplashAdView.this.fsa.placeId, "video"));
                                    }
                                    if (SplashAdView.this.frX != null && !TextUtils.isEmpty(SplashAdView.this.fsh.videoJumpUrl)) {
                                        SplashAdView.this.frX.DS(SplashAdView.this.fsh.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fsj, layoutParams);
                        d.doi().a(g.c(this.fsa.extraParam, 3, this.fsa.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bCg();
                        this.fsh.videoLocalPath = "";
                        a.a(this.fsh);
                        return false;
                    }
                }
                a.bCg();
                this.fsh.videoLocalPath = "";
                a.a(this.fsh);
                return false;
            } else if (!TextUtils.isEmpty(this.fsh.adImgUrl)) {
                if (this.frZ != null) {
                    this.frZ = null;
                }
                this.frZ = new TbImageView(this.mContext);
                this.frZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fsa.advisible != 0) {
                                d.doi().a(g.c(SplashAdView.this.fsa.extraParam, 2, SplashAdView.this.fsa.placeId, "image"));
                            }
                            if (SplashAdView.this.frX != null && !TextUtils.isEmpty(SplashAdView.this.fsh.redirectUrl)) {
                                SplashAdView.this.frX.DS(SplashAdView.this.fsh.redirectUrl);
                            }
                        }
                    }
                });
                this.frZ.startLoad(this.fsa.adImgUrl, 10, false);
                this.frZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.frZ, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.doi().a(g.c(this.fsa.extraParam, 3, this.fsa.placeId, "image"));
                return true;
            } else {
                a.bCg();
            }
        } else {
            a.bCf();
            a.bCg();
        }
        return false;
    }

    public String bCk() {
        if (this.fsa == null) {
            if (this.fsb == null) {
                return null;
            }
            return this.fsb.displayName;
        }
        return this.fsa.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fsj != null) {
            this.fsj.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fsh;
    }
}
