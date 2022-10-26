package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h26 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public HeadImageView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public TextView n;
    public View o;
    public j36 p;
    public int q;
    public String r;
    public String s;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b2 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h26(TbPageContext tbPageContext) {
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
        this.q = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070266);
        r(k());
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(this.n, R.drawable.label_bg_gray);
                SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                this.j.setPlaceHolder(1);
                this.m.setPlaceHolder(2);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if ((view2 == this.j || view2 == this.k || view2 == this.n) && !StringUtils.isNull(this.p.d)) {
                TiebaStatic.log(new StatisticItem(this.r).param("obj_id", String.valueOf(this.p.a)));
                UrlManager.getInstance().dealOneLink(g(), new String[]{this.p.d});
            } else if ((view2 == this.i || view2 == this.l || view2 == this.m) && !StringUtils.isNull(this.p.g)) {
                TiebaStatic.log(new StatisticItem(this.s).param("obj_id", String.valueOf(this.p.a)));
                UrlManager.getInstance().dealOneLink(g(), new String[]{this.p.g});
            }
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f091c80);
            this.j = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091acb);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ace);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091aca);
            this.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091acd);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091acc);
            this.o = view2.findViewById(R.id.obfuscated_res_0x7f092294);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j.setDefaultResource(17170445);
            this.j.setPlaceHolder(1);
            this.j.setRadius(this.q);
            this.m.setDrawBorder(true);
            this.m.setBorderWidth(1);
            this.m.setPlaceHolder(2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: s */
    public void l(j36 j36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, j36Var) == null) {
            if (j36Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.p = j36Var;
            this.j.L(j36Var.c, 10, false);
            this.k.setText(UtilHelper.getFixedText(j36Var.b, 7, true));
            if (StringUtils.isNull(j36Var.i)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(j36Var.i);
            }
            this.l.setText(j36Var.e);
            if (jq4.c().g()) {
                this.m.setVisibility(0);
                this.m.L(j36Var.f, 10, false);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void t(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) {
            this.r = str2;
            this.s = str3;
        }
    }
}
