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
public class c3b extends z2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0b V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c3b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l1b l1bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, l1bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, l1bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (l1b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void K(@NonNull List<m1b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(p2b.f(this.a));
            t0b e = p2b.e(this.a);
            this.V = e;
            list.add(e);
            r0b c = p2b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            e1b p = p2b.p(this.a);
            this.G = p;
            list.add(p);
            list.add(p2b.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                r2b.h(this.a, editorTools, this);
                r2b.j(this.a, editorTools, this);
                r2b.k(this.a, editorTools, this);
                r2b.b(this.a, editorTools, this);
                r2b.i(this.a, editorTools);
                r2b.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            r2b.d(editorTools, this);
            r2b.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                ce5 g = r2b.g(this.a, editorTools, this);
                g.h(false);
                g.i(false);
            }
            editorTools.f();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.N(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f119c));
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.T(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b, com.baidu.tieba.sda.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.c(writeData);
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sda.m(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            sda.w(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.b0();
            sda.w(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public boolean e0() {
        InterceptResult invokeV;
        r0b r0bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((r0bVar = this.E) != null && r0bVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b, com.baidu.tieba.o1b
    public boolean j() {
        InterceptResult invokeV;
        t0b t0bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            r0b r0bVar = this.E;
            if (r0bVar != null && r0bVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (t0bVar = this.V) != null && t0bVar.t()) {
                return super.j();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
