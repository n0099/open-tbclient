package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bs5 implements as5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, cs5> a;
    public final ViewGroup b;
    public final js5 c;
    public final gs5 d;
    public ViewType e;
    public cs5 f;

    public bs5(js5 js5Var, @NonNull ViewGroup viewGroup, @NonNull gs5 gs5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {js5Var, viewGroup, gs5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = viewGroup;
        this.c = js5Var;
        this.d = gs5Var;
    }

    @Override // com.baidu.tieba.as5
    public void a(ViewType viewType, String str) {
        gs5.a aVar;
        gs5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.as5
    public void c(ViewType viewType, @NonNull cs5 cs5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, cs5Var) == null) {
            this.a.put(viewType, cs5Var);
        }
    }

    @Override // com.baidu.tieba.as5
    public void b(ViewType viewType) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) != null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        js5 js5Var = this.c;
        if (js5Var != null && js5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        cs5 cs5Var = this.f;
        if (cs5Var != null) {
            cs5Var.b(this.b);
        }
        cs5 cs5Var2 = this.a.get(viewType);
        gs5.e d = d(viewType);
        if (cs5Var2 != null && d != null) {
            cs5Var2.c(viewType, this.b, d);
            this.f = cs5Var2;
            this.a.put(viewType, cs5Var2);
        }
    }

    public final gs5.e d(ViewType viewType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewType)) == null) {
            if (viewType == ViewType.ERROR) {
                return this.d.c;
            }
            if (viewType == ViewType.EMPTY) {
                return this.d.b;
            }
            if (viewType == ViewType.LOADING) {
                return this.d.a;
            }
            return null;
        }
        return (gs5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.as5
    public void onChangeSkinType(int i) {
        cs5 cs5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (cs5Var = this.f) != null) {
            cs5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.as5
    public void onDestroy() {
        cs5 cs5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (cs5Var = this.f) != null) {
            cs5Var.b(this.b);
        }
    }
}
