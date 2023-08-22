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
/* loaded from: classes6.dex */
public class h4b extends c4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h4b a;

        public a(h4b h4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n0()) {
                    this.a.e.Q0(11, false);
                    this.a.o0(2);
                    return;
                }
                h4b h4bVar = this.a;
                h4bVar.e.b(h4bVar.a.getString(R.string.obfuscated_res_0x7f0f0617));
                this.a.o0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull o2b o2bVar, boolean z) {
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

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public LinkedList<xa5> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            u1b u1bVar = this.E;
            if (u1bVar == null) {
                return null;
            }
            return u1bVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d4b
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u1b u1bVar = this.E;
            if (u1bVar == null) {
                return 0;
            }
            return u1bVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void L(@NonNull List<p2b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            x1b f = s3b.f(this.a);
            list.add(f);
            y1b g = s3b.g(this.a);
            f.w(g);
            list.add(g);
            g2b o = s3b.o(this.a);
            f.w(o);
            list.add(o);
            f2b n = s3b.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            u1b c = s3b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            h2b p = s3b.p(this.a);
            this.G = p;
            list.add(p);
            list.add(s3b.h(this.a, this.C));
            t1b b = s3b.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            b2b j = s3b.j(this.a);
            this.I.w(j);
            list.add(j);
            i2b q = s3b.q(this.a);
            this.H = q;
            list.add(q);
            list.add(s3b.a(this.a));
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                u3b.h(this.a, editorTools, this);
                u3b.j(this.a, editorTools, this);
                u3b.k(this.a, editorTools, this);
                u3b.b(this.a, editorTools, this);
                u3b.i(this.a, editorTools);
                u3b.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            u3b.d(editorTools, this);
            u3b.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                u3b.g(this.a, editorTools, this);
                u3b.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                u3b.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.N(editorTools);
            if (mk5.isOn()) {
                C(new zh5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.O(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e42));
                q0(0, 0);
                r0(R.drawable.obfuscated_res_0x7f080baf, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1124));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1126));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f13c3) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0319));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.f(i, z);
            t1b t1bVar = this.I;
            if (t1bVar != null) {
                t1bVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        x0();
        if (n0()) {
            X();
            this.e.setResult(100);
            this.e.x();
            return;
        }
        h0(true);
    }
}
