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
import com.repackage.k56;
import com.repackage.li;
import com.repackage.m56;
/* loaded from: classes3.dex */
public class HotUserRankFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public RankListViewController b;
    public String c;
    public long d;
    public boolean e;
    public m56 f;
    public BdListView.p g;
    public m56.b h;

    /* loaded from: classes3.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankFragment a;

        public a(HotUserRankFragment hotUserRankFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f.j()) {
                this.a.N0();
                this.a.b.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements m56.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankFragment a;

        public b(HotUserRankFragment hotUserRankFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankFragment;
        }

        @Override // com.repackage.m56.b
        public void a(k56 k56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k56Var) == null) {
                if (this.a.isLoadingViewAttached()) {
                    HotUserRankFragment hotUserRankFragment = this.a;
                    hotUserRankFragment.hideLoadingView(hotUserRankFragment.a);
                }
                if (k56Var != null) {
                    if (this.a.f.f() == 2) {
                        if (this.a.d <= 0 && !TextUtils.isEmpty(this.a.c)) {
                            if (k56Var.a != null) {
                                if (this.a.e) {
                                    k56Var.a.a = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07ca), this.a.c);
                                } else {
                                    k56Var.a.a = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f088f), this.a.c);
                                }
                            }
                        } else {
                            k56Var.a.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0670);
                        }
                        this.a.b.f(k56Var.a, !li.isEmpty(this.a.c));
                        if (this.a.isResumed() || this.a.getBaseFragmentActivity() != null) {
                            CustomMessage customMessage = new CustomMessage(2921447);
                            customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, k56Var);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                    if (this.a.f.g() != null) {
                        this.a.b.h(this.a.f.g().b);
                    }
                    if (this.a.f.j()) {
                        return;
                    }
                    this.a.b.j(this.a.c);
                }
            }
        }

        @Override // com.repackage.m56.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                HotUserRankFragment hotUserRankFragment = this.a;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.a);
                HotUserRankFragment hotUserRankFragment2 = this.a;
                hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.a, str, false);
            }
        }
    }

    public HotUserRankFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = new b(this);
    }

    public m56 M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (m56) invokeV.objValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.c)) {
                this.f.i(this.c);
                return;
            }
            long j = this.d;
            if (j > 0) {
                this.f.h(j);
            }
        }
    }

    public void O0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    public void P0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.d = j;
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.e(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            m56 m56Var = new m56(getUniqueId());
            this.f = m56Var;
            m56Var.n(this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.a == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02d8, (ViewGroup) null);
                this.a = inflate;
                RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.obfuscated_res_0x7f0919ff), this.c, this.d);
                this.b = rankListViewController;
                rankListViewController.g(this.g);
            }
            if (this.f.g() == null || ListUtils.isEmpty(this.f.g().b)) {
                N0();
                showLoadingView(this.a);
            }
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.f.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideNetRefreshView(this.a);
            N0();
            showLoadingView(this.a);
        }
    }
}
