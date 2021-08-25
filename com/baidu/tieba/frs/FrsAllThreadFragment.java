package com.baidu.tieba.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.k0.c;
import c.a.q0.v0.p0;
import c.a.q0.v0.t;
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
/* loaded from: classes7.dex */
public class FrsAllThreadFragment extends BaseFragment implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f50615e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f50616f;

    /* renamed from: g  reason: collision with root package name */
    public String f50617g;

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

    public final void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f50617g).param("obj_type", str).param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // c.a.q0.v0.p0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // c.a.q0.v0.p0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            scrollToTop();
            t tVar = new t();
            tVar.f27158a = 1;
            tVar.f27159b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void g() {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (view = this.f50615e) != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f50615e.getParent()).removeView(this.f50615e);
            this.f50615e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f50617g = arguments.getString("forum_id", "");
            }
            g();
            return this.f50615e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                a(2, "4");
            } else {
                a(2, "5");
            }
        }
    }

    @Override // c.a.q0.v0.p0
    public void scrollToTop() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (recyclerView = this.f50616f) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    public void setView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.f50615e = view;
            this.f50616f = (RecyclerView) view.findViewById(R.id.frs_lv_thread);
            g();
        }
    }
}
