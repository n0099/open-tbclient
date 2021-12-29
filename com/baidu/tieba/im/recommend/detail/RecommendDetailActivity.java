package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes12.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements RecommendDetailModel.d, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RECOMMEND_DETAIL_URL = "c/u/user/bigvip";
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendDetailModel mModel;
    public long mUserId;
    public String mUserName;
    public c.a.t0.s1.q.a.b mView;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendDetailActivity f46822e;

        public a(RecommendDetailActivity recommendDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46822e = recommendDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46822e.mView.f(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendDetailActivity f46823e;

        public b(RecommendDetailActivity recommendDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46823e = recommendDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46823e.mView.f(true);
            }
        }
    }

    public RecommendDetailActivity() {
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

    private void checkIsShowAcceptSwitch() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.mView == null) {
            return;
        }
        if (!c.a.s0.t.d.b.g0().N(String.valueOf(this.mUserId))) {
            this.mView.g();
        } else {
            this.mView.a();
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
            if (bundle != null) {
                this.mUserId = bundle.getLong("user_id", 0L);
                this.mUserName = bundle.getString("user_name");
                return;
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.mUserId = intent.getLongExtra("user_id", 0L);
                this.mUserName = intent.getStringExtra("user_name");
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                this.mModel.G(false);
            } else {
                this.mModel.G(true);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onAcceptMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                showToast(R.string.success);
                TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
                return;
            }
            this.mHandler.postDelayed(new a(this), 500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.t0.s1.q.a.b bVar = this.mView;
            if (bVar != null) {
                bVar.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new c.a.t0.s1.q.a.b(this);
            this.mModel = new RecommendDetailModel(getPageContext(), this);
            initData(bundle);
            checkIsShowAcceptSwitch();
            this.mModel.E(this.mUserId);
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

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onFailed(String str) {
        RecommendDetailModel recommendDetailModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!StringUtils.isNull(str)) {
                showToast(str);
            }
            if (this.mView == null || (recommendDetailModel = this.mModel) == null || !recommendDetailModel.C() || this.mModel.B()) {
                return;
            }
            if (n.C()) {
                this.mView.h(R.string.no_data_text);
            } else {
                this.mView.h(R.string.game_index_no_network_text);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("user_id", this.mUserId);
            bundle.putString("user_name", this.mUserName);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onSuccess(UserInfoBigVip userInfoBigVip, boolean z) {
        c.a.t0.s1.q.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, userInfoBigVip, z) == null) || (bVar = this.mView) == null || userInfoBigVip == null) {
            return;
        }
        bVar.b();
        this.mView.i(userInfoBigVip, z);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onUnAcceptMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
                showToast(R.string.success);
                return;
            }
            this.mHandler.postDelayed(new b(this), 500L);
        }
    }
}
