package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.i1;
import c.a.t0.e1.t2.a;
import c.a.t0.e1.t2.b;
import c.a.t0.e1.t2.c;
import c.a.t0.x3.c0;
import c.a.t0.x3.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f43713e;

    /* renamed from: f  reason: collision with root package name */
    public int f43714f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43715g;

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
        this.f43714f = SkinManager.getColor(c1.CAM_X0302);
    }

    public boolean isHasHotRankList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43715g : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (bVar = this.f43713e) == null) {
            return;
        }
        bVar.onChangeSkinType(i2);
    }

    public void setData(c0 c0Var, FrsViewData frsViewData) {
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c0Var, frsViewData) == null) {
            if (this.f43715g) {
                if (c0Var == null) {
                    c0Var = new c0();
                    c0Var.f25037b = new ArrayList();
                }
                if (!ListUtils.isEmpty(c0Var.f25037b) && (d0Var = c0Var.f25037b.get(0)) != null && getResources().getString(i1.hot_user_rank).equals(d0Var.f25042c) && getResources().getString(i1.hot_user_rank).equals(d0Var.f25041b)) {
                    c0Var.a--;
                    c0Var.f25037b.remove(0);
                }
                c0Var.a++;
                d0 d0Var2 = new d0();
                d0Var2.f25042c = getResources().getString(i1.hot_user_rank);
                d0Var2.f25041b = getResources().getString(i1.hot_user_rank);
                c0Var.f25037b.add(0, d0Var2);
            }
            if (c0Var == null) {
                return;
            }
            int f2 = n.f(getContext(), d1.M_H_X001);
            int f3 = n.f(getContext(), d1.M_H_X001);
            int i2 = c0Var.a;
            if (i2 >= 2) {
                this.f43713e = new MultiServiceViewController(getContext());
            } else if (i2 == 1) {
                this.f43713e = new c(getContext());
                f3 = n.f(getContext(), d1.tbds12);
                f2 = n.f(getContext(), d1.tbds5);
            }
            setPadding(0, f2, 0, f3);
            removeAllViews();
            addView(this.f43713e.getView(), -1, -2);
            this.f43713e.a(c0Var, frsViewData);
            b bVar = this.f43713e;
            if (bVar instanceof a) {
                ((a) bVar).b(this.f43714f);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setHasHotRankList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f43715g = z;
        }
    }

    public void setThemeFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f43714f = i2;
            b bVar = this.f43713e;
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
        this.f43714f = SkinManager.getColor(c1.CAM_X0302);
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
        this.f43714f = SkinManager.getColor(c1.CAM_X0302);
    }
}
