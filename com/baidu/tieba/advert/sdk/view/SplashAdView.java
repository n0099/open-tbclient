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
/* loaded from: classes22.dex */
public class SplashAdView extends BCAdView {
    private b fvx;
    public boolean fvy;
    public ScalableVideoView fvz;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fvu = redirectType;
        this.fvt = new c(tbPageContext.getPageActivity());
        this.fvq = new AdInfo();
    }

    public boolean bDw() {
        loadAd();
        this.fvq = AdInfo.jsonToObject(this.fvt.bDo());
        this.fvq.placeId = this.placeId;
        if (this.fvq.advisible == 0) {
            d.drV().a(g.r(this.fvq.extraParam, 3, this.fvq.placeId));
        }
        this.fvx = b.Es(a.bDu());
        if (this.fvx.isValidate()) {
            if (this.fvx.bds()) {
                this.fvy = true;
                String str = this.fvx.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.T(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fvz = new ScalableVideoView(this.mContext);
                    this.fvz.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fvz.setDataSource(str);
                        this.fvz.setVolume(0.0f, 0.0f);
                        this.fvz.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fvz.start();
                            }
                        });
                        this.fvz.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bDt();
                                SplashAdView.this.fvx.videoLocalPath = "";
                                a.a(SplashAdView.this.fvx);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fvz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fvq.advisible != 0) {
                                        d.drV().a(g.d(SplashAdView.this.fvq.extraParam, 2, SplashAdView.this.fvq.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fvn != null && !TextUtils.isEmpty(SplashAdView.this.fvx.videoJumpUrl)) {
                                        SplashAdView.this.fvn.Eq(SplashAdView.this.fvx.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fvz, layoutParams);
                        d.drV().a(g.d(this.fvq.extraParam, 3, this.fvq.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bDt();
                        this.fvx.videoLocalPath = "";
                        a.a(this.fvx);
                        return false;
                    }
                }
                a.bDt();
                this.fvx.videoLocalPath = "";
                a.a(this.fvx);
                return false;
            } else if (!TextUtils.isEmpty(this.fvx.adImgUrl)) {
                if (this.fvp != null) {
                    this.fvp = null;
                }
                this.fvp = new TbImageView(this.mContext);
                this.fvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fvq.advisible != 0) {
                                d.drV().a(g.d(SplashAdView.this.fvq.extraParam, 2, SplashAdView.this.fvq.placeId, "image"));
                            }
                            if (SplashAdView.this.fvn != null && !TextUtils.isEmpty(SplashAdView.this.fvx.redirectUrl)) {
                                SplashAdView.this.fvn.Eq(SplashAdView.this.fvx.redirectUrl);
                            }
                        }
                    }
                });
                this.fvp.startLoad(this.fvq.adImgUrl, 10, false);
                this.fvp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fvp, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.drV().a(g.d(this.fvq.extraParam, 3, this.fvq.placeId, "image"));
                return true;
            } else {
                a.bDt();
            }
        } else {
            a.bDs();
            a.bDt();
        }
        return false;
    }

    public String bDx() {
        if (this.fvq == null) {
            if (this.fvr == null) {
                return null;
            }
            return this.fvr.displayName;
        }
        return this.fvq.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fvz != null) {
            this.fvz.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fvx;
    }
}
