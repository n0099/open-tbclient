package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d46 extends me6<z26> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q26 i;
    public q26 j;
    public ViewGroup k;

    @Override // com.baidu.tieba.me6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d08bc : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d46(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i, boolean z) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            this.i = new f46(tbPageContext, i);
            this.j = new f46(tbPageContext, i);
            s();
            return;
        }
        this.i = new e46(tbPageContext, i);
        this.j = new e46(tbPageContext, i);
        r();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.me6
    /* renamed from: t */
    public void l(z26 z26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, z26Var) == null) && z26Var != null) {
            this.i.a(z26Var.a);
            this.j.a(z26Var.b);
        }
    }

    @Override // com.baidu.tieba.me6
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.onChangeSkinType(tbPageContext, i);
            this.j.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = (ViewGroup) h();
            View view2 = new View(getContext());
            this.k.setPadding(g().getResources().getDimensionPixelSize(R.dimen.tbds44), g().getResources().getDimensionPixelSize(R.dimen.tbds12), g().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(g().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
            this.k.addView(this.j.getView());
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = (ViewGroup) h();
            View view2 = new View(getContext());
            this.k.setPadding(g().getResources().getDimensionPixelSize(R.dimen.tbds34), g().getResources().getDimensionPixelSize(R.dimen.tbds21), g().getResources().getDimensionPixelSize(R.dimen.tbds34), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(g().getResources().getDimensionPixelSize(R.dimen.tbds20), -1));
            this.k.addView(this.j.getView());
        }
    }
}
