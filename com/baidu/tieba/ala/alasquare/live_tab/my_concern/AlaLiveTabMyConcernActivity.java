package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.f0.h;
import d.a.q0.v.d.c.f.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasNotificationAccessOpen;
    public boolean isLoading;
    public d.a.q0.v.d.c.f.d.a mAlaLiveTabMyConcernView;
    public MyConcernTabModel.b mDataCallback;
    public boolean mHasMore;
    public MyConcernTabModel mModel;
    public View.OnClickListener mNetRefreshListener;
    public h mNetRefreshView;
    public CustomMessageListener mNotificationRemovedListener;
    public a.f onListViewCallBack;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabMyConcernActivity f14067a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity, Integer.valueOf(i2)};
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
            this.f14067a = alaLiveTabMyConcernActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14067a.deleteItem(d.a.q0.v.d.c.f.b.a.class);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabMyConcernActivity f14068a;

        public b(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14068a = alaLiveTabMyConcernActivity;
        }

        @Override // d.a.q0.v.d.c.f.d.a.f
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!j.z() || this.f14068a.isLoading) {
                    if (this.f14068a.mAlaLiveTabMyConcernView != null) {
                        this.f14068a.mAlaLiveTabMyConcernView.q(false);
                        return;
                    }
                    return;
                }
                this.f14068a.refreshData();
            }
        }

        @Override // d.a.q0.v.d.c.f.d.a.f
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && l.D() && this.f14068a.mHasMore && !this.f14068a.isLoading) {
                this.f14068a.isLoading = true;
                this.f14068a.mModel.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MyConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabMyConcernActivity f14069a;

        public c(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14069a = alaLiveTabMyConcernActivity;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void a(List<n> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f14069a.isLoading = false;
                this.f14069a.hideNetRefreshView();
                this.f14069a.mAlaLiveTabMyConcernView.q(false);
                AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.f14069a;
                alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.mAlaLiveTabMyConcernView.g());
                if (!ListUtils.isEmpty(list)) {
                    this.f14069a.mAlaLiveTabMyConcernView.p(list);
                } else {
                    this.f14069a.errorDealing(z2);
                }
                this.f14069a.mHasMore = z;
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f14069a.isLoading = false;
                AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.f14069a;
                alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.mAlaLiveTabMyConcernView.g());
                this.f14069a.mAlaLiveTabMyConcernView.q(false);
                this.f14069a.errorDealing(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabMyConcernActivity f14070e;

        public d(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14070e = alaLiveTabMyConcernActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14070e.refreshData();
            }
        }
    }

    public AlaLiveTabMyConcernActivity() {
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
        this.mHasMore = true;
        this.isLoading = false;
        this.hasNotificationAccessOpen = false;
        this.mNotificationRemovedListener = new a(this, 2921421);
        this.onListViewCallBack = new b(this);
        this.mDataCallback = new c(this);
        this.mNetRefreshListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteItem(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, cls) == null) {
            MyConcernTabModel myConcernTabModel = this.mModel;
            if (myConcernTabModel != null) {
                myConcernTabModel.E(cls);
            }
            d.a.q0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
            if (aVar != null) {
                aVar.o(cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorDealing(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65548, this, z) == null) && z) {
            showNetRefreshView(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.mNetRefreshListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (hVar = this.mNetRefreshView) == null) {
            return;
        }
        hVar.dettachView(this.mAlaLiveTabMyConcernView.f());
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            d.a.q0.v.d.c.f.d.a aVar = new d.a.q0.v.d.c.f.d.a(getPageContext());
            this.mAlaLiveTabMyConcernView = aVar;
            aVar.r(this.onListViewCallBack);
            setContentView(this.mAlaLiveTabMyConcernView.h());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.isLoading = true;
            this.mModel.C();
        }
    }

    private void showNetRefreshView(int i2, String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65552, this, i2, str, onClickListener) == null) {
            if (this.mNetRefreshView == null) {
                h hVar = new h(getPageContext().getPageActivity(), onClickListener);
                this.mNetRefreshView = hVar;
                hVar.g(null);
                this.mNetRefreshView.o();
                this.mNetRefreshView.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mNetRefreshView.i(i2);
            this.mNetRefreshView.l(null);
            this.mNetRefreshView.m(str);
            this.mNetRefreshView.onChangeSkinType();
            this.mNetRefreshView.dettachView(this.mAlaLiveTabMyConcernView.f());
            this.mNetRefreshView.attachView(this.mAlaLiveTabMyConcernView.f());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
            if (aVar != null) {
                aVar.l(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (!TbadkCoreApplication.isLogin()) {
                finish();
                return;
            }
            initView();
            this.hasNotificationAccessOpen = d.a.q0.v.d.c.f.c.a.a(getPageContext());
            MyConcernTabModel myConcernTabModel = new MyConcernTabModel(getPageContext());
            this.mModel = myConcernTabModel;
            myConcernTabModel.F(this.mDataCallback);
            if (!l.D()) {
                showNetRefreshView(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.mNetRefreshListener);
            } else {
                showLoadingView(this.mAlaLiveTabMyConcernView.g(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
                refreshData();
            }
            registerListener(this.mNotificationRemovedListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            MyConcernTabModel myConcernTabModel = this.mModel;
            if (myConcernTabModel != null) {
                myConcernTabModel.onDestroy();
            }
            hideLoadingView(this.mAlaLiveTabMyConcernView.g());
            d.a.q0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
            if (aVar != null) {
                aVar.m();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onNetRefreshButtonClicked();
            refreshData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            this.isLoading = false;
            d.a.q0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
            if (aVar != null) {
                aVar.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (this.hasNotificationAccessOpen || !d.a.q0.v.d.c.f.c.a.a(getPageContext())) {
                return;
            }
            deleteItem(d.a.q0.v.d.c.f.b.a.class);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, d.a.d.a.g
    public TbPageContext<AlaLiveTabMyConcernActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.getPageContext() : (TbPageContext) invokeV.objValue;
    }
}
