package com.baidu.tieba;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.location.editortool.PbLocationInfoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ee9 extends le5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee9(Context context) {
        super(context, (String) null, 8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.n = 3;
        this.m = new PbLocationInfoContainer(context);
        this.p = new int[]{20, 19};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee9(Context context, boolean z) {
        super(context, (String) null, 8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = false;
        this.n = 3;
        this.m = new PbLocationInfoContainer(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, BdUtilHelper.getDimens(b(), R.dimen.obfuscated_res_0x7f0703e5));
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = BdUtilHelper.getDimens(b(), R.dimen.obfuscated_res_0x7f070207);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = BdUtilHelper.getDimens(b(), R.dimen.obfuscated_res_0x7f070207);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = BdUtilHelper.getDimens(b(), R.dimen.obfuscated_res_0x7f070394);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = BdUtilHelper.getDimens(b(), R.dimen.obfuscated_res_0x7f070394);
        ((PbLocationInfoContainer) this.m).setLayoutParams(layoutParams);
        this.p = new int[]{20, 19};
    }
}
