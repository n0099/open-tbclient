package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
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
import java.util.List;
/* loaded from: classes9.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_HISTORY_LIVING = 0;
    public static final int TYPE_HISTORY_WHOLE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaRecentHistoryModel f46980e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.w.f.f.c.a f46981f;

    /* renamed from: g  reason: collision with root package name */
    public int f46982g;

    /* renamed from: h  reason: collision with root package name */
    public h f46983h;

    /* renamed from: i  reason: collision with root package name */
    public f.g f46984i;
    public BdListView.p j;
    public AlaRecentHistoryModel.b k;

    /* loaded from: classes9.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f46985e;

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
            this.f46985e = alaRecentHistoryFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f46985e.f46980e == null) {
                return;
            }
            this.f46985e.f46980e.refresh();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f46986e;

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
            this.f46986e = alaRecentHistoryFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46986e.f46980e == null) {
                return;
            }
            this.f46986e.f46980e.loadMore();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AlaRecentHistoryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f46987a;

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
            this.f46987a = alaRecentHistoryFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<b.a.r0.w.f.f.b.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f46987a.f46981f.e();
                AlaRecentHistoryFragment alaRecentHistoryFragment = this.f46987a;
                alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.f46981f.g());
                this.f46987a.f46981f.o(list, z);
                if (!ListUtils.isEmpty(list)) {
                    this.f46987a.h(false, null, null);
                    return;
                }
                String string = this.f46987a.f46982g == 0 ? this.f46987a.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : this.f46987a.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip);
                AlaRecentHistoryFragment alaRecentHistoryFragment2 = this.f46987a;
                alaRecentHistoryFragment2.h(true, alaRecentHistoryFragment2.f46981f.g(), string);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f46987a.f46981f.e();
                if (z) {
                    this.f46987a.showToast(R.string.square_load_data_failed_tip);
                } else {
                    AlaRecentHistoryFragment alaRecentHistoryFragment = this.f46987a;
                    alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.f46981f.g(), str, false);
                }
                this.f46987a.f46981f.q();
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
        this.f46984i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
    }

    public static AlaRecentHistoryFragment newInstance(int i2) {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideNetRefreshView(this.f46981f.g());
            if (ListUtils.getCount(this.f46980e.getData()) == 0) {
                showLoadingView(this.f46981f.g());
            }
            AlaRecentHistoryModel alaRecentHistoryModel = this.f46980e;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.refresh();
            }
        }
    }

    public final void h(boolean z, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), viewGroup, str}) == null) {
            if (this.f46983h == null) {
                this.f46983h = new h(getPageContext().getPageActivity(), null);
            }
            if (z) {
                this.f46983h.attachView(viewGroup);
                this.f46983h.c().setVisibility(8);
                this.f46983h.l(null);
                this.f46983h.d().setVisibility(0);
                this.f46983h.d().setText(str);
                return;
            }
            this.f46983h.dettachView(viewGroup);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.w.f.f.c.a aVar = this.f46981f;
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
            this.f46982g = i2;
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
            this.f46980e = new AlaRecentHistoryModel(getPageContext(), this.f46982g, this.k);
            b.a.r0.w.f.f.c.a aVar = new b.a.r0.w.f.f.c.a(getPageContext(), this.f46982g);
            this.f46981f = aVar;
            aVar.p(this.f46984i);
            this.f46981f.r(this.j);
            g();
            if (this.f46982g == 0) {
                TiebaStatic.log("c12650");
            }
            return this.f46981f.h();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            AlaRecentHistoryModel alaRecentHistoryModel = this.f46980e;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.onDestroy();
            }
            b.a.r0.w.f.f.c.a aVar = this.f46981f;
            if (aVar != null) {
                aVar.l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g();
        }
    }
}
