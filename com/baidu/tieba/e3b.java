package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes5.dex */
public class e3b extends z2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e3b a;

        public a(e3b e3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e3bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n0()) {
                    this.a.e.M0(11, false);
                    this.a.o0(2);
                    return;
                }
                e3b e3bVar = this.a;
                e3bVar.e.a(e3bVar.a.getString(R.string.obfuscated_res_0x7f0f0620));
                this.a.o0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l1b l1bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, l1bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, l1bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (l1b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public LinkedList<t55> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r0b r0bVar = this.E;
            if (r0bVar == null) {
                return null;
            }
            return r0bVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a3b
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x0();
            super.Z();
        }
    }

    @Override // com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r0b r0bVar = this.E;
            if (r0bVar == null) {
                return 0;
            }
            return r0bVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void K(@NonNull List<m1b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            u0b f = p2b.f(this.a);
            list.add(f);
            v0b g = p2b.g(this.a);
            f.w(g);
            list.add(g);
            d1b o = p2b.o(this.a);
            f.w(o);
            list.add(o);
            c1b n = p2b.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            r0b c = p2b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            e1b p = p2b.p(this.a);
            this.G = p;
            list.add(p);
            list.add(p2b.h(this.a, this.C));
            q0b b = p2b.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            y0b j = p2b.j(this.a);
            this.I.w(j);
            list.add(j);
            f1b q = p2b.q(this.a);
            this.H = q;
            list.add(q);
            list.add(p2b.a(this.a));
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                r2b.h(this.a, editorTools, this);
                r2b.j(this.a, editorTools, this);
                r2b.k(this.a, editorTools, this);
                r2b.b(this.a, editorTools, this);
                r2b.i(this.a, editorTools);
                r2b.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            r2b.d(editorTools, this);
            r2b.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                r2b.g(this.a, editorTools, this);
                r2b.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                r2b.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.M(editorTools);
            if (pf5.isOn()) {
                C(new cd5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.N(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e68));
                q0(0, 0);
                r0(R.drawable.obfuscated_res_0x7f080bbf, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f114a));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f114c));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f13ee) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f031c));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.f(i, z);
            q0b q0bVar = this.I;
            if (q0bVar != null) {
                q0bVar.k0();
            }
        }
    }

    @Override // com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        x0();
        if (n0()) {
            W();
            this.e.setResult(100);
            this.e.s();
            return;
        }
        h0(true);
    }
}
