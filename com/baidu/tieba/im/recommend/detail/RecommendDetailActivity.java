package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import com.baidu.tieba.lg8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes6.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements RecommendDetailModel.e, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lg8 a;
    public RecommendDetailModel b;
    public long c;
    public String d;
    public String e;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RecommendDetailModel recommendDetailModel = this.b;
            if (recommendDetailModel != null) {
                recommendDetailModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    public void Q0(boolean z) {
        RecommendDetailModel recommendDetailModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (recommendDetailModel = this.b) != null) {
            recommendDetailModel.X(z);
        }
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mHandler.postDelayed(new c(this, z), 500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            lg8 lg8Var = this.a;
            if (lg8Var != null) {
                lg8Var.j(i);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("user_id", this.c);
            bundle.putString("user_name", this.d);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.a == null) {
            return;
        }
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.c), false);
            this.a.i();
            return;
        }
        this.mHandler.postDelayed(new b(this), 500L);
    }

    public final void N0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
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

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || this.a == null) {
            return;
        }
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.c), true);
            this.a.i();
            return;
        }
        this.mHandler.postDelayed(new a(this), 500L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new lg8(this);
            this.b = new RecommendDetailModel(getPageContext(), this, this);
            N0(bundle);
            this.a.a();
            this.b.Z(this.c);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void onFailed(String str) {
        RecommendDetailModel recommendDetailModel;
        lg8 lg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (!StringUtils.isNull(str) && (lg8Var = this.a) != null) {
                lg8Var.g();
                this.a.b();
            }
            if (this.a != null && (recommendDetailModel = this.b) != null && recommendDetailModel.W() && !this.b.U() && StringUtils.isNull(str)) {
                if (BdUtilHelper.isNetOk()) {
                    this.a.o(R.string.no_data_text);
                } else {
                    this.a.o(R.string.game_index_no_network_text);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void s(UserInfoBigVip userInfoBigVip, boolean z) {
        lg8 lg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, userInfoBigVip, z) == null) && (lg8Var = this.a) != null && userInfoBigVip != null) {
            lg8Var.g();
            this.a.p(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void z(View view2, BdSwitchView.SwitchState switchState) {
        lg8 lg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, view2, switchState) == null) && (lg8Var = this.a) != null && this.b != null) {
            boolean z = false;
            if (view2 == lg8Var.c()) {
                RecommendDetailModel recommendDetailModel = this.b;
                if (switchState != BdSwitchView.SwitchState.OFF) {
                    z = true;
                }
                recommendDetailModel.c0(1, z);
            } else if (view2 == this.a.d()) {
                RecommendDetailModel recommendDetailModel2 = this.b;
                if (switchState != BdSwitchView.SwitchState.OFF) {
                    z = true;
                }
                recommendDetailModel2.c0(2, z);
            }
        }
    }
}
