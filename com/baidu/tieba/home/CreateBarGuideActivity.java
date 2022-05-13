package com.baidu.tieba.home;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.home.BfbInfoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import com.repackage.os6;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOW_VERSION_ERRCODE = 260211;
    public static final int MAX_LENGTH = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumName;
    public BfbInfoModel.b mCallback;
    public BfbInfoModel mModel;
    public os6 mView;

    /* loaded from: classes3.dex */
    public class a implements BfbInfoModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarGuideActivity a;

        public a(CreateBarGuideActivity createBarGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarGuideActivity;
        }

        @Override // com.baidu.tieba.home.BfbInfoModel.b
        public void a(int i, String str, UserBfbInfo userBfbInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, userBfbInfo) == null) {
                CreateBarGuideActivity createBarGuideActivity = this.a;
                createBarGuideActivity.hideLoadingView(createBarGuideActivity.mView.d());
                this.a.mView.g();
                if (i == 0) {
                    this.a.mView.h(this.a.forumName, userBfbInfo);
                    return;
                }
                this.a.showToast(str);
                if (i == 260211) {
                    this.a.showUpdateDialog(null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ CreateBarGuideActivity b;

        public b(CreateBarGuideActivity createBarGuideActivity, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = createBarGuideActivity;
            this.a = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
                this.b.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(this.b.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ CreateBarGuideActivity b;

        public c(CreateBarGuideActivity createBarGuideActivity, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = createBarGuideActivity;
            this.a = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public CreateBarGuideActivity() {
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
        this.mCallback = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f1412);
            }
            nr4 nr4Var = new nr4(getActivity());
            nr4Var.setTitle(str);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new b(this, nr4Var));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new c(this, nr4Var));
            nr4Var.create(getPageContext());
            nr4Var.show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.changeSkinType(i);
            os6 os6Var = this.mView;
            if (os6Var != null) {
                os6Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
            this.forumName = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && this.forumName.length() > 30) {
                this.forumName = this.forumName.substring(0, 30);
            }
            BfbInfoModel bfbInfoModel = new BfbInfoModel(this);
            this.mModel = bfbInfoModel;
            bfbInfoModel.C(this.mCallback);
            os6 os6Var = new os6(this);
            this.mView = os6Var;
            os6Var.e();
            showLoadingView(this.mView.d());
            this.mModel.loadData();
            TiebaStatic.log("c11222");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mView = null;
            this.mModel.y();
        }
    }
}
