package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class fd4 extends k32<TextureMapView, hu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<ed4> n;
    public List<dd4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd4(@NonNull Context context, @NonNull hu2 hu2Var) {
        super(context, hu2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hu2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (l32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = hu2Var.c;
        this.j = hu2Var.b;
        String str = hu2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = hu2Var.r;
    }

    public static fd4 K(Context context, hu2 hu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, hu2Var)) == null) {
            if (context != null && hu2Var != null && hu2Var.isValid()) {
                return new fd4(context, hu2Var);
            }
            return null;
        }
        return (fd4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (ed4 ed4Var : this.n) {
                this.l.removeView(ed4Var.e);
            }
            this.n.clear();
            for (dd4 dd4Var : this.o) {
                this.l.removeView(dd4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public dd4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (dd4 dd4Var : this.o) {
                if (dd4Var.b == view2) {
                    return dd4Var;
                }
            }
            return null;
        }
        return (dd4) invokeL.objValue;
    }

    @Nullable
    public ed4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (ed4 ed4Var : this.n) {
                if (marker == ed4Var.b) {
                    return ed4Var;
                }
            }
            return null;
        }
        return (ed4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k32
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return this.l;
        }
        return (TextureMapView) invokeL.objValue;
    }

    public List<ed4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (ed4 ed4Var : this.n) {
                pu2 pu2Var = ed4Var.a;
                if (pu2Var != null && TextUtils.equals(str, pu2Var.a)) {
                    arrayList.add(ed4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
