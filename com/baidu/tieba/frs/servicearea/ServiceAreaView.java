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
import com.baidu.tieba.e67;
import com.baidu.tieba.f67;
import com.baidu.tieba.g67;
import com.baidu.tieba.gb9;
import com.baidu.tieba.hb9;
import com.baidu.tieba.hi;
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
    public f67 a;
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
        f67 f67Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (f67Var = this.a) != null) {
            f67Var.onChangeSkinType(i);
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
            f67 f67Var = this.a;
            if (f67Var instanceof e67) {
                ((e67) f67Var).b(i);
            }
        }
    }

    public void setData(gb9 gb9Var, FrsViewData frsViewData) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gb9Var, frsViewData) == null) {
            if (this.c) {
                if (gb9Var == null) {
                    gb9Var = new gb9();
                    gb9Var.b = new ArrayList();
                }
                if (!ListUtils.isEmpty(gb9Var.b) && (hb9Var = gb9Var.b.get(0)) != null && getResources().getString(R.string.obfuscated_res_0x7f0f0951).equals(hb9Var.c) && getResources().getString(R.string.obfuscated_res_0x7f0f0951).equals(hb9Var.b)) {
                    gb9Var.a--;
                    gb9Var.b.remove(0);
                }
                gb9Var.a++;
                hb9 hb9Var2 = new hb9();
                hb9Var2.c = getResources().getString(R.string.obfuscated_res_0x7f0f0951);
                hb9Var2.b = getResources().getString(R.string.obfuscated_res_0x7f0f0951);
                gb9Var.b.add(0, hb9Var2);
            }
            if (gb9Var == null) {
                return;
            }
            int g = hi.g(getContext(), R.dimen.M_H_X001);
            int g2 = hi.g(getContext(), R.dimen.M_H_X001);
            int i = gb9Var.a;
            if (i >= 2) {
                this.a = new MultiServiceViewController(getContext());
            } else if (i == 1) {
                this.a = new g67(getContext());
                g2 = hi.g(getContext(), R.dimen.tbds12);
                g = hi.g(getContext(), R.dimen.tbds5);
            }
            setPadding(0, g, 0, g2);
            removeAllViews();
            addView(this.a.getView(), -1, -2);
            this.a.a(gb9Var, frsViewData);
            f67 f67Var = this.a;
            if (f67Var instanceof e67) {
                ((e67) f67Var).b(this.b);
            }
            b(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
