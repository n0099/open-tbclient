package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ia6 extends yf6<d96> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public ProgressBar j;
    public FrameLayout k;
    public TextView l;
    public TextView m;
    public TextView n;

    @Override // com.baidu.tieba.yf6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0107 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.yf6
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia6(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        r(h());
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09020e);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091459);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09145a);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090225);
            this.j = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f09020f);
            this.k = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09145d);
            h().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yf6
    /* renamed from: s */
    public void l(d96 d96Var) {
        a96 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, d96Var) == null) && (c = d96Var.c()) != null && c.b() != null) {
            String str = "LV." + c.b().yy_level_id;
            if (!TextUtils.isEmpty(c.b().yy_level_name)) {
                str = c.b().yy_level_name + str;
                this.m.setText(c.b().yy_level_name);
            }
            this.i.setText(str);
            if (c.b().yy_levelup_exp <= c.b().yy_level_exp) {
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.l.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            if (!TextUtils.isEmpty(c.b().yy_level_next_name)) {
                this.n.setText(c.b().yy_level_next_name);
            }
            long j = c.b().yy_levelup_exp;
            long j2 = c.b().yy_level_exp;
            this.j.setMax((int) j);
            this.j.setProgress((int) j2);
            if (!TextUtils.isEmpty(c.b().yy_level_next_name) && c.b().yy_levelup_exp > c.b().yy_level_exp) {
                String string = this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0226);
                int i = (int) ((((float) (c.b().yy_levelup_exp - c.b().yy_level_exp)) * 100.0f) / ((float) c.b().yy_levelup_exp));
                if (i <= 0) {
                    i = 1;
                }
                this.l.setText(String.format(string, c.b().yy_level_next_name, i + "%"));
            }
        }
    }
}
