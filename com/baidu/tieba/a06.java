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
/* loaded from: classes3.dex */
public class a06 extends i16<vy5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public ProgressBar j;
    public FrameLayout k;
    public TextView l;
    public TextView m;
    public TextView n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a06(TbPageContext<?> tbPageContext) {
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

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0104 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
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

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09020a);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912eb);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912ec);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090221);
            this.j = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f09020b);
            this.k = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0912ef);
            h().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: s */
    public void i(vy5 vy5Var) {
        sy5 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vy5Var) == null) || (c = vy5Var.c()) == null || c.b() == null) {
            return;
        }
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
        if (TextUtils.isEmpty(c.b().yy_level_next_name) || c.b().yy_levelup_exp <= c.b().yy_level_exp) {
            return;
        }
        String string = this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0224);
        int i = (int) ((((float) (c.b().yy_levelup_exp - c.b().yy_level_exp)) * 100.0f) / ((float) c.b().yy_levelup_exp));
        if (i <= 0) {
            i = 1;
        }
        this.l.setText(String.format(string, c.b().yy_level_next_name, i + "%"));
    }
}
