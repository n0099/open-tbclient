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
    public ScalableVideoView fVA;
    private b fVy;
    public boolean fVz;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.fVv = redirectType;
        this.fVu = new c(tbPageContext.getPageActivity());
        this.fVr = new AdInfo();
    }

    public boolean bJT() {
        loadAd();
        this.fVr = AdInfo.jsonToObject(this.fVu.bJL());
        this.fVr.placeId = this.placeId;
        if (this.fVr.advisible == 0) {
            d.dAT().a(g.u(this.fVr.extraParam, 3, this.fVr.placeId));
        }
        this.fVy = b.Fl(a.bJR());
        if (this.fVy.isValidate()) {
            if (this.fVy.bjw()) {
                this.fVz = true;
                String str = this.fVy.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.W(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.fVA = new ScalableVideoView(this.mContext);
                    this.fVA.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.fVA.setDataSource(str);
                        this.fVA.setVolume(0.0f, 0.0f);
                        this.fVA.prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.fVA.start();
                            }
                        });
                        this.fVA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.bJQ();
                                SplashAdView.this.fVy.videoLocalPath = "";
                                a.a(SplashAdView.this.fVy);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.fVA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                            }
                        });
                        this.fVA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.fVr.advisible != 0) {
                                        d.dAT().a(g.d(SplashAdView.this.fVr.extraParam, 2, SplashAdView.this.fVr.placeId, "video"));
                                    }
                                    if (SplashAdView.this.fVo != null && !TextUtils.isEmpty(SplashAdView.this.fVy.videoJumpUrl)) {
                                        SplashAdView.this.fVo.Fj(SplashAdView.this.fVy.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.fVA, layoutParams);
                        d.dAT().a(g.d(this.fVr.extraParam, 3, this.fVr.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.bJQ();
                        this.fVy.videoLocalPath = "";
                        a.a(this.fVy);
                        return false;
                    }
                }
                a.bJQ();
                this.fVy.videoLocalPath = "";
                a.a(this.fVy);
                return false;
            } else if (!TextUtils.isEmpty(this.fVy.adImgUrl)) {
                if (this.fVq != null) {
                    this.fVq = null;
                }
                this.fVq = new TbImageView(this.mContext);
                this.fVq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.fVr.advisible != 0) {
                                d.dAT().a(g.d(SplashAdView.this.fVr.extraParam, 2, SplashAdView.this.fVr.placeId, "image"));
                            }
                            if (SplashAdView.this.fVo != null && !TextUtils.isEmpty(SplashAdView.this.fVy.redirectUrl)) {
                                SplashAdView.this.fVo.Fj(SplashAdView.this.fVy.redirectUrl);
                            }
                        }
                    }
                });
                this.fVq.startLoad(this.fVr.adImgUrl, 10, false);
                this.fVq.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.fVq, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                d.dAT().a(g.d(this.fVr.extraParam, 3, this.fVr.placeId, "image"));
                return true;
            } else {
                a.bJQ();
            }
        } else {
            a.bJP();
            a.bJQ();
        }
        return false;
    }

    public String bJU() {
        if (this.fVr == null) {
            if (this.fVs == null) {
                return null;
            }
            return this.fVs.displayName;
        }
        return this.fVr.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fVA != null) {
            this.fVA.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.fVy;
    }
}
