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
public class c3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, b3a> d;
    public b3a e;

    /* loaded from: classes5.dex */
    public class a implements t19 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b3a a;

        public a(c3a c3aVar, b3a b3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c3aVar, b3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b3aVar;
        }

        @Override // com.baidu.tieba.t19
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
                    if (s1a.h(i)) {
                        g3a.f(a, 0, str, i);
                    } else {
                        g3a.m(a, 0, str);
                    }
                    b29.c(a);
                }
            }
        }
    }

    public c3a(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
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

    public b3a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b3a b3aVar = new b3a(this.a);
            b3aVar.b();
            b3aVar.setBusinessType(99);
            b3aVar.setFromCDN(this.c);
            b3aVar.C(this.b);
            b3aVar.setAfterClickSchemeListener(new a(this, b3aVar));
            return b3aVar;
        }
        return (b3a) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo != null && (advertAppInfo.h instanceof AdCard)) {
                b3a b3aVar = this.d.get(advertAppInfo);
                if (b3aVar == null) {
                    b3aVar = a();
                    this.d.put(advertAppInfo, b3aVar);
                }
                b3aVar.c((AdCard) advertAppInfo.h);
                this.e = b3aVar;
                if (z) {
                    b3aVar.w();
                }
                return b3aVar.r();
            }
            return null;
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        b3a b3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (b3aVar = this.e) != null) {
            b3aVar.w();
        }
    }

    public void d() {
        b3a b3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b3aVar = this.e) != null) {
            b3aVar.A();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (b3a b3aVar : this.d.values()) {
                if (b3aVar != null) {
                    b3aVar.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        b3a b3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) && advertAppInfo != null && (b3aVar = this.d.get(advertAppInfo)) != null) {
            b3aVar.B();
            this.d.remove(advertAppInfo);
        }
    }
}
