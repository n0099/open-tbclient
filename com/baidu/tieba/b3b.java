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
/* loaded from: classes5.dex */
public class b3b extends z2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public i2b V;
    public h2b W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b3b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l1b l1bVar, boolean z) {
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
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new h2b(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        z0(list);
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
            y0(editorTools);
            r2b.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.T(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            i2b a = i2b.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.M0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.z2b, com.baidu.tieba.a3b
    public void N(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.N(navigationBar);
            i2b i2bVar = this.V;
            if (i2bVar != null) {
                if (TextUtils.isEmpty(i2bVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f114c);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void y0(@NonNull EditorTools editorTools) {
        i2b i2bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (i2bVar = this.V) == null) {
            return;
        }
        for (String str : i2bVar.e) {
            j2b.a(this.a, editorTools, this, str);
        }
    }

    public final void z0(@NonNull List<m1b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (m1b<?> m1bVar : list) {
                if (m1bVar instanceof c1b) {
                    this.D = (c1b) m1bVar;
                } else if (m1bVar instanceof r0b) {
                    this.E = (r0b) m1bVar;
                } else if (m1bVar instanceof b1b) {
                    this.F = (b1b) m1bVar;
                } else if (m1bVar instanceof e1b) {
                    this.G = (e1b) m1bVar;
                } else if (m1bVar instanceof f1b) {
                    this.H = (f1b) m1bVar;
                } else if (m1bVar instanceof q0b) {
                    this.I = (q0b) m1bVar;
                }
                if (m1bVar != null) {
                    m1bVar.q(list);
                }
            }
        }
    }
}
