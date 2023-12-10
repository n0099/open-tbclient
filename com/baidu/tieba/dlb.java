package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.ejb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class dlb extends xkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qib V;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dlb a;

        public a(dlb dlbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dlbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dlbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BrowserHelper.startWebActivity(this.a.a.getPageActivity(), "", BdUtilHelper.urlAddParam(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ejb.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ejb a;
        public final /* synthetic */ dlb b;

        public b(dlb dlbVar, ejb ejbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dlbVar, ejbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dlbVar;
            this.a = ejbVar;
        }

        @Override // com.baidu.tieba.ejb.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ajb ajbVar = this.b.D;
                if (ajbVar != null) {
                    ajbVar.P(0);
                }
                if (this.b.V != null) {
                    this.b.V.z(8);
                }
                this.a.B(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dlb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull jjb jjbVar, boolean z) {
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

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void S(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.S(bundle);
            this.p.setQuestionThread(true);
        }
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TimeHelper.isSameDay(System.currentTimeMillis(), SharedPrefHelper.getInstance().getLong("key_question_write_guide_time", 0L));
        }
        return invokeV.booleanValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SharedPrefHelper.getInstance().putLong("key_question_write_guide_time", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            rva.s(this.p.getForumId(), this);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.b();
            rva.D(this.p.getForumId(), this.p, true);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.b0();
            rva.D(this.p.getForumId(), this.p, false);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void K(@NonNull List<kjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            list.add(nkb.o(this.a));
            ajb n = nkb.n(this.a, this, this.s, this.J);
            this.D = n;
            n.Q(false);
            list.add(this.D);
            z0(list);
            pib c = nkb.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            list.add(nkb.h(this.a, this.C));
            xib k = nkb.k(this.a);
            k.w(this.E);
            list.add(k);
            yib l = nkb.l(this.a);
            k.w(l);
            list.add(l);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editorTools) == null) {
            editorTools.setMoreButtonAtEnd(false);
            editorTools.setBarLauncherType(8);
            editorTools.M(true);
            editorTools.N(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            pkb.m(this.a, editorTools, this.p.getCallFrom(), this).p(false);
            editorTools.h();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, navigationBar) == null) {
            super.N(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f116e));
            q0(0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X002));
            r0(R.drawable.obfuscated_res_0x7f080bfa, R.dimen.tbds42, R.dimen.tbds42, R.dimen.tbds3);
            this.j.setOnClickListener(new a(this));
        }
    }

    public final void z0(@NonNull List<kjb<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, list) == null) && A0()) {
            ejb r = nkb.r(this.a);
            r.A(new b(this, r));
            list.add(r);
            ajb ajbVar = this.D;
            if (ajbVar != null) {
                ajbVar.P(8);
            }
            qib d = nkb.d(this.a);
            this.V = d;
            list.add(d);
            B0();
        }
    }

    @Override // com.baidu.tieba.ykb, com.baidu.tieba.gjb
    public void q(@NonNull ljb ljbVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, ljbVar, z) == null) {
            super.q(ljbVar, z);
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
