package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a26;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.bg;
import com.baidu.tieba.c26;
import com.baidu.tieba.cg;
import com.baidu.tieba.hi;
import com.baidu.tieba.p26;
import com.baidu.tieba.tm;
import com.baidu.tieba.y16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BCAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c26 a;
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
    public a26 l;

    /* loaded from: classes3.dex */
    public static class a implements p26.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<BCAdView> a;
        public AdInfo b;
        public a26 c;
        public AdType d;

        /* renamed from: com.baidu.tieba.advert.sdk.view.BCAdView$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0216a extends bg<tm> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0216a(a aVar) {
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

            @Override // com.baidu.tieba.bg
            public void onCancelled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    super.onCancelled(str);
                }
            }

            @Override // com.baidu.tieba.bg
            public void onProgressUpdate(Object... objArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                    super.onProgressUpdate(objArr);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.bg
            public void onLoaded(tm tmVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tmVar, str, i) == null) {
                    super.onLoaded((C0216a) tmVar, str, i);
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

        @Override // com.baidu.tieba.p26.b
        public void a(String str) {
            BCAdView bCAdView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (bCAdView = this.a.get()) == null) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    y16 y16Var = new y16(new JSONObject(str));
                    if (bCAdView.a != null) {
                        bCAdView.a.b(y16Var);
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

        @Override // com.baidu.tieba.p26.b
        public void b(String str) {
            c26 c26Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || hi.isEmpty(str)) {
                return;
            }
            AdInfo jsonToObject = AdInfo.jsonToObject(str);
            this.b = jsonToObject;
            if (this.d == AdType.SPLASH && !hi.isEmpty(jsonToObject.adImgUrl)) {
                cg.h().k(this.b.adImgUrl, 10, new C0216a(this), 0, 0, null, new Object[0]);
            }
            this.c.b(str);
            BCAdView bCAdView = this.a.get();
            if (bCAdView != null && (c26Var = bCAdView.a) != null) {
                c26Var.d();
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
            c26 c26Var = this.a;
            if (c26Var != null) {
                c26Var.c();
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
        c26 c26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (c26Var = this.a) != null) {
            c26Var.e();
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
            p26.d().e(this.d, new a(this), this.g);
        }
    }

    public void setBCAdCallBack(c26 c26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, c26Var) == null) && c26Var != null) {
            this.a = c26Var;
        }
    }
}
