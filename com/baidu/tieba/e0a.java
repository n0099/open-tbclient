package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class e0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, d0a> d;
    public d0a e;

    /* loaded from: classes5.dex */
    public class a implements tz8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0a a;

        public a(e0a e0aVar, d0a d0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e0aVar, d0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0aVar;
        }

        @Override // com.baidu.tieba.tz8
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                AdvertAppInfo a = this.a.a();
                if (i != 0 && a != null) {
                    String str = "image";
                    if (hashMap != null) {
                        String str2 = (String) hashMap.get("da_area");
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                    }
                    if (vy9.h(i)) {
                        j0a.f(a, 0, str, i);
                    } else {
                        j0a.m(a, 0, str);
                    }
                    b09.c(a);
                }
            }
        }
    }

    public e0a(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = z;
        this.b = hVar;
        this.d = new HashMap();
    }

    public d0a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d0a d0aVar = new d0a(this.a);
            d0aVar.b();
            d0aVar.setBusinessType(99);
            d0aVar.setFromCDN(this.c);
            d0aVar.C(this.b);
            d0aVar.setAfterClickSchemeListener(new a(this, d0aVar));
            return d0aVar;
        }
        return (d0a) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo != null && (advertAppInfo.h instanceof AdCard)) {
                d0a d0aVar = this.d.get(advertAppInfo);
                if (d0aVar == null) {
                    d0aVar = a();
                    this.d.put(advertAppInfo, d0aVar);
                }
                d0aVar.c((AdCard) advertAppInfo.h);
                this.e = d0aVar;
                if (z) {
                    d0aVar.w();
                }
                return d0aVar.r();
            }
            return null;
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (d0aVar = this.e) != null) {
            d0aVar.w();
        }
    }

    public void d() {
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (d0aVar = this.e) != null) {
            d0aVar.A();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (d0a d0aVar : this.d.values()) {
                if (d0aVar != null) {
                    d0aVar.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) && advertAppInfo != null && (d0aVar = this.d.get(advertAppInfo)) != null) {
            d0aVar.B();
            this.d.remove(advertAppInfo);
        }
    }
}
