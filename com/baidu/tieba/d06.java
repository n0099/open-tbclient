package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.multidelmenu.view.MultiDelPostMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d06 extends c06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiDelPostMenuView c;
    public ViewGroup d;

    public d06(TbPageContext tbPageContext, ViewGroup viewGroup, sz5 sz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, sz5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = viewGroup;
        a06 a06Var = new a06(tbPageContext, new tz5(sz5Var));
        this.b = a06Var;
        a06Var.d(this);
        this.c = new MultiDelPostMenuView(tbPageContext, this);
    }

    @Override // com.baidu.tieba.c06
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a) {
            return;
        }
        this.a = false;
        MultiDelPostMenuView multiDelPostMenuView = this.c;
        if (multiDelPostMenuView != null && this.d != null && multiDelPostMenuView.getParent() != null) {
            this.d.removeView(this.c);
        }
        zz5 zz5Var = this.b;
        if (zz5Var != null) {
            zz5Var.dismiss();
        }
        this.c = null;
        this.d = null;
        this.b = null;
    }

    @Override // com.baidu.tieba.c06
    public void d(int i) {
        MultiDelPostMenuView multiDelPostMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (multiDelPostMenuView = this.c) != null) {
            multiDelPostMenuView.setDelCount(i);
        }
    }

    @Override // com.baidu.tieba.c06
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a) {
            return;
        }
        this.a = true;
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
