package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.i1;
import c.a.u0.e1.u2.a;
import c.a.u0.e1.u2.b;
import c.a.u0.e1.u2.c;
import c.a.u0.z3.d0;
import c.a.u0.z3.e0;
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
    public b f43958e;

    /* renamed from: f  reason: collision with root package name */
    public int f43959f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43960g;

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
        this.f43959f = SkinManager.getColor(c1.CAM_X0302);
    }

    public boolean isHasHotRankList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43960g : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (bVar = this.f43958e) == null) {
            return;
        }
        bVar.onChangeSkinType(i2);
    }

    public void setData(d0 d0Var, FrsViewData frsViewData) {
        e0 e0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d0Var, frsViewData) == null) {
            if (this.f43960g) {
                if (d0Var == null) {
                    d0Var = new d0();
                    d0Var.f26148b = new ArrayList();
                }
                if (!ListUtils.isEmpty(d0Var.f26148b) && (e0Var = d0Var.f26148b.get(0)) != null && getResources().getString(i1.hot_user_rank).equals(e0Var.f26153c) && getResources().getString(i1.hot_user_rank).equals(e0Var.f26152b)) {
                    d0Var.a--;
                    d0Var.f26148b.remove(0);
                }
                d0Var.a++;
                e0 e0Var2 = new e0();
                e0Var2.f26153c = getResources().getString(i1.hot_user_rank);
                e0Var2.f26152b = getResources().getString(i1.hot_user_rank);
                d0Var.f26148b.add(0, e0Var2);
            }
            if (d0Var == null) {
                return;
            }
            int f2 = n.f(getContext(), d1.M_H_X001);
            int f3 = n.f(getContext(), d1.M_H_X001);
            int i2 = d0Var.a;
            if (i2 >= 2) {
                this.f43958e = new MultiServiceViewController(getContext());
            } else if (i2 == 1) {
                this.f43958e = new c(getContext());
                f3 = n.f(getContext(), d1.tbds12);
                f2 = n.f(getContext(), d1.tbds5);
            }
            setPadding(0, f2, 0, f3);
            removeAllViews();
            addView(this.f43958e.getView(), -1, -2);
            this.f43958e.a(d0Var, frsViewData);
            b bVar = this.f43958e;
            if (bVar instanceof a) {
                ((a) bVar).b(this.f43959f);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setHasHotRankList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f43960g = z;
        }
    }

    public void setThemeFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f43959f = i2;
            b bVar = this.f43958e;
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
        this.f43959f = SkinManager.getColor(c1.CAM_X0302);
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
        this.f43959f = SkinManager.getColor(c1.CAM_X0302);
    }
}
