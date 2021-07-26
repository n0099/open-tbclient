package com.baidu.tieba.enterForum.tabfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.m0.d;
import d.a.q0.a0.t;
import d.a.q0.l0.l.b;
import d.a.q0.l0.l.e.a;
/* loaded from: classes4.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f14861e;

    /* renamed from: f  reason: collision with root package name */
    public String f14862f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumTabFeedNetModel f14863g;

    /* renamed from: h  reason: collision with root package name */
    public a f14864h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f14865i;
    public int j;

    public EnterForumTabFeedFragment() {
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

    public void M0(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (enterForumTabFeedNetModel = this.f14863g) == null) {
            return;
        }
        if (this.f14864h != null && z) {
            if (enterForumTabFeedNetModel.d()) {
                this.f14864h.t();
                this.f14864h.q(true);
            } else {
                hideNetRefreshView(this.f14865i);
                showLoadingView(this.f14865i);
            }
        }
        this.f14863g.refresh();
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.enter_forum_tab_feed_fragment : invokeV.intValue;
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14861e : (String) invokeV.objValue;
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.f14864h;
            if (aVar != null) {
                return aVar.k();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.l0.l.b
    public void X(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            if (!this.f14863g.d()) {
                showNoDataRefreshView(this.f14865i, false);
                return;
            }
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.o(i2, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a068" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.q = this.f14861e;
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            super.hideLoadingView(view);
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.r(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            super.hideNetRefreshView(view);
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.r(true);
            }
        }
    }

    @Override // d.a.q0.l0.l.b
    public void i() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (enterForumTabFeedNetModel = this.f14863g) == null) {
            return;
        }
        enterForumTabFeedNetModel.loadMore();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f14863g == null) {
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
                this.f14863g = enterForumTabFeedNetModel;
                enterForumTabFeedNetModel.U(this.f14862f, this.f14861e);
                this.f14863g.S();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.l(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle == null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f14861e = bundle.getString("tab_name");
                this.f14862f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(N0(), (ViewGroup) null);
            this.f14865i = viewGroup2;
            this.f14864h = new a(this, this, viewGroup2, this.f14861e);
            this.j = (l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2;
            return this.f14865i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            t.b().e(false);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14863g;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.destory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onLazyLoad();
            if (j.z()) {
                showLoadingView(this.f14865i);
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14863g;
                if (enterForumTabFeedNetModel != null) {
                    enterForumTabFeedNetModel.refresh();
                    return;
                }
                return;
            }
            showNetRefreshView(this.f14865i, null, true);
        }
    }

    @Override // d.a.p0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            M0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && j.z()) {
            hideNetRefreshView(this.f14865i);
            showLoadingView(this.f14865i);
            M0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            t.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                a aVar = this.f14864h;
                if (aVar != null) {
                    aVar.p();
                    return;
                }
                return;
            }
            a aVar2 = this.f14864h;
            if (aVar2 != null) {
                aVar2.n();
            }
        }
    }

    @Override // d.a.q0.l0.l.b
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, errorData) == null) {
            hideLoadingView(this.f14865i);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.f14863g.d()) {
                showNetRefreshView(this.f14865i, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.r(false);
            }
            super.showLoadingView(view, false, this.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048598, this, view, str, z) == null) {
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.r(false);
            }
            super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, view, z) == null) {
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.r(false);
            }
            super.showNoDataRefreshView(view, z);
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // d.a.q0.l0.l.b
    public void z0(d.a.q0.l0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            hideLoadingView(this.f14865i);
            if (!this.f14863g.d()) {
                showNoDataRefreshView(this.f14865i, false);
                return;
            }
            a aVar = this.f14864h;
            if (aVar != null) {
                aVar.m(bVar);
            }
        }
    }
}
