package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import c.a.d.f.l.d;
import c.a.d.f.p.l;
import c.a.s0.y.a.d.c;
import c.a.s0.y.a.h.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BCAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView mAdImageView;
    public BCAdView mBCAdView;
    public AdInfo mCacheAdInfo;
    public c.a.s0.y.a.e.a mCallBack;
    public Context mContext;
    public int mHeight;
    public TbPageContext<?> mPageContext;
    public AdInfo mRequestAdInfo;
    public c mSplashInfoCache;
    public int mWidth;
    public String placeId;
    public RedirectType redirectType;
    public AdType type;

    /* loaded from: classes11.dex */
    public static class a implements b.InterfaceC1508b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<BCAdView> a;

        /* renamed from: b  reason: collision with root package name */
        public AdInfo f43175b;

        /* renamed from: c  reason: collision with root package name */
        public c f43176c;

        /* renamed from: d  reason: collision with root package name */
        public AdType f43177d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1880a extends c.a.d.f.l.c<c.a.d.m.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1880a(a aVar) {
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
            public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                    super.onLoaded((C1880a) aVar, str, i2);
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
            this.f43175b = bCAdView.mRequestAdInfo;
            this.f43176c = bCAdView.mSplashInfoCache;
            this.f43177d = bCAdView.type;
            this.a = new WeakReference<>(bCAdView);
        }

        @Override // c.a.s0.y.a.h.b.InterfaceC1508b
        public void a(String str) {
            BCAdView bCAdView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bCAdView = this.a.get()) == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    c.a.s0.y.a.d.a aVar = new c.a.s0.y.a.d.a(new JSONObject(str));
                    if (bCAdView.mCallBack != null) {
                        bCAdView.mCallBack.b(aVar);
                    }
                }
                if (bCAdView.type == AdType.SPLASH) {
                    bCAdView.mSplashInfoCache.b("");
                } else {
                    bCAdView.closeAd();
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }

        @Override // c.a.s0.y.a.h.b.InterfaceC1508b
        public void b(String str) {
            c.a.s0.y.a.e.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || l.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.f43175b = jsonToObject;
            if (this.f43177d == AdType.SPLASH && !l.isEmpty(jsonToObject.adImgUrl)) {
                d.h().k(this.f43175b.adImgUrl, 10, new C1880a(this), 0, 0, null, new Object[0]);
            }
            this.f43176c.b(str);
            BCAdView bCAdView = this.a.get();
            if (bCAdView == null || (aVar = bCAdView.mCallBack) == null) {
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
        this.mPageContext = tbPageContext;
        this.mBCAdView = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.type = adType;
        this.mHeight = i2;
        this.mWidth = i3;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.mAdImageView = null;
                removeAllViews();
                this.mCacheAdInfo = null;
            } catch (Exception e2) {
                BdLog.e("Ad close failed" + e2.getMessage());
            }
        }
    }

    public final void b() {
        c.a.s0.y.a.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.mCallBack) == null) {
            return;
        }
        aVar.e();
    }

    public void closeAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.y.a.e.a aVar = this.mCallBack;
            if (aVar != null) {
                aVar.c();
            }
            a();
        }
    }

    public void loadAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AdInfo adInfo = new AdInfo();
            this.mRequestAdInfo = adInfo;
            adInfo.placeId = this.placeId;
            adInfo.adHeight = this.mHeight;
            adInfo.adWidth = this.mWidth;
            adInfo.typeId = this.type;
            b.d().e(this.mPageContext, new a(this), this.mRequestAdInfo);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            b();
        }
    }

    public void setBCAdCallBack(c.a.s0.y.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.mCallBack = aVar;
    }
}
