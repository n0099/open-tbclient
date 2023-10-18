package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c76 extends cj6<m66> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b76 i;
    public b76 j;
    public LinearLayout k;
    public ViewGroup l;
    public View m;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0956 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c76(TbPageContext<?> tbPageContext, ViewGroup viewGroup, String str) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new b76(tbPageContext, str);
        this.j = new b76(tbPageContext, str);
        ViewGroup viewGroup2 = (ViewGroup) i();
        this.l = viewGroup2;
        this.k = (LinearLayout) viewGroup2.findViewById(R.id.obfuscated_res_0x7f091054);
        this.m = this.l.findViewById(R.id.obfuscated_res_0x7f09104a);
        View view2 = new View(c());
        this.k.setPadding(h().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, h().getResources().getDimensionPixelSize(R.dimen.tbds44), h().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.k.addView(this.i.h());
        this.k.addView(view2, new LinearLayout.LayoutParams(h().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.k.addView(this.j.h());
        k(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: o */
    public void j(m66 m66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, m66Var) == null) && m66Var != null) {
            this.i.i(m66Var.a);
            this.j.i(m66Var.b);
            if (m66Var.c) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    public void t(h76 h76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h76Var) == null) {
            this.i.l(h76Var);
            this.j.l(h76Var);
        }
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.i.k(tbPageContext, i);
            this.j.k(tbPageContext, i);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0204);
        }
    }
}
