package com.baidu.tieba;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b69 extends z59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t59 V;
    public a49 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b69(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull r49 r49Var, boolean z) {
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
        this.V = new t59(tbPageContext, this);
    }

    @Override // com.baidu.tieba.a69
    public void M(@NonNull List<s49<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(p59.e(this.a));
            a49 d = p59.d(this.a);
            this.W = d;
            list.add(d);
            z39 c = p59.c(this.a, this, this.d, this.s, this.V);
            this.E = c;
            list.add(c);
            l49 o = p59.o(this.a);
            this.G = o;
            list.add(o);
            list.add(p59.g(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
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
                r59.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            r59.d(editorTools, this);
            r59.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                g65 g = r59.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f55));
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nm8.j(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.c0();
            nm8.s(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69
    public boolean e0() {
        InterceptResult invokeV;
        z39 z39Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.p.isSaveDraft() || this.l == null || (((z39Var = this.E) == null || !z39Var.r()) && this.C.f().size() == 0) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69, com.baidu.tieba.u49
    public boolean h() {
        InterceptResult invokeV;
        a49 a49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            z39 z39Var = this.E;
            if (z39Var != null && z39Var.r() && this.E.o() != null && this.E.o().getText().length() >= 20 && this.E.o().getText().length() <= 500 && (a49Var = this.W) != null && a49Var.r()) {
                return super.h();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69, com.baidu.tieba.u49
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.i();
            nm8.s(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.z59, com.baidu.tieba.a69, com.baidu.tieba.nm8.g
    public void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, writeData) == null) && writeData != null && writeData.getType() == 12) {
            super.k(writeData);
        }
    }
}
