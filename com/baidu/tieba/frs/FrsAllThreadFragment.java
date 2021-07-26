package com.baidu.tieba.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.k0.c;
import d.a.q0.u0.p0;
import d.a.q0.u0.t;
/* loaded from: classes4.dex */
public class FrsAllThreadFragment extends BaseFragment implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f15337e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15338f;

    /* renamed from: g  reason: collision with root package name */
    public String f15339g;

    public FrsAllThreadFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.u0.p0
    public void J0() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (recyclerView = this.f15338f) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    @Override // d.a.q0.u0.p0
    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    public final void M0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f15339g).param("obj_type", str).param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void N0() {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (view = this.f15337e) != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f15337e.getParent()).removeView(this.f15337e);
            this.f15337e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void O0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f15337e = view;
            this.f15338f = (RecyclerView) view.findViewById(R.id.frs_lv_thread);
            N0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new c(getUniqueId(), "a006", baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f15339g = arguments.getString("forum_id", "");
            }
            N0();
            return this.f15337e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                M0(2, "4");
            } else {
                M0(2, "5");
            }
        }
    }

    @Override // d.a.q0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            J0();
            t tVar = new t();
            tVar.f64450a = 1;
            tVar.f64451b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }
}
