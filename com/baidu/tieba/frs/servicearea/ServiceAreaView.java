package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.p0.a4.d0;
import c.a.p0.a4.e0;
import c.a.p0.f1.k2.a;
import c.a.p0.f1.k2.b;
import c.a.p0.f1.k2.c;
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
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ServiceAreaView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public int f32829b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32830c;

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
        this.f32829b = SkinManager.getColor(R.color.CAM_X0302);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32830c : invokeV.booleanValue;
    }

    public void b(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.onChangeSkinType(i);
    }

    public void setData(d0 d0Var, FrsViewData frsViewData) {
        e0 e0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d0Var, frsViewData) == null) {
            if (this.f32830c) {
                if (d0Var == null) {
                    d0Var = new d0();
                    d0Var.f12177b = new ArrayList();
                }
                if (!ListUtils.isEmpty(d0Var.f12177b) && (e0Var = d0Var.f12177b.get(0)) != null && getResources().getString(R.string.obfuscated_res_0x7f0f0886).equals(e0Var.f12182c) && getResources().getString(R.string.obfuscated_res_0x7f0f0886).equals(e0Var.f12181b)) {
                    d0Var.a--;
                    d0Var.f12177b.remove(0);
                }
                d0Var.a++;
                e0 e0Var2 = new e0();
                e0Var2.f12182c = getResources().getString(R.string.obfuscated_res_0x7f0f0886);
                e0Var2.f12181b = getResources().getString(R.string.obfuscated_res_0x7f0f0886);
                d0Var.f12177b.add(0, e0Var2);
            }
            if (d0Var == null) {
                return;
            }
            int f2 = n.f(getContext(), R.dimen.M_H_X001);
            int f3 = n.f(getContext(), R.dimen.M_H_X001);
            int i = d0Var.a;
            if (i >= 2) {
                this.a = new MultiServiceViewController(getContext());
            } else if (i == 1) {
                this.a = new c(getContext());
                f3 = n.f(getContext(), R.dimen.tbds12);
                f2 = n.f(getContext(), R.dimen.tbds5);
            }
            setPadding(0, f2, 0, f3);
            removeAllViews();
            addView(this.a.getView(), -1, -2);
            this.a.a(d0Var, frsViewData);
            b bVar = this.a;
            if (bVar instanceof a) {
                ((a) bVar).b(this.f32829b);
            }
            b(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setHasHotRankList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f32830c = z;
        }
    }

    public void setThemeFontColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f32829b = i;
            b bVar = this.a;
            if (bVar instanceof a) {
                ((a) bVar).b(i);
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
        this.f32829b = SkinManager.getColor(R.color.CAM_X0302);
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
        this.f32829b = SkinManager.getColor(R.color.CAM_X0302);
    }
}
