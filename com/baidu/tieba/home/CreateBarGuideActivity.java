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
import d.a.r0.r.s.a;
import tbclient.UserBfbInfo;
/* loaded from: classes5.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOW_VERSION_ERRCODE = 260211;
    public static final int MAX_LENGTH = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumName;
    public BfbInfoModel.b mCallback;
    public BfbInfoModel mModel;
    public d.a.s0.c1.a mView;

    /* loaded from: classes5.dex */
    public class a implements BfbInfoModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CreateBarGuideActivity f16385a;

        public a(CreateBarGuideActivity createBarGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16385a = createBarGuideActivity;
        }

        @Override // com.baidu.tieba.home.BfbInfoModel.b
        public void a(int i2, String str, UserBfbInfo userBfbInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, userBfbInfo) == null) {
                CreateBarGuideActivity createBarGuideActivity = this.f16385a;
                createBarGuideActivity.hideLoadingView(createBarGuideActivity.mView.d());
                this.f16385a.mView.g();
                if (i2 == 0) {
                    this.f16385a.mView.h(this.f16385a.forumName, userBfbInfo);
                    return;
                }
                this.f16385a.showToast(str);
                if (i2 == 260211) {
                    this.f16385a.showUpdateDialog(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f16386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CreateBarGuideActivity f16387f;

        public b(CreateBarGuideActivity createBarGuideActivity, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16387f = createBarGuideActivity;
            this.f16386e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16386e.dismiss();
                this.f16387f.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(this.f16387f.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f16388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CreateBarGuideActivity f16389f;

        public c(CreateBarGuideActivity createBarGuideActivity, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarGuideActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16389f = createBarGuideActivity;
            this.f16388e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16388e.dismiss();
            }
        }
    }

    public CreateBarGuideActivity() {
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
        this.mCallback = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = getResources().getString(R.string.tips_version_low);
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getActivity());
            aVar.setTitle(str);
            aVar.setPositiveButton(R.string.confirm, new b(this, aVar));
            aVar.setNegativeButton(R.string.cancel, new c(this, aVar));
            aVar.create(getPageContext());
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.changeSkinType(i2);
            d.a.s0.c1.a aVar = this.mView;
            if (aVar != null) {
                aVar.f();
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
            bfbInfoModel.A(this.mCallback);
            d.a.s0.c1.a aVar = new d.a.s0.c1.a(this);
            this.mView = aVar;
            aVar.e();
            showLoadingView(this.mView.d());
            this.mModel.LoadData();
            TiebaStatic.log("c11222");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mView = null;
            this.mModel.w();
        }
    }
}
