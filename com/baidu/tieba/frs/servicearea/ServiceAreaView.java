package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.sva;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tva;
import com.baidu.tieba.w28;
import com.baidu.tieba.x28;
import com.baidu.tieba.y28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x28 a;
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void b(int i) {
        x28 x28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (x28Var = this.a) != null) {
            x28Var.onChangeSkinType(i);
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
            x28 x28Var = this.a;
            if (x28Var instanceof w28) {
                ((w28) x28Var).b(i);
            }
        }
    }

    public void setData(sva svaVar, FrsViewData frsViewData) {
        tva tvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, svaVar, frsViewData) == null) {
            if (this.c) {
                if (svaVar == null) {
                    svaVar = new sva();
                    svaVar.b = new ArrayList();
                }
                if (!ListUtils.isEmpty(svaVar.b) && (tvaVar = svaVar.b.get(0)) != null && getResources().getString(R.string.obfuscated_res_0x7f0f0a54).equals(tvaVar.c) && getResources().getString(R.string.obfuscated_res_0x7f0f0a54).equals(tvaVar.b)) {
                    svaVar.a--;
                    svaVar.b.remove(0);
                }
                svaVar.a++;
                tva tvaVar2 = new tva();
                tvaVar2.c = getResources().getString(R.string.obfuscated_res_0x7f0f0a54);
                tvaVar2.b = getResources().getString(R.string.obfuscated_res_0x7f0f0a54);
                svaVar.b.add(0, tvaVar2);
            }
            if (svaVar == null) {
                return;
            }
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X001);
            int i = svaVar.a;
            if (i >= 2) {
                this.a = new MultiServiceViewController(getContext());
            } else if (i == 1) {
                this.a = new y28(getContext());
                dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds12);
                dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.a.getView(), -1, -2);
            this.a.a(svaVar, frsViewData);
            x28 x28Var = this.a;
            if (x28Var instanceof w28) {
                ((w28) x28Var).b(this.b);
            }
            b(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
