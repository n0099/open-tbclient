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
import com.baidu.tieba.b26;
import com.baidu.tieba.bb6;
import com.baidu.tieba.ej;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
import com.baidu.tieba.ka6;
import com.baidu.tieba.xc5;
import com.baidu.tieba.za6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements ka6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public EnterForumTabFeedNetModel c;
    public bb6 d;
    public ViewGroup e;
    public int f;

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

    @Override // com.baidu.tieba.yx4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            q1(false);
        }
    }

    @Override // com.baidu.tieba.ka6
    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorData) == null) {
            hideLoadingView(this.e);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.c.a()) {
                showNetRefreshView(this.e, errorData != null ? getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c58, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a068" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public xc5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            xc5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.a;
            }
            return pageStayDurationItem;
        }
        return (xc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.hideLoadingView(view2);
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.r(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            super.hideNetRefreshView(view2);
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.r(true);
            }
        }
    }

    @Override // com.baidu.tieba.ka6
    public void i() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (enterForumTabFeedNetModel = this.c) == null) {
            return;
        }
        enterForumTabFeedNetModel.b();
    }

    @Override // com.baidu.tieba.ka6
    public void n1(za6 za6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, za6Var) == null) {
            hideLoadingView(this.e);
            if (!this.c.a()) {
                showNoDataRefreshView(this.e, false);
                return;
            }
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.m(za6Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.c == null) {
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
                this.c = enterForumTabFeedNetModel;
                enterForumTabFeedNetModel.X(this.b, this.a);
                this.c.V();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.l(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(r1(), (ViewGroup) null);
            this.e = viewGroup2;
            this.d = new bb6(this, this, viewGroup2, this.a);
            this.f = (ej.i(getContext()) - ej.f(getContext(), R.dimen.tbds304)) / 2;
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            b26.b().e(false);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.c;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.destory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.e);
            showLoadingView(this.e);
            q1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            b26.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                bb6 bb6Var = this.d;
                if (bb6Var != null) {
                    bb6Var.p();
                    return;
                }
                return;
            }
            bb6 bb6Var2 = this.d;
            if (bb6Var2 != null) {
                bb6Var2.n();
            }
        }
    }

    public void q1(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (enterForumTabFeedNetModel = this.c) == null) {
            return;
        }
        if (this.d != null && z) {
            if (enterForumTabFeedNetModel.a()) {
                this.d.t();
                this.d.q(true);
            } else {
                hideNetRefreshView(this.e);
                showLoadingView(this.e);
            }
        }
        this.c.refresh();
    }

    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R.layout.obfuscated_res_0x7f0d0275 : invokeV.intValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.r(false);
            }
            super.showLoadingView(view2, false, this.f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, view2, str, z) == null) {
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.r(false);
            }
            super.showNetRefreshView(view2, getString(R.string.obfuscated_res_0x7f0f0fd9), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ab));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, view2, z) == null) {
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.r(false);
            }
            super.showNoDataRefreshView(view2, z);
            setNetRefreshViewTopMargin(ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ab));
        }
    }

    public boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                return bb6Var.k();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka6
    public void x0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            if (!this.c.a()) {
                showNoDataRefreshView(this.e, false);
                return;
            }
            bb6 bb6Var = this.d;
            if (bb6Var != null) {
                bb6Var.o(i, i2);
            }
        }
    }
}
