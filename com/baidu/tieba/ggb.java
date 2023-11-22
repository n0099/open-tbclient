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
public class ggb extends bgb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ggb a;

        public a(ggb ggbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ggbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ggbVar;
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
                ggb ggbVar = this.a;
                ggbVar.e.a(ggbVar.a.getString(R.string.obfuscated_res_0x7f0f0622));
                this.a.o0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ggb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull neb nebVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, nebVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, nebVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (neb) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.cgb, com.baidu.tieba.qeb
    public LinkedList<o65> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            tdb tdbVar = this.E;
            if (tdbVar == null) {
                return null;
            }
            return tdbVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cgb
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x0();
            super.Z();
        }
    }

    @Override // com.baidu.tieba.cgb, com.baidu.tieba.qeb
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            tdb tdbVar = this.E;
            if (tdbVar == null) {
                return 0;
            }
            return tdbVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bgb, com.baidu.tieba.cgb, com.baidu.tieba.qeb
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.bgb, com.baidu.tieba.cgb
    public void K(@NonNull List<oeb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            wdb f = rfb.f(this.a);
            list.add(f);
            xdb g = rfb.g(this.a);
            f.w(g);
            list.add(g);
            feb o = rfb.o(this.a);
            f.w(o);
            list.add(o);
            eeb n = rfb.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            tdb c = rfb.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            geb p = rfb.p(this.a);
            this.G = p;
            list.add(p);
            list.add(rfb.h(this.a, this.C));
            sdb b = rfb.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            aeb j = rfb.j(this.a);
            this.I.w(j);
            list.add(j);
            heb q = rfb.q(this.a);
            this.H = q;
            list.add(q);
            list.add(rfb.a(this.a));
        }
    }

    @Override // com.baidu.tieba.bgb, com.baidu.tieba.cgb
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
                tfb.h(this.a, editorTools, this);
                tfb.j(this.a, editorTools, this);
                tfb.k(this.a, editorTools, this);
                tfb.b(this.a, editorTools, this);
                tfb.i(this.a, editorTools);
                tfb.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            tfb.d(editorTools, this);
            tfb.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                tfb.g(this.a, editorTools, this);
                tfb.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                tfb.c(this.a, editorTools, this);
            }
            editorTools.h();
            editorTools.setActionListener(74, this);
            super.M(editorTools);
            if (dh5.isOn()) {
                C(new yd5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.bgb, com.baidu.tieba.cgb
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.N(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e7a));
                q0(0, 0);
                r0(R.drawable.obfuscated_res_0x7f080bd0, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f115c));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f115e));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1403) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f031c));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.cgb, com.baidu.tieba.qeb
    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.f(i, z);
            sdb sdbVar = this.I;
            if (sdbVar != null) {
                sdbVar.k0();
            }
        }
    }

    @Override // com.baidu.tieba.cgb, com.baidu.tieba.qeb
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
        h0(true);
    }
}
