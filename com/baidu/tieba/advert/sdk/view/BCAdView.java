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
import d.a.o0.t.a.f.c;
import d.a.o0.t.a.i.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BCAdView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.t.a.g.a f13769e;

    /* renamed from: f  reason: collision with root package name */
    public BCAdView f13770f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13771g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13772h;

    /* renamed from: i  reason: collision with root package name */
    public Context f13773i;
    public AdInfo j;
    public AdInfo k;
    public String l;
    public int m;
    public int n;
    public AdType o;
    public c p;

    /* loaded from: classes4.dex */
    public static class a implements b.InterfaceC1668b {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<BCAdView> f13774a;

        /* renamed from: b  reason: collision with root package name */
        public AdInfo f13775b;

        /* renamed from: c  reason: collision with root package name */
        public c f13776c;

        /* renamed from: d  reason: collision with root package name */
        public AdType f13777d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0171a extends d.a.c.e.l.c<d.a.c.k.d.a> {
            public C0171a(a aVar) {
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
            public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
                super.onLoaded((C0171a) aVar, str, i2);
            }
        }

        public a(BCAdView bCAdView) {
            this.f13775b = bCAdView.k;
            this.f13776c = bCAdView.p;
            this.f13777d = bCAdView.o;
            this.f13774a = new WeakReference<>(bCAdView);
        }

        @Override // d.a.o0.t.a.i.b.InterfaceC1668b
        public void a(String str) {
            BCAdView bCAdView = this.f13774a.get();
            if (bCAdView == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    d.a.o0.t.a.f.a aVar = new d.a.o0.t.a.f.a(new JSONObject(str));
                    if (bCAdView.f13769e != null) {
                        bCAdView.f13769e.b(aVar);
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

        @Override // d.a.o0.t.a.i.b.InterfaceC1668b
        public void b(String str) {
            d.a.o0.t.a.g.a aVar;
            if (k.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.f13775b = jsonToObject;
            if (this.f13777d == AdType.SPLASH && !k.isEmpty(jsonToObject.adImgUrl)) {
                d.h().k(this.f13775b.adImgUrl, 10, new C0171a(this), 0, 0, null, new Object[0]);
            }
            this.f13776c.b(str);
            BCAdView bCAdView = this.f13774a.get();
            if (bCAdView == null || (aVar = bCAdView.f13769e) == null) {
                return;
            }
            aVar.d();
        }
    }

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i2, int i3) {
        super(tbPageContext.getPageActivity());
        this.f13772h = tbPageContext;
        this.f13770f = this;
        this.f13773i = tbPageContext.getPageActivity();
        this.l = str;
        this.o = adType;
        this.m = i2;
        this.n = i3;
    }

    public void a() {
        d.a.o0.t.a.g.a aVar = this.f13769e;
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
        b.d().e(this.f13772h, new a(this), this.k);
    }

    public final void c() {
        try {
            this.f13771g = null;
            removeAllViews();
            this.j = null;
        } catch (Exception e2) {
            BdLog.e("Ad close failed" + e2.getMessage());
        }
    }

    public final void d() {
        d.a.o0.t.a.g.a aVar = this.f13769e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public void setBCAdCallBack(d.a.o0.t.a.g.a aVar) {
        if (aVar != null) {
            this.f13769e = aVar;
        }
    }
}
