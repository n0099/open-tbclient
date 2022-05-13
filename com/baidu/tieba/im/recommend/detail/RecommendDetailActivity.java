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
import com.repackage.j77;
import com.repackage.mi;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements RecommendDetailModel.e, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RECOMMEND_DETAIL_URL = "c/u/user/bigvip";
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendDetailModel mModel;
    public long mUserId;
    public String mUserName;
    public String mUserPortrait;
    public j77 mView;

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
                this.a.mView.l(this.a.mView.l, false);
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
                this.a.mView.l(this.a.mView.l, true);
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
                this.b.mView.l(this.b.mView.m, !this.a);
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

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bundle) == null) {
            if (bundle != null) {
                this.mUserId = bundle.getLong("user_id", 0L);
                this.mUserName = bundle.getString("user_name");
                this.mUserPortrait = bundle.getString(RecommendDetailActivityConfig.USER_PORTRAIT);
                return;
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.mUserId = intent.getLongExtra("user_id", 0L);
                this.mUserName = intent.getStringExtra("user_name");
                this.mUserPortrait = intent.getStringExtra(RecommendDetailActivityConfig.USER_PORTRAIT);
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        j77 j77Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) || (j77Var = this.mView) == null || this.mModel == null) {
            return;
        }
        if (view2 == j77Var.c()) {
            this.mModel.N(1, switchState != BdSwitchView.SwitchState.OFF);
        } else if (view2 == this.mView.d()) {
            this.mModel.N(2, switchState != BdSwitchView.SwitchState.OFF);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void onAcceptMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.mView == null) {
            return;
        }
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            this.mView.i();
            return;
        }
        this.mHandler.postDelayed(new a(this), 500L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            j77 j77Var = this.mView;
            if (j77Var != null) {
                j77Var.j(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new j77(this);
            this.mModel = new RecommendDetailModel(getPageContext(), this, this);
            initData(bundle);
            this.mView.a();
            this.mModel.K(this.mUserId);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RecommendDetailModel recommendDetailModel = this.mModel;
            if (recommendDetailModel != null) {
                recommendDetailModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void onFailed(String str) {
        RecommendDetailModel recommendDetailModel;
        j77 j77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!StringUtils.isNull(str) && (j77Var = this.mView) != null) {
                j77Var.g();
                this.mView.b();
            }
            if (this.mView == null || (recommendDetailModel = this.mModel) == null || !recommendDetailModel.H() || this.mModel.F() || !StringUtils.isNull(str)) {
                return;
            }
            if (mi.C()) {
                this.mView.o(R.string.obfuscated_res_0x7f0f0c45);
            } else {
                this.mView.o(R.string.obfuscated_res_0x7f0f0786);
            }
        }
    }

    public void onNeglectMsgSettingChanged(boolean z) {
        RecommendDetailModel recommendDetailModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (recommendDetailModel = this.mModel) == null) {
            return;
        }
        recommendDetailModel.I(z);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("user_id", this.mUserId);
            bundle.putString("user_name", this.mUserName);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void onSuccess(UserInfoBigVip userInfoBigVip, boolean z) {
        j77 j77Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, userInfoBigVip, z) == null) || (j77Var = this.mView) == null || userInfoBigVip == null) {
            return;
        }
        j77Var.g();
        this.mView.p(userInfoBigVip, z);
    }

    public void onSwitchChangeFailed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mHandler.postDelayed(new c(this, z), 500L);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.e
    public void onUnAcceptMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.mView == null) {
            return;
        }
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            this.mView.i();
            return;
        }
        this.mHandler.postDelayed(new b(this), 500L);
    }
}
