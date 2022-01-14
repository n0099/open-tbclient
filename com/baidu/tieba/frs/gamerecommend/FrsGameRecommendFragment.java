package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.j0.f;
import c.a.t0.d1.r0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes12.dex */
public class FrsGameRecommendFragment extends BaseFragment implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.d1.g2.e.a f43403e;

    /* renamed from: f  reason: collision with root package name */
    public AlaGameRecommendModel f43404f;

    /* renamed from: g  reason: collision with root package name */
    public String f43405g;

    /* renamed from: h  reason: collision with root package name */
    public String f43406h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f43407i;

    /* renamed from: j  reason: collision with root package name */
    public AlaGameRecommendModel.b f43408j;
    public f.g k;
    public BdListView.p l;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRecommendFragment a;

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
            this.a = frsGameRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == c.a.d.f.m.b.e(split[1], 0)) {
                this.a.forceRefresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements AlaGameRecommendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRecommendFragment a;

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
            this.a = frsGameRecommendFragment;
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.f43403e.b();
                FrsGameRecommendFragment frsGameRecommendFragment = this.a;
                frsGameRecommendFragment.hideNetRefreshView(frsGameRecommendFragment.f43403e.d());
                FrsGameRecommendFragment frsGameRecommendFragment2 = this.a;
                frsGameRecommendFragment2.hideLoadingView(frsGameRecommendFragment2.f43403e.d());
                this.a.f43403e.k(list, z);
            }
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.a.f43403e.b();
                if (z) {
                    this.a.showToast(R.string.card_vr_video_load_failed);
                } else {
                    FrsGameRecommendFragment frsGameRecommendFragment = this.a;
                    frsGameRecommendFragment.showNetRefreshView(frsGameRecommendFragment.f43403e.d(), str, false);
                }
                this.a.f43403e.m();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f43409e;

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
            this.f43409e = frsGameRecommendFragment;
        }

        @Override // c.a.s0.s.j0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    if (this.f43409e.f43404f != null) {
                        this.f43409e.f43404f.loadData();
                        return;
                    }
                    return;
                }
                this.f43409e.showToast(R.string.neterror);
                this.f43409e.f43403e.b();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameRecommendFragment f43410e;

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
            this.f43410e = frsGameRecommendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43410e.f43404f == null) {
                return;
            }
            this.f43410e.f43404f.loadMore();
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
        this.f43407i = new a(this, 0);
        this.f43408j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
    }

    public static FrsGameRecommendFragment newInstance(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
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
            this.f43403e.c();
        }
    }

    @Override // c.a.t0.d1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43403e.e() : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        c.a.t0.d1.g2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (aVar = this.f43403e) == null) {
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
            this.f43405g = arguments.getString("forum_id");
            this.f43406h = arguments.getString("forum_name");
            c.a.t0.d1.g2.e.a aVar = new c.a.t0.d1.g2.e.a(getPageContext(), this.f43405g, this.f43406h);
            this.f43403e = aVar;
            aVar.l(this.k);
            this.f43403e.n(this.l);
            MessageManager.getInstance().registerListener(2001446, this.f43407i);
            this.f43404f = new AlaGameRecommendModel(this.f43405g, this.f43408j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) ? this.f43403e.f() : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            c.a.t0.d1.g2.e.a aVar = this.f43403e;
            if (aVar != null) {
                aVar.j();
            }
            AlaGameRecommendModel alaGameRecommendModel = this.f43404f;
            if (alaGameRecommendModel != null) {
                alaGameRecommendModel.onDestroy();
            }
            if (this.f43407i != null) {
                MessageManager.getInstance().unRegisterListener(this.f43407i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        AlaGameRecommendModel alaGameRecommendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (alaGameRecommendModel = this.f43404f) == null) {
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
            if (isAdded() && isPrimary() && (alaGameRecommendModel = this.f43404f) != null) {
                if (alaGameRecommendModel.a()) {
                    forceRefresh();
                    return;
                }
                this.f43404f.loadData();
                showLoadingView(this.f43403e.d());
            }
        }
    }
}
