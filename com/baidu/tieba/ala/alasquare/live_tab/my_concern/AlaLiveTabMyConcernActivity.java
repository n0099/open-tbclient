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
import com.repackage.bo5;
import com.repackage.do5;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.li;
import com.repackage.t35;
import com.repackage.yn5;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasNotificationAccessOpen;
    public boolean isLoading;
    public do5 mAlaLiveTabMyConcernView;
    public MyConcernTabModel.b mDataCallback;
    public boolean mHasMore;
    public MyConcernTabModel mModel;
    public View.OnClickListener mNetRefreshListener;
    public t35 mNetRefreshView;
    public CustomMessageListener mNotificationRemovedListener;
    public do5.f onListViewCallBack;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.deleteItem(yn5.class);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements do5.f {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // com.repackage.do5.f
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!ji.z() || this.a.isLoading) {
                    if (this.a.mAlaLiveTabMyConcernView != null) {
                        this.a.mAlaLiveTabMyConcernView.q(false);
                        return;
                    }
                    return;
                }
                this.a.refreshData();
            }
        }

        @Override // com.repackage.do5.f
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && li.D() && this.a.mHasMore && !this.a.isLoading) {
                this.a.isLoading = true;
                this.a.mModel.D();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void a(List<jn> list, boolean z, boolean z2) {
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

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

        public d(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.refreshData();
            }
        }
    }

    public AlaLiveTabMyConcernActivity() {
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
                myConcernTabModel.G(cls);
            }
            do5 do5Var = this.mAlaLiveTabMyConcernView;
            if (do5Var != null) {
                do5Var.o(cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorDealing(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65548, this, z) == null) && z) {
            showNetRefreshView(R.drawable.new_pic_emotion_08, getResources().getString(R.string.obfuscated_res_0x7f0f0f95), this.mNetRefreshListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView() {
        t35 t35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (t35Var = this.mNetRefreshView) == null) {
            return;
        }
        t35Var.dettachView(this.mAlaLiveTabMyConcernView.f());
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            do5 do5Var = new do5(getPageContext());
            this.mAlaLiveTabMyConcernView = do5Var;
            do5Var.r(this.onListViewCallBack);
            setContentView(this.mAlaLiveTabMyConcernView.h());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.isLoading = true;
            this.mModel.E();
        }
    }

    private void showNetRefreshView(int i, String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65552, this, i, str, onClickListener) == null) {
            if (this.mNetRefreshView == null) {
                t35 t35Var = new t35(getPageContext().getPageActivity(), onClickListener);
                this.mNetRefreshView = t35Var;
                t35Var.g(null);
                this.mNetRefreshView.p();
                this.mNetRefreshView.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mNetRefreshView.i(i);
            this.mNetRefreshView.m(null);
            this.mNetRefreshView.n(str);
            this.mNetRefreshView.onChangeSkinType();
            this.mNetRefreshView.dettachView(this.mAlaLiveTabMyConcernView.f());
            this.mNetRefreshView.attachView(this.mAlaLiveTabMyConcernView.f());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            do5 do5Var = this.mAlaLiveTabMyConcernView;
            if (do5Var != null) {
                do5Var.l(i);
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
            this.hasNotificationAccessOpen = bo5.a(getPageContext());
            MyConcernTabModel myConcernTabModel = new MyConcernTabModel(getPageContext());
            this.mModel = myConcernTabModel;
            myConcernTabModel.H(this.mDataCallback);
            if (!li.D()) {
                showNetRefreshView(R.drawable.new_pic_emotion_08, getResources().getString(R.string.obfuscated_res_0x7f0f0f95), this.mNetRefreshListener);
            } else {
                showLoadingView(this.mAlaLiveTabMyConcernView.g(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a8));
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
            do5 do5Var = this.mAlaLiveTabMyConcernView;
            if (do5Var != null && do5Var.g() != null) {
                hideLoadingView(this.mAlaLiveTabMyConcernView.g());
            }
            do5 do5Var2 = this.mAlaLiveTabMyConcernView;
            if (do5Var2 != null) {
                do5Var2.m();
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
            do5 do5Var = this.mAlaLiveTabMyConcernView;
            if (do5Var != null) {
                do5Var.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (this.hasNotificationAccessOpen || !bo5.a(getPageContext())) {
                return;
            }
            deleteItem(yn5.class);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.repackage.c9
    public TbPageContext<AlaLiveTabMyConcernActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.getPageContext() : (TbPageContext) invokeV.objValue;
    }
}
