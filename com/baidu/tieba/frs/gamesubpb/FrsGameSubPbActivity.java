package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import b.a.e.l.e.n;
import b.a.r0.x0.g2.c;
import b.a.r0.x0.g2.d.a;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMMENT_PUBLISH_SUCCESS = 1002;
    public static final int START_ACTIVITY_REQUEST_CODE = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAddComment;
    public boolean isDelComment;
    public View.OnClickListener mCommonClickListener;
    public int mForumId;
    public b.a.r0.x0.g2.c mHalfToFullScreenController;
    public String mMainTowerId;
    public b.a.r0.x0.g2.d.a mSubPbModel;
    public b.a.r0.x0.g2.e.a mSubPbView;

    /* loaded from: classes9.dex */
    public class a implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f48646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsGameSubPbActivity f48647b;

        public a(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48647b = frsGameSubPbActivity;
            this.f48646a = false;
        }

        @Override // b.a.r0.x0.g2.c.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48647b.mSubPbView.P(false);
                this.f48646a = true;
            }
        }

        @Override // b.a.r0.x0.g2.c.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.r0.x0.g2.c.e
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!this.f48646a) {
                    return this.f48647b.mSubPbView.y() != null && this.f48647b.mSubPbView.y().getTop() == 0;
                }
                this.f48646a = false;
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameSubPbActivity f48648e;

        public b(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48648e = frsGameSubPbActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48648e.mSubPbModel == null) {
                return;
            }
            this.f48648e.mSubPbModel.h(true);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGameSubPbActivity f48649a;

        public c(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48649a = frsGameSubPbActivity;
        }

        @Override // b.a.r0.x0.g2.d.a.d
        public void a(boolean z, int i2, String str, boolean z2, boolean z3, b.a.r0.x0.g2.d.b bVar, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Boolean.valueOf(z3), bVar, list}) == null) {
                if (this.f48649a.mHalfToFullScreenController != null && this.f48649a.mHalfToFullScreenController.h()) {
                    this.f48649a.mHalfToFullScreenController.k(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity frsGameSubPbActivity = this.f48649a;
                    frsGameSubPbActivity.hideNetRefreshView(frsGameSubPbActivity.mSubPbView.x());
                    this.f48649a.mSubPbView.O(z2, bVar, list);
                    if (ListUtils.isEmpty(list)) {
                        return;
                    }
                    n nVar = list.get(list.size() - 1);
                    if (nVar instanceof b.a.r0.x0.g2.d.d) {
                        this.f48649a.mSubPbModel.m(((b.a.r0.x0.g2.d.d) nVar).f25786e);
                    }
                } else if (z3) {
                } else {
                    FrsGameSubPbActivity frsGameSubPbActivity2 = this.f48649a;
                    frsGameSubPbActivity2.setNetRefreshViewTopMargin(frsGameSubPbActivity2.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity3 = this.f48649a;
                    View x = frsGameSubPbActivity3.mSubPbView.x();
                    if (TextUtils.isEmpty(str)) {
                        str = this.f48649a.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity3.showNetRefreshView(x, str, false);
                    if (this.f48649a.mHalfToFullScreenController != null) {
                        this.f48649a.mHalfToFullScreenController.i();
                    }
                }
            }
        }

        @Override // b.a.r0.x0.g2.d.a.d
        public void b(boolean z, int i2, String str, b.a.r0.x0.g2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, dVar}) == null) {
                this.f48649a.mSubPbView.z(z, str, dVar);
                if (z) {
                    this.f48649a.isAddComment = true;
                }
            }
        }

        @Override // b.a.r0.x0.g2.d.a.d
        public void c(boolean z, int i2, String str, b.a.r0.x0.g2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, dVar}) == null) {
                this.f48649a.mSubPbView.A(z, str, dVar);
                if (z) {
                    this.f48649a.isDelComment = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameSubPbActivity f48650e;

        public d(FrsGameSubPbActivity frsGameSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48650e = frsGameSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view == null && this.f48650e.mSubPbView == null) && view == this.f48650e.mSubPbView.w() && this.f48650e.checkUpIsLogin()) {
                    if (this.f48650e.mHalfToFullScreenController != null) {
                        this.f48650e.mHalfToFullScreenController.i();
                    }
                    this.f48650e.mSubPbView.t(null);
                }
            }
        }
    }

    public FrsGameSubPbActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void dealIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSubPbView.D(i2);
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
            b.a.r0.x0.g2.e.a aVar = new b.a.r0.x0.g2.e.a(this, this.mCommonClickListener, this.mMainTowerId);
            this.mSubPbView = aVar;
            setContentView(aVar.x());
            b.a.r0.x0.g2.c cVar = new b.a.r0.x0.g2.c(this, this.mSubPbView.u(), this.mSubPbView.v());
            this.mHalfToFullScreenController = cVar;
            cVar.g();
            this.mHalfToFullScreenController.j(new a(this));
            this.mSubPbView.H(this.mHalfToFullScreenController);
            this.mSubPbView.P(true);
            this.mSubPbView.I(new b(this));
            b.a.r0.x0.g2.d.a aVar2 = new b.a.r0.x0.g2.d.a(this, this.mForumId, this.mMainTowerId);
            this.mSubPbModel = aVar2;
            aVar2.l(new c(this));
            this.mSubPbModel.h(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            b.a.r0.x0.g2.e.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.E();
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
