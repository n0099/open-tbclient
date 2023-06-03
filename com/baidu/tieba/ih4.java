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
/* loaded from: classes6.dex */
public class ih4 extends n72<TextureMapView, ky2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<hh4> n;
    public List<gh4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih4(@NonNull Context context, @NonNull ky2 ky2Var) {
        super(context, ky2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ky2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (o72) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = ky2Var.c;
        this.j = ky2Var.b;
        String str = ky2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = ky2Var.r;
    }

    public static ih4 K(Context context, ky2 ky2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ky2Var)) == null) {
            if (context != null && ky2Var != null && ky2Var.isValid()) {
                return new ih4(context, ky2Var);
            }
            return null;
        }
        return (ih4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (hh4 hh4Var : this.n) {
                this.l.removeView(hh4Var.e);
            }
            this.n.clear();
            for (gh4 gh4Var : this.o) {
                this.l.removeView(gh4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public gh4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (gh4 gh4Var : this.o) {
                if (gh4Var.b == view2) {
                    return gh4Var;
                }
            }
            return null;
        }
        return (gh4) invokeL.objValue;
    }

    @Nullable
    public hh4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (hh4 hh4Var : this.n) {
                if (marker == hh4Var.b) {
                    return hh4Var;
                }
            }
            return null;
        }
        return (hh4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n72
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

    public List<hh4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (hh4 hh4Var : this.n) {
                sy2 sy2Var = hh4Var.a;
                if (sy2Var != null && TextUtils.equals(str, sy2Var.a)) {
                    arrayList.add(hh4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
