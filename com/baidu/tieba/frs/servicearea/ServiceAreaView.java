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
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ak8;
import com.repackage.ao6;
import com.repackage.bk8;
import com.repackage.oi;
import com.repackage.yn6;
import com.repackage.zn6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zn6 a;
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
        zn6 zn6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (zn6Var = this.a) == null) {
            return;
        }
        zn6Var.onChangeSkinType(i);
    }

    public void setData(ak8 ak8Var, FrsViewData frsViewData) {
        bk8 bk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ak8Var, frsViewData) == null) {
            if (this.c) {
                if (ak8Var == null) {
                    ak8Var = new ak8();
                    ak8Var.b = new ArrayList();
                }
                if (!ListUtils.isEmpty(ak8Var.b) && (bk8Var = ak8Var.b.get(0)) != null && getResources().getString(R.string.obfuscated_res_0x7f0f0886).equals(bk8Var.c) && getResources().getString(R.string.obfuscated_res_0x7f0f0886).equals(bk8Var.b)) {
                    ak8Var.a--;
                    ak8Var.b.remove(0);
                }
                ak8Var.a++;
                bk8 bk8Var2 = new bk8();
                bk8Var2.c = getResources().getString(R.string.obfuscated_res_0x7f0f0886);
                bk8Var2.b = getResources().getString(R.string.obfuscated_res_0x7f0f0886);
                ak8Var.b.add(0, bk8Var2);
            }
            if (ak8Var == null) {
                return;
            }
            int f = oi.f(getContext(), R.dimen.M_H_X001);
            int f2 = oi.f(getContext(), R.dimen.M_H_X001);
            int i = ak8Var.a;
            if (i >= 2) {
                this.a = new MultiServiceViewController(getContext());
            } else if (i == 1) {
                this.a = new ao6(getContext());
                f2 = oi.f(getContext(), R.dimen.tbds12);
                f = oi.f(getContext(), R.dimen.tbds5);
            }
            setPadding(0, f, 0, f2);
            removeAllViews();
            addView(this.a.getView(), -1, -2);
            this.a.a(ak8Var, frsViewData);
            zn6 zn6Var = this.a;
            if (zn6Var instanceof yn6) {
                ((yn6) zn6Var).b(this.b);
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
            zn6 zn6Var = this.a;
            if (zn6Var instanceof yn6) {
                ((yn6) zn6Var).b(i);
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
