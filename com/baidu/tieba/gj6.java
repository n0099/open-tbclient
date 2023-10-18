package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class gj6 extends cj6<ls6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public ej6 l;
    public fj6 m;
    public fj6 n;
    public is6 o;
    public js6 p;
    public js6 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b6 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj6(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.u = str;
        t(i());
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            ej6 ej6Var = this.l;
            if (ej6Var != null) {
                ej6Var.k(tbPageContext, i);
            }
            fj6 fj6Var = this.m;
            if (fj6Var != null) {
                fj6Var.k(tbPageContext, i);
            }
            fj6 fj6Var2 = this.n;
            if (fj6Var2 != null) {
                fj6Var2.k(tbPageContext, i);
            }
        }
    }

    public void x(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }

    public final void o(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(h().getPageActivity()).createFromThreadCfg(threadData, null, mj6.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            mj6.a(threadData.getTid());
            h().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        js6 js6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.i()) {
                is6 is6Var = this.o;
                if (is6Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, is6Var);
                }
                o(this.o.getThreadData());
            } else if (view2 == this.m.i()) {
                js6 js6Var2 = this.p;
                if (js6Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, js6Var2);
                }
                o(this.p.getThreadData());
            } else if (view2 != this.n.i() || (js6Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, js6Var);
                }
                o(this.q.getThreadData());
            }
        }
    }

    public final void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905c2);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ca9);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ca8);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f090919);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f09091a);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new ej6(this.b, null, null);
            }
            this.l.x(0, 0, 0, 0);
            this.l.y(8);
            this.l.z(8);
            if (this.l.i().getParent() != null) {
                ((ViewGroup) this.l.i().getParent()).removeView(this.l.i());
            }
            this.l.i().setOnClickListener(this);
            this.l.i().setVisibility(8);
            this.k.addView(this.l.i());
            if (this.m == null) {
                this.m = new fj6(this.b);
            }
            this.m.x(8);
            this.m.y(0, dimensionPixelSize, 0, 0);
            if (this.m.i().getParent() != null) {
                ((ViewGroup) this.m.i().getParent()).removeView(this.m.i());
            }
            this.m.i().setOnClickListener(this);
            this.m.i().setVisibility(8);
            this.k.addView(this.m.i());
            if (this.n == null) {
                this.n = new fj6(this.b);
            }
            this.n.x(8);
            this.n.y(0, dimensionPixelSize, 0, 0);
            if (this.n.i().getParent() != null) {
                ((ViewGroup) this.n.i().getParent()).removeView(this.n.i());
            }
            this.n.i().setOnClickListener(this);
            this.n.i().setVisibility(8);
            this.k.addView(this.n.i());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: u */
    public void j(ls6 ls6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ls6Var) == null) && ls6Var != null && ls6Var.c() != null) {
            if (!TextUtils.isEmpty(ls6Var.c().b)) {
                this.j.setText(ls6Var.c().b);
            }
            List<ThreadData> list = ls6Var.c().a;
            if (ListUtils.getCount(list) >= 1) {
                is6 is6Var = new is6();
                this.o = is6Var;
                is6Var.c(list.get(0));
                this.l.i().setVisibility(0);
                this.l.j(this.o);
            }
            if (ListUtils.getCount(list) >= 2) {
                js6 js6Var = new js6();
                this.p = js6Var;
                js6Var.c(list.get(1));
                this.m.i().setVisibility(0);
                this.m.j(this.p);
                this.m.z(8);
            }
            if (ListUtils.getCount(list) >= 3) {
                js6 js6Var2 = new js6();
                this.q = js6Var2;
                js6Var2.c(list.get(2));
                this.n.i().setVisibility(0);
                this.n.j(this.q);
                this.n.z(8);
            }
        }
    }
}
