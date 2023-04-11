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
public class ed4 extends j32<TextureMapView, gu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<dd4> n;
    public List<cd4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed4(@NonNull Context context, @NonNull gu2 gu2Var) {
        super(context, gu2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gu2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (k32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = gu2Var.c;
        this.j = gu2Var.b;
        String str = gu2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = gu2Var.r;
    }

    public static ed4 K(Context context, gu2 gu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, gu2Var)) == null) {
            if (context != null && gu2Var != null && gu2Var.isValid()) {
                return new ed4(context, gu2Var);
            }
            return null;
        }
        return (ed4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (dd4 dd4Var : this.n) {
                this.l.removeView(dd4Var.e);
            }
            this.n.clear();
            for (cd4 cd4Var : this.o) {
                this.l.removeView(cd4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public cd4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (cd4 cd4Var : this.o) {
                if (cd4Var.b == view2) {
                    return cd4Var;
                }
            }
            return null;
        }
        return (cd4) invokeL.objValue;
    }

    @Nullable
    public dd4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (dd4 dd4Var : this.n) {
                if (marker == dd4Var.b) {
                    return dd4Var;
                }
            }
            return null;
        }
        return (dd4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j32
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

    public List<dd4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (dd4 dd4Var : this.n) {
                ou2 ou2Var = dd4Var.a;
                if (ou2Var != null && TextUtils.equals(str, ou2Var.a)) {
                    arrayList.add(dd4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
