package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.jv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ev5 implements dv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, fv5> a;
    public final ViewGroup b;
    public final mv5 c;
    public final jv5 d;
    public ViewType e;
    public fv5 f;

    public ev5(mv5 mv5Var, @NonNull ViewGroup viewGroup, @NonNull jv5 jv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mv5Var, viewGroup, jv5Var};
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
        this.c = mv5Var;
        this.d = jv5Var;
    }

    @Override // com.baidu.tieba.dv5
    public void a(ViewType viewType, String str) {
        jv5.a aVar;
        jv5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.dv5
    public void c(ViewType viewType, @NonNull fv5 fv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, fv5Var) == null) {
            this.a.put(viewType, fv5Var);
        }
    }

    @Override // com.baidu.tieba.dv5
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
        mv5 mv5Var = this.c;
        if (mv5Var != null && mv5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        fv5 fv5Var = this.f;
        if (fv5Var != null) {
            fv5Var.b(this.b);
        }
        fv5 fv5Var2 = this.a.get(viewType);
        jv5.e d = d(viewType);
        if (fv5Var2 != null && d != null) {
            fv5Var2.c(viewType, this.b, d);
            this.f = fv5Var2;
            this.a.put(viewType, fv5Var2);
        }
    }

    public final jv5.e d(ViewType viewType) {
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
        return (jv5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dv5
    public void onChangeSkinType(int i) {
        fv5 fv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (fv5Var = this.f) != null) {
            fv5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.dv5
    public void onDestroy() {
        fv5 fv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (fv5Var = this.f) != null) {
            fv5Var.b(this.b);
        }
    }
}
