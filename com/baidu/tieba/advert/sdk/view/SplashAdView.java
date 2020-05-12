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
    private b eDp;
    public boolean eDq;
    public ScalableVideoView eDr;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.eDm = redirectType;
        this.eDl = new c(tbPageContext.getPageActivity());
        this.eDi = new AdInfo();
    }

    public boolean bhy() {
        loadAd();
        this.eDi = AdInfo.jsonToObject(this.eDl.bhq());
        this.eDi.placeId = this.placeId;
        if (this.eDi.advisible == 0) {
            d.cOj().a(g.u(this.eDi.extraParam, 3, this.eDi.placeId));
        }
        this.eDp = b.yQ(a.bhw());
        if (this.eDp.isValidate()) {
            if (this.eDp.bhp()) {
                this.eDq = true;
                String str = this.eDp.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.K(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.eDr = new ScalableVideoView(this.mContext);
                    this.eDr.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.eDr.setDataSource(str);
                        this.eDr.setVolume(0.0f, 0.0f);
                        this.eDr.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.eDr.start();
                            }
                        });
                        this.eDr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bhv();
                                SplashAdView.this.eDp.videoLocalPath = "";
                                a.a(SplashAdView.this.eDp);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.eDr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.eDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.eDi.advisible != 0) {
                                        d.cOj().a(g.c(SplashAdView.this.eDi.extraParam, 2, SplashAdView.this.eDi.placeId, "video"));
                                    }
                                    if (SplashAdView.this.eDf != null && !TextUtils.isEmpty(SplashAdView.this.eDp.videoJumpUrl)) {
                                        SplashAdView.this.eDf.yO(SplashAdView.this.eDp.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.eDr, layoutParams);
                        d.cOj().a(g.c(this.eDi.extraParam, 3, this.eDi.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bhv();
                        this.eDp.videoLocalPath = "";
                        a.a(this.eDp);
                        return false;
                    }
                }
                a.bhv();
                this.eDp.videoLocalPath = "";
                a.a(this.eDp);
                return false;
            } else if (!TextUtils.isEmpty(this.eDp.adImgUrl)) {
                if (this.eDh != null) {
                    this.eDh = null;
                }
                this.eDh = new TbImageView(this.mContext);
                this.eDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.eDi.advisible != 0) {
                                d.cOj().a(g.c(SplashAdView.this.eDi.extraParam, 2, SplashAdView.this.eDi.placeId, "image"));
                            }
                            if (SplashAdView.this.eDf != null && !TextUtils.isEmpty(SplashAdView.this.eDp.redirectUrl)) {
                                SplashAdView.this.eDf.yO(SplashAdView.this.eDp.redirectUrl);
                            }
                        }
                    }
                });
                this.eDh.startLoad(this.eDi.adImgUrl, 10, false);
                this.eDh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.eDh, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.cOj().a(g.c(this.eDi.extraParam, 3, this.eDi.placeId, "image"));
                return true;
            } else {
                a.bhv();
            }
        } else {
            a.bhu();
            a.bhv();
        }
        return false;
    }

    public String bhz() {
        if (this.eDi == null) {
            if (this.eDj == null) {
                return null;
            }
            return this.eDj.displayName;
        }
        return this.eDi.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eDr != null) {
            this.eDr.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.eDp;
    }
}
