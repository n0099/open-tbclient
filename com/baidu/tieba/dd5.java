package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.id5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class dd5 implements cd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ed5> a;
    public final ViewGroup b;
    public final ld5 c;
    public final id5 d;
    public ViewType e;
    public ed5 f;

    public dd5(ld5 ld5Var, @NonNull ViewGroup viewGroup, @NonNull id5 id5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ld5Var, viewGroup, id5Var};
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
        this.c = ld5Var;
        this.d = id5Var;
    }

    @Override // com.baidu.tieba.cd5
    public void a(ViewType viewType, String str) {
        id5.a aVar;
        id5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType != ViewType.EMPTY || (aVar = this.d.b) == null) {
            } else {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.cd5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        ld5 ld5Var = this.c;
        if (ld5Var != null && ld5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        ed5 ed5Var = this.f;
        if (ed5Var != null) {
            ed5Var.b(this.b);
        }
        ed5 ed5Var2 = this.a.get(viewType);
        id5.e d = d(viewType);
        if (ed5Var2 == null || d == null) {
            return;
        }
        ed5Var2.c(viewType, this.b, d);
        this.f = ed5Var2;
        this.a.put(viewType, ed5Var2);
    }

    @Override // com.baidu.tieba.cd5
    public void c(ViewType viewType, @NonNull ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ed5Var) == null) {
            this.a.put(viewType, ed5Var);
        }
    }

    public final id5.e d(ViewType viewType) {
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
        return (id5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd5
    public void onChangeSkinType(int i) {
        ed5 ed5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (ed5Var = this.f) == null) {
            return;
        }
        ed5Var.e(i);
    }

    @Override // com.baidu.tieba.cd5
    public void onDestroy() {
        ed5 ed5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ed5Var = this.f) == null) {
            return;
        }
        ed5Var.b(this.b);
    }
}
