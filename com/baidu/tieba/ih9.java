package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ih9 extends dh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih9 a;

        public a(ih9 ih9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ih9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m0()) {
                    this.a.e.x0(11, false);
                    this.a.n0(2);
                    return;
                }
                ih9 ih9Var = this.a;
                ih9Var.e.d(ih9Var.a.getString(R.string.obfuscated_res_0x7f0f0551));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih9(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull pf9 pf9Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, pf9Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, pf9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (pf9) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.eh9, com.baidu.tieba.sf9
    public LinkedList<u05> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ve9 ve9Var = this.E;
            if (ve9Var == null) {
                return null;
            }
            return ve9Var.a0();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eh9
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.eh9, com.baidu.tieba.sf9
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ve9 ve9Var = this.E;
            if (ve9Var == null) {
                return 0;
            }
            return ve9Var.Z();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dh9, com.baidu.tieba.eh9
    public void M(@NonNull List<qf9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ye9 f = tg9.f(this.a);
            list.add(f);
            ze9 g = tg9.g(this.a);
            f.w(g);
            list.add(g);
            hf9 o = tg9.o(this.a);
            f.w(o);
            list.add(o);
            gf9 n = tg9.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            ve9 c = tg9.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            if9 p = tg9.p(this.a);
            this.G = p;
            list.add(p);
            list.add(tg9.h(this.a, this.C));
            ue9 b = tg9.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            cf9 j = tg9.j(this.a);
            this.I.w(j);
            list.add(j);
            jf9 q = tg9.q(this.a);
            this.H = q;
            list.add(q);
            list.add(tg9.a(this.a));
        }
    }

    @Override // com.baidu.tieba.dh9, com.baidu.tieba.eh9
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.E(true);
            editorTools.F(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                vg9.h(this.a, editorTools, this);
                vg9.j(this.a, editorTools, this);
                vg9.k(this.a, editorTools, this);
                vg9.b(this.a, editorTools, this);
                vg9.i(this.a, editorTools);
                vg9.f(this.a, editorTools, this);
                vg9.e(this.a, editorTools, this);
                vg9.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            vg9.d(editorTools, this);
            vg9.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                vg9.g(this.a, editorTools, this);
                vg9.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                vg9.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.dh9, com.baidu.tieba.eh9
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0ce5));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f080a01, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f7b));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f7d));
                if (this.p.getProZone() == 1) {
                    navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f16ac));
                }
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1202) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02e8));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.eh9, com.baidu.tieba.sf9
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            ue9 ue9Var = this.I;
            if (ue9Var != null) {
                ue9Var.j0();
            }
        }
    }

    @Override // com.baidu.tieba.eh9, com.baidu.tieba.sf9
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        w0();
        if (m0()) {
            X();
            this.e.setResult(100);
            this.e.finish();
            return;
        }
        g0(true);
    }
}
