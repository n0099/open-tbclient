package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bu5 implements au5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, cu5> a;
    public final ViewGroup b;
    public final ju5 c;
    public final gu5 d;
    public ViewType e;
    public cu5 f;

    public bu5(ju5 ju5Var, @NonNull ViewGroup viewGroup, @NonNull gu5 gu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju5Var, viewGroup, gu5Var};
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
        this.c = ju5Var;
        this.d = gu5Var;
    }

    @Override // com.baidu.tieba.au5
    public void a(ViewType viewType, String str) {
        gu5.a aVar;
        gu5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.au5
    public void c(ViewType viewType, @NonNull cu5 cu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, cu5Var) == null) {
            this.a.put(viewType, cu5Var);
        }
    }

    @Override // com.baidu.tieba.au5
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
        ju5 ju5Var = this.c;
        if (ju5Var != null && ju5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        cu5 cu5Var = this.f;
        if (cu5Var != null) {
            cu5Var.b(this.b);
        }
        cu5 cu5Var2 = this.a.get(viewType);
        gu5.e d = d(viewType);
        if (cu5Var2 != null && d != null) {
            cu5Var2.c(viewType, this.b, d);
            this.f = cu5Var2;
            this.a.put(viewType, cu5Var2);
        }
    }

    public final gu5.e d(ViewType viewType) {
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
        return (gu5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.au5
    public void onChangeSkinType(int i) {
        cu5 cu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (cu5Var = this.f) != null) {
            cu5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.au5
    public void onDestroy() {
        cu5 cu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (cu5Var = this.f) != null) {
            cu5Var.b(this.b);
        }
    }
}
