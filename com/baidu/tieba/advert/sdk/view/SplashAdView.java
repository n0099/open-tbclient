package com.baidu.tieba.advert.sdk.view;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes5.dex */
public class SplashAdView extends BCAdView {
    private b dcs;
    public boolean dct;
    public ScalableVideoView dcv;

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.dcp = redirectType;
        this.dco = new c(tbPageContext.getPageActivity());
        this.dcl = new AdInfo();
    }

    public boolean aEH() {
        loadAd();
        this.dcl = AdInfo.jsonToObject(this.dco.aEy());
        this.dcl.placeId = this.placeId;
        if (this.dcl.advisible == 0) {
            com.baidu.tieba.recapp.report.c.cjE().a(f.s(this.dcl.extraParam, 3, this.dcl.placeId));
        }
        this.dcs = b.tm(a.aEE());
        if (this.dcs.aEw()) {
            if (this.dcs.aEx()) {
                this.dct = true;
                String str = this.dcs.videoLocalPath;
                File file = new File(str);
                if (file.exists()) {
                    a.J(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                    this.dcv = new ScalableVideoView(this.mContext);
                    this.dcv.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.dcv.setDataSource(str);
                        this.dcv.setVolume(0.0f, 0.0f);
                        this.dcv.b(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                SplashAdView.this.dcv.start();
                            }
                        });
                        this.dcv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.2
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                a.aED();
                                SplashAdView.this.dcs.videoLocalPath = "";
                                a.a(SplashAdView.this.dcs);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                                return false;
                            }
                        });
                        this.dcv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.3
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                            }
                        });
                        this.dcv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!a.isFastDoubleClick()) {
                                    if (SplashAdView.this.dcl.advisible != 0) {
                                        com.baidu.tieba.recapp.report.c.cjE().a(f.b(SplashAdView.this.dcl.extraParam, 2, SplashAdView.this.dcl.placeId, "video"));
                                    }
                                    if (SplashAdView.this.dci != null && !TextUtils.isEmpty(SplashAdView.this.dcs.videoJumpUrl)) {
                                        SplashAdView.this.dci.tk(SplashAdView.this.dcs.videoJumpUrl);
                                    }
                                }
                            }
                        });
                        addView(this.dcv, layoutParams);
                        com.baidu.tieba.recapp.report.c.cjE().a(f.b(this.dcl.extraParam, 3, this.dcl.placeId, "video"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.aED();
                        this.dcs.videoLocalPath = "";
                        a.a(this.dcs);
                        return false;
                    }
                }
                a.aED();
                this.dcs.videoLocalPath = "";
                a.a(this.dcs);
                return false;
            } else if (!TextUtils.isEmpty(this.dcs.adImgUrl)) {
                if (this.dck != null) {
                    this.dck = null;
                }
                this.dck = new TbImageView(this.mContext);
                this.dck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.view.SplashAdView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!a.isFastDoubleClick()) {
                            if (SplashAdView.this.dcl.advisible != 0) {
                                com.baidu.tieba.recapp.report.c.cjE().a(f.b(SplashAdView.this.dcl.extraParam, 2, SplashAdView.this.dcl.placeId, "image"));
                            }
                            if (SplashAdView.this.dci != null && !TextUtils.isEmpty(SplashAdView.this.dcs.redirectUrl)) {
                                SplashAdView.this.dci.tk(SplashAdView.this.dcs.redirectUrl);
                            }
                        }
                    }
                });
                this.dck.startLoad(this.dcl.adImgUrl, 10, false);
                this.dck.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.dck, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                com.baidu.tieba.recapp.report.c.cjE().a(f.b(this.dcl.extraParam, 3, this.dcl.placeId, "image"));
                return true;
            } else {
                a.aED();
            }
        } else {
            a.aEC();
            a.aED();
        }
        return false;
    }

    public String aEI() {
        if (this.dcl == null) {
            if (this.dcm == null) {
                return null;
            }
            return this.dcm.displayName;
        }
        return this.dcl.displayName;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dcv != null) {
            this.dcv.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public b getEntryInfoData() {
        return this.dcs;
    }
}
