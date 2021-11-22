package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.e.f.p.l;
import b.a.r0.m3.c0;
import b.a.r0.m3.d0;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.i1;
import b.a.r0.x0.s2.a;
import b.a.r0.x0.s2.b;
import b.a.r0.x0.s2.c;
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
/* loaded from: classes9.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f49819e;

    /* renamed from: f  reason: collision with root package name */
    public int f49820f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49821g;

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
        this.f49820f = SkinManager.getColor(c1.CAM_X0302);
    }

    public boolean isHasHotRankList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49821g : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (bVar = this.f49819e) == null) {
            return;
        }
        bVar.onChangeSkinType(i2);
    }

    public void setData(c0 c0Var, FrsViewData frsViewData) {
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c0Var, frsViewData) == null) {
            if (this.f49821g) {
                if (c0Var == null) {
                    c0Var = new c0();
                    c0Var.f22378b = new ArrayList();
                }
                if (!ListUtils.isEmpty(c0Var.f22378b) && (d0Var = c0Var.f22378b.get(0)) != null && getResources().getString(i1.hot_user_rank).equals(d0Var.f22385c) && getResources().getString(i1.hot_user_rank).equals(d0Var.f22384b)) {
                    c0Var.f22377a--;
                    c0Var.f22378b.remove(0);
                }
                c0Var.f22377a++;
                d0 d0Var2 = new d0();
                d0Var2.f22385c = getResources().getString(i1.hot_user_rank);
                d0Var2.f22384b = getResources().getString(i1.hot_user_rank);
                c0Var.f22378b.add(0, d0Var2);
            }
            if (c0Var == null) {
                return;
            }
            int g2 = l.g(getContext(), d1.M_H_X001);
            int g3 = l.g(getContext(), d1.M_H_X001);
            int i2 = c0Var.f22377a;
            if (i2 >= 2) {
                this.f49819e = new MultiServiceViewController(getContext());
            } else if (i2 == 1) {
                this.f49819e = new c(getContext());
                g3 = l.g(getContext(), d1.tbds12);
                g2 = l.g(getContext(), d1.tbds5);
            }
            setPadding(0, g2, 0, g3);
            removeAllViews();
            addView(this.f49819e.getView(), -1, -2);
            this.f49819e.a(c0Var, frsViewData);
            b bVar = this.f49819e;
            if (bVar instanceof a) {
                ((a) bVar).b(this.f49820f);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setHasHotRankList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f49821g = z;
        }
    }

    public void setThemeFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f49820f = i2;
            b bVar = this.f49819e;
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
        this.f49820f = SkinManager.getColor(c1.CAM_X0302);
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
        this.f49820f = SkinManager.getColor(c1.CAM_X0302);
    }
}
