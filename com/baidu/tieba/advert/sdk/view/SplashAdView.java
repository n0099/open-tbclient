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
    private b fck;
    public boolean fcl;
    public ScalableVideoView fcm;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fch = redirectType;
        this.fcg = new c(tbPageContext.getPageActivity());
        this.fcd = new AdInfo();
    }

    public boolean bql() {
        loadAd();
        this.fcd = AdInfo.jsonToObject(this.fcg.bqd());
        this.fcd.placeId = this.placeId;
        if (this.fcd.advisible == 0) {
            d.cZQ().a(g.s(this.fcd.extraParam, 3, this.fcd.placeId));
        }
        this.fck = b.AP(a.bqj());
        if (this.fck.isValidate()) {
            if (this.fck.bqc()) {
                this.fcl = true;
                String str = this.fck.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.P(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fcm = new ScalableVideoView(this.mContext);
                    this.fcm.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fcm.setDataSource(str);
                        this.fcm.setVolume(0.0f, 0.0f);
                        this.fcm.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fcm.start();
                            }
                        });
                        this.fcm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bqi();
                                SplashAdView.this.fck.videoLocalPath = "";
                                a.a(SplashAdView.this.fck);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fcm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fcm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fcd.advisible != 0) {
                                        d.cZQ().a(g.c(SplashAdView.this.fcd.extraParam, 2, SplashAdView.this.fcd.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fca != null && !TextUtils.isEmpty(SplashAdView.this.fck.videoJumpUrl)) {
                                        SplashAdView.this.fca.AN(SplashAdView.this.fck.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fcm, layoutParams);
                        d.cZQ().a(g.c(this.fcd.extraParam, 3, this.fcd.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bqi();
                        this.fck.videoLocalPath = "";
                        a.a(this.fck);
                        return false;
                    }
                }
                a.bqi();
                this.fck.videoLocalPath = "";
                a.a(this.fck);
                return false;
            } else if (!TextUtils.isEmpty(this.fck.adImgUrl)) {
                if (this.fcc != null) {
                    this.fcc = null;
                }
                this.fcc = new TbImageView(this.mContext);
                this.fcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fcd.advisible != 0) {
                                d.cZQ().a(g.c(SplashAdView.this.fcd.extraParam, 2, SplashAdView.this.fcd.placeId, "image"));
                            }
                            if (SplashAdView.this.fca != null && !TextUtils.isEmpty(SplashAdView.this.fck.redirectUrl)) {
                                SplashAdView.this.fca.AN(SplashAdView.this.fck.redirectUrl);
                            }
                        }
                    }
                });
                this.fcc.startLoad(this.fcd.adImgUrl, 10, false);
                this.fcc.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fcc, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.cZQ().a(g.c(this.fcd.extraParam, 3, this.fcd.placeId, "image"));
                return true;
            } else {
                a.bqi();
            }
        } else {
            a.bqh();
            a.bqi();
        }
        return false;
    }

    public String bqm() {
        if (this.fcd == null) {
            if (this.fce == null) {
                return null;
            }
            return this.fce.displayName;
        }
        return this.fcd.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fcm != null) {
            this.fcm.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fck;
    }
}
