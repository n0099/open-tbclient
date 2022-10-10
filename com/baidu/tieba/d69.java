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
public class d69 extends z59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d69 a;

        public a(d69 d69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l0()) {
                    this.a.e.w0(11, false);
                    this.a.m0(2);
                    return;
                }
                d69 d69Var = this.a;
                d69Var.e.d(d69Var.a.getString(R.string.obfuscated_res_0x7f0f0536));
                this.a.m0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d69(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull r49 r49Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, r49Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, r49Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (r49) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public LinkedList<iz4> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z39 z39Var = this.E;
            if (z39Var == null) {
                return null;
            }
            return z39Var.U();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a69
    public void M(@NonNull List<s49<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            b49 e = p59.e(this.a);
            list.add(e);
            c49 f = p59.f(this.a);
            e.u(f);
            list.add(f);
            k49 n = p59.n(this.a);
            e.u(n);
            list.add(n);
            j49 m = p59.m(this.a, this, this.s, this.J);
            this.D = m;
            list.add(m);
            z39 c = p59.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            e.u(c);
            list.add(this.E);
            l49 o = p59.o(this.a);
            this.G = o;
            list.add(o);
            list.add(p59.g(this.a, this.C));
            y39 b = p59.b(this.a);
            this.I = b;
            b.u(this.E);
            f.u(this.I);
            list.add(this.I);
            f49 i = p59.i(this.a);
            this.I.u(i);
            list.add(i);
            m49 p = p59.p(this.a);
            this.H = p;
            list.add(p);
            list.add(p59.a(this.a));
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
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
                r59.h(this.a, editorTools, this);
                r59.j(this.a, editorTools, this);
                r59.k(this.a, editorTools, this);
                r59.b(this.a, editorTools, this);
                r59.i(this.a, editorTools);
                r59.f(this.a, editorTools, this);
                r59.e(this.a, editorTools, this);
                r59.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            r59.d(editorTools, this);
            r59.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                r59.g(this.a, editorTools, this);
                r59.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                r59.c(this.a, editorTools, this);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0c6b));
                o0(0, 0);
                p0(R.drawable.obfuscated_res_0x7f0809ae, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f02));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f04));
                if (this.p.getProZone() == 1) {
                    navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f161d));
                }
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.share_to) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02de));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.a69
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.b(i, z);
            y39 y39Var = this.I;
            if (y39Var != null) {
                y39Var.h0();
            }
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            z39 z39Var = this.E;
            if (z39Var == null) {
                return 0;
            }
            return z39Var.T();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a.getPageActivity() == null) {
            return;
        }
        u0();
        if (l0()) {
            X();
            this.e.setResult(100);
            this.e.finish();
            return;
        }
        g0(true);
    }
}
