package com.baidu.tieba.enterForum.hotuserrank;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.s0.l0.i.c.c;
import d.a.s0.l0.i.d.a;
/* loaded from: classes5.dex */
public class HotUserRankFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f14663e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f14664f;

    /* renamed from: g  reason: collision with root package name */
    public String f14665g;

    /* renamed from: h  reason: collision with root package name */
    public long f14666h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14667i;
    public d.a.s0.l0.i.d.a j;
    public BdListView.p k;
    public a.b l;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f14668e;

        public a(HotUserRankFragment hotUserRankFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14668e = hotUserRankFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f14668e.j.j()) {
                this.f14668e.R0();
                this.f14668e.f14664f.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f14669a;

        public b(HotUserRankFragment hotUserRankFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14669a = hotUserRankFragment;
        }

        @Override // d.a.s0.l0.i.d.a.b
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (this.f14669a.isLoadingViewAttached()) {
                    HotUserRankFragment hotUserRankFragment = this.f14669a;
                    hotUserRankFragment.hideLoadingView(hotUserRankFragment.f14663e);
                }
                if (cVar != null) {
                    if (this.f14669a.j.f() == 2) {
                        if (this.f14669a.f14666h <= 0 && !TextUtils.isEmpty(this.f14669a.f14665g)) {
                            if (cVar.f62918a != null) {
                                if (this.f14669a.f14667i) {
                                    cVar.f62918a.f62904a = String.format(this.f14669a.getResources().getString(R.string.god_rank_category_name), this.f14669a.f14665g);
                                } else {
                                    cVar.f62918a.f62904a = String.format(this.f14669a.getResources().getString(R.string.hot_user_rank_category_name), this.f14669a.f14665g);
                                }
                            }
                        } else {
                            cVar.f62918a.f62904a = this.f14669a.getResources().getString(R.string.forum_hot_user_rank);
                        }
                        this.f14669a.f14664f.f(cVar.f62918a, !k.isEmpty(this.f14669a.f14665g));
                        if (this.f14669a.isResumed() || this.f14669a.getBaseFragmentActivity() != null) {
                            CustomMessage customMessage = new CustomMessage(2921447);
                            customMessage.setTag(this.f14669a.getBaseFragmentActivity().getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                    if (this.f14669a.j.g() != null) {
                        this.f14669a.f14664f.h(this.f14669a.j.g().f62919b);
                    }
                    if (this.f14669a.j.j()) {
                        return;
                    }
                    this.f14669a.f14664f.j(this.f14669a.f14665g);
                }
            }
        }

        @Override // d.a.s0.l0.i.d.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                HotUserRankFragment hotUserRankFragment = this.f14669a;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f14663e);
                HotUserRankFragment hotUserRankFragment2 = this.f14669a;
                hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f14663e, str, false);
            }
        }
    }

    public HotUserRankFragment() {
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
        this.k = new a(this);
        this.l = new b(this);
    }

    public d.a.s0.l0.i.d.a Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (d.a.s0.l0.i.d.a) invokeV.objValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.f14665g)) {
                this.j.i(this.f14665g);
                return;
            }
            long j = this.f14666h;
            if (j > 0) {
                this.j.h(j);
            }
        }
    }

    public void S0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f14665g = str;
        }
    }

    public void T0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f14666h = j;
        }
    }

    public void U0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f14667i = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f14664f.e(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            d.a.s0.l0.i.d.a aVar = new d.a.s0.l0.i.d.a(getUniqueId());
            this.j = aVar;
            aVar.n(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f14663e == null) {
                View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
                this.f14663e = inflate;
                RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f14665g, this.f14666h);
                this.f14664f = rankListViewController;
                rankListViewController.g(this.k);
            }
            if (this.j.g() == null || ListUtils.isEmpty(this.j.g().f62919b)) {
                R0();
                showLoadingView(this.f14663e);
            }
            return this.f14663e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.j.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideNetRefreshView(this.f14663e);
            R0();
            showLoadingView(this.f14663e);
        }
    }
}
