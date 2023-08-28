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
public class g4b extends e4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public n3b V;
    public m3b W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull q2b q2bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, q2bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, q2bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (q2b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A0(@NonNull List<r2b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (r2b<?> r2bVar : list) {
                if (r2bVar instanceof h2b) {
                    this.D = (h2b) r2bVar;
                } else if (r2bVar instanceof w1b) {
                    this.E = (w1b) r2bVar;
                } else if (r2bVar instanceof g2b) {
                    this.F = (g2b) r2bVar;
                } else if (r2bVar instanceof j2b) {
                    this.G = (j2b) r2bVar;
                } else if (r2bVar instanceof k2b) {
                    this.H = (k2b) r2bVar;
                } else if (r2bVar instanceof v1b) {
                    this.I = (v1b) r2bVar;
                }
                if (r2bVar != null) {
                    r2bVar.q(list);
                }
            }
        }
    }

    @Override // com.baidu.tieba.e4b, com.baidu.tieba.f4b
    public void L(@NonNull List<r2b<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new m3b(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        A0(list);
    }

    @Override // com.baidu.tieba.e4b, com.baidu.tieba.f4b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            y0(editorTools);
            w3b.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.e4b, com.baidu.tieba.f4b
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            n3b a = n3b.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.Q0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.e4b, com.baidu.tieba.f4b
    public void O(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.O(navigationBar);
            n3b n3bVar = this.V;
            if (n3bVar != null) {
                if (TextUtils.isEmpty(n3bVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f1126);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void y0(@NonNull EditorTools editorTools) {
        n3b n3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, editorTools) != null) || (n3bVar = this.V) == null) {
            return;
        }
        for (String str : n3bVar.e) {
            o3b.a(this.a, editorTools, this, str);
        }
    }
}
