package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bh5 implements ah5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ch5> a;
    public final ViewGroup b;
    public final jh5 c;
    public final gh5 d;
    public ViewType e;
    public ch5 f;

    public bh5(jh5 jh5Var, @NonNull ViewGroup viewGroup, @NonNull gh5 gh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jh5Var, viewGroup, gh5Var};
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
        this.c = jh5Var;
        this.d = gh5Var;
    }

    @Override // com.baidu.tieba.ah5
    public void a(ViewType viewType, String str) {
        gh5.a aVar;
        gh5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.ah5
    public void c(ViewType viewType, @NonNull ch5 ch5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ch5Var) == null) {
            this.a.put(viewType, ch5Var);
        }
    }

    @Override // com.baidu.tieba.ah5
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
        jh5 jh5Var = this.c;
        if (jh5Var != null && jh5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        ch5 ch5Var = this.f;
        if (ch5Var != null) {
            ch5Var.b(this.b);
        }
        ch5 ch5Var2 = this.a.get(viewType);
        gh5.e d = d(viewType);
        if (ch5Var2 != null && d != null) {
            ch5Var2.c(viewType, this.b, d);
            this.f = ch5Var2;
            this.a.put(viewType, ch5Var2);
        }
    }

    public final gh5.e d(ViewType viewType) {
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
        return (gh5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ah5
    public void onChangeSkinType(int i) {
        ch5 ch5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (ch5Var = this.f) != null) {
            ch5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.ah5
    public void onDestroy() {
        ch5 ch5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ch5Var = this.f) != null) {
            ch5Var.b(this.b);
        }
    }
}
