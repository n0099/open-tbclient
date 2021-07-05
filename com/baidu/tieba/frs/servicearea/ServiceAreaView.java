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
import d.a.c.e.p.l;
import d.a.s0.h3.a0;
import d.a.s0.h3.b0;
import d.a.s0.u0.g2.a;
import d.a.s0.u0.g2.b;
import d.a.s0.u0.g2.c;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f15972e;

    /* renamed from: f  reason: collision with root package name */
    public int f15973f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15974g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceAreaView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15973f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15974g : invokeV.booleanValue;
    }

    public void b(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (bVar = this.f15972e) == null) {
            return;
        }
        bVar.onChangeSkinType(i2);
    }

    public void setData(a0 a0Var, FrsViewData frsViewData) {
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, a0Var, frsViewData) == null) {
            if (this.f15974g) {
                if (a0Var == null) {
                    a0Var = new a0();
                    a0Var.f61154b = new ArrayList();
                }
                if (!ListUtils.isEmpty(a0Var.f61154b) && (b0Var = a0Var.f61154b.get(0)) != null && getResources().getString(R.string.hot_user_rank).equals(b0Var.f61157c) && getResources().getString(R.string.hot_user_rank).equals(b0Var.f61156b)) {
                    a0Var.f61153a--;
                    a0Var.f61154b.remove(0);
                }
                a0Var.f61153a++;
                b0 b0Var2 = new b0();
                b0Var2.f61157c = getResources().getString(R.string.hot_user_rank);
                b0Var2.f61156b = getResources().getString(R.string.hot_user_rank);
                a0Var.f61154b.add(0, b0Var2);
            }
            if (a0Var == null) {
                return;
            }
            int g2 = l.g(getContext(), R.dimen.M_H_X001);
            int g3 = l.g(getContext(), R.dimen.M_H_X001);
            int i2 = a0Var.f61153a;
            if (i2 >= 2) {
                this.f15972e = new MultiServiceViewController(getContext());
            } else if (i2 == 1) {
                this.f15972e = new c(getContext());
                g3 = l.g(getContext(), R.dimen.tbds12);
                g2 = l.g(getContext(), R.dimen.tbds5);
            }
            setPadding(0, g2, 0, g3);
            removeAllViews();
            addView(this.f15972e.getView(), -1, -2);
            this.f15972e.a(a0Var, frsViewData);
            b bVar = this.f15972e;
            if (bVar instanceof a) {
                ((a) bVar).b(this.f15973f);
            }
            b(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setHasHotRankList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f15974g = z;
        }
    }

    public void setThemeFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f15973f = i2;
            b bVar = this.f15972e;
            if (bVar instanceof a) {
                ((a) bVar).b(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f15973f = SkinManager.getColor(R.color.CAM_X0302);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f15973f = SkinManager.getColor(R.color.CAM_X0302);
    }
}
