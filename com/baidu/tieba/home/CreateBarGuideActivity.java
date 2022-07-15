package com.baidu.tieba.home;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.repackage.cr4;
import com.repackage.js6;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public js6 b;
    public BfbInfoModel c;
    public BfbInfoModel.b d;

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
                createBarGuideActivity.hideLoadingView(createBarGuideActivity.b.d());
                this.a.b.g();
                if (i == 0) {
                    this.a.b.h(this.a.a, userBfbInfo);
                    return;
                }
                this.a.showToast(str);
                if (i == 260211) {
                    this.a.D1(null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ CreateBarGuideActivity b;

        public b(CreateBarGuideActivity createBarGuideActivity, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity, cr4Var};
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
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
                this.b.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(this.b.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ CreateBarGuideActivity b;

        public c(CreateBarGuideActivity createBarGuideActivity, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity, cr4Var};
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
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
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
        this.d = new a(this);
    }

    public final void D1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f142a);
            }
            cr4 cr4Var = new cr4(getActivity());
            cr4Var.setTitle(str);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0427, new b(this, cr4Var));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new c(this, cr4Var));
            cr4Var.create(getPageContext());
            cr4Var.show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.changeSkinType(i);
            js6 js6Var = this.b;
            if (js6Var != null) {
                js6Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
            this.a = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && this.a.length() > 30) {
                this.a = this.a.substring(0, 30);
            }
            BfbInfoModel bfbInfoModel = new BfbInfoModel(this);
            this.c = bfbInfoModel;
            bfbInfoModel.E(this.d);
            js6 js6Var = new js6(this);
            this.b = js6Var;
            js6Var.e();
            showLoadingView(this.b.d());
            this.c.loadData();
            TiebaStatic.log("c11222");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.b = null;
            this.c.A();
        }
    }
}
