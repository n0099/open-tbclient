package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.p0.s.f0.f;
import c.a.q0.m0.h.c;
import c.a.q0.m0.k.a;
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
/* loaded from: classes7.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f50106e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f50107f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50108g;

    /* renamed from: h  reason: collision with root package name */
    public c f50109h;

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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a025" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.m0.k.a
    public void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && j.z()) {
            this.f50107f.hideNetRefreshView();
            this.f50107f.showLoadingView(false);
            this.f50106e.z();
        }
    }

    @Override // c.a.q0.m0.k.a
    public void netCallback(int i2, c.a.q0.m0.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) {
            this.f50107f.hideLoadingView();
            this.f50107f.stopPullRefresh();
            if (i2 == 0 && aVar != null) {
                this.f50107f.hideNetRefreshView();
                this.f50107f.showListView();
                this.f50107f.setData(aVar);
                return;
            }
            this.f50107f.showNetRefreshView(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f50106e == null) {
                RecommendModel recommendModel = new RecommendModel(getPageContext());
                this.f50106e = recommendModel;
                recommendModel.A(this);
                this.f50106e.setUniqueId(getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (recommendView = this.f50107f) == null) {
            return;
        }
        recommendView.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f50107f == null) {
                RecommendView recommendView = new RecommendView(getPageContext());
                this.f50107f = recommendView;
                recommendView.setTabViewController(this.f50109h);
                this.f50107f.setPresenter(this);
                this.f50107f.setListPullRefreshListener(this);
                this.f50107f.setPageUniqueId(getUniqueId());
            }
            if (this.f50107f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f50107f.getParent()).removeView(this.f50107f);
            }
            c.a.q0.h3.c.g().i(getUniqueId());
            return this.f50107f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f50109h = null;
            this.f50107f.onDestroy();
            this.f50106e.onDestroy();
            c.a.q0.h3.c.g().k(getUniqueId());
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f50108g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f50107f.showLoadingView(false);
        this.f50106e.z();
        this.f50108g = true;
    }

    @Override // c.a.p0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            RecommendModel recommendModel = this.f50106e;
            if (recommendModel != null) {
                recommendModel.z();
            }
            c.a.q0.h3.c.g().j(getUniqueId());
        }
    }

    public void onNavigationbarHeightChange(View view, int i2) {
        RecommendView recommendView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, view, i2) == null) || (recommendView = this.f50107f) == null) {
            return;
        }
        recommendView.onNavigationbarHeightChange(view, i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
                if (this.f50108g) {
                    return;
                }
                loadData();
                this.f50108g = true;
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
            c.a.q0.h3.c.g().h(getUniqueId(), false);
        }
    }

    public void setTabViewController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f50109h = cVar;
        }
    }
}
