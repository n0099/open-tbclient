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
import d.b.j0.s2.f0.h;
import java.io.File;
/* loaded from: classes4.dex */
public class SplashAdView extends BCAdView {
    public d.b.j0.r.a.f.b q;
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
            d.b.j0.r.a.j.a.a();
            SplashAdView.this.q.f61338d = "";
            d.b.j0.r.a.j.a.g(SplashAdView.this.q);
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
            if (d.b.j0.r.a.j.a.e()) {
                return;
            }
            AdInfo adInfo = SplashAdView.this.j;
            if (adInfo.advisible != 0) {
                d.b.j0.s2.f0.e.b().d(h.k(adInfo.extraParam, 2, adInfo.placeId, "video"));
            }
            SplashAdView splashAdView = SplashAdView.this;
            if (splashAdView.f14328e == null || TextUtils.isEmpty(splashAdView.q.f61339e)) {
                return;
            }
            SplashAdView splashAdView2 = SplashAdView.this;
            splashAdView2.f14328e.b(splashAdView2.q.f61339e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.j0.r.a.j.a.e()) {
                return;
            }
            AdInfo adInfo = SplashAdView.this.j;
            if (adInfo.advisible != 0) {
                d.b.j0.s2.f0.e.b().d(h.k(adInfo.extraParam, 2, adInfo.placeId, "image"));
            }
            SplashAdView splashAdView = SplashAdView.this;
            if (splashAdView.f14328e == null || TextUtils.isEmpty(splashAdView.q.f61336b)) {
                return;
            }
            SplashAdView splashAdView2 = SplashAdView.this;
            splashAdView2.f14328e.b(splashAdView2.q.f61336b);
        }
    }

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        this.p = new d.b.j0.r.a.f.c(tbPageContext.getPageActivity());
        this.j = new AdInfo();
    }

    public boolean f() {
        b();
        AdInfo jsonToObject = AdInfo.jsonToObject(this.p.a());
        this.j = jsonToObject;
        String str = this.l;
        jsonToObject.placeId = str;
        if (jsonToObject.advisible == 0) {
            d.b.j0.s2.f0.e.b().d(h.j(jsonToObject.extraParam, 3, str));
        }
        d.b.j0.r.a.f.b b2 = d.b.j0.r.a.f.b.b(d.b.j0.r.a.j.a.d());
        this.q = b2;
        if (b2.c()) {
            if (this.q.d()) {
                this.r = true;
                String str2 = this.q.f61338d;
                File file = new File(str2);
                if (file.exists()) {
                    d.b.j0.r.a.j.a.b(file);
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
                        d.b.j0.s2.f0.e.b().d(h.k(adInfo.extraParam, 3, adInfo.placeId, "video"));
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        d.b.j0.r.a.j.a.a();
                        d.b.j0.r.a.f.b bVar = this.q;
                        bVar.f61338d = "";
                        d.b.j0.r.a.j.a.g(bVar);
                        return false;
                    }
                }
                d.b.j0.r.a.j.a.a();
                d.b.j0.r.a.f.b bVar2 = this.q;
                bVar2.f61338d = "";
                d.b.j0.r.a.j.a.g(bVar2);
                return false;
            } else if (!TextUtils.isEmpty(this.q.f61335a)) {
                if (this.f14330g != null) {
                    this.f14330g = null;
                }
                TbImageView tbImageView = new TbImageView(this.i);
                this.f14330g = tbImageView;
                tbImageView.setOnClickListener(new e());
                this.f14330g.W(this.j.adImgUrl, 10, false);
                this.f14330g.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.f14330g, new RelativeLayout.LayoutParams(this.n, this.m));
                AdInfo adInfo2 = this.j;
                d.b.j0.s2.f0.e.b().d(h.k(adInfo2.extraParam, 3, adInfo2.placeId, "image"));
                return true;
            } else {
                d.b.j0.r.a.j.a.a();
            }
        } else {
            d.b.j0.r.a.j.a.c();
            d.b.j0.r.a.j.a.a();
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

    public d.b.j0.r.a.f.b getEntryInfoData() {
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
