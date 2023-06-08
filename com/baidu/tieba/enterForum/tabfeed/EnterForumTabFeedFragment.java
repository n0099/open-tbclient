package com.baidu.tieba.enterForum.tabfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
import com.baidu.tieba.hz6;
import com.baidu.tieba.vi;
import com.baidu.tieba.vr5;
import com.baidu.tieba.wz6;
import com.baidu.tieba.yz6;
import com.baidu.tieba.zn6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements hz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public EnterForumTabFeedNetModel c;
    public yz6 d;
    public ViewGroup e;
    public int f;

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d02af : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.sr5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a068" : (String) invokeV.objValue;
    }

    public EnterForumTabFeedFragment() {
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

    public String J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                return yz6Var.k();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public vr5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            vr5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.a;
            }
            return pageStayDurationItem;
        }
        return (vr5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hz6
    public void j() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (enterForumTabFeedNetModel = this.c) != null) {
            enterForumTabFeedNetModel.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            zn6.b().e(false);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.c;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.destory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                showLoadingView(this.e);
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.c;
                if (enterForumTabFeedNetModel != null) {
                    enterForumTabFeedNetModel.refresh();
                    return;
                }
                return;
            }
            showNetRefreshView(this.e, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.e);
            showLoadingView(this.e);
            H1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            zn6.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                yz6 yz6Var = this.d;
                if (yz6Var != null) {
                    yz6Var.p();
                    return;
                }
                return;
            }
            yz6 yz6Var2 = this.d;
            if (yz6Var2 != null) {
                yz6Var2.n();
            }
        }
    }

    @Override // com.baidu.tieba.hz6
    public void H0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (!this.c.d()) {
                showNoDataRefreshView(this.e, false);
                return;
            }
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.o(i, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, view2, z) == null) {
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.r(false);
            }
            super.showNoDataRefreshView(view2, z);
            setNetRefreshViewTopMargin(vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703c3));
        }
    }

    public void H1(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (enterForumTabFeedNetModel = this.c) != null) {
            if (this.d != null && z) {
                if (enterForumTabFeedNetModel.d()) {
                    this.d.t();
                    this.d.q(true);
                } else {
                    hideNetRefreshView(this.e);
                    showLoadingView(this.e);
                }
            }
            this.c.refresh();
        }
    }

    @Override // com.baidu.tieba.w95.g
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            H1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            super.hideLoadingView(view2);
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.r(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            super.hideNetRefreshView(view2);
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.r(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.c == null) {
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
                this.c = enterForumTabFeedNetModel;
                enterForumTabFeedNetModel.s0(this.b, this.a);
                this.c.q0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.l(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle == null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.a = bundle.getString("tab_name");
                this.b = bundle.getString("tab_code");
            }
        }
    }

    @Override // com.baidu.tieba.hz6
    public void q1(wz6 wz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, wz6Var) == null) {
            hideLoadingView(this.e);
            if (!this.c.d()) {
                showNoDataRefreshView(this.e, false);
                return;
            }
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.m(wz6Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.r(false);
            }
            super.showLoadingView(view2, false, this.f);
        }
    }

    @Override // com.baidu.tieba.hz6
    public void g(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, errorData) == null) {
            hideLoadingView(this.e);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0a2f);
                }
            }
            if (!this.c.d()) {
                String str = null;
                if (errorData != null) {
                    str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
                }
                showNetRefreshView(this.e, str, true);
            }
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(I1(), (ViewGroup) null);
            this.e = viewGroup2;
            this.d = new yz6(this, this, viewGroup2, this.a);
            this.f = (vi.j(getContext()) - vi.g(getContext(), R.dimen.tbds304)) / 2;
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048599, this, view2, str, z) == null) {
            yz6 yz6Var = this.d;
            if (yz6Var != null) {
                yz6Var.r(false);
            }
            super.showNetRefreshView(view2, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703c3));
        }
    }
}
