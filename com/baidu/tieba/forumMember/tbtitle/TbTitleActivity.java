package com.baidu.tieba.forumMember.tbtitle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.e.e.p.j;
import c.a.r0.j3.x;
import c.a.r0.u0.d.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes7.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener mCommonListener;
    public String mForumId;
    public String mForumName;
    public c.a.r0.u0.d.a.a<TbTitleActivity> mGetLevelInfoModel;
    public a.c mLevelInfoModelCallback;
    public c.a.e.a.e mLikeCallback;
    public LikeModel mLikeModel;
    public NoNetworkView.b mNoNetworkChangeListener;
    public c.a.r0.u0.d.b.a mView;

    /* loaded from: classes7.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbTitleActivity f50871a;

        public a(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50871a = tbTitleActivity;
        }

        @Override // c.a.r0.u0.d.a.a.c
        public void a(DataRes dataRes, boolean z, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) {
                if (z) {
                    if (i2 != 0 || dataRes == null) {
                        this.f50871a.mGetLevelInfoModel.c(c.a.e.e.m.b.e(this.f50871a.mForumId, 0));
                        return;
                    }
                    this.f50871a.mView.f();
                    this.f50871a.mView.g();
                    this.f50871a.mView.d(dataRes);
                    this.f50871a.mView.e(dataRes.level_info);
                } else if (i2 != 0 || dataRes == null) {
                    this.f50871a.mView.f();
                    this.f50871a.mView.n(str);
                } else {
                    this.f50871a.mView.f();
                    this.f50871a.mView.g();
                    this.f50871a.mView.d(dataRes);
                    this.f50871a.mView.e(dataRes.level_info);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbTitleActivity f50872e;

        public b(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50872e = tbTitleActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == R.id.tbtile_like_btn && this.f50872e.checkUpIsLogin()) {
                if (j.z()) {
                    this.f50872e.mLikeModel.L(this.f50872e.mForumName, this.f50872e.mForumId);
                } else {
                    this.f50872e.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f50874b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbTitleActivity f50875c;

        public c(TbTitleActivity tbTitleActivity, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50875c = tbTitleActivity;
            this.f50873a = str;
            this.f50874b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.f50873a)) {
                    return null;
                }
                c.a.r0.k1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f50873a), this.f50874b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbTitleActivity f50876e;

        public d(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50876e = tbTitleActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f50876e.mView.m();
                    this.f50876e.mGetLevelInfoModel.d(c.a.e.e.m.b.e(this.f50876e.mForumId, 0));
                }
                this.f50876e.mView.j(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbTitleActivity f50877a;

        public e(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50877a = tbTitleActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && (obj instanceof x)) {
                    c.a.r0.j3.e.i().n(this.f50877a.mForumName, false);
                    z = true;
                }
                if (!z) {
                    if (this.f50877a.mLikeModel.getErrorCode() != 22) {
                        if (AntiHelper.m(this.f50877a.mLikeModel.getErrorCode(), this.f50877a.mLikeModel.getErrorString())) {
                            AntiHelper.u(this.f50877a.getPageContext().getPageActivity(), this.f50877a.mLikeModel.getErrorString());
                            return;
                        } else {
                            this.f50877a.getPageContext().showToast(this.f50877a.mLikeModel.getErrorString());
                            return;
                        }
                    }
                    this.f50877a.getPageContext().showToast(this.f50877a.getPageContext().getString(R.string.had_liked_forum));
                    return;
                }
                this.f50877a.getPageContext().showToast(this.f50877a.getPageContext().getString(R.string.attention_success));
                TbadkCoreApplication.getInst().addLikeForum(this.f50877a.mForumName);
                TbTitleActivity tbTitleActivity = this.f50877a;
                tbTitleActivity.saveAcceptNotify(true, tbTitleActivity.mForumId);
                x xVar = (x) obj;
                if (xVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                }
                if (this.f50877a.mView.k != null) {
                    this.f50877a.mView.k.setVisibility(8);
                }
                xVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
            }
        }
    }

    public TbTitleActivity() {
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
        this.mLevelInfoModelCallback = new a(this);
        this.mCommonListener = new b(this);
        this.mNoNetworkChangeListener = new d(this);
        this.mLikeCallback = new e(this);
    }

    private void initLikeModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.mLikeModel = likeModel;
            likeModel.setLoadDataCallBack(this.mLikeCallback);
        }
    }

    private void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            c.a.r0.j3.e0.a.c(301005, CmdConfigHttp.CMD_GET_LEVLE_INFO, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
            c.a.r0.j3.e0.a.f(301005, GetLevelInfoSocketResponsedMessage.class, false);
            c.a.r0.j3.e0.a.b(2003007, c.a.r0.u0.d.a.b.b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAcceptNotify(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, this, z, str) == null) {
            new c(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.i(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.r0.u0.d.b.a aVar = new c.a.r0.u0.d.b.a(this, this.mCommonListener);
            this.mView = aVar;
            aVar.l(this.mNoNetworkChangeListener);
            initLikeModel();
            this.mGetLevelInfoModel = new c.a.r0.u0.d.a.a<>(this.mLevelInfoModelCallback, this);
            Intent intent = getIntent();
            if (intent != null) {
                this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
                this.mForumName = intent.getStringExtra("forumName");
            }
            if (!TextUtils.isEmpty(this.mForumId) && !TextUtils.isEmpty(this.mForumName)) {
                registerTask();
                this.mView.m();
                this.mGetLevelInfoModel.d(c.a.e.e.m.b.e(this.mForumId, 0));
                return;
            }
            this.mView.n("");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && j.z()) {
            this.mView.m();
            this.mGetLevelInfoModel.d(c.a.e.e.m.b.e(this.mForumId, 0));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
        }
    }
}
