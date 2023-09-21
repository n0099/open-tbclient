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
/* loaded from: classes6.dex */
public class g8b extends e8b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public n7b V;
    public m7b W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g8b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull q6b q6bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, q6bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, q6bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (q6b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.e8b, com.baidu.tieba.f8b
    public void K(@NonNull List<r6b<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new m7b(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        z0(list);
    }

    @Override // com.baidu.tieba.e8b, com.baidu.tieba.f8b
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
            w7b.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.e8b, com.baidu.tieba.f8b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.T(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            n7b a = n7b.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.M0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.e8b, com.baidu.tieba.f8b
    public void N(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.N(navigationBar);
            n7b n7bVar = this.V;
            if (n7bVar != null) {
                if (TextUtils.isEmpty(n7bVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f113f);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void y0(@NonNull EditorTools editorTools) {
        n7b n7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (n7bVar = this.V) == null) {
            return;
        }
        for (String str : n7bVar.e) {
            o7b.a(this.a, editorTools, this, str);
        }
    }

    public final void z0(@NonNull List<r6b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (r6b<?> r6bVar : list) {
                if (r6bVar instanceof h6b) {
                    this.D = (h6b) r6bVar;
                } else if (r6bVar instanceof w5b) {
                    this.E = (w5b) r6bVar;
                } else if (r6bVar instanceof g6b) {
                    this.F = (g6b) r6bVar;
                } else if (r6bVar instanceof j6b) {
                    this.G = (j6b) r6bVar;
                } else if (r6bVar instanceof k6b) {
                    this.H = (k6b) r6bVar;
                } else if (r6bVar instanceof v5b) {
                    this.I = (v5b) r6bVar;
                }
                if (r6bVar != null) {
                    r6bVar.q(list);
                }
            }
        }
    }
}
