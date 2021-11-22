package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.f.p.j;
import b.a.e.m.e.n;
import b.a.q0.s.g0.f;
import b.a.r0.x0.r0;
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
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameRecommendFragment extends BaseFragment implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.x0.f2.e.a f49461e;

    /* renamed from: f  reason: collision with root package name */
    public AlaGameRecommendModel f49462f;

    /* renamed from: g  reason: collision with root package name */
    public String f49463g;

    /* renamed from: h  reason: collision with root package name */
    public String f49464h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f49465i;
    public AlaGameRecommendModel.b j;
    public f.g k;
    public BdListView.p l;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f49466a;

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
            this.f49466a = frsGameRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.a.e.f.m.b.e(split[1], 0)) {
                this.f49466a.forceRefresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AlaGameRecommendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f49467a;

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
            this.f49467a = frsGameRecommendFragment;
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f49467a.f49461e.b();
                FrsGameRecommendFragment frsGameRecommendFragment = this.f49467a;
                frsGameRecommendFragment.hideNetRefreshView(frsGameRecommendFragment.f49461e.d());
                FrsGameRecommendFragment frsGameRecommendFragment2 = this.f49467a;
                frsGameRecommendFragment2.hideLoadingView(frsGameRecommendFragment2.f49461e.d());
                this.f49467a.f49461e.k(list, z);
            }
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f49467a.f49461e.b();
                if (z) {
                    this.f49467a.showToast(R.string.card_vr_video_load_failed);
                } else {
                    FrsGameRecommendFragment frsGameRecommendFragment = this.f49467a;
                    frsGameRecommendFragment.showNetRefreshView(frsGameRecommendFragment.f49461e.d(), str, false);
                }
                this.f49467a.f49461e.m();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f49468e;

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
            this.f49468e = frsGameRecommendFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f49468e.f49462f != null) {
                        this.f49468e.f49462f.loadData();
                        return;
                    }
                    return;
                }
                this.f49468e.showToast(R.string.neterror);
                this.f49468e.f49461e.b();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f49469e;

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
            this.f49469e = frsGameRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49469e.f49462f == null) {
                return;
            }
            this.f49469e.f49462f.loadMore();
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
        this.f49465i = new a(this, 0);
        this.j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
    }

    public static FrsGameRecommendFragment newInstance(String str, String str2) {
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

    public final void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49461e.c();
        }
    }

    @Override // b.a.r0.x0.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49461e.e() : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        b.a.r0.x0.f2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (aVar = this.f49461e) == null) {
            return;
        }
        aVar.i(i2);
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
            this.f49463g = arguments.getString("forum_id");
            this.f49464h = arguments.getString("forum_name");
            b.a.r0.x0.f2.e.a aVar = new b.a.r0.x0.f2.e.a(getPageContext(), this.f49463g, this.f49464h);
            this.f49461e = aVar;
            aVar.l(this.k);
            this.f49461e.n(this.l);
            MessageManager.getInstance().registerListener(2001446, this.f49465i);
            this.f49462f = new AlaGameRecommendModel(this.f49463g, this.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) ? this.f49461e.f() : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            b.a.r0.x0.f2.e.a aVar = this.f49461e;
            if (aVar != null) {
                aVar.j();
            }
            AlaGameRecommendModel alaGameRecommendModel = this.f49462f;
            if (alaGameRecommendModel != null) {
                alaGameRecommendModel.onDestroy();
            }
            if (this.f49465i != null) {
                MessageManager.getInstance().unRegisterListener(this.f49465i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        AlaGameRecommendModel alaGameRecommendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (alaGameRecommendModel = this.f49462f) == null) {
            return;
        }
        alaGameRecommendModel.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaGameRecommendModel alaGameRecommendModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && (alaGameRecommendModel = this.f49462f) != null) {
                if (alaGameRecommendModel.a()) {
                    forceRefresh();
                    return;
                }
                this.f49462f.loadData();
                showLoadingView(this.f49461e.d());
            }
        }
    }
}
