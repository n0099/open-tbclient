package com.baidu.tieba.enterForum.hotuserrank;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.r0.o0.i.c.c;
import b.a.r0.o0.i.d.a;
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
/* loaded from: classes8.dex */
public class HotUserRankFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f48504e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f48505f;

    /* renamed from: g  reason: collision with root package name */
    public String f48506g;

    /* renamed from: h  reason: collision with root package name */
    public long f48507h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48508i;
    public b.a.r0.o0.i.d.a j;
    public BdListView.p k;
    public a.b l;

    /* loaded from: classes8.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f48509e;

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
            this.f48509e = hotUserRankFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48509e.j.j()) {
                this.f48509e.k();
                this.f48509e.f48505f.i();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f48510a;

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
            this.f48510a = hotUserRankFragment;
        }

        @Override // b.a.r0.o0.i.d.a.b
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (this.f48510a.isLoadingViewAttached()) {
                    HotUserRankFragment hotUserRankFragment = this.f48510a;
                    hotUserRankFragment.hideLoadingView(hotUserRankFragment.f48504e);
                }
                if (cVar != null) {
                    if (this.f48510a.j.f() == 2) {
                        if (this.f48510a.f48507h <= 0 && !TextUtils.isEmpty(this.f48510a.f48506g)) {
                            if (cVar.f23198a != null) {
                                if (this.f48510a.f48508i) {
                                    cVar.f23198a.f23184a = String.format(this.f48510a.getResources().getString(R.string.god_rank_category_name), this.f48510a.f48506g);
                                } else {
                                    cVar.f23198a.f23184a = String.format(this.f48510a.getResources().getString(R.string.hot_user_rank_category_name), this.f48510a.f48506g);
                                }
                            }
                        } else {
                            cVar.f23198a.f23184a = this.f48510a.getResources().getString(R.string.forum_hot_user_rank);
                        }
                        this.f48510a.f48505f.f(cVar.f23198a, !k.isEmpty(this.f48510a.f48506g));
                        if (this.f48510a.isResumed() || this.f48510a.getBaseFragmentActivity() != null) {
                            CustomMessage customMessage = new CustomMessage(2921447);
                            customMessage.setTag(this.f48510a.getBaseFragmentActivity().getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                    if (this.f48510a.j.g() != null) {
                        this.f48510a.f48505f.h(this.f48510a.j.g().f23199b);
                    }
                    if (this.f48510a.j.j()) {
                        return;
                    }
                    this.f48510a.f48505f.j(this.f48510a.f48506g);
                }
            }
        }

        @Override // b.a.r0.o0.i.d.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                HotUserRankFragment hotUserRankFragment = this.f48510a;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f48504e);
                HotUserRankFragment hotUserRankFragment2 = this.f48510a;
                hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f48504e, str, false);
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

    public b.a.r0.o0.i.d.a getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (b.a.r0.o0.i.d.a) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.f48506g)) {
                this.j.i(this.f48506g);
                return;
            }
            long j = this.f48507h;
            if (j > 0) {
                this.j.h(j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f48505f.e(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            b.a.r0.o0.i.d.a aVar = new b.a.r0.o0.i.d.a(getUniqueId());
            this.j = aVar;
            aVar.n(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f48504e == null) {
                View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
                this.f48504e = inflate;
                RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f48506g, this.f48507h);
                this.f48505f = rankListViewController;
                rankListViewController.g(this.k);
            }
            if (this.j.g() == null || ListUtils.isEmpty(this.j.g().f23199b)) {
                k();
                showLoadingView(this.f48504e);
            }
            return this.f48504e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.j.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideNetRefreshView(this.f48504e);
            k();
            showLoadingView(this.f48504e);
        }
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f48506g = str;
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f48507h = j;
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f48508i = z;
        }
    }
}
