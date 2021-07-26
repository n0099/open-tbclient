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
import d.a.d.e.p.k;
import d.a.q0.l0.i.c.c;
import d.a.q0.l0.i.d.a;
/* loaded from: classes4.dex */
public class HotUserRankFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f14750e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f14751f;

    /* renamed from: g  reason: collision with root package name */
    public String f14752g;

    /* renamed from: h  reason: collision with root package name */
    public long f14753h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14754i;
    public d.a.q0.l0.i.d.a j;
    public BdListView.p k;
    public a.b l;

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f14755e;

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
            this.f14755e = hotUserRankFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f14755e.j.j()) {
                this.f14755e.X0();
                this.f14755e.f14751f.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f14756a;

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
            this.f14756a = hotUserRankFragment;
        }

        @Override // d.a.q0.l0.i.d.a.b
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (this.f14756a.isLoadingViewAttached()) {
                    HotUserRankFragment hotUserRankFragment = this.f14756a;
                    hotUserRankFragment.hideLoadingView(hotUserRankFragment.f14750e);
                }
                if (cVar != null) {
                    if (this.f14756a.j.f() == 2) {
                        if (this.f14756a.f14753h <= 0 && !TextUtils.isEmpty(this.f14756a.f14752g)) {
                            if (cVar.f60295a != null) {
                                if (this.f14756a.f14754i) {
                                    cVar.f60295a.f60281a = String.format(this.f14756a.getResources().getString(R.string.god_rank_category_name), this.f14756a.f14752g);
                                } else {
                                    cVar.f60295a.f60281a = String.format(this.f14756a.getResources().getString(R.string.hot_user_rank_category_name), this.f14756a.f14752g);
                                }
                            }
                        } else {
                            cVar.f60295a.f60281a = this.f14756a.getResources().getString(R.string.forum_hot_user_rank);
                        }
                        this.f14756a.f14751f.f(cVar.f60295a, !k.isEmpty(this.f14756a.f14752g));
                        if (this.f14756a.isResumed() || this.f14756a.getBaseFragmentActivity() != null) {
                            CustomMessage customMessage = new CustomMessage(2921447);
                            customMessage.setTag(this.f14756a.getBaseFragmentActivity().getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                    if (this.f14756a.j.g() != null) {
                        this.f14756a.f14751f.h(this.f14756a.j.g().f60296b);
                    }
                    if (this.f14756a.j.j()) {
                        return;
                    }
                    this.f14756a.f14751f.j(this.f14756a.f14752g);
                }
            }
        }

        @Override // d.a.q0.l0.i.d.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                HotUserRankFragment hotUserRankFragment = this.f14756a;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f14750e);
                HotUserRankFragment hotUserRankFragment2 = this.f14756a;
                hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f14750e, str, false);
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

    public d.a.q0.l0.i.d.a W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (d.a.q0.l0.i.d.a) invokeV.objValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.f14752g)) {
                this.j.i(this.f14752g);
                return;
            }
            long j = this.f14753h;
            if (j > 0) {
                this.j.h(j);
            }
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f14752g = str;
        }
    }

    public void Z0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f14753h = j;
        }
    }

    public void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f14754i = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f14751f.e(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            d.a.q0.l0.i.d.a aVar = new d.a.q0.l0.i.d.a(getUniqueId());
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
            if (this.f14750e == null) {
                View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
                this.f14750e = inflate;
                RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f14752g, this.f14753h);
                this.f14751f = rankListViewController;
                rankListViewController.g(this.k);
            }
            if (this.j.g() == null || ListUtils.isEmpty(this.j.g().f60296b)) {
                X0();
                showLoadingView(this.f14750e);
            }
            return this.f14750e;
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
            hideNetRefreshView(this.f14750e);
            X0();
            showLoadingView(this.f14750e);
        }
    }
}
