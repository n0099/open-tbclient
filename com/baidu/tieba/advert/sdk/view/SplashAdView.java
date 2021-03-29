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
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableType;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableVideoView;
import d.b.i0.r2.b0.h;
import java.io.File;
/* loaded from: classes4.dex */
public class SplashAdView extends BCAdView {
    public d.b.i0.r.a.e.b q;
    public boolean r;
    public ScalableVideoView s;

    /* loaded from: classes4.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            SplashAdView.this.s.g();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            d.b.i0.r.a.i.a.b();
            SplashAdView.this.q.f59667d = "";
            d.b.i0.r.a.i.a.k(SplashAdView.this.q);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.i0.r.a.i.a.i()) {
                return;
            }
            AdInfo adInfo = SplashAdView.this.j;
            if (adInfo.advisible != 0) {
                d.b.i0.r2.b0.e.b().d(h.k(adInfo.extraParam, 2, adInfo.placeId, "video"));
            }
            SplashAdView splashAdView = SplashAdView.this;
            if (splashAdView.f14657e == null || TextUtils.isEmpty(splashAdView.q.f59668e)) {
                return;
            }
            SplashAdView splashAdView2 = SplashAdView.this;
            splashAdView2.f14657e.b(splashAdView2.q.f59668e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.i0.r.a.i.a.i()) {
                return;
            }
            AdInfo adInfo = SplashAdView.this.j;
            if (adInfo.advisible != 0) {
                d.b.i0.r2.b0.e.b().d(h.k(adInfo.extraParam, 2, adInfo.placeId, "image"));
            }
            SplashAdView splashAdView = SplashAdView.this;
            if (splashAdView.f14657e == null || TextUtils.isEmpty(splashAdView.q.f59665b)) {
                return;
            }
            SplashAdView splashAdView2 = SplashAdView.this;
            splashAdView2.f14657e.b(splashAdView2.q.f59665b);
        }
    }

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.p = new d.b.i0.r.a.e.c(tbPageContext.getPageActivity());
        this.j = new AdInfo();
    }

    public boolean f() {
        b();
        AdInfo jsonToObject = AdInfo.jsonToObject(this.p.a());
        this.j = jsonToObject;
        String str = this.l;
        jsonToObject.placeId = str;
        if (jsonToObject.advisible == 0) {
            d.b.i0.r2.b0.e.b().d(h.j(jsonToObject.extraParam, 3, str));
        }
        d.b.i0.r.a.e.b b2 = d.b.i0.r.a.e.b.b(d.b.i0.r.a.i.a.g());
        this.q = b2;
        if (b2.c()) {
            if (this.q.d()) {
                this.r = true;
                String str2 = this.q.f59667d;
                File file = new File(str2);
                if (file.exists()) {
                    d.b.i0.r.a.i.a.c(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.n, this.m);
                    ScalableVideoView scalableVideoView = new ScalableVideoView(this.i);
                    this.s = scalableVideoView;
                    scalableVideoView.setScalableType(ScalableType.CENTER_CROP);
                    try {
                        this.s.setDataSource(str2);
                        this.s.setVolume(0.0f, 0.0f);
                        this.s.c(new a());
                        this.s.setOnErrorListener(new b());
                        this.s.setOnCompletionListener(new c());
                        this.s.setOnClickListener(new d());
                        addView(this.s, layoutParams);
                        AdInfo adInfo = this.j;
                        d.b.i0.r2.b0.e.b().d(h.k(adInfo.extraParam, 3, adInfo.placeId, "video"));
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        d.b.i0.r.a.i.a.b();
                        d.b.i0.r.a.e.b bVar = this.q;
                        bVar.f59667d = "";
                        d.b.i0.r.a.i.a.k(bVar);
                        return false;
                    }
                }
                d.b.i0.r.a.i.a.b();
                d.b.i0.r.a.e.b bVar2 = this.q;
                bVar2.f59667d = "";
                d.b.i0.r.a.i.a.k(bVar2);
                return false;
            } else if (!TextUtils.isEmpty(this.q.f59664a)) {
                if (this.f14659g != null) {
                    this.f14659g = null;
                }
                TbImageView tbImageView = new TbImageView(this.i);
                this.f14659g = tbImageView;
                tbImageView.setOnClickListener(new e());
                this.f14659g.W(this.j.adImgUrl, 10, false);
                this.f14659g.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.f14659g, new RelativeLayout.LayoutParams(this.n, this.m));
                AdInfo adInfo2 = this.j;
                d.b.i0.r2.b0.e.b().d(h.k(adInfo2.extraParam, 3, adInfo2.placeId, "image"));
                return true;
            } else {
                d.b.i0.r.a.i.a.b();
            }
        } else {
            d.b.i0.r.a.i.a.d();
            d.b.i0.r.a.i.a.b();
        }
        return false;
    }

    public String g() {
        AdInfo adInfo = this.j;
        if (adInfo == null) {
            AdInfo adInfo2 = this.k;
            if (adInfo2 == null) {
                return null;
            }
            return adInfo2.displayName;
        }
        return adInfo.displayName;
    }

    public d.b.i0.r.a.e.b getEntryInfoData() {
        return this.q;
    }

    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ScalableVideoView scalableVideoView = this.s;
        if (scalableVideoView != null) {
            scalableVideoView.onDetachedFromWindow();
        }
    }
}
