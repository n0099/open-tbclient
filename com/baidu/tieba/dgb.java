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
/* loaded from: classes5.dex */
public class dgb extends agb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public udb V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dgb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull meb mebVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, mebVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, mebVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (meb) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public void K(@NonNull List<neb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(qfb.f(this.a));
            udb e = qfb.e(this.a);
            this.V = e;
            list.add(e);
            sdb c = qfb.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            feb p = qfb.p(this.a);
            this.G = p;
            list.add(p);
            list.add(qfb.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.M(true);
            editorTools.N(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                sfb.h(this.a, editorTools, this);
                sfb.j(this.a, editorTools, this);
                sfb.k(this.a, editorTools, this);
                sfb.b(this.a, editorTools, this);
                sfb.i(this.a, editorTools);
                sfb.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            sfb.d(editorTools, this);
            sfb.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                ye5 g = sfb.g(this.a, editorTools, this);
                g.i(false);
                g.j(false);
            }
            editorTools.h();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.N(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f11b0));
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.T(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb, com.baidu.tieba.xqa.h
    public void d(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.d(writeData);
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xqa.m(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb, com.baidu.tieba.peb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            xqa.w(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.b0();
            xqa.w(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb
    public boolean d0() {
        InterceptResult invokeV;
        sdb sdbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((sdbVar = this.E) != null && sdbVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.agb, com.baidu.tieba.bgb, com.baidu.tieba.peb
    public boolean j() {
        InterceptResult invokeV;
        udb udbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            sdb sdbVar = this.E;
            if (sdbVar != null && sdbVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (udbVar = this.V) != null && udbVar.t()) {
                return super.j();
            }
            c0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
