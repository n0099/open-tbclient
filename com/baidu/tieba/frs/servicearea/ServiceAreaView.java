package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dr6;
import com.baidu.tieba.ej;
import com.baidu.tieba.er6;
import com.baidu.tieba.fr6;
import com.baidu.tieba.pm8;
import com.baidu.tieba.qm8;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public er6 a;
    public int b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceAreaView(@NonNull Context context) {
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
        this.b = SkinManager.getColor(R.color.CAM_X0302);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public void b(int i) {
        er6 er6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (er6Var = this.a) == null) {
            return;
        }
        er6Var.onChangeSkinType(i);
    }

    public void setData(pm8 pm8Var, FrsViewData frsViewData) {
        qm8 qm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pm8Var, frsViewData) == null) {
            if (this.c) {
                if (pm8Var == null) {
                    pm8Var = new pm8();
                    pm8Var.b = new ArrayList();
                }
                if (!ListUtils.isEmpty(pm8Var.b) && (qm8Var = pm8Var.b.get(0)) != null && getResources().getString(R.string.obfuscated_res_0x7f0f08b1).equals(qm8Var.c) && getResources().getString(R.string.obfuscated_res_0x7f0f08b1).equals(qm8Var.b)) {
                    pm8Var.a--;
                    pm8Var.b.remove(0);
                }
                pm8Var.a++;
                qm8 qm8Var2 = new qm8();
                qm8Var2.c = getResources().getString(R.string.obfuscated_res_0x7f0f08b1);
                qm8Var2.b = getResources().getString(R.string.obfuscated_res_0x7f0f08b1);
                pm8Var.b.add(0, qm8Var2);
            }
            if (pm8Var == null) {
                return;
            }
            int f = ej.f(getContext(), R.dimen.M_H_X001);
            int f2 = ej.f(getContext(), R.dimen.M_H_X001);
            int i = pm8Var.a;
            if (i >= 2) {
                this.a = new MultiServiceViewController(getContext());
            } else if (i == 1) {
                this.a = new fr6(getContext());
                f2 = ej.f(getContext(), R.dimen.tbds12);
                f = ej.f(getContext(), R.dimen.tbds5);
            }
            setPadding(0, f, 0, f2);
            removeAllViews();
            addView(this.a.getView(), -1, -2);
            this.a.a(pm8Var, frsViewData);
            er6 er6Var = this.a;
            if (er6Var instanceof dr6) {
                ((dr6) er6Var).b(this.b);
            }
            b(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setHasHotRankList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    public void setThemeFontColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b = i;
            er6 er6Var = this.a;
            if (er6Var instanceof dr6) {
                ((dr6) er6Var).b(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.b = SkinManager.getColor(R.color.CAM_X0302);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.b = SkinManager.getColor(R.color.CAM_X0302);
    }
}
