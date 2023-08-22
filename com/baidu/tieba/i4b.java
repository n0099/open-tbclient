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
import com.baidu.tieba.j2b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class i4b extends c4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v1b V;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i4b a;

        public a(i4b i4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BrowserHelper.startWebActivity(this.a.a.getPageActivity(), "", BdUtilHelper.urlAddParam(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements j2b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j2b a;
        public final /* synthetic */ i4b b;

        public b(i4b i4bVar, j2b j2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i4bVar, j2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i4bVar;
            this.a = j2bVar;
        }

        @Override // com.baidu.tieba.j2b.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f2b f2bVar = this.b.D;
                if (f2bVar != null) {
                    f2bVar.P(0);
                }
                if (this.b.V != null) {
                    this.b.V.z(8);
                }
                this.a.B(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull o2b o2bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, o2bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, o2bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (o2b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.U(bundle);
            this.p.setQuestionThread(true);
        }
    }

    public final void A0(@NonNull List<p2b<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && B0()) {
            j2b r = s3b.r(this.a);
            r.A(new b(this, r));
            list.add(r);
            f2b f2bVar = this.D;
            if (f2bVar != null) {
                f2bVar.P(8);
            }
            v1b d = s3b.d(this.a);
            this.V = d;
            list.add(d);
            C0();
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, editorTools) == null) {
            editorTools.setMoreButtonAtEnd(false);
            editorTools.setBarLauncherType(8);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            u3b.m(this.a, editorTools, this.p.getCallFrom(), this).o(false);
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, navigationBar) == null) {
            super.O(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1125));
            q0(0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X002));
            r0(R.drawable.obfuscated_res_0x7f080bcf, R.dimen.tbds42, R.dimen.tbds42, R.dimen.tbds3);
            this.j.setOnClickListener(new a(this));
        }
    }

    public final boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TimeHelper.isSameDay(System.currentTimeMillis(), SharedPrefHelper.getInstance().getLong("key_question_write_guide_time", 0L));
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SharedPrefHelper.getInstance().putLong("key_question_write_guide_time", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            dfa.s(this.p.getForumId(), this);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.a();
            dfa.D(this.p.getForumId(), this.p, true);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.c0();
            dfa.D(this.p.getForumId(), this.p, false);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void L(@NonNull List<p2b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            list.add(s3b.o(this.a));
            f2b n = s3b.n(this.a, this, this.s, this.J);
            this.D = n;
            n.Q(false);
            list.add(this.D);
            A0(list);
            u1b c = s3b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            list.add(s3b.h(this.a, this.C));
            c2b k = s3b.k(this.a);
            k.w(this.E);
            list.add(k);
            d2b l = s3b.l(this.a);
            k.w(l);
            list.add(l);
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.l2b
    public void q(@NonNull q2b q2bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, q2bVar, z) == null) {
            super.q(q2bVar, z);
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
