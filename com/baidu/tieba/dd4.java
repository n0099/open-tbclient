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
public class dd4 extends i32<TextureMapView, fu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<cd4> n;
    public List<bd4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd4(@NonNull Context context, @NonNull fu2 fu2Var) {
        super(context, fu2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fu2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (j32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = fu2Var.c;
        this.j = fu2Var.b;
        String str = fu2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = fu2Var.r;
    }

    public static dd4 K(Context context, fu2 fu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, fu2Var)) == null) {
            if (context != null && fu2Var != null && fu2Var.isValid()) {
                return new dd4(context, fu2Var);
            }
            return null;
        }
        return (dd4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (cd4 cd4Var : this.n) {
                this.l.removeView(cd4Var.e);
            }
            this.n.clear();
            for (bd4 bd4Var : this.o) {
                this.l.removeView(bd4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public bd4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (bd4 bd4Var : this.o) {
                if (bd4Var.b == view2) {
                    return bd4Var;
                }
            }
            return null;
        }
        return (bd4) invokeL.objValue;
    }

    @Nullable
    public cd4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (cd4 cd4Var : this.n) {
                if (marker == cd4Var.b) {
                    return cd4Var;
                }
            }
            return null;
        }
        return (cd4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i32
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

    public List<cd4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (cd4 cd4Var : this.n) {
                nu2 nu2Var = cd4Var.a;
                if (nu2Var != null && TextUtils.equals(str, nu2Var.a)) {
                    arrayList.add(cd4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
