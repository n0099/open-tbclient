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
public class clb extends xkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ clb a;

        public a(clb clbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n0()) {
                    this.a.e.L0(11, false);
                    this.a.o0(2);
                    return;
                }
                clb clbVar = this.a;
                clbVar.e.a(clbVar.a.getString(R.string.obfuscated_res_0x7f0f062a));
                this.a.o0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public clb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull jjb jjbVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, jjbVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, jjbVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (jjb) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public LinkedList<x65> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pib pibVar = this.E;
            if (pibVar == null) {
                return null;
            }
            return pibVar.Y();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ykb
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x0();
            super.Z();
        }
    }

    @Override // com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            pib pibVar = this.E;
            if (pibVar == null) {
                return 0;
            }
            return pibVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void K(@NonNull List<kjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            sib f = nkb.f(this.a);
            list.add(f);
            tib g = nkb.g(this.a);
            f.w(g);
            list.add(g);
            bjb o = nkb.o(this.a);
            f.w(o);
            list.add(o);
            ajb n = nkb.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            pib c = nkb.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            cjb p = nkb.p(this.a);
            this.G = p;
            list.add(p);
            list.add(nkb.h(this.a, this.C));
            oib b = nkb.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            wib j = nkb.j(this.a);
            this.I.w(j);
            list.add(j);
            djb q = nkb.q(this.a);
            this.H = q;
            list.add(q);
            list.add(nkb.a(this.a));
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.M(true);
            editorTools.N(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                pkb.h(this.a, editorTools, this);
                pkb.j(this.a, editorTools, this);
                pkb.k(this.a, editorTools, this);
                pkb.b(this.a, editorTools, this);
                pkb.i(this.a, editorTools);
                pkb.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            pkb.d(editorTools, this);
            pkb.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                pkb.g(this.a, editorTools, this);
                pkb.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                pkb.c(this.a, editorTools, this);
            }
            editorTools.h();
            editorTools.setActionListener(74, this);
            super.M(editorTools);
            if (mh5.isOn()) {
                C(new he5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.N(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e89));
                q0(0, 0);
                r0(R.drawable.obfuscated_res_0x7f080bd8, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f116d));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f116f));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1414) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0324));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.f(i, z);
            oib oibVar = this.I;
            if (oibVar != null) {
                oibVar.k0();
            }
        }
    }

    @Override // com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        x0();
        if (n0()) {
            W();
            this.e.setResult(100);
            this.e.t();
            return;
        }
        g0(true);
    }
}
