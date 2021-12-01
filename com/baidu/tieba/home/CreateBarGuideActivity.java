package com.baidu.tieba.home;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
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
import tbclient.UserBfbInfo;
/* loaded from: classes10.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOW_VERSION_ERRCODE = 260211;
    public static final int MAX_LENGTH = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumName;
    public BfbInfoModel.b mCallback;
    public BfbInfoModel mModel;
    public c.a.r0.l1.a mView;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarGuideActivity;
        }

        @Override // com.baidu.tieba.home.BfbInfoModel.b
        public void a(int i2, String str, UserBfbInfo userBfbInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, userBfbInfo) == null) {
                CreateBarGuideActivity createBarGuideActivity = this.a;
                createBarGuideActivity.hideLoadingView(createBarGuideActivity.mView.d());
                this.a.mView.g();
                if (i2 == 0) {
                    this.a.mView.h(this.a.forumName, userBfbInfo);
                    return;
                }
                this.a.showToast(str);
                if (i2 == 260211) {
                    this.a.showUpdateDialog(null);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f45058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CreateBarGuideActivity f45059f;

        public b(CreateBarGuideActivity createBarGuideActivity, c.a.q0.s.s.a aVar) {
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
            this.f45059f = createBarGuideActivity;
            this.f45058e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f45058e.dismiss();
                this.f45059f.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(this.f45059f.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f45060e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CreateBarGuideActivity f45061f;

        public c(CreateBarGuideActivity createBarGuideActivity, c.a.q0.s.s.a aVar) {
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
            this.f45061f = createBarGuideActivity;
            this.f45060e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f45060e.dismiss();
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = getResources().getString(R.string.tips_version_low);
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
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
            c.a.r0.l1.a aVar = this.mView;
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
            c.a.r0.l1.a aVar = new c.a.r0.l1.a(this);
            this.mView = aVar;
            aVar.e();
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
            this.mModel.w();
        }
    }
}
