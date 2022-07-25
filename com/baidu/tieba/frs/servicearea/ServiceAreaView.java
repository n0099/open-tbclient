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
import com.repackage.gn6;
import com.repackage.hn6;
import com.repackage.in6;
import com.repackage.pi;
import com.repackage.th8;
import com.repackage.uh8;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hn6 a;
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
        hn6 hn6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (hn6Var = this.a) == null) {
            return;
        }
        hn6Var.onChangeSkinType(i);
    }

    public void setData(th8 th8Var, FrsViewData frsViewData) {
        uh8 uh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, th8Var, frsViewData) == null) {
            if (this.c) {
                if (th8Var == null) {
                    th8Var = new th8();
                    th8Var.b = new ArrayList();
                }
                if (!ListUtils.isEmpty(th8Var.b) && (uh8Var = th8Var.b.get(0)) != null && getResources().getString(R.string.obfuscated_res_0x7f0f0887).equals(uh8Var.c) && getResources().getString(R.string.obfuscated_res_0x7f0f0887).equals(uh8Var.b)) {
                    th8Var.a--;
                    th8Var.b.remove(0);
                }
                th8Var.a++;
                uh8 uh8Var2 = new uh8();
                uh8Var2.c = getResources().getString(R.string.obfuscated_res_0x7f0f0887);
                uh8Var2.b = getResources().getString(R.string.obfuscated_res_0x7f0f0887);
                th8Var.b.add(0, uh8Var2);
            }
            if (th8Var == null) {
                return;
            }
            int f = pi.f(getContext(), R.dimen.M_H_X001);
            int f2 = pi.f(getContext(), R.dimen.M_H_X001);
            int i = th8Var.a;
            if (i >= 2) {
                this.a = new MultiServiceViewController(getContext());
            } else if (i == 1) {
                this.a = new in6(getContext());
                f2 = pi.f(getContext(), R.dimen.tbds12);
                f = pi.f(getContext(), R.dimen.tbds5);
            }
            setPadding(0, f, 0, f2);
            removeAllViews();
            addView(this.a.getView(), -1, -2);
            this.a.a(th8Var, frsViewData);
            hn6 hn6Var = this.a;
            if (hn6Var instanceof gn6) {
                ((gn6) hn6Var).b(this.b);
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
            hn6 hn6Var = this.a;
            if (hn6Var instanceof gn6) {
                ((gn6) hn6Var).b(i);
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
