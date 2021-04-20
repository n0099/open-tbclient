package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import d.b.c.e.l.d;
import d.b.c.e.p.k;
import d.b.i0.r.a.f.c;
import d.b.i0.r.a.i.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BCAdView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r.a.g.a f14320e;

    /* renamed from: f  reason: collision with root package name */
    public BCAdView f14321f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f14322g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f14323h;
    public Context i;
    public AdInfo j;
    public AdInfo k;
    public String l;
    public int m;
    public int n;
    public AdType o;
    public c p;

    /* loaded from: classes4.dex */
    public static class a implements b.InterfaceC1539b {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<BCAdView> f14324a;

        /* renamed from: b  reason: collision with root package name */
        public AdInfo f14325b;

        /* renamed from: c  reason: collision with root package name */
        public c f14326c;

        /* renamed from: d  reason: collision with root package name */
        public AdType f14327d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0183a extends d.b.c.e.l.c<d.b.c.j.d.a> {
            public C0183a(a aVar) {
            }

            @Override // d.b.c.e.l.c
            public void onCancelled(String str) {
                super.onCancelled(str);
            }

            @Override // d.b.c.e.l.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.c.e.l.c
            public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
                super.onLoaded((C0183a) aVar, str, i);
            }
        }

        public a(BCAdView bCAdView) {
            this.f14325b = bCAdView.k;
            this.f14326c = bCAdView.p;
            this.f14327d = bCAdView.o;
            this.f14324a = new WeakReference<>(bCAdView);
        }

        @Override // d.b.i0.r.a.i.b.InterfaceC1539b
        public void a(String str) {
            BCAdView bCAdView = this.f14324a.get();
            if (bCAdView == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    d.b.i0.r.a.f.a aVar = new d.b.i0.r.a.f.a(new JSONObject(str));
                    if (bCAdView.f14320e != null) {
                        bCAdView.f14320e.c(aVar);
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

        @Override // d.b.i0.r.a.i.b.InterfaceC1539b
        public void b(String str) {
            d.b.i0.r.a.g.a aVar;
            if (k.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.f14325b = jsonToObject;
            if (this.f14327d == AdType.SPLASH && !k.isEmpty(jsonToObject.adImgUrl)) {
                d.h().k(this.f14325b.adImgUrl, 10, new C0183a(this), 0, 0, null, new Object[0]);
            }
            this.f14326c.b(str);
            BCAdView bCAdView = this.f14324a.get();
            if (bCAdView == null || (aVar = bCAdView.f14320e) == null) {
                return;
            }
            aVar.d();
        }
    }

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.f14323h = tbPageContext;
        this.f14321f = this;
        this.i = tbPageContext.getPageActivity();
        this.l = str;
        this.o = adType;
        this.m = i;
        this.n = i2;
    }

    public void a() {
        d.b.i0.r.a.g.a aVar = this.f14320e;
        if (aVar != null) {
            aVar.a();
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
        b.d().e(this.f14323h, new a(this), this.k);
    }

    public final void c() {
        try {
            this.f14322g = null;
            removeAllViews();
            this.j = null;
        } catch (Exception e2) {
            BdLog.e("Ad close failed" + e2.getMessage());
        }
    }

    public final void d() {
        d.b.i0.r.a.g.a aVar = this.f14320e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public void setBCAdCallBack(d.b.i0.r.a.g.a aVar) {
        if (aVar != null) {
            this.f14320e = aVar;
        }
    }
}
