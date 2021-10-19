package com.baidu.tieba.enterForum.hotuserrank;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.r0.o0.i.c.c;
import c.a.r0.o0.i.d.a;
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
/* loaded from: classes7.dex */
public class HotUserRankFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f50242e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f50243f;

    /* renamed from: g  reason: collision with root package name */
    public String f50244g;

    /* renamed from: h  reason: collision with root package name */
    public long f50245h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50246i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.o0.i.d.a f50247j;
    public BdListView.p k;
    public a.b l;

    /* loaded from: classes7.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f50248e;

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
            this.f50248e = hotUserRankFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50248e.f50247j.j()) {
                this.f50248e.k();
                this.f50248e.f50243f.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotUserRankFragment f50249a;

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
            this.f50249a = hotUserRankFragment;
        }

        @Override // c.a.r0.o0.i.d.a.b
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (this.f50249a.isLoadingViewAttached()) {
                    HotUserRankFragment hotUserRankFragment = this.f50249a;
                    hotUserRankFragment.hideLoadingView(hotUserRankFragment.f50242e);
                }
                if (cVar != null) {
                    if (this.f50249a.f50247j.f() == 2) {
                        if (this.f50249a.f50245h <= 0 && !TextUtils.isEmpty(this.f50249a.f50244g)) {
                            if (cVar.f22828a != null) {
                                if (this.f50249a.f50246i) {
                                    cVar.f22828a.f22814a = String.format(this.f50249a.getResources().getString(R.string.god_rank_category_name), this.f50249a.f50244g);
                                } else {
                                    cVar.f22828a.f22814a = String.format(this.f50249a.getResources().getString(R.string.hot_user_rank_category_name), this.f50249a.f50244g);
                                }
                            }
                        } else {
                            cVar.f22828a.f22814a = this.f50249a.getResources().getString(R.string.forum_hot_user_rank);
                        }
                        this.f50249a.f50243f.f(cVar.f22828a, !k.isEmpty(this.f50249a.f50244g));
                        if (this.f50249a.isResumed() || this.f50249a.getBaseFragmentActivity() != null) {
                            CustomMessage customMessage = new CustomMessage(2921447);
                            customMessage.setTag(this.f50249a.getBaseFragmentActivity().getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                    if (this.f50249a.f50247j.g() != null) {
                        this.f50249a.f50243f.h(this.f50249a.f50247j.g().f22829b);
                    }
                    if (this.f50249a.f50247j.j()) {
                        return;
                    }
                    this.f50249a.f50243f.j(this.f50249a.f50244g);
                }
            }
        }

        @Override // c.a.r0.o0.i.d.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                HotUserRankFragment hotUserRankFragment = this.f50249a;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f50242e);
                HotUserRankFragment hotUserRankFragment2 = this.f50249a;
                hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f50242e, str, false);
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

    public c.a.r0.o0.i.d.a getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50247j : (c.a.r0.o0.i.d.a) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.f50244g)) {
                this.f50247j.i(this.f50244g);
                return;
            }
            long j2 = this.f50245h;
            if (j2 > 0) {
                this.f50247j.h(j2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f50243f.e(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.r0.o0.i.d.a aVar = new c.a.r0.o0.i.d.a(getUniqueId());
            this.f50247j = aVar;
            aVar.n(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f50242e == null) {
                View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
                this.f50242e = inflate;
                RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f50244g, this.f50245h);
                this.f50243f = rankListViewController;
                rankListViewController.g(this.k);
            }
            if (this.f50247j.g() == null || ListUtils.isEmpty(this.f50247j.g().f22829b)) {
                k();
                showLoadingView(this.f50242e);
            }
            return this.f50242e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.f50247j.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideNetRefreshView(this.f50242e);
            k();
            showLoadingView(this.f50242e);
        }
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f50244g = str;
        }
    }

    public void setForumId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f50245h = j2;
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f50246i = z;
        }
    }
}
