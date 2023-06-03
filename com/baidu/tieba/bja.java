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
public class bja extends zia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public iia V;
    public hia W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bja(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull lha lhaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, lhaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, lhaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (lha) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A0(@NonNull List<mha<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (mha<?> mhaVar : list) {
                if (mhaVar instanceof cha) {
                    this.D = (cha) mhaVar;
                } else if (mhaVar instanceof rga) {
                    this.E = (rga) mhaVar;
                } else if (mhaVar instanceof bha) {
                    this.F = (bha) mhaVar;
                } else if (mhaVar instanceof eha) {
                    this.G = (eha) mhaVar;
                } else if (mhaVar instanceof fha) {
                    this.H = (fha) mhaVar;
                } else if (mhaVar instanceof qga) {
                    this.I = (qga) mhaVar;
                }
                if (mhaVar != null) {
                    mhaVar.q(list);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zia, com.baidu.tieba.aja
    public void M(@NonNull List<mha<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new hia(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        A0(list);
    }

    @Override // com.baidu.tieba.zia, com.baidu.tieba.aja
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.E(true);
            editorTools.F(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            z0(editorTools);
            ria.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.zia, com.baidu.tieba.aja
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            iia a = iia.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.U0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.zia, com.baidu.tieba.aja
    public void P(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            iia iiaVar = this.V;
            if (iiaVar != null) {
                if (TextUtils.isEmpty(iiaVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f10e5);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void z0(@NonNull EditorTools editorTools) {
        iia iiaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, editorTools) != null) || (iiaVar = this.V) == null) {
            return;
        }
        for (String str : iiaVar.e) {
            jia.a(this.a, editorTools, this, str);
        }
    }
}
