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
public class f4b extends c4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w1b V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull o2b o2bVar, boolean z) {
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
    public void L(@NonNull List<p2b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(s3b.f(this.a));
            w1b e = s3b.e(this.a);
            this.V = e;
            list.add(e);
            u1b c = s3b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            h2b p = s3b.p(this.a);
            this.G = p;
            list.add(p);
            list.add(s3b.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
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
                zi5 g = u3b.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.O(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1172));
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b, com.baidu.tieba.dfa.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.c(writeData);
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dfa.m(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.a();
            dfa.w(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.c0();
            dfa.w(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public boolean e0() {
        InterceptResult invokeV;
        u1b u1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((u1bVar = this.E) != null && u1bVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public boolean j() {
        InterceptResult invokeV;
        w1b w1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            u1b u1bVar = this.E;
            if (u1bVar != null && u1bVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (w1bVar = this.V) != null && w1bVar.t()) {
                return super.j();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
