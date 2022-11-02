package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.g69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class f89 extends z79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s59 V;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f89 a;

        public a(f89 f89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a.getPageActivity(), "", xi.R(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements g69.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g69 a;
        public final /* synthetic */ f89 b;

        public b(f89 f89Var, g69 g69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f89Var, g69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f89Var;
            this.a = g69Var;
        }

        @Override // com.baidu.tieba.g69.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c69 c69Var = this.b.D;
                if (c69Var != null) {
                    c69Var.P(0);
                }
                if (this.b.V != null) {
                    this.b.V.z(8);
                }
                this.a.B(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f89(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l69 l69Var, boolean z) {
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

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.U(bundle);
            this.p.setQuestionThread(true);
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ky4.k().x("key_question_write_guide_time", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            do8.p(this.p.getForumId(), this);
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            do8.z(this.p.getForumId(), this.p, false);
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89, com.baidu.tieba.o69
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.j();
            do8.z(this.p.getForumId(), this.p, true);
        }
    }

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return !TimeHelper.isSameDay(System.currentTimeMillis(), ky4.k().m("key_question_write_guide_time", 0L));
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void M(@NonNull List<m69<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            list.add(p79.o(this.a));
            c69 n = p79.n(this.a, this, this.s, this.J);
            this.D = n;
            n.Q(false);
            list.add(this.D);
            y0(list);
            r59 c = p79.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            list.add(p79.h(this.a, this.C));
            z59 k = p79.k(this.a);
            k.w(this.E);
            list.add(k);
            a69 l = p79.l(this.a);
            k.w(l);
            list.add(l);
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setMoreButtonAtEnd(false);
            editorTools.setBarLauncherType(8);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            r79.m(this.a, editorTools, this.p.getCallFrom(), this).n(false);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f2d));
            p0(0, xi.g(this.a.getPageActivity(), R.dimen.M_W_X002));
            q0(R.drawable.obfuscated_res_0x7f0809e5, R.dimen.tbds42, R.dimen.tbds42, R.dimen.tbds3);
            this.j.setOnClickListener(new a(this));
        }
    }

    public final void y0(@NonNull List<m69<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && z0()) {
            g69 r = p79.r(this.a);
            r.A(new b(this, r));
            list.add(r);
            c69 c69Var = this.D;
            if (c69Var != null) {
                c69Var.P(8);
            }
            s59 d = p79.d(this.a);
            this.V = d;
            list.add(d);
            A0();
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89, com.baidu.tieba.i69
    public void q(@NonNull n69 n69Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, n69Var, z) == null) {
            super.q(n69Var, z);
            if (this.a.getPageActivity() == null) {
                return;
            }
            if (z) {
                this.a.getPageActivity().getWindow().setSoftInputMode(16);
            } else {
                this.a.getPageActivity().getWindow().setSoftInputMode(48);
            }
        }
    }
}
