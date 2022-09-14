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
public class i84 extends ny1<TextureMapView, kp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<h84> n;
    public List<g84> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i84(@NonNull Context context, @NonNull kp2 kp2Var) {
        super(context, kp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (oy1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = kp2Var.c;
        this.j = kp2Var.b;
        String str = kp2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = kp2Var.r;
    }

    public static i84 K(Context context, kp2 kp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, kp2Var)) == null) {
            if (context == null || kp2Var == null || !kp2Var.isValid()) {
                return null;
            }
            return new i84(context, kp2Var);
        }
        return (i84) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (h84 h84Var : this.n) {
                this.l.removeView(h84Var.e);
            }
            this.n.clear();
            for (g84 g84Var : this.o) {
                this.l.removeView(g84Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public g84 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (g84 g84Var : this.o) {
                if (g84Var.b == view2) {
                    return g84Var;
                }
            }
            return null;
        }
        return (g84) invokeL.objValue;
    }

    @Nullable
    public h84 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (h84 h84Var : this.n) {
                if (marker == h84Var.b) {
                    return h84Var;
                }
            }
            return null;
        }
        return (h84) invokeL.objValue;
    }

    public List<h84> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (h84 h84Var : this.n) {
                sp2 sp2Var = h84Var.a;
                if (sp2Var != null && TextUtils.equals(str, sp2Var.a)) {
                    arrayList.add(h84Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ny1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
