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
import com.repackage.d56;
import com.repackage.du4;
import com.repackage.e66;
import com.repackage.mi;
import com.repackage.wi8;
import com.repackage.z56;
/* loaded from: classes3.dex */
public class RecommendFragment extends BaseFragment implements du4.g, z56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendModel a;
    public RecommendView b;
    public boolean c;
    public d56 d;

    public RecommendFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a025" : (String) invokeV.objValue;
    }

    @Override // com.repackage.z56
    public void l(int i, e66 e66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, e66Var) == null) {
            this.b.h();
            this.b.u();
            if (i == 0 && e66Var != null) {
                this.b.i();
                this.b.q();
                this.b.setData(e66Var);
                return;
            }
            this.b.s(false);
        }
    }

    @Override // com.repackage.z56
    public void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && mi.z()) {
            this.b.i();
            this.b.r(false);
            this.a.B();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.a == null) {
                RecommendModel recommendModel = new RecommendModel(getPageContext());
                this.a = recommendModel;
                recommendModel.C(this);
                this.a.setUniqueId(getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        RecommendView recommendView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (recommendView = this.b) == null) {
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
            if (this.b == null) {
                RecommendView recommendView = new RecommendView(getPageContext());
                this.b = recommendView;
                recommendView.setTabViewController(this.d);
                this.b.setPresenter(this);
                this.b.setListPullRefreshListener(this);
                this.b.setPageUniqueId(getUniqueId());
            }
            if (this.b.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            wi8.g().i(getUniqueId());
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = null;
            this.b.n();
            this.a.onDestroy();
            wi8.g().k(getUniqueId());
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.c || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.b.r(false);
        this.a.B();
        this.c = true;
    }

    @Override // com.repackage.du4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            RecommendModel recommendModel = this.a;
            if (recommendModel != null) {
                recommendModel.B();
            }
            wi8.g().j(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
                if (this.c) {
                    return;
                }
                loadData();
                this.c = true;
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
            wi8.g().h(getUniqueId(), false);
        }
    }
}
