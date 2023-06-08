package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SkinManager;
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
import tbclient.NamoaixudEntry;
/* loaded from: classes6.dex */
public class he9 extends in6<rd9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TBSpecificationBtn n;
    public View o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public TbImageView w;
    public NamoaixudEntry x;
    public View.OnClickListener y;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0795 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he9 a;

        public a(he9 he9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.l.getId()) {
                    if (this.a.x != null) {
                        TbSingleton.getInstance().setDuXiaoManActivityTimestamp(tg.g(this.a.x.activity_timestamp, 0L));
                        this.a.v.setVisibility(8);
                        if ("1".equals(this.a.x.activity_link_type)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.x.activity_link_addr));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 2));
                } else if (view2.getId() == this.a.j.getId()) {
                    if (this.a.x != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.x.goto_button_url));
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he9(TbPageContext<?> tbPageContext) {
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
        this.y = new a(this);
        this.i = h();
        int g = vi.g(this.c, R.dimen.M_W_X003);
        this.i.setPadding(g, 0, g, 0);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0924a3);
        TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0923c6);
        this.l = textView;
        textView.setOnClickListener(this.y);
        View findViewById = this.i.findViewById(R.id.obfuscated_res_0x7f091afc);
        this.j = findViewById;
        findViewById.setOnClickListener(this.y);
        this.m = (ImageView) this.i.findViewById(R.id.img_arrow);
        this.n = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f0904b8);
        this.o = this.i.findViewById(R.id.obfuscated_res_0x7f0909ee);
        this.p = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0909ef);
        this.q = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09254d);
        this.r = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090474);
        this.s = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090287);
        this.t = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090432);
        this.u = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090288);
        this.v = this.i.findViewById(R.id.obfuscated_res_0x7f091de3);
        this.w = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0910b7);
        j(g(), this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: x */
    public void i(rd9 rd9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, rd9Var) == null) && rd9Var != null && rd9Var.c() != null) {
            NamoaixudEntry c = rd9Var.c();
            this.x = c;
            if ("1".equals(c.layout_type)) {
                this.q.setVisibility(0);
                this.r.setVisibility(8);
                this.s.setVisibility(0);
                this.t.setVisibility(8);
                this.u.setVisibility(0);
            } else {
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(0);
                this.u.setVisibility(8);
            }
            this.q.setText(this.x.tip);
            if (tg.g(this.x.activity_timestamp, 0L) != TbSingleton.getInstance().getDuXiaoManActivityTimestamp()) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
            this.l.setText(this.x.activity_desc);
            this.s.setText(this.x.amount);
            this.u.setText(this.x.amount_msg);
            if (this.a == 0) {
                str = this.x.encourage_icon;
            } else {
                str = this.x.encourage_icon_dark;
            }
            this.w.N(str, 10, false);
            this.p.setText(this.x.encourage_desc);
            this.n.setText(this.x.goto_button_name);
            this.t.setText(this.x.amount_msg);
            j(g(), this.a);
            TiebaStatic.log("c14712");
        }
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            o75 d = o75.d(this.j);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            o75 d2 = o75.d(this.k);
            d2.w(R.color.CAM_X0105);
            d2.C(R.string.F_X02);
            o75 d3 = o75.d(this.q);
            d3.w(R.color.CAM_X0109);
            d3.C(R.string.F_X01);
            o75 d4 = o75.d(this.r);
            d4.w(R.color.CAM_X0109);
            d4.C(R.string.F_X01);
            o75 d5 = o75.d(this.l);
            d5.w(R.color.CAM_X0107);
            d5.C(R.string.F_X01);
            o75 d6 = o75.d(this.s);
            d6.w(R.color.CAM_X0105);
            d6.C(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.n.k();
            o75 d7 = o75.d(this.o);
            d7.o(R.string.J_X04);
            d7.m(R.dimen.L_X01);
            d7.l(R.color.CAM_X0321);
            o75 d8 = o75.d(this.p);
            d8.w(R.color.CAM_X0321);
            d8.C(R.string.F_X01);
            o75 d9 = o75.d(this.u);
            d9.w(R.color.CAM_X0109);
            d9.C(R.string.F_X01);
            o75 d10 = o75.d(this.t);
            d10.w(R.color.CAM_X0105);
            d10.C(R.string.F_X01);
        }
    }
}
