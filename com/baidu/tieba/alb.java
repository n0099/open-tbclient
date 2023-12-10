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
public class alb extends xkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rib V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public alb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull jjb jjbVar, boolean z) {
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
    public void K(@NonNull List<kjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(nkb.f(this.a));
            rib e = nkb.e(this.a);
            this.V = e;
            list.add(e);
            pib c = nkb.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            cjb p = nkb.p(this.a);
            this.G = p;
            list.add(p);
            list.add(nkb.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
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
                if5 g = pkb.g(this.a, editorTools, this);
                g.i(false);
                g.j(false);
            }
            editorTools.h();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.N(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f11c1));
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void S(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.S(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb, com.baidu.tieba.rva.h
    public void d(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.d(writeData);
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rva.m(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            rva.w(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.b0();
            rva.w(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb
    public boolean d0() {
        InterceptResult invokeV;
        pib pibVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((pibVar = this.E) != null && pibVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ykb, com.baidu.tieba.mjb
    public boolean j() {
        InterceptResult invokeV;
        rib ribVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            pib pibVar = this.E;
            if (pibVar != null && pibVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (ribVar = this.V) != null && ribVar.t()) {
                return super.j();
            }
            c0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
