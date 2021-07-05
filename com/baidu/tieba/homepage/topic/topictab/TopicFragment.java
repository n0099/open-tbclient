package com.baidu.tieba.homepage.topic.topictab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.r0.z0.b0;
import d.a.s0.e1.k.b.a;
import d.a.s0.u0.n0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes5.dex */
public class TopicFragment extends BaseFragment implements n0, f.g, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f16912e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f16913f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16914g;

    public TopicFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16914g = false;
    }

    @Override // d.a.s0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a021" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (super.getCurrentPageSourceKeyList() != null) {
                arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
            } else {
                arrayList = new ArrayList();
            }
            if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
                arrayList.add("a001");
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.s0.e1.k.b.a
    public void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && j.z()) {
            this.f16913f.e();
            this.f16913f.l(false);
            this.f16912e.w();
        }
    }

    @Override // d.a.s0.e1.k.b.a
    public void netCallback(int i2, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, list) == null) {
            this.f16913f.d();
            this.f16913f.p();
            if (i2 == 0 && !ListUtils.isEmpty(list)) {
                this.f16913f.e();
                this.f16913f.k();
                this.f16913f.setData(list);
                this.f16913f.n();
                return;
            }
            this.f16913f.m(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f16913f.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.f16912e.x(this);
            this.f16912e.setUniqueId(getUniqueId());
            this.f16913f.setPresenter(this);
            this.f16913f.setListPullRefreshListener(this);
            this.f16913f.setPageUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f16913f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f16913f.getParent()).removeView(this.f16913f);
            }
            if (this.f16914g) {
                this.f16913f.f();
                this.f16914g = false;
            }
            return this.f16913f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroyView();
            this.f16913f.c();
            this.f16912e.onDestroy();
            this.f16914g = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16913f.l(false);
            this.f16912e.w();
        }
    }

    @Override // d.a.r0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f16912e.w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.f16913f.setViewForeground();
                TiebaStatic.log(new StatisticItem("c13349"));
            }
        }
    }

    @Override // d.a.s0.u0.n0
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f16913f.j();
        }
    }

    @Override // d.a.s0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void x(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, b0Var) == null) {
        }
    }
}
