package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import c.a.d.f.l.d;
import c.a.d.f.p.m;
import c.a.p0.a0.a.d.c;
import c.a.p0.a0.a.h.b;
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
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BCAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a0.a.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public BCAdView f31211b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f31212c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f31213d;

    /* renamed from: e  reason: collision with root package name */
    public Context f31214e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f31215f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f31216g;

    /* renamed from: h  reason: collision with root package name */
    public String f31217h;
    public int i;
    public int j;
    public AdType k;
    public c l;

    /* loaded from: classes5.dex */
    public static class a implements b.InterfaceC0909b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<BCAdView> a;

        /* renamed from: b  reason: collision with root package name */
        public AdInfo f31218b;

        /* renamed from: c  reason: collision with root package name */
        public c f31219c;

        /* renamed from: d  reason: collision with root package name */
        public AdType f31220d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1838a extends c.a.d.f.l.c<c.a.d.o.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1838a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.d.f.l.c
            public void onCancelled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    super.onCancelled(str);
                }
            }

            @Override // c.a.d.f.l.c
            public void onProgressUpdate(Object... objArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                    super.onProgressUpdate(objArr);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.d.f.l.c
            public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) {
                    super.onLoaded((C1838a) aVar, str, i);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31218b = bCAdView.f31216g;
            this.f31219c = bCAdView.l;
            this.f31220d = bCAdView.k;
            this.a = new WeakReference<>(bCAdView);
        }

        @Override // c.a.p0.a0.a.h.b.InterfaceC0909b
        public void a(String str) {
            BCAdView bCAdView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bCAdView = this.a.get()) == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    c.a.p0.a0.a.d.a aVar = new c.a.p0.a0.a.d.a(new JSONObject(str));
                    if (bCAdView.a != null) {
                        bCAdView.a.b(aVar);
                    }
                }
                if (bCAdView.k == AdType.SPLASH) {
                    bCAdView.l.b("");
                } else {
                    bCAdView.a();
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }

        @Override // c.a.p0.a0.a.h.b.InterfaceC0909b
        public void b(String str) {
            c.a.p0.a0.a.e.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || m.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.f31218b = jsonToObject;
            if (this.f31220d == AdType.SPLASH && !m.isEmpty(jsonToObject.adImgUrl)) {
                d.h().k(this.f31218b.adImgUrl, 10, new C1838a(this), 0, 0, null, new Object[0]);
            }
            this.f31219c.b(str);
            BCAdView bCAdView = this.a.get();
            if (bCAdView == null || (aVar = bCAdView.a) == null) {
                return;
            }
            aVar.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, adType, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31213d = tbPageContext;
        this.f31211b = this;
        this.f31214e = tbPageContext.getPageActivity();
        this.f31217h = str;
        this.k = adType;
        this.i = i;
        this.j = i2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.a0.a.e.a aVar = this.a;
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
            this.f31216g = adInfo;
            adInfo.placeId = this.f31217h;
            adInfo.adHeight = this.i;
            adInfo.adWidth = this.j;
            adInfo.typeId = this.k;
            b.d().e(this.f31213d, new a(this), this.f31216g);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f31212c = null;
                removeAllViews();
                this.f31215f = null;
            } catch (Exception e2) {
                BdLog.e("Ad close failed" + e2.getMessage());
            }
        }
    }

    public final void d() {
        c.a.p0.a0.a.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.a) == null) {
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

    public void setBCAdCallBack(c.a.p0.a0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a = aVar;
    }
}
