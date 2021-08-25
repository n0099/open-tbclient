package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.f0.h;
import c.a.p0.s.f0.f;
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
/* loaded from: classes7.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_HISTORY_LIVING = 0;
    public static final int TYPE_HISTORY_WHOLE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaRecentHistoryModel f49356e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.v.d.f.c.a f49357f;

    /* renamed from: g  reason: collision with root package name */
    public int f49358g;

    /* renamed from: h  reason: collision with root package name */
    public h f49359h;

    /* renamed from: i  reason: collision with root package name */
    public f.g f49360i;

    /* renamed from: j  reason: collision with root package name */
    public BdListView.p f49361j;
    public AlaRecentHistoryModel.b k;

    /* loaded from: classes7.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f49362e;

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
            this.f49362e = alaRecentHistoryFragment;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f49362e.f49356e == null) {
                return;
            }
            this.f49362e.f49356e.refresh();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f49363e;

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
            this.f49363e = alaRecentHistoryFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49363e.f49356e == null) {
                return;
            }
            this.f49363e.f49356e.loadMore();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AlaRecentHistoryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryFragment f49364a;

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
            this.f49364a = alaRecentHistoryFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<c.a.q0.v.d.f.b.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f49364a.f49357f.e();
                AlaRecentHistoryFragment alaRecentHistoryFragment = this.f49364a;
                alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.f49357f.g());
                this.f49364a.f49357f.o(list, z);
                if (!ListUtils.isEmpty(list)) {
                    this.f49364a.h(false, null, null);
                    return;
                }
                String string = this.f49364a.f49358g == 0 ? this.f49364a.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : this.f49364a.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip);
                AlaRecentHistoryFragment alaRecentHistoryFragment2 = this.f49364a;
                alaRecentHistoryFragment2.h(true, alaRecentHistoryFragment2.f49357f.g(), string);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f49364a.f49357f.e();
                if (z) {
                    this.f49364a.showToast(R.string.square_load_data_failed_tip);
                } else {
                    AlaRecentHistoryFragment alaRecentHistoryFragment = this.f49364a;
                    alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.f49357f.g(), str, false);
                }
                this.f49364a.f49357f.q();
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
        this.f49360i = new a(this);
        this.f49361j = new b(this);
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
            hideNetRefreshView(this.f49357f.g());
            if (ListUtils.getCount(this.f49356e.getData()) == 0) {
                showLoadingView(this.f49357f.g());
            }
            AlaRecentHistoryModel alaRecentHistoryModel = this.f49356e;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.refresh();
            }
        }
    }

    public final void h(boolean z, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), viewGroup, str}) == null) {
            if (this.f49359h == null) {
                this.f49359h = new h(getPageContext().getPageActivity(), null);
            }
            if (z) {
                this.f49359h.attachView(viewGroup);
                this.f49359h.c().setVisibility(8);
                this.f49359h.l(null);
                this.f49359h.d().setVisibility(0);
                this.f49359h.d().setText(str);
                return;
            }
            this.f49359h.dettachView(viewGroup);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.v.d.f.c.a aVar = this.f49357f;
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
            this.f49358g = i2;
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
            this.f49356e = new AlaRecentHistoryModel(getPageContext(), this.f49358g, this.k);
            c.a.q0.v.d.f.c.a aVar = new c.a.q0.v.d.f.c.a(getPageContext(), this.f49358g);
            this.f49357f = aVar;
            aVar.p(this.f49360i);
            this.f49357f.r(this.f49361j);
            g();
            if (this.f49358g == 0) {
                TiebaStatic.log("c12650");
            }
            return this.f49357f.h();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            AlaRecentHistoryModel alaRecentHistoryModel = this.f49356e;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.onDestroy();
            }
            c.a.q0.v.d.f.c.a aVar = this.f49357f;
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
