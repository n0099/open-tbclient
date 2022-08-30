package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.kd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class fd5 implements ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, gd5> a;
    public final ViewGroup b;
    public final nd5 c;
    public final kd5 d;
    public ViewType e;
    public gd5 f;

    public fd5(nd5 nd5Var, @NonNull ViewGroup viewGroup, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nd5Var, viewGroup, kd5Var};
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
        this.c = nd5Var;
        this.d = kd5Var;
    }

    @Override // com.baidu.tieba.ed5
    public void a(ViewType viewType, String str) {
        kd5.a aVar;
        kd5.b bVar;
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

    @Override // com.baidu.tieba.ed5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        nd5 nd5Var = this.c;
        if (nd5Var != null && nd5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        gd5 gd5Var = this.f;
        if (gd5Var != null) {
            gd5Var.b(this.b);
        }
        gd5 gd5Var2 = this.a.get(viewType);
        kd5.e d = d(viewType);
        if (gd5Var2 == null || d == null) {
            return;
        }
        gd5Var2.c(viewType, this.b, d);
        this.f = gd5Var2;
        this.a.put(viewType, gd5Var2);
    }

    @Override // com.baidu.tieba.ed5
    public void c(ViewType viewType, @NonNull gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, gd5Var) == null) {
            this.a.put(viewType, gd5Var);
        }
    }

    public final kd5.e d(ViewType viewType) {
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
        return (kd5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed5
    public void onChangeSkinType(int i) {
        gd5 gd5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (gd5Var = this.f) == null) {
            return;
        }
        gd5Var.e(i);
    }

    @Override // com.baidu.tieba.ed5
    public void onDestroy() {
        gd5 gd5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gd5Var = this.f) == null) {
            return;
        }
        gd5Var.b(this.b);
    }
}
