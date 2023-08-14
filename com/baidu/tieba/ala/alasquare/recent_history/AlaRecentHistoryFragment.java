package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import com.baidu.tieba.i95;
import com.baidu.tieba.mb6;
import com.baidu.tieba.nb6;
import com.baidu.tieba.om5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaRecentHistoryModel a;
    public nb6 b;
    public int c;
    public om5 d;
    public i95.g e;
    public BdListView.p f;
    public AlaRecentHistoryModel.b g;

    /* loaded from: classes5.dex */
    public class a implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecentHistoryFragment a;

        public a(AlaRecentHistoryFragment alaRecentHistoryFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecentHistoryFragment;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.a != null) {
                this.a.a.refresh();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecentHistoryFragment a;

        public b(AlaRecentHistoryFragment alaRecentHistoryFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecentHistoryFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AlaRecentHistoryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecentHistoryFragment a;

        public c(AlaRecentHistoryFragment alaRecentHistoryFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecentHistoryFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<mb6> list) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.b.e();
                AlaRecentHistoryFragment alaRecentHistoryFragment = this.a;
                alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.b.g());
                this.a.b.o(list, z);
                if (ListUtils.isEmpty(list)) {
                    if (this.a.c == 0) {
                        string = this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f142b);
                    } else {
                        string = this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f142c);
                    }
                    AlaRecentHistoryFragment alaRecentHistoryFragment2 = this.a;
                    alaRecentHistoryFragment2.P1(true, alaRecentHistoryFragment2.b.g(), string);
                    return;
                }
                this.a.P1(false, null, null);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.b.e();
                if (z) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1435);
                } else {
                    AlaRecentHistoryFragment alaRecentHistoryFragment = this.a;
                    alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.b.g(), str, false);
                }
                this.a.b.q();
            }
        }
    }

    public AlaRecentHistoryFragment() {
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
        this.e = new a(this);
        this.f = new b(this);
        this.g = new c(this);
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideNetRefreshView(this.b.g());
            if (ListUtils.getCount(this.a.getData()) == 0) {
                showLoadingView(this.b.g());
            }
            AlaRecentHistoryModel alaRecentHistoryModel = this.a;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.refresh();
            }
        }
    }

    public static AlaRecentHistoryFragment N1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            AlaRecentHistoryFragment alaRecentHistoryFragment = new AlaRecentHistoryFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key_type", i);
            alaRecentHistoryFragment.setArguments(bundle);
            return alaRecentHistoryFragment;
        }
        return (AlaRecentHistoryFragment) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            nb6 nb6Var = this.b;
            if (nb6Var != null) {
                nb6Var.k(i);
            }
        }
    }

    public final void P1(boolean z, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), viewGroup, str}) == null) {
            if (this.d == null) {
                this.d = new om5(getPageContext().getPageActivity(), null);
            }
            if (z) {
                this.d.attachView(viewGroup);
                this.d.b().setVisibility(8);
                this.d.l(null);
                this.d.c().setVisibility(0);
                this.d.c().setText(str);
                return;
            }
            this.d.dettachView(viewGroup);
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
            int i = arguments.getInt("key_type");
            this.c = i;
            if (i >= 0 && i <= 1) {
                return;
            }
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = new AlaRecentHistoryModel(getPageContext(), this.c, this.g);
            nb6 nb6Var = new nb6(getPageContext(), this.c);
            this.b = nb6Var;
            nb6Var.p(this.e);
            this.b.r(this.f);
            O1();
            if (this.c == 0) {
                TiebaStatic.log("c12650");
            }
            return this.b.h();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            AlaRecentHistoryModel alaRecentHistoryModel = this.a;
            if (alaRecentHistoryModel != null) {
                alaRecentHistoryModel.onDestroy();
            }
            nb6 nb6Var = this.b;
            if (nb6Var != null) {
                nb6Var.l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            O1();
        }
    }
}
