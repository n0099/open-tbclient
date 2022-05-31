package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ig8;
import com.repackage.m96;
import com.repackage.s86;
import com.repackage.t86;
import com.repackage.u86;
import com.repackage.w86;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public s86.c mDataCallback;
    public s86 mModel;
    public NoNetworkView.b mNetworkChangedListener;
    public u86 mView;

    /* loaded from: classes3.dex */
    public class a implements s86.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BawuTeamInfoActivity a;

        public a(BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bawuTeamInfoActivity;
        }

        @Override // com.repackage.s86.c
        public void a(ArrayList<w86> arrayList, m96 m96Var, boolean z, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, m96Var, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
                if (!z) {
                    if (arrayList != null && arrayList.size() > 0) {
                        BawuTeamInfoActivity bawuTeamInfoActivity = this.a;
                        bawuTeamInfoActivity.hideLoadingView(bawuTeamInfoActivity.mView.d());
                        this.a.mView.k(arrayList, m96Var, false);
                    }
                    this.a.mModel.m(this.a.forumId);
                    return;
                }
                BawuTeamInfoActivity bawuTeamInfoActivity2 = this.a;
                bawuTeamInfoActivity2.hideLoadingView(bawuTeamInfoActivity2.mView.d());
                if (i == 0) {
                    this.a.mView.k(arrayList, m96Var, true);
                    return;
                }
                this.a.showToast(str);
                if (this.a.mView.e()) {
                    this.a.mView.j();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BawuTeamInfoActivity a;

        public b(BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bawuTeamInfoActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.refreshData();
            }
        }
    }

    public BawuTeamInfoActivity() {
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
        this.mNetworkChangedListener = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            showLoadingView(this.mView.d(), true);
            this.mModel.m(this.forumId);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mModel = new s86();
            a aVar = new a(this);
            this.mDataCallback = aVar;
            this.mModel.o(aVar);
            this.mModel.l(this.forumId);
            showLoadingView(this.mView.d(), true);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u86 u86Var = new u86(this, this.forumId);
            this.mView = u86Var;
            u86Var.h(this.mNetworkChangedListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.f(i);
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
            s86 s86Var = this.mModel;
            if (s86Var != null) {
                s86Var.h();
            }
            u86 u86Var = this.mView;
            if (u86Var != null) {
                u86Var.g();
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
            ig8.h(301007, BawuTeamSocketResponseMessage.class, false, false);
            ig8.c(301007, CmdConfigHttp.BAWU_TEAM_INFO_CMD, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
            ig8.b(2003005, t86.class);
        }
    }
}
