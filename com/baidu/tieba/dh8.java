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
/* loaded from: classes3.dex */
public class dh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, ch8> d;
    public ch8 e;

    /* loaded from: classes3.dex */
    public class a implements ii7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch8 a;

        public a(dh8 dh8Var, ch8 ch8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh8Var, ch8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch8Var;
        }

        @Override // com.baidu.tieba.ii7
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
                    if (wf8.h(i)) {
                        ih8.f(a, 0, str, i);
                    } else {
                        ih8.m(a, 0, str);
                    }
                    qi7.c(a);
                }
            }
        }
    }

    public dh8(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
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

    public ch8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ch8 ch8Var = new ch8(this.a);
            ch8Var.b();
            ch8Var.setBusinessType(99);
            ch8Var.setFromCDN(this.c);
            ch8Var.C(this.b);
            ch8Var.setAfterClickSchemeListener(new a(this, ch8Var));
            return ch8Var;
        }
        return (ch8) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo != null && (advertAppInfo.h instanceof AdCard)) {
                ch8 ch8Var = this.d.get(advertAppInfo);
                if (ch8Var == null) {
                    ch8Var = a();
                    this.d.put(advertAppInfo, ch8Var);
                }
                ch8Var.d((AdCard) advertAppInfo.h);
                this.e = ch8Var;
                if (z) {
                    ch8Var.w();
                }
                return ch8Var.r();
            }
            return null;
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ch8Var = this.e) != null) {
            ch8Var.w();
        }
    }

    public void d() {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ch8Var = this.e) != null) {
            ch8Var.A();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (ch8 ch8Var : this.d.values()) {
                if (ch8Var != null) {
                    ch8Var.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) && advertAppInfo != null && (ch8Var = this.d.get(advertAppInfo)) != null) {
            ch8Var.B();
            this.d.remove(advertAppInfo);
        }
    }
}
