package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.p0.s.f0.f;
import d.a.q0.l0.h.c;
import d.a.q0.l0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f14815e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f14816f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14817g;

    /* renamed from: h  reason: collision with root package name */
    public c f14818h;

    public RecommendFragment() {
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

    @Override // d.a.q0.l0.k.a
    public void f(int i2, d.a.q0.l0.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
            this.f14816f.h();
            this.f14816f.v();
            if (i2 == 0 && aVar != null) {
                this.f14816f.i();
                this.f14816f.r();
                this.f14816f.setData(aVar);
                return;
            }
            this.f14816f.t(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a025" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.l0.k.a
    public void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && j.z()) {
            this.f14816f.i();
            this.f14816f.s(false);
            this.f14815e.z();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f14815e == null) {
                RecommendModel recommendModel = new RecommendModel(getPageContext());
                this.f14815e = recommendModel;
                recommendModel.A(this);
                this.f14815e.setUniqueId(getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (recommendView = this.f14816f) == null) {
            return;
        }
        recommendView.m();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f14816f == null) {
                RecommendView recommendView = new RecommendView(getPageContext());
                this.f14816f = recommendView;
                recommendView.setTabViewController(this.f14818h);
                this.f14816f.setPresenter(this);
                this.f14816f.setListPullRefreshListener(this);
                this.f14816f.setPageUniqueId(getUniqueId());
            }
            if (this.f14816f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f14816f.getParent()).removeView(this.f14816f);
            }
            d.a.q0.g3.c.g().i(getUniqueId());
            return this.f14816f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f14818h = null;
            this.f14816f.n();
            this.f14815e.onDestroy();
            d.a.q0.g3.c.g().k(getUniqueId());
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f14817g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f14816f.s(false);
        this.f14815e.z();
        this.f14817g = true;
    }

    @Override // d.a.p0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            RecommendModel recommendModel = this.f14815e;
            if (recommendModel != null) {
                recommendModel.z();
            }
            d.a.q0.g3.c.g().j(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
                if (this.f14817g) {
                    return;
                }
                loadData();
                this.f14817g = true;
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
            d.a.q0.g3.c.g().h(getUniqueId(), false);
        }
    }
}
