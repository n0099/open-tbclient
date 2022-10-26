package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.kg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class fg5 implements eg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;
    public final ViewGroup b;
    public final ng5 c;
    public final kg5 d;
    public ViewType e;
    public gg5 f;

    public fg5(ng5 ng5Var, ViewGroup viewGroup, kg5 kg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ng5Var, viewGroup, kg5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = viewGroup;
        this.c = ng5Var;
        this.d = kg5Var;
    }

    @Override // com.baidu.tieba.eg5
    public void a(ViewType viewType, String str) {
        kg5.a aVar;
        kg5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.eg5
    public void c(ViewType viewType, gg5 gg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, gg5Var) == null) {
            this.a.put(viewType, gg5Var);
        }
    }

    @Override // com.baidu.tieba.eg5
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
        ng5 ng5Var = this.c;
        if (ng5Var != null && ng5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        gg5 gg5Var = this.f;
        if (gg5Var != null) {
            gg5Var.b(this.b);
        }
        gg5 gg5Var2 = (gg5) this.a.get(viewType);
        kg5.e d = d(viewType);
        if (gg5Var2 != null && d != null) {
            gg5Var2.c(viewType, this.b, d);
            this.f = gg5Var2;
            this.a.put(viewType, gg5Var2);
        }
    }

    public final kg5.e d(ViewType viewType) {
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
        return (kg5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.eg5
    public void onChangeSkinType(int i) {
        gg5 gg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (gg5Var = this.f) != null) {
            gg5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.eg5
    public void onDestroy() {
        gg5 gg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gg5Var = this.f) != null) {
            gg5Var.b(this.b);
        }
    }
}
