package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.o0.r.f0.f;
import d.a.p0.u0.q0;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameRecommendFragment extends BaseFragment implements q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.u0.t1.e.a f15732e;

    /* renamed from: f  reason: collision with root package name */
    public AlaGameRecommendModel f15733f;

    /* renamed from: g  reason: collision with root package name */
    public String f15734g;

    /* renamed from: h  reason: collision with root package name */
    public String f15735h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f15736i;
    public AlaGameRecommendModel.b j;
    public f.g k;
    public BdListView.p l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f15737a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsGameRecommendFragment frsGameRecommendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameRecommendFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15737a = frsGameRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == d.a.c.e.m.b.d(split[1], 0)) {
                this.f15737a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaGameRecommendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f15738a;

        public b(FrsGameRecommendFragment frsGameRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15738a = frsGameRecommendFragment;
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f15738a.f15732e.b();
                FrsGameRecommendFragment frsGameRecommendFragment = this.f15738a;
                frsGameRecommendFragment.hideNetRefreshView(frsGameRecommendFragment.f15732e.d());
                FrsGameRecommendFragment frsGameRecommendFragment2 = this.f15738a;
                frsGameRecommendFragment2.hideLoadingView(frsGameRecommendFragment2.f15732e.d());
                this.f15738a.f15732e.k(list, z);
            }
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f15738a.f15732e.b();
                if (z) {
                    this.f15738a.showToast(R.string.card_vr_video_load_failed);
                } else {
                    FrsGameRecommendFragment frsGameRecommendFragment = this.f15738a;
                    frsGameRecommendFragment.showNetRefreshView(frsGameRecommendFragment.f15732e.d(), str, false);
                }
                this.f15738a.f15732e.m();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f15739e;

        public c(FrsGameRecommendFragment frsGameRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15739e = frsGameRecommendFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f15739e.f15733f != null) {
                        this.f15739e.f15733f.F();
                        return;
                    }
                    return;
                }
                this.f15739e.showToast(R.string.neterror);
                this.f15739e.f15732e.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f15740e;

        public d(FrsGameRecommendFragment frsGameRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15740e = frsGameRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15740e.f15733f == null) {
                return;
            }
            this.f15740e.f15733f.loadMore();
        }
    }

    public FrsGameRecommendFragment() {
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
        this.f15736i = new a(this, 0);
        this.j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
    }

    public static FrsGameRecommendFragment L0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            FrsGameRecommendFragment frsGameRecommendFragment = new FrsGameRecommendFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            frsGameRecommendFragment.setArguments(bundle);
            return frsGameRecommendFragment;
        }
        return (FrsGameRecommendFragment) invokeLL.objValue;
    }

    @Override // d.a.p0.u0.q0
    public NavigationBar g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15732e.e() : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        d.a.p0.u0.t1.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (aVar = this.f15732e) == null) {
            return;
        }
        aVar.i(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            this.f15734g = arguments.getString("forum_id");
            this.f15735h = arguments.getString("forum_name");
            d.a.p0.u0.t1.e.a aVar = new d.a.p0.u0.t1.e.a(getPageContext(), this.f15734g, this.f15735h);
            this.f15732e = aVar;
            aVar.l(this.k);
            this.f15732e.n(this.l);
            MessageManager.getInstance().registerListener(2001446, this.f15736i);
            this.f15733f = new AlaGameRecommendModel(this.f15734g, this.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) ? this.f15732e.f() : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            d.a.p0.u0.t1.e.a aVar = this.f15732e;
            if (aVar != null) {
                aVar.j();
            }
            AlaGameRecommendModel alaGameRecommendModel = this.f15733f;
            if (alaGameRecommendModel != null) {
                alaGameRecommendModel.onDestroy();
            }
            if (this.f15736i != null) {
                MessageManager.getInstance().unRegisterListener(this.f15736i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        AlaGameRecommendModel alaGameRecommendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaGameRecommendModel = this.f15733f) == null) {
            return;
        }
        alaGameRecommendModel.F();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaGameRecommendModel alaGameRecommendModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && (alaGameRecommendModel = this.f15733f) != null) {
                if (alaGameRecommendModel.d()) {
                    s();
                    return;
                }
                this.f15733f.F();
                showLoadingView(this.f15732e.d());
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15732e.c();
        }
    }
}
