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
/* loaded from: classes6.dex */
public class gja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, fja> d;
    public fja e;

    /* loaded from: classes6.dex */
    public class a implements qf9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fja a;

        public a(gja gjaVar, fja fjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gjaVar, fjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fjaVar;
        }

        @Override // com.baidu.tieba.qf9
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
                    if (wha.h(i)) {
                        kja.f(a, 0, str, i);
                    } else {
                        kja.m(a, 0, str);
                    }
                    yf9.c(a);
                }
            }
        }
    }

    public gja(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
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

    public fja a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fja fjaVar = new fja(this.a);
            fjaVar.c();
            fjaVar.setBusinessType(99);
            fjaVar.setFromCDN(this.c);
            fjaVar.E(this.b);
            fjaVar.setAfterClickSchemeListener(new a(this, fjaVar));
            return fjaVar;
        }
        return (fja) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo != null && (advertAppInfo.h instanceof AdCard)) {
                fja fjaVar = this.d.get(advertAppInfo);
                if (fjaVar == null) {
                    fjaVar = a();
                    this.d.put(advertAppInfo, fjaVar);
                }
                fjaVar.e((AdCard) advertAppInfo.h);
                this.e = fjaVar;
                if (z) {
                    fjaVar.y();
                }
                return fjaVar.t();
            }
            return null;
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        fja fjaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fjaVar = this.e) != null) {
            fjaVar.y();
        }
    }

    public void d() {
        fja fjaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (fjaVar = this.e) != null) {
            fjaVar.C();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (fja fjaVar : this.d.values()) {
                if (fjaVar != null) {
                    fjaVar.D();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        fja fjaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) && advertAppInfo != null && (fjaVar = this.d.get(advertAppInfo)) != null) {
            fjaVar.D();
            this.d.remove(advertAppInfo);
        }
    }
}
