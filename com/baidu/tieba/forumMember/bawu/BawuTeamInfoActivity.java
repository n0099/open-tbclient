package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.aba;
import com.baidu.tieba.md7;
import com.baidu.tieba.sc7;
import com.baidu.tieba.tc7;
import com.baidu.tieba.uc7;
import com.baidu.tieba.wc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uc7 a;
    public sc7 b;
    public long c;
    public sc7.c d;
    public NoNetworkView.b e;

    /* loaded from: classes5.dex */
    public class a implements sc7.c {
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

        @Override // com.baidu.tieba.sc7.c
        public void a(ArrayList<wc7> arrayList, md7 md7Var, boolean z, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, md7Var, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
                if (!z) {
                    if (arrayList != null && arrayList.size() > 0) {
                        BawuTeamInfoActivity bawuTeamInfoActivity = this.a;
                        bawuTeamInfoActivity.hideLoadingView(bawuTeamInfoActivity.a.d());
                        this.a.a.k(arrayList, md7Var, false);
                    }
                    this.a.b.l(this.a.c);
                    return;
                }
                BawuTeamInfoActivity bawuTeamInfoActivity2 = this.a;
                bawuTeamInfoActivity2.hideLoadingView(bawuTeamInfoActivity2.a.d());
                if (i == 0) {
                    this.a.a.k(arrayList, md7Var, true);
                    return;
                }
                this.a.showToast(str);
                if (this.a.a.e()) {
                    this.a.a.j();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !z) {
                return;
            }
            this.a.z1();
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
        this.e = new b(this);
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aba.h(301007, BawuTeamSocketResponseMessage.class, false, false);
            aba.c(301007, CmdConfigHttp.BAWU_TEAM_INFO_CMD, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, true, false);
            aba.b(2003005, tc7.class);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            sc7 sc7Var = this.b;
            if (sc7Var != null) {
                sc7Var.h();
            }
            uc7 uc7Var = this.a;
            if (uc7Var != null) {
                uc7Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            z1();
        }
    }

    public void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            uc7 uc7Var = new uc7(this, this.c);
            this.a = uc7Var;
            uc7Var.h(this.e);
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            showLoadingView(this.a.d(), true);
            this.b.l(this.c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.f(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.c = getIntent().getLongExtra("forum_id", 0L);
            }
            A1();
            y1();
            initData();
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = new sc7();
            a aVar = new a(this);
            this.d = aVar;
            this.b.n(aVar);
            this.b.k(this.c);
            showLoadingView(this.a.d(), true);
        }
    }
}
