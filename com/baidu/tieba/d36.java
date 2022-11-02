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
/* loaded from: classes3.dex */
public class d36 extends z26<t86> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public b36 l;
    public c36 m;
    public c36 n;
    public q86 o;
    public r86 p;
    public r86 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    @Override // com.baidu.tieba.z26
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018b : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d36(TbPageContext<?> tbPageContext, String str) {
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
        s(k());
    }

    @Override // com.baidu.tieba.z26
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            b36 b36Var = this.l;
            if (b36Var != null) {
                b36Var.m(tbPageContext, i);
            }
            c36 c36Var = this.m;
            if (c36Var != null) {
                c36Var.m(tbPageContext, i);
            }
            c36 c36Var2 = this.n;
            if (c36Var2 != null) {
                c36Var2.m(tbPageContext, i);
            }
        }
    }

    public void u(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        r86 r86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.k()) {
                q86 q86Var = this.o;
                if (q86Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, q86Var);
                }
                r(this.o.getThreadData());
            } else if (view2 == this.m.k()) {
                r86 r86Var2 = this.p;
                if (r86Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, r86Var2);
                }
                r(this.p.getThreadData());
            } else if (view2 != this.n.k() || (r86Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, r86Var);
                }
                r(this.q.getThreadData());
            }
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(g().getPageActivity()).createFromThreadCfg(threadData, null, k36.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            k36.a(threadData.getTid());
            g().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09051f);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b3b);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b3a);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f090826);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f090827);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new b36(this.b, null, null);
            }
            this.l.u(0, 0, 0, 0);
            this.l.v(8);
            this.l.w(8);
            if (this.l.k().getParent() != null) {
                ((ViewGroup) this.l.k().getParent()).removeView(this.l.k());
            }
            this.l.k().setOnClickListener(this);
            this.l.k().setVisibility(8);
            this.k.addView(this.l.k());
            if (this.m == null) {
                this.m = new c36(this.b);
            }
            this.m.u(8);
            this.m.v(0, dimensionPixelSize, 0, 0);
            if (this.m.k().getParent() != null) {
                ((ViewGroup) this.m.k().getParent()).removeView(this.m.k());
            }
            this.m.k().setOnClickListener(this);
            this.m.k().setVisibility(8);
            this.k.addView(this.m.k());
            if (this.n == null) {
                this.n = new c36(this.b);
            }
            this.n.u(8);
            this.n.v(0, dimensionPixelSize, 0, 0);
            if (this.n.k().getParent() != null) {
                ((ViewGroup) this.n.k().getParent()).removeView(this.n.k());
            }
            this.n.k().setOnClickListener(this);
            this.n.k().setVisibility(8);
            this.k.addView(this.n.k());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.z26
    /* renamed from: t */
    public void l(t86 t86Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, t86Var) == null) && t86Var != null && t86Var.c() != null) {
            if (!TextUtils.isEmpty(t86Var.c().b)) {
                this.j.setText(t86Var.c().b);
            }
            List<ThreadData> list = t86Var.c().a;
            if (ListUtils.getCount(list) >= 1) {
                q86 q86Var = new q86();
                this.o = q86Var;
                q86Var.c(list.get(0));
                this.l.k().setVisibility(0);
                this.l.l(this.o);
            }
            if (ListUtils.getCount(list) >= 2) {
                r86 r86Var = new r86();
                this.p = r86Var;
                r86Var.c(list.get(1));
                this.m.k().setVisibility(0);
                this.m.l(this.p);
                this.m.w(8);
            }
            if (ListUtils.getCount(list) >= 3) {
                r86 r86Var2 = new r86();
                this.q = r86Var2;
                r86Var2.c(list.get(2));
                this.n.k().setVisibility(0);
                this.n.l(this.q);
                this.n.w(8);
            }
        }
    }
}
