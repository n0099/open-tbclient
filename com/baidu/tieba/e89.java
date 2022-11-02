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
/* loaded from: classes3.dex */
public class e89 extends z79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e89 a;

        public a(e89 e89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m0()) {
                    this.a.e.v0(11, false);
                    this.a.n0(2);
                    return;
                }
                e89 e89Var = this.a;
                e89Var.e.d(e89Var.a.getString(R.string.obfuscated_res_0x7f0f0541));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e89(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l69 l69Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, l69Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, l69Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (l69) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.a89, com.baidu.tieba.o69
    public LinkedList<d05> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r59 r59Var = this.E;
            if (r59Var == null) {
                return null;
            }
            return r59Var.W();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a89
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.a89, com.baidu.tieba.o69
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r59 r59Var = this.E;
            if (r59Var == null) {
                return 0;
            }
            return r59Var.V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void M(@NonNull List<m69<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            u59 f = p79.f(this.a);
            list.add(f);
            v59 g = p79.g(this.a);
            f.w(g);
            list.add(g);
            d69 o = p79.o(this.a);
            f.w(o);
            list.add(o);
            c69 n = p79.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            r59 c = p79.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            e69 p = p79.p(this.a);
            this.G = p;
            list.add(p);
            list.add(p79.h(this.a, this.C));
            q59 b = p79.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            y59 j = p79.j(this.a);
            this.I.w(j);
            list.add(j);
            f69 q = p79.q(this.a);
            this.H = q;
            list.add(q);
            list.add(p79.a(this.a));
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                r79.h(this.a, editorTools, this);
                r79.j(this.a, editorTools, this);
                r79.k(this.a, editorTools, this);
                r79.b(this.a, editorTools, this);
                r79.i(this.a, editorTools);
                r79.f(this.a, editorTools, this);
                r79.e(this.a, editorTools, this);
                r79.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            r79.d(editorTools, this);
            r79.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                r79.g(this.a, editorTools, this);
                r79.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                r79.c(this.a, editorTools, this);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0c93));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f0809c6, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f2c));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f2e));
                if (this.p.getProZone() == 1) {
                    navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1656));
                }
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.share_to) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02df));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.a89, com.baidu.tieba.o69
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            q59 q59Var = this.I;
            if (q59Var != null) {
                q59Var.j0();
            }
        }
    }

    @Override // com.baidu.tieba.a89, com.baidu.tieba.o69
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
