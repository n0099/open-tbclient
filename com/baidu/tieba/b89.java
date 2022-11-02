package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b89 extends z79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public i79 V;
    public h79 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b89(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l69 l69Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, l69Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, l69Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (l69) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void M(@NonNull List<m69<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new h79(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        y0(list);
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            x0(editorTools);
            r79.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            i79 a = i79.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.v0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.z79, com.baidu.tieba.a89
    public void P(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            i79 i79Var = this.V;
            if (i79Var != null) {
                if (TextUtils.isEmpty(i79Var.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f0f2e);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void x0(@NonNull EditorTools editorTools) {
        i79 i79Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (i79Var = this.V) == null) {
            return;
        }
        for (String str : i79Var.e) {
            j79.a(this.a, editorTools, this, str);
        }
    }

    public final void y0(@NonNull List<m69<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (m69<?> m69Var : list) {
                if (m69Var instanceof c69) {
                    this.D = (c69) m69Var;
                } else if (m69Var instanceof r59) {
                    this.E = (r59) m69Var;
                } else if (m69Var instanceof b69) {
                    this.F = (b69) m69Var;
                } else if (m69Var instanceof e69) {
                    this.G = (e69) m69Var;
                } else if (m69Var instanceof f69) {
                    this.H = (f69) m69Var;
                } else if (m69Var instanceof q59) {
                    this.I = (q59) m69Var;
                }
                if (m69Var != null) {
                    m69Var.q(list);
                }
            }
        }
    }
}
