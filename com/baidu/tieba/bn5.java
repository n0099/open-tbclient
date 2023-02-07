package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bn5 implements an5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, cn5> a;
    public final ViewGroup b;
    public final jn5 c;
    public final gn5 d;
    public ViewType e;
    public cn5 f;

    public bn5(jn5 jn5Var, @NonNull ViewGroup viewGroup, @NonNull gn5 gn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jn5Var, viewGroup, gn5Var};
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
        this.c = jn5Var;
        this.d = gn5Var;
    }

    @Override // com.baidu.tieba.an5
    public void a(ViewType viewType, String str) {
        gn5.a aVar;
        gn5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.an5
    public void c(ViewType viewType, @NonNull cn5 cn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, cn5Var) == null) {
            this.a.put(viewType, cn5Var);
        }
    }

    @Override // com.baidu.tieba.an5
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
        jn5 jn5Var = this.c;
        if (jn5Var != null && jn5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        cn5 cn5Var = this.f;
        if (cn5Var != null) {
            cn5Var.b(this.b);
        }
        cn5 cn5Var2 = this.a.get(viewType);
        gn5.e d = d(viewType);
        if (cn5Var2 != null && d != null) {
            cn5Var2.c(viewType, this.b, d);
            this.f = cn5Var2;
            this.a.put(viewType, cn5Var2);
        }
    }

    public final gn5.e d(ViewType viewType) {
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
        return (gn5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.an5
    public void onChangeSkinType(int i) {
        cn5 cn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (cn5Var = this.f) != null) {
            cn5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.an5
    public void onDestroy() {
        cn5 cn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (cn5Var = this.f) != null) {
            cn5Var.b(this.b);
        }
    }
}
