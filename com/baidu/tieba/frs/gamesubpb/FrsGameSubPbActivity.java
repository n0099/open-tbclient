package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.al6;
import com.repackage.cl6;
import com.repackage.el6;
import com.repackage.uo;
import com.repackage.yk6;
import com.repackage.zk6;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMMENT_PUBLISH_SUCCESS = 1002;
    public static final int START_ACTIVITY_REQUEST_CODE = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAddComment;
    public boolean isDelComment;
    public View.OnClickListener mCommonClickListener;
    public int mForumId;
    public yk6 mHalfToFullScreenController;
    public String mMainTowerId;
    public zk6 mSubPbModel;
    public el6 mSubPbView;

    /* loaded from: classes3.dex */
    public class a implements yk6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ FrsGameSubPbActivity b;

        public a(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsGameSubPbActivity;
            this.a = false;
        }

        @Override // com.repackage.yk6.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.mSubPbView.P(false);
                this.a = true;
            }
        }

        @Override // com.repackage.yk6.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.yk6.e
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!this.a) {
                    return this.b.mSubPbView.y() != null && this.b.mSubPbView.y().getTop() == 0;
                }
                this.a = false;
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameSubPbActivity a;

        public b(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameSubPbActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mSubPbModel == null) {
                return;
            }
            this.a.mSubPbModel.h(true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements zk6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameSubPbActivity a;

        public c(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameSubPbActivity;
        }

        @Override // com.repackage.zk6.d
        public void a(boolean z, int i, String str, boolean z2, boolean z3, al6 al6Var, List<uo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Boolean.valueOf(z3), al6Var, list}) == null) {
                if (this.a.mHalfToFullScreenController != null && this.a.mHalfToFullScreenController.h()) {
                    this.a.mHalfToFullScreenController.k(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity frsGameSubPbActivity = this.a;
                    frsGameSubPbActivity.hideNetRefreshView(frsGameSubPbActivity.mSubPbView.x());
                    this.a.mSubPbView.O(z2, al6Var, list);
                    if (ListUtils.isEmpty(list)) {
                        return;
                    }
                    uo uoVar = list.get(list.size() - 1);
                    if (uoVar instanceof cl6) {
                        this.a.mSubPbModel.m(((cl6) uoVar).a);
                    }
                } else if (z3) {
                } else {
                    FrsGameSubPbActivity frsGameSubPbActivity2 = this.a;
                    frsGameSubPbActivity2.setNetRefreshViewTopMargin(frsGameSubPbActivity2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023f));
                    FrsGameSubPbActivity frsGameSubPbActivity3 = this.a;
                    View x = frsGameSubPbActivity3.mSubPbView.x();
                    if (TextUtils.isEmpty(str)) {
                        str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f69);
                    }
                    frsGameSubPbActivity3.showNetRefreshView(x, str, false);
                    if (this.a.mHalfToFullScreenController != null) {
                        this.a.mHalfToFullScreenController.i();
                    }
                }
            }
        }

        @Override // com.repackage.zk6.d
        public void b(boolean z, int i, String str, cl6 cl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, cl6Var}) == null) {
                this.a.mSubPbView.z(z, str, cl6Var);
                if (z) {
                    this.a.isAddComment = true;
                }
            }
        }

        @Override // com.repackage.zk6.d
        public void c(boolean z, int i, String str, cl6 cl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, cl6Var}) == null) {
                this.a.mSubPbView.A(z, str, cl6Var);
                if (z) {
                    this.a.isDelComment = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameSubPbActivity a;

        public d(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 == null && this.a.mSubPbView == null) && view2 == this.a.mSubPbView.w() && this.a.checkUpIsLogin()) {
                    if (this.a.mHalfToFullScreenController != null) {
                        this.a.mHalfToFullScreenController.i();
                    }
                    this.a.mSubPbView.t(null);
                }
            }
        }
    }

    public FrsGameSubPbActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void dealIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            Intent intent = getIntent();
            this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
            this.mMainTowerId = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
        }
    }

    private void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mCommonClickListener = new d(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.isAddComment || this.isDelComment) {
                setResult(1002);
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSubPbView.D(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            if (getIntent() == null) {
                finish();
            }
            dealIntent();
            if (this.mForumId <= 0 || TextUtils.isEmpty(this.mMainTowerId)) {
                finish();
            }
            initListeners();
            el6 el6Var = new el6(this, this.mCommonClickListener, this.mMainTowerId);
            this.mSubPbView = el6Var;
            setContentView(el6Var.x());
            yk6 yk6Var = new yk6(this, this.mSubPbView.u(), this.mSubPbView.v());
            this.mHalfToFullScreenController = yk6Var;
            yk6Var.g();
            this.mHalfToFullScreenController.j(new a(this));
            this.mSubPbView.H(this.mHalfToFullScreenController);
            this.mSubPbView.P(true);
            this.mSubPbView.I(new b(this));
            zk6 zk6Var = new zk6(this, this.mForumId, this.mMainTowerId);
            this.mSubPbModel = zk6Var;
            zk6Var.l(new c(this));
            this.mSubPbModel.h(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            el6 el6Var = this.mSubPbView;
            if (el6Var != null) {
                el6Var.E();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onNetRefreshButtonClicked();
            this.mSubPbModel.h(false);
        }
    }
}
