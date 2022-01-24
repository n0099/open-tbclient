package com.baidu.tieba.enterForum.tabfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.q0.d;
import c.a.t0.g0.v;
import c.a.t0.v0.l.b;
import c.a.t0.v0.l.e.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_CODE = "tab_code";
    public static final String TAB_NAME = "tab_name";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f42693e;

    /* renamed from: f  reason: collision with root package name */
    public String f42694f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumTabFeedNetModel f42695g;

    /* renamed from: h  reason: collision with root package name */
    public a f42696h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f42697i;

    /* renamed from: j  reason: collision with root package name */
    public int f42698j;

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

    @Override // c.a.t0.v0.l.b
    public void callLoadMore() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (enterForumTabFeedNetModel = this.f42695g) == null) {
            return;
        }
        enterForumTabFeedNetModel.loadMore();
    }

    public void callRefresh(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (enterForumTabFeedNetModel = this.f42695g) == null) {
            return;
        }
        if (this.f42696h != null && z) {
            if (enterForumTabFeedNetModel.a()) {
                this.f42696h.t();
                this.f42696h.q(true);
            } else {
                hideNetRefreshView(this.f42697i);
                showLoadingView(this.f42697i);
            }
        }
        this.f42695g.refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a068" : (String) invokeV.objValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.enter_forum_tab_feed_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.f42693e;
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42693e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            super.hideLoadingView(view);
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.r(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            super.hideNetRefreshView(view);
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.r(true);
            }
        }
    }

    public boolean isAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a aVar = this.f42696h;
            if (aVar != null) {
                return aVar.k();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f42695g == null) {
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
                this.f42695g = enterForumTabFeedNetModel;
                enterForumTabFeedNetModel.U(this.f42694f, this.f42693e);
                this.f42695g.S();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.l(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle == null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f42693e = bundle.getString("tab_name");
                this.f42694f = bundle.getString("tab_code");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
            this.f42697i = viewGroup2;
            this.f42696h = new a(this, this, viewGroup2, this.f42693e);
            this.f42698j = (n.i(getContext()) - n.f(getContext(), R.dimen.tbds304)) / 2;
            return this.f42697i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            v.b().e(false);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f42695g;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.destory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onLazyLoad();
            if (l.z()) {
                showLoadingView(this.f42697i);
                EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f42695g;
                if (enterForumTabFeedNetModel != null) {
                    enterForumTabFeedNetModel.refresh();
                    return;
                }
                return;
            }
            showNetRefreshView(this.f42697i, null, true);
        }
    }

    @Override // c.a.s0.s.k0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            callRefresh(false);
        }
    }

    @Override // c.a.t0.v0.l.b
    public void onNetCallback(c.a.t0.v0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            hideLoadingView(this.f42697i);
            if (!this.f42695g.a()) {
                showNoDataRefreshView(this.f42697i, false);
                return;
            }
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.m(bVar);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && l.z()) {
            hideNetRefreshView(this.f42697i);
            showLoadingView(this.f42697i);
            callRefresh(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            v.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                a aVar = this.f42696h;
                if (aVar != null) {
                    aVar.p();
                    return;
                }
                return;
            }
            a aVar2 = this.f42696h;
            if (aVar2 != null) {
                aVar2.n();
            }
        }
    }

    @Override // c.a.t0.v0.l.b
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, errorData) == null) {
            hideLoadingView(this.f42697i);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.f42695g.a()) {
                showNetRefreshView(this.f42697i, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.q(false);
            }
        }
    }

    @Override // c.a.t0.v0.l.b
    public void removeListItems(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            if (!this.f42695g.a()) {
                showNoDataRefreshView(this.f42697i, false);
                return;
            }
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.o(i2, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.r(false);
            }
            super.showLoadingView(view, false, this.f42698j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048599, this, view, str, z) == null) {
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.r(false);
            }
            super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(n.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, view, z) == null) {
            a aVar = this.f42696h;
            if (aVar != null) {
                aVar.r(false);
            }
            super.showNoDataRefreshView(view, z);
            setNetRefreshViewTopMargin(n.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }
}
