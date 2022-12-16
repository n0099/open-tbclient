package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bi5 implements ai5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ci5> a;
    public final ViewGroup b;
    public final ji5 c;
    public final gi5 d;
    public ViewType e;
    public ci5 f;

    public bi5(ji5 ji5Var, @NonNull ViewGroup viewGroup, @NonNull gi5 gi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ji5Var, viewGroup, gi5Var};
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
        this.c = ji5Var;
        this.d = gi5Var;
    }

    @Override // com.baidu.tieba.ai5
    public void a(ViewType viewType, String str) {
        gi5.a aVar;
        gi5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.ai5
    public void c(ViewType viewType, @NonNull ci5 ci5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ci5Var) == null) {
            this.a.put(viewType, ci5Var);
        }
    }

    @Override // com.baidu.tieba.ai5
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
        ji5 ji5Var = this.c;
        if (ji5Var != null && ji5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        ci5 ci5Var = this.f;
        if (ci5Var != null) {
            ci5Var.b(this.b);
        }
        ci5 ci5Var2 = this.a.get(viewType);
        gi5.e d = d(viewType);
        if (ci5Var2 != null && d != null) {
            ci5Var2.c(viewType, this.b, d);
            this.f = ci5Var2;
            this.a.put(viewType, ci5Var2);
        }
    }

    public final gi5.e d(ViewType viewType) {
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
        return (gi5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ai5
    public void onChangeSkinType(int i) {
        ci5 ci5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (ci5Var = this.f) != null) {
            ci5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.ai5
    public void onDestroy() {
        ci5 ci5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ci5Var = this.f) != null) {
            ci5Var.b(this.b);
        }
    }
}
