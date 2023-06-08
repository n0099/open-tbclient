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
/* loaded from: classes6.dex */
public class hja extends eja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yga V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hja(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull qha qhaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, qhaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, qhaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (qha) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void M(@NonNull List<rha<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(uia.f(this.a));
            yga e = uia.e(this.a);
            this.V = e;
            list.add(e);
            wga c = uia.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            jha p = uia.p(this.a);
            this.G = p;
            list.add(p);
            list.add(uia.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.E(true);
            editorTools.F(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                wia.h(this.a, editorTools, this);
                wia.j(this.a, editorTools, this);
                wia.k(this.a, editorTools, this);
                wia.b(this.a, editorTools, this);
                wia.i(this.a, editorTools);
                wia.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            wia.d(editorTools, this);
            wia.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                ui5 g = wia.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1131));
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja, com.baidu.tieba.mx9.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mx9.k(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            mx9.t(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja, com.baidu.tieba.tha
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.j();
            mx9.t(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public boolean e0() {
        InterceptResult invokeV;
        wga wgaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((wgaVar = this.E) != null && wgaVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja, com.baidu.tieba.tha
    public boolean i() {
        InterceptResult invokeV;
        yga ygaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            wga wgaVar = this.E;
            if (wgaVar != null && wgaVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (ygaVar = this.V) != null && ygaVar.t()) {
                return super.i();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
