package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k77;
import com.repackage.pi;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements RecommendDetailModel.e, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k77 a;
    public RecommendDetailModel b;
    public long c;
    public String d;
    public String e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendDetailActivity a;

        public a(RecommendDetailActivity recommendDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.l(this.a.a.l, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendDetailActivity a;

        public b(RecommendDetailActivity recommendDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.l(this.a.a.l, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ RecommendDetailActivity b;

        public c(RecommendDetailActivity recommendDetailActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recommendDetailActivity;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.l(this.b.a.m, !this.a);
            }
        }
    }

    public RecommendDetailActivity() {
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

    public final void B1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle != null) {
                this.c = bundle.getLong("user_id", 0L);
                this.d = bundle.getString("user_name");
                this.e = bundle.getString(RecommendDetailActivityConfig.USER_PORTRAIT);
                return;
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getLongExtra("user_id", 0L);
                this.d = intent.getStringExtra("user_name");
                this.e = intent.getStringExtra(RecommendDetailActivityConfig.USER_PORTRAIT);
            }
        }
    }

    public void C1(boolean z) {
        RecommendDetailModel recommendDetailModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (recommendDetailModel = this.b) == null) {
            return;
        }
        recommendDetailModel.K(z);
    }

    public void D1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mHandler.postDelayed(new c(this, z), 500L);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void W(UserInfoBigVip userInfoBigVip, boolean z) {
        k77 k77Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, userInfoBigVip, z) == null) || (k77Var = this.a) == null || userInfoBigVip == null) {
            return;
        }
        k77Var.g();
        this.a.p(userInfoBigVip, z);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.a == null) {
            return;
        }
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.c), true);
            this.a.i();
            return;
        }
        this.mHandler.postDelayed(new a(this), 500L);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void j0(View view2, BdSwitchView.SwitchState switchState) {
        k77 k77Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, view2, switchState) == null) || (k77Var = this.a) == null || this.b == null) {
            return;
        }
        if (view2 == k77Var.c()) {
            this.b.P(1, switchState != BdSwitchView.SwitchState.OFF);
        } else if (view2 == this.a.d()) {
            this.b.P(2, switchState != BdSwitchView.SwitchState.OFF);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            k77 k77Var = this.a;
            if (k77Var != null) {
                k77Var.j(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new k77(this);
            this.b = new RecommendDetailModel(getPageContext(), this, this);
            B1(bundle);
            this.a.a();
            this.b.M(this.c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            RecommendDetailModel recommendDetailModel = this.b;
            if (recommendDetailModel != null) {
                recommendDetailModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void onFailed(String str) {
        RecommendDetailModel recommendDetailModel;
        k77 k77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!StringUtils.isNull(str) && (k77Var = this.a) != null) {
                k77Var.g();
                this.a.b();
            }
            if (this.a == null || (recommendDetailModel = this.b) == null || !recommendDetailModel.J() || this.b.H() || !StringUtils.isNull(str)) {
                return;
            }
            if (pi.D()) {
                this.a.o(R.string.obfuscated_res_0x7f0f0c31);
            } else {
                this.a.o(R.string.obfuscated_res_0x7f0f078e);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("user_id", this.c);
            bundle.putString("user_name", this.d);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void w1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.a == null) {
            return;
        }
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.c), false);
            this.a.i();
            return;
        }
        this.mHandler.postDelayed(new b(this), 500L);
    }
}
