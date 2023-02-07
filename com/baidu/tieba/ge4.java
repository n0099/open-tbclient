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
public class ge4 extends l42<TextureMapView, iv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<fe4> n;
    public List<ee4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge4(@NonNull Context context, @NonNull iv2 iv2Var) {
        super(context, iv2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iv2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m42) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = iv2Var.c;
        this.j = iv2Var.b;
        String str = iv2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = iv2Var.r;
    }

    public static ge4 K(Context context, iv2 iv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, iv2Var)) == null) {
            if (context != null && iv2Var != null && iv2Var.isValid()) {
                return new ge4(context, iv2Var);
            }
            return null;
        }
        return (ge4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (fe4 fe4Var : this.n) {
                this.l.removeView(fe4Var.e);
            }
            this.n.clear();
            for (ee4 ee4Var : this.o) {
                this.l.removeView(ee4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public ee4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (ee4 ee4Var : this.o) {
                if (ee4Var.b == view2) {
                    return ee4Var;
                }
            }
            return null;
        }
        return (ee4) invokeL.objValue;
    }

    @Nullable
    public fe4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (fe4 fe4Var : this.n) {
                if (marker == fe4Var.b) {
                    return fe4Var;
                }
            }
            return null;
        }
        return (fe4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l42
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

    public List<fe4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (fe4 fe4Var : this.n) {
                qv2 qv2Var = fe4Var.a;
                if (qv2Var != null && TextUtils.equals(str, qv2Var.a)) {
                    arrayList.add(fe4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
