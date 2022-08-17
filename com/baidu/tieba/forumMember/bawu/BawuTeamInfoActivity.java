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
import com.repackage.bd6;
import com.repackage.hc6;
import com.repackage.ic6;
import com.repackage.jc6;
import com.repackage.jk8;
import com.repackage.lc6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jc6 a;
    public hc6 b;
    public long c;
    public hc6.c d;
    public NoNetworkView.b e;

    /* loaded from: classes3.dex */
    public class a implements hc6.c {
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

        @Override // com.repackage.hc6.c
        public void a(ArrayList<lc6> arrayList, bd6 bd6Var, boolean z, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, bd6Var, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
                if (!z) {
                    if (arrayList != null && arrayList.size() > 0) {
                        BawuTeamInfoActivity bawuTeamInfoActivity = this.a;
                        bawuTeamInfoActivity.hideLoadingView(bawuTeamInfoActivity.a.d());
                        this.a.a.k(arrayList, bd6Var, false);
                    }
                    this.a.b.l(this.a.c);
                    return;
                }
                BawuTeamInfoActivity bawuTeamInfoActivity2 = this.a;
                bawuTeamInfoActivity2.hideLoadingView(bawuTeamInfoActivity2.a.d());
                if (i == 0) {
                    this.a.a.k(arrayList, bd6Var, true);
                    return;
                }
                this.a.showToast(str);
                if (this.a.a.e()) {
                    this.a.a.j();
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
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.E1();
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
        this.e = new b(this);
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jc6 jc6Var = new jc6(this, this.c);
            this.a = jc6Var;
            jc6Var.h(this.e);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            showLoadingView(this.a.d(), true);
            this.b.l(this.c);
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jk8.h(301007, BawuTeamSocketResponseMessage.class, false, false);
            jk8.c(301007, CmdConfigHttp.BAWU_TEAM_INFO_CMD, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
            jk8.b(2003005, ic6.class);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = new hc6();
            a aVar = new a(this);
            this.d = aVar;
            this.b.n(aVar);
            this.b.k(this.c);
            showLoadingView(this.a.d(), true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.f(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.c = getIntent().getLongExtra("forum_id", 0L);
            }
            F1();
            D1();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            hc6 hc6Var = this.b;
            if (hc6Var != null) {
                hc6Var.h();
            }
            jc6 jc6Var = this.a;
            if (jc6Var != null) {
                jc6Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            E1();
        }
    }
}
