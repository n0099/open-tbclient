package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaRecentHistoryModel f14102e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.v.d.e.c.a f14103f;

    /* renamed from: g  reason: collision with root package name */
    public int f14104g;

    /* renamed from: h  reason: collision with root package name */
    public h f14105h;

    /* renamed from: i  reason: collision with root package name */
    public f.g f14106i;
    public BdListView.p j;
    public AlaRecentHistoryModel.b k;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f14107e;

        public a(AlaRecentHistoryFragment alaRecentHistoryFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14107e = alaRecentHistoryFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14107e.f14102e == null) {
                return;
            }
            this.f14107e.f14102e.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f14108e;

        public b(AlaRecentHistoryFragment alaRecentHistoryFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14108e = alaRecentHistoryFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14108e.f14102e == null) {
                return;
            }
            this.f14108e.f14102e.loadMore();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaRecentHistoryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f14109a;

        public c(AlaRecentHistoryFragment alaRecentHistoryFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14109a = alaRecentHistoryFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<d.a.q0.v.d.e.b.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f14109a.f14103f.e();
                AlaRecentHistoryFragment alaRecentHistoryFragment = this.f14109a;
                alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.f14103f.g());
                this.f14109a.f14103f.o(list, z);
                if (!ListUtils.isEmpty(list)) {
                    this.f14109a.T0(false, null, null);
                    return;
                }
                String string = this.f14109a.f14104g == 0 ? this.f14109a.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : this.f14109a.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip);
                AlaRecentHistoryFragment alaRecentHistoryFragment2 = this.f14109a;
                alaRecentHistoryFragment2.T0(true, alaRecentHistoryFragment2.f14103f.g(), string);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f14109a.f14103f.e();
                if (z) {
                    this.f14109a.showToast(R.string.square_load_data_failed_tip);
                } else {
                    AlaRecentHistoryFragment alaRecentHistoryFragment = this.f14109a;
                    alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.f14103f.g(), str, false);
                }
                this.f14109a.f14103f.q();
            }
        }
    }

    public AlaRecentHistoryFragment() {
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
        this.f14106i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
    }

    public static AlaRecentHistoryFragment R0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            AlaRecentHistoryFragment alaRecentHistoryFragment = new AlaRecentHistoryFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key_type", i2);
            alaRecentHistoryFragment.setArguments(bundle);
            return alaRecentHistoryFragment;
        }
        return (AlaRecentHistoryFragment) invokeI.objValue;
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideNetRefreshView(this.f14103f.g());
            if (ListUtils.getCount(this.f14102e.getData()) == 0) {
                showLoadingView(this.f14103f.g());
            }
            AlaRecentHistoryModel alaRecentHistoryModel = this.f14102e;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.refresh();
            }
        }
    }

    public final void T0(boolean z, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), viewGroup, str}) == null) {
            if (this.f14105h == null) {
                this.f14105h = new h(getPageContext().getPageActivity(), null);
            }
            if (z) {
                this.f14105h.attachView(viewGroup);
                this.f14105h.c().setVisibility(8);
                this.f14105h.l(null);
                this.f14105h.d().setVisibility(0);
                this.f14105h.d().setText(str);
                return;
            }
            this.f14105h.dettachView(viewGroup);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.v.d.e.c.a aVar = this.f14103f;
            if (aVar != null) {
                aVar.k(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            int i2 = arguments.getInt("key_type");
            this.f14104g = i2;
            if (i2 < 0 || i2 > 1) {
                getPageContext().getPageActivity().finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f14102e = new AlaRecentHistoryModel(getPageContext(), this.f14104g, this.k);
            d.a.q0.v.d.e.c.a aVar = new d.a.q0.v.d.e.c.a(getPageContext(), this.f14104g);
            this.f14103f = aVar;
            aVar.p(this.f14106i);
            this.f14103f.r(this.j);
            S0();
            if (this.f14104g == 0) {
                TiebaStatic.log("c12650");
            }
            return this.f14103f.h();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            AlaRecentHistoryModel alaRecentHistoryModel = this.f14102e;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.onDestroy();
            }
            d.a.q0.v.d.e.c.a aVar = this.f14103f;
            if (aVar != null) {
                aVar.l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            S0();
        }
    }
}
