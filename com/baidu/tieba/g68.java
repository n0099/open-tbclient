package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.DuxiaomanEntry;
/* loaded from: classes4.dex */
public class g68 extends i16<r58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public TBSpecificationBtn m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public View u;
    public TbImageView v;
    public DuxiaomanEntry w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        public a(g68 g68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.k.getId()) {
                    if (this.a.w != null) {
                        TbSingleton.getInstance().setDuXiaoManActivityTimestamp(dh.g(this.a.w.activity_timestamp, 0L));
                        this.a.u.setVisibility(8);
                        if ("1".equals(this.a.w.activity_link_type)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.w.activity_link_addr));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 2));
                } else if (view2.getId() == this.a.i.getId()) {
                    if (this.a.w != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.w.goto_button_url));
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g68(TbPageContext<?> tbPageContext) {
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
        this.x = new a(this);
        View h = h();
        this.j = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092219);
        TextView textView = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092126);
        this.k = textView;
        textView.setOnClickListener(this.x);
        View findViewById = h.findViewById(R.id.obfuscated_res_0x7f0918f1);
        this.i = findViewById;
        findViewById.setOnClickListener(this.x);
        this.l = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090ec8);
        this.m = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f090439);
        this.n = h.findViewById(R.id.obfuscated_res_0x7f0908f3);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0908f4);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0922b4);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090400);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090275);
        this.s = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0903d4);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090276);
        this.u = h.findViewById(R.id.obfuscated_res_0x7f091bbd);
        this.v = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f090ef7);
        j(g(), this.a);
    }

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06fd : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            hv4 d = hv4.d(this.i);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            hv4 d2 = hv4.d(this.j);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            hv4 d3 = hv4.d(this.p);
            d3.v(R.color.CAM_X0109);
            d3.A(R.string.F_X01);
            hv4 d4 = hv4.d(this.q);
            d4.v(R.color.CAM_X0109);
            d4.A(R.string.F_X01);
            hv4 d5 = hv4.d(this.k);
            d5.v(R.color.CAM_X0107);
            d5.A(R.string.F_X01);
            hv4 d6 = hv4.d(this.r);
            d6.v(R.color.CAM_X0105);
            d6.A(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.m.k();
            hv4 d7 = hv4.d(this.n);
            d7.n(R.string.J_X04);
            d7.l(R.dimen.L_X01);
            d7.k(R.color.CAM_X0321);
            hv4 d8 = hv4.d(this.o);
            d8.v(R.color.CAM_X0321);
            d8.A(R.string.F_X01);
            hv4 d9 = hv4.d(this.t);
            d9.v(R.color.CAM_X0109);
            d9.A(R.string.F_X01);
            hv4 d10 = hv4.d(this.s);
            d10.v(R.color.CAM_X0105);
            d10.A(R.string.F_X01);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: v */
    public void i(r58 r58Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, r58Var) == null) || r58Var == null || r58Var.c() == null) {
            return;
        }
        DuxiaomanEntry c = r58Var.c();
        this.w = c;
        if ("1".equals(c.layout_type)) {
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        }
        this.p.setText(this.w.tip);
        if (dh.g(this.w.activity_timestamp, 0L) != TbSingleton.getInstance().getDuXiaoManActivityTimestamp()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        this.k.setText(this.w.activity_desc);
        this.r.setText(this.w.amount);
        this.t.setText(this.w.amount_msg);
        this.v.K(this.a == 0 ? this.w.encourage_icon : this.w.encourage_icon_dark, 10, false);
        this.o.setText(this.w.encourage_desc);
        this.m.setText(this.w.goto_button_name);
        this.s.setText(this.w.amount_msg);
        j(g(), this.a);
        TiebaStatic.log("c14712");
    }
}
