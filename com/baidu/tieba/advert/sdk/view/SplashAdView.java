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
import d.a.n0.t2.i0.g;
import java.io.File;
/* loaded from: classes4.dex */
public class SplashAdView extends BCAdView {
    public d.a.n0.t.a.f.b q;
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
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            d.a.n0.t.a.j.a.a();
            SplashAdView.this.q.f60805d = "";
            d.a.n0.t.a.j.a.h(SplashAdView.this.q);
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
            if (d.a.n0.t.a.j.a.f()) {
                return;
            }
            AdInfo adInfo = SplashAdView.this.j;
            if (adInfo.advisible != 0) {
                d.a.n0.t2.i0.e.b().d(g.k(adInfo.extraParam, 2, adInfo.placeId, "video"));
            }
            SplashAdView splashAdView = SplashAdView.this;
            if (splashAdView.f13622e == null || TextUtils.isEmpty(splashAdView.q.f60806e)) {
                return;
            }
            SplashAdView splashAdView2 = SplashAdView.this;
            splashAdView2.f13622e.a(splashAdView2.q.f60806e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.n0.t.a.j.a.f()) {
                return;
            }
            AdInfo adInfo = SplashAdView.this.j;
            if (adInfo.advisible != 0) {
                d.a.n0.t2.i0.e.b().d(g.k(adInfo.extraParam, 2, adInfo.placeId, "image"));
            }
            SplashAdView splashAdView = SplashAdView.this;
            if (splashAdView.f13622e == null || TextUtils.isEmpty(splashAdView.q.f60803b)) {
                return;
            }
            SplashAdView splashAdView2 = SplashAdView.this;
            splashAdView2.f13622e.a(splashAdView2.q.f60803b);
        }
    }

    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i2, int i3, RedirectType redirectType) {
        super(tbPageContext, str, adType, i2, i3);
        this.p = new d.a.n0.t.a.f.c(tbPageContext.getPageActivity());
        this.j = new AdInfo();
    }

    public boolean f() {
        b();
        AdInfo jsonToObject = AdInfo.jsonToObject(this.p.a());
        this.j = jsonToObject;
        String str = this.l;
        jsonToObject.placeId = str;
        if (jsonToObject.advisible == 0) {
            d.a.n0.t2.i0.e.b().d(g.j(jsonToObject.extraParam, 3, str));
        }
        d.a.n0.t.a.f.b b2 = d.a.n0.t.a.f.b.b(d.a.n0.t.a.j.a.d());
        this.q = b2;
        if (b2.c()) {
            if (this.q.d()) {
                this.r = true;
                String str2 = this.q.f60805d;
                File file = new File(str2);
                if (file.exists()) {
                    d.a.n0.t.a.j.a.b(file);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.n, this.m);
                    ScalableVideoView scalableVideoView = new ScalableVideoView(this.f13626i);
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
                        d.a.n0.t2.i0.e.b().d(g.k(adInfo.extraParam, 3, adInfo.placeId, "video"));
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        d.a.n0.t.a.j.a.a();
                        d.a.n0.t.a.f.b bVar = this.q;
                        bVar.f60805d = "";
                        d.a.n0.t.a.j.a.h(bVar);
                        return false;
                    }
                }
                d.a.n0.t.a.j.a.a();
                d.a.n0.t.a.f.b bVar2 = this.q;
                bVar2.f60805d = "";
                d.a.n0.t.a.j.a.h(bVar2);
                return false;
            } else if (!TextUtils.isEmpty(this.q.f60802a)) {
                if (this.f13624g != null) {
                    this.f13624g = null;
                }
                TbImageView tbImageView = new TbImageView(this.f13626i);
                this.f13624g = tbImageView;
                tbImageView.setOnClickListener(new e());
                this.f13624g.V(this.j.adImgUrl, 10, false);
                this.f13624g.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.f13624g, new RelativeLayout.LayoutParams(this.n, this.m));
                AdInfo adInfo2 = this.j;
                d.a.n0.t2.i0.e.b().d(g.k(adInfo2.extraParam, 3, adInfo2.placeId, "image"));
                return true;
            } else {
                d.a.n0.t.a.j.a.a();
            }
        } else {
            d.a.n0.t.a.j.a.c();
            d.a.n0.t.a.j.a.a();
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

    public d.a.n0.t.a.f.b getEntryInfoData() {
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
