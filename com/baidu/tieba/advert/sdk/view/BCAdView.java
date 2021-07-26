package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.l.d;
import d.a.d.e.p.k;
import d.a.q0.t.a.f.c;
import d.a.q0.t.a.i.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BCAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.t.a.g.a f13943e;

    /* renamed from: f  reason: collision with root package name */
    public BCAdView f13944f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13945g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13946h;

    /* renamed from: i  reason: collision with root package name */
    public Context f13947i;
    public AdInfo j;
    public AdInfo k;
    public String l;
    public int m;
    public int n;
    public AdType o;
    public c p;

    /* loaded from: classes4.dex */
    public static class a implements b.InterfaceC1643b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<BCAdView> f13948a;

        /* renamed from: b  reason: collision with root package name */
        public AdInfo f13949b;

        /* renamed from: c  reason: collision with root package name */
        public c f13950c;

        /* renamed from: d  reason: collision with root package name */
        public AdType f13951d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0191a extends d.a.d.e.l.c<d.a.d.k.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0191a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.d.e.l.c
            public void onCancelled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    super.onCancelled(str);
                }
            }

            @Override // d.a.d.e.l.c
            public void onProgressUpdate(Object... objArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                    super.onProgressUpdate(objArr);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.d.e.l.c
            public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                    super.onLoaded((C0191a) aVar, str, i2);
                }
            }
        }

        public a(BCAdView bCAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bCAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13949b = bCAdView.k;
            this.f13950c = bCAdView.p;
            this.f13951d = bCAdView.o;
            this.f13948a = new WeakReference<>(bCAdView);
        }

        @Override // d.a.q0.t.a.i.b.InterfaceC1643b
        public void a(String str) {
            BCAdView bCAdView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bCAdView = this.f13948a.get()) == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    d.a.q0.t.a.f.a aVar = new d.a.q0.t.a.f.a(new JSONObject(str));
                    if (bCAdView.f13943e != null) {
                        bCAdView.f13943e.b(aVar);
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

        @Override // d.a.q0.t.a.i.b.InterfaceC1643b
        public void b(String str) {
            d.a.q0.t.a.g.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || k.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.f13949b = jsonToObject;
            if (this.f13951d == AdType.SPLASH && !k.isEmpty(jsonToObject.adImgUrl)) {
                d.h().k(this.f13949b.adImgUrl, 10, new C0191a(this), 0, 0, null, new Object[0]);
            }
            this.f13950c.b(str);
            BCAdView bCAdView = this.f13948a.get();
            if (bCAdView == null || (aVar = bCAdView.f13943e) == null) {
                return;
            }
            aVar.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i2, int i3) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, adType, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13946h = tbPageContext;
        this.f13944f = this;
        this.f13947i = tbPageContext.getPageActivity();
        this.l = str;
        this.o = adType;
        this.m = i2;
        this.n = i3;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.q0.t.a.g.a aVar = this.f13943e;
            if (aVar != null) {
                aVar.c();
            }
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AdInfo adInfo = new AdInfo();
            this.k = adInfo;
            adInfo.placeId = this.l;
            adInfo.adHeight = this.m;
            adInfo.adWidth = this.n;
            adInfo.typeId = this.o;
            b.d().e(this.f13946h, new a(this), this.k);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f13945g = null;
                removeAllViews();
                this.j = null;
            } catch (Exception e2) {
                BdLog.e("Ad close failed" + e2.getMessage());
            }
        }
    }

    public final void d() {
        d.a.q0.t.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f13943e) == null) {
            return;
        }
        aVar.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            d();
        }
    }

    public void setBCAdCallBack(d.a.q0.t.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f13943e = aVar;
    }
}
