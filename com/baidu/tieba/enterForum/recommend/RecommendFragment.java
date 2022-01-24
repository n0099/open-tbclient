package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.s0.s.k0.f;
import c.a.t0.v0.h.c;
import c.a.t0.v0.k.a;
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
/* loaded from: classes12.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f42648e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f42649f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42650g;

    /* renamed from: h  reason: collision with root package name */
    public c f42651h;

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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a025" : (String) invokeV.objValue;
    }

    @Override // c.a.t0.v0.k.a
    public void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && l.z()) {
            this.f42649f.hideNetRefreshView();
            this.f42649f.showLoadingView(false);
            this.f42648e.z();
        }
    }

    @Override // c.a.t0.v0.k.a
    public void netCallback(int i2, c.a.t0.v0.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) {
            this.f42649f.hideLoadingView();
            this.f42649f.stopPullRefresh();
            if (i2 == 0 && aVar != null) {
                this.f42649f.hideNetRefreshView();
                this.f42649f.showListView();
                this.f42649f.setData(aVar);
                return;
            }
            this.f42649f.showNetRefreshView(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f42648e == null) {
                RecommendModel recommendModel = new RecommendModel(getPageContext());
                this.f42648e = recommendModel;
                recommendModel.A(this);
                this.f42648e.setUniqueId(getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (recommendView = this.f42649f) == null) {
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
            if (this.f42649f == null) {
                RecommendView recommendView = new RecommendView(getPageContext());
                this.f42649f = recommendView;
                recommendView.setTabViewController(this.f42651h);
                this.f42649f.setPresenter(this);
                this.f42649f.setListPullRefreshListener(this);
                this.f42649f.setPageUniqueId(getUniqueId());
            }
            if (this.f42649f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f42649f.getParent()).removeView(this.f42649f);
            }
            c.a.t0.w3.c.g().i(getUniqueId());
            return this.f42649f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f42651h = null;
            this.f42649f.onDestroy();
            this.f42648e.onDestroy();
            c.a.t0.w3.c.g().k(getUniqueId());
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f42650g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f42649f.showLoadingView(false);
        this.f42648e.z();
        this.f42650g = true;
    }

    @Override // c.a.s0.s.k0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            RecommendModel recommendModel = this.f42648e;
            if (recommendModel != null) {
                recommendModel.z();
            }
            c.a.t0.w3.c.g().j(getUniqueId());
        }
    }

    public void onNavigationbarHeightChange(View view, int i2) {
        RecommendView recommendView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, view, i2) == null) || (recommendView = this.f42649f) == null) {
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
                if (this.f42650g) {
                    return;
                }
                loadData();
                this.f42650g = true;
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
            c.a.t0.w3.c.g().h(getUniqueId(), false);
        }
    }

    public void setTabViewController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f42651h = cVar;
        }
    }
}
