package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.bi;
import com.baidu.tieba.c76;
import com.baidu.tieba.l66;
import com.baidu.tieba.n66;
import com.baidu.tieba.p66;
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
    public p66 a;
    public BCAdView b;
    public TbImageView c;
    public TbPageContext<?> d;
    public Context e;
    public AdInfo f;
    public AdInfo g;
    public String h;
    public int i;
    public int j;
    public AdType k;
    public n66 l;

    /* loaded from: classes5.dex */
    public static class a implements c76.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<BCAdView> a;
        public AdInfo b;
        public n66 c;
        public AdType d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0238a extends BdResourceCallback<BdImage> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0238a(a aVar) {
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

            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onCancelled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    super.onCancelled(str);
                }
            }

            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onProgressUpdate(Object... objArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                    super.onProgressUpdate(objArr);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) {
                    super.onLoaded((C0238a) bdImage, str, i);
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
            this.b = bCAdView.g;
            this.c = bCAdView.l;
            this.d = bCAdView.k;
            this.a = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.c76.b
        public void a(String str) {
            BCAdView bCAdView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (bCAdView = this.a.get()) == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    l66 l66Var = new l66(new JSONObject(str));
                    if (bCAdView.a != null) {
                        bCAdView.a.b(l66Var);
                    }
                }
                if (bCAdView.k == AdType.SPLASH) {
                    bCAdView.l.b("");
                } else {
                    bCAdView.a();
                }
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
        }

        @Override // com.baidu.tieba.c76.b
        public void b(String str) {
            p66 p66Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || bi.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.b = jsonToObject;
            if (this.d == AdType.SPLASH && !bi.isEmpty(jsonToObject.adImgUrl)) {
                BdResourceLoader.getInstance().loadResource(this.b.adImgUrl, 10, new C0238a(this), 0, 0, null, new Object[0]);
            }
            this.c.b(str);
            BCAdView bCAdView = this.a.get();
            if (bCAdView != null && (p66Var = bCAdView.a) != null) {
                p66Var.d();
            }
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
        this.d = tbPageContext;
        this.b = this;
        this.e = tbPageContext.getPageActivity();
        this.h = str;
        this.k = adType;
        this.i = i;
        this.j = i2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p66 p66Var = this.a;
            if (p66Var != null) {
                p66Var.c();
            }
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.c = null;
                removeAllViews();
                this.f = null;
            } catch (Exception e) {
                BdLog.e("Ad close failed" + e.getMessage());
            }
        }
    }

    public final void d() {
        p66 p66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (p66Var = this.a) != null) {
            p66Var.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            d();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AdInfo adInfo = new AdInfo();
            this.g = adInfo;
            adInfo.placeId = this.h;
            adInfo.adHeight = this.i;
            adInfo.adWidth = this.j;
            adInfo.typeId = this.k;
            c76.d().e(this.d, new a(this), this.g);
        }
    }

    public void setBCAdCallBack(p66 p66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, p66Var) == null) && p66Var != null) {
            this.a = p66Var;
        }
    }
}
