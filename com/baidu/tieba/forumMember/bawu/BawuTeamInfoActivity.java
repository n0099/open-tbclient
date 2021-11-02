package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import b.a.r0.v0.a.e;
import b.a.r0.v0.a.f;
import b.a.r0.v0.a.g;
import b.a.r0.v0.a.i;
import b.a.r0.v0.c.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public e.c mDataCallback;
    public e mModel;
    public NoNetworkView.b mNetworkChangedListener;
    public g mView;

    /* loaded from: classes9.dex */
    public class a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BawuTeamInfoActivity f48163a;

        public a(BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48163a = bawuTeamInfoActivity;
        }

        @Override // b.a.r0.v0.a.e.c
        public void a(ArrayList<i> arrayList, l lVar, boolean z, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, lVar, Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) {
                if (!z) {
                    if (arrayList != null && arrayList.size() > 0) {
                        BawuTeamInfoActivity bawuTeamInfoActivity = this.f48163a;
                        bawuTeamInfoActivity.hideLoadingView(bawuTeamInfoActivity.mView.d());
                        this.f48163a.mView.k(arrayList, lVar, false);
                    }
                    this.f48163a.mModel.i(this.f48163a.forumId);
                    return;
                }
                BawuTeamInfoActivity bawuTeamInfoActivity2 = this.f48163a;
                bawuTeamInfoActivity2.hideLoadingView(bawuTeamInfoActivity2.mView.d());
                if (i2 == 0) {
                    this.f48163a.mView.k(arrayList, lVar, true);
                    return;
                }
                this.f48163a.showToast(str);
                if (this.f48163a.mView.e()) {
                    this.f48163a.mView.j();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BawuTeamInfoActivity f48164e;

        public b(BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48164e = bawuTeamInfoActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f48164e.refreshData();
            }
        }
    }

    public BawuTeamInfoActivity() {
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
        this.mNetworkChangedListener = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            showLoadingView(this.mView.d(), true);
            this.mModel.i(this.forumId);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mModel = new e();
            a aVar = new a(this);
            this.mDataCallback = aVar;
            this.mModel.k(aVar);
            this.mModel.h(this.forumId);
            showLoadingView(this.mView.d(), true);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g gVar = new g(this);
            this.mView = gVar;
            gVar.h(this.mNetworkChangedListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.f(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.forumId = getIntent().getLongExtra("forum_id", 0L);
            }
            registerTask();
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            e eVar = this.mModel;
            if (eVar != null) {
                eVar.g();
            }
            g gVar = this.mView;
            if (gVar != null) {
                gVar.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            refreshData();
        }
    }

    public void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.r0.l3.f0.a.h(301007, BawuTeamSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(301007, CmdConfigHttp.BAWU_TEAM_INFO_CMD, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
            b.a.r0.l3.f0.a.b(2003005, f.class);
        }
    }
}
