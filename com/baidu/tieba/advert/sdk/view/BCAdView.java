package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import d.a.j0.r.a.f.c;
import d.a.j0.r.a.i.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BCAdView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.r.a.g.a f14383e;

    /* renamed from: f  reason: collision with root package name */
    public BCAdView f14384f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f14385g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f14386h;

    /* renamed from: i  reason: collision with root package name */
    public Context f14387i;
    public AdInfo j;
    public AdInfo k;
    public String l;
    public int m;
    public int n;
    public AdType o;
    public c p;

    /* loaded from: classes4.dex */
    public static class a implements b.InterfaceC1501b {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<BCAdView> f14388a;

        /* renamed from: b  reason: collision with root package name */
        public AdInfo f14389b;

        /* renamed from: c  reason: collision with root package name */
        public c f14390c;

        /* renamed from: d  reason: collision with root package name */
        public AdType f14391d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0180a extends d.a.c.e.l.c<d.a.c.j.d.a> {
            public C0180a(a aVar) {
            }

            @Override // d.a.c.e.l.c
            public void onCancelled(String str) {
                super.onCancelled(str);
            }

            @Override // d.a.c.e.l.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.l.c
            public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
                super.onLoaded((C0180a) aVar, str, i2);
            }
        }

        public a(BCAdView bCAdView) {
            this.f14389b = bCAdView.k;
            this.f14390c = bCAdView.p;
            this.f14391d = bCAdView.o;
            this.f14388a = new WeakReference<>(bCAdView);
        }

        @Override // d.a.j0.r.a.i.b.InterfaceC1501b
        public void a(String str) {
            BCAdView bCAdView = this.f14388a.get();
            if (bCAdView == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    d.a.j0.r.a.f.a aVar = new d.a.j0.r.a.f.a(new JSONObject(str));
                    if (bCAdView.f14383e != null) {
                        bCAdView.f14383e.b(aVar);
                    }
                }
                if (bCAdView.o == AdType.SPLASH) {
                    bCAdView.p.b("");
                } else {
                    bCAdView.a();
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }

        @Override // d.a.j0.r.a.i.b.InterfaceC1501b
        public void b(String str) {
            d.a.j0.r.a.g.a aVar;
            if (k.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.f14389b = jsonToObject;
            if (this.f14391d == AdType.SPLASH && !k.isEmpty(jsonToObject.adImgUrl)) {
                d.h().k(this.f14389b.adImgUrl, 10, new C0180a(this), 0, 0, null, new Object[0]);
            }
            this.f14390c.b(str);
            BCAdView bCAdView = this.f14388a.get();
            if (bCAdView == null || (aVar = bCAdView.f14383e) == null) {
                return;
            }
            aVar.d();
        }
    }

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i2, int i3) {
        super(tbPageContext.getPageActivity());
        this.f14386h = tbPageContext;
        this.f14384f = this;
        this.f14387i = tbPageContext.getPageActivity();
        this.l = str;
        this.o = adType;
        this.m = i2;
        this.n = i3;
    }

    public void a() {
        d.a.j0.r.a.g.a aVar = this.f14383e;
        if (aVar != null) {
            aVar.c();
        }
        c();
    }

    public void b() {
        AdInfo adInfo = new AdInfo();
        this.k = adInfo;
        adInfo.placeId = this.l;
        adInfo.adHeight = this.m;
        adInfo.adWidth = this.n;
        adInfo.typeId = this.o;
        b.d().e(this.f14386h, new a(this), this.k);
    }

    public final void c() {
        try {
            this.f14385g = null;
            removeAllViews();
            this.j = null;
        } catch (Exception e2) {
            BdLog.e("Ad close failed" + e2.getMessage());
        }
    }

    public final void d() {
        d.a.j0.r.a.g.a aVar = this.f14383e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public void setBCAdCallBack(d.a.j0.r.a.g.a aVar) {
        if (aVar != null) {
            this.f14383e = aVar;
        }
    }
}
