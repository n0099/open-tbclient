package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.h;
import c.a.t0.a0.f.c.f.d.a;
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
import java.util.List;
/* loaded from: classes12.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasNotificationAccessOpen;
    public boolean isLoading;
    public c.a.t0.a0.f.c.f.d.a mAlaLiveTabMyConcernView;
    public MyConcernTabModel.b mDataCallback;
    public boolean mHasMore;
    public MyConcernTabModel mModel;
    public View.OnClickListener mNetRefreshListener;
    public h mNetRefreshView;
    public CustomMessageListener mNotificationRemovedListener;
    public a.f onListViewCallBack;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

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
            this.a = alaLiveTabMyConcernActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.deleteItem(c.a.t0.a0.f.c.f.b.a.class);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

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
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // c.a.t0.a0.f.c.f.d.a.f
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!l.z() || this.a.isLoading) {
                    if (this.a.mAlaLiveTabMyConcernView != null) {
                        this.a.mAlaLiveTabMyConcernView.q(false);
                        return;
                    }
                    return;
                }
                this.a.refreshData();
            }
        }

        @Override // c.a.t0.a0.f.c.f.d.a.f
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && n.C() && this.a.mHasMore && !this.a.isLoading) {
                this.a.isLoading = true;
                this.a.mModel.B();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements MyConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

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
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void a(List<c.a.d.n.e.n> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.isLoading = false;
                this.a.hideNetRefreshView();
                this.a.mAlaLiveTabMyConcernView.q(false);
                AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.a;
                alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.mAlaLiveTabMyConcernView.g());
                if (!ListUtils.isEmpty(list)) {
                    this.a.mAlaLiveTabMyConcernView.p(list);
                } else {
                    this.a.errorDealing(z2);
                }
                this.a.mHasMore = z;
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.isLoading = false;
                AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.a;
                alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.mAlaLiveTabMyConcernView.g());
                this.a.mAlaLiveTabMyConcernView.q(false);
                this.a.errorDealing(z);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabMyConcernActivity f41953e;

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
            this.f41953e = alaLiveTabMyConcernActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41953e.refreshData();
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
            c.a.t0.a0.f.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
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
            c.a.t0.a0.f.c.f.d.a aVar = new c.a.t0.a0.f.c.f.d.a(getPageContext());
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
                this.mNetRefreshView.p();
                this.mNetRefreshView.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mNetRefreshView.i(i2);
            this.mNetRefreshView.m(null);
            this.mNetRefreshView.n(str);
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
            c.a.t0.a0.f.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
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
            this.hasNotificationAccessOpen = c.a.t0.a0.f.c.f.c.a.a(getPageContext());
            MyConcernTabModel myConcernTabModel = new MyConcernTabModel(getPageContext());
            this.mModel = myConcernTabModel;
            myConcernTabModel.F(this.mDataCallback);
            if (!n.C()) {
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
            c.a.t0.a0.f.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
            if (aVar != null && aVar.g() != null) {
                hideLoadingView(this.mAlaLiveTabMyConcernView.g());
            }
            c.a.t0.a0.f.c.f.d.a aVar2 = this.mAlaLiveTabMyConcernView;
            if (aVar2 != null) {
                aVar2.m();
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
            c.a.t0.a0.f.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
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
            if (this.hasNotificationAccessOpen || !c.a.t0.a0.f.c.f.c.a.a(getPageContext())) {
                return;
            }
            deleteItem(c.a.t0.a0.f.c.f.b.a.class);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, c.a.d.a.g
    public TbPageContext<AlaLiveTabMyConcernActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.getPageContext() : (TbPageContext) invokeV.objValue;
    }
}
