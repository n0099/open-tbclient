package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pv4;
import com.repackage.qi;
import com.repackage.qv4;
/* loaded from: classes3.dex */
public class PublishButton extends TBSpecificationBtn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 1.0f;
        m();
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setTextSize(R.dimen.T_X08);
            setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0862));
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.drawableStateChanged();
            setAlpha(this.o);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                qv4 qv4Var = new qv4();
                qv4Var.p(R.color.CAM_X0101);
                qv4Var.v(R.dimen.tbds6);
                qv4Var.u(R.string.A_X01);
                qv4Var.i(R.drawable.obfuscated_res_0x7f08094b, 0, TBSpecificationButtonConfig.IconType.WEBP);
                qv4Var.g(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds42));
                setConfig(qv4Var);
            } else {
                pv4 pv4Var = new pv4();
                pv4Var.i(R.drawable.obfuscated_res_0x7f08094b, 0, TBSpecificationButtonConfig.IconType.WEBP);
                pv4Var.g(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds42));
                pv4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
                setConfig(pv4Var);
            }
            k();
        }
    }

    public void setScrollAlpha(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.o = f;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 1.0f;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = 1.0f;
        m();
    }
}
