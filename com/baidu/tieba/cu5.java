package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.hu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class cu5 implements bu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, du5> a;
    public final ViewGroup b;
    public final ku5 c;
    public final hu5 d;
    public ViewType e;
    public du5 f;

    public cu5(ku5 ku5Var, @NonNull ViewGroup viewGroup, @NonNull hu5 hu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ku5Var, viewGroup, hu5Var};
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
        this.c = ku5Var;
        this.d = hu5Var;
    }

    @Override // com.baidu.tieba.bu5
    public void a(ViewType viewType, String str) {
        hu5.a aVar;
        hu5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.bu5
    public void c(ViewType viewType, @NonNull du5 du5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, du5Var) == null) {
            this.a.put(viewType, du5Var);
        }
    }

    @Override // com.baidu.tieba.bu5
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
        ku5 ku5Var = this.c;
        if (ku5Var != null && ku5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        du5 du5Var = this.f;
        if (du5Var != null) {
            du5Var.b(this.b);
        }
        du5 du5Var2 = this.a.get(viewType);
        hu5.e d = d(viewType);
        if (du5Var2 != null && d != null) {
            du5Var2.c(viewType, this.b, d);
            this.f = du5Var2;
            this.a.put(viewType, du5Var2);
        }
    }

    public final hu5.e d(ViewType viewType) {
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
        return (hu5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bu5
    public void onChangeSkinType(int i) {
        du5 du5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (du5Var = this.f) != null) {
            du5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.bu5
    public void onDestroy() {
        du5 du5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (du5Var = this.f) != null) {
            du5Var.b(this.b);
        }
    }
}
