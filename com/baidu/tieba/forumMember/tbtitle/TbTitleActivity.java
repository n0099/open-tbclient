package com.baidu.tieba.forumMember.tbtitle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
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
import com.repackage.a9;
import com.repackage.bb6;
import com.repackage.db6;
import com.repackage.eb6;
import com.repackage.fi8;
import com.repackage.hj8;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.s77;
import com.repackage.zi8;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes3.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener mCommonListener;
    public String mForumId;
    public String mForumName;
    public bb6<TbTitleActivity> mGetLevelInfoModel;
    public bb6.c mLevelInfoModelCallback;
    public a9 mLikeCallback;
    public LikeModel mLikeModel;
    public NoNetworkView.b mNoNetworkChangeListener;
    public eb6 mView;

    /* loaded from: classes3.dex */
    public class a implements bb6.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTitleActivity a;

        public a(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbTitleActivity;
        }

        @Override // com.repackage.bb6.c
        public void a(DataRes dataRes, boolean z, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
                if (z) {
                    if (i != 0 || dataRes == null) {
                        this.a.mGetLevelInfoModel.c(kg.e(this.a.mForumId, 0));
                        return;
                    }
                    this.a.mView.i();
                    this.a.mView.j();
                    this.a.mView.g(dataRes);
                    this.a.mView.h(dataRes.level_info);
                } else if (i != 0 || dataRes == null) {
                    this.a.mView.i();
                    this.a.mView.s(str);
                } else {
                    this.a.mView.i();
                    this.a.mView.j();
                    this.a.mView.g(dataRes);
                    this.a.mView.h(dataRes.level_info);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTitleActivity a;

        public b(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbTitleActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091f4e && this.a.checkUpIsLogin()) {
                if (ki.z()) {
                    this.a.mLikeModel.P(this.a.mForumName, this.a.mForumId);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ TbTitleActivity c;

        public c(TbTitleActivity tbTitleActivity, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbTitleActivity;
            this.a = str;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    return null;
                }
                s77.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTitleActivity a;

        public d(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbTitleActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.mView.r();
                    this.a.mGetLevelInfoModel.d(kg.e(this.a.mForumId, 0));
                }
                this.a.mView.n(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTitleActivity a;

        public e(TbTitleActivity tbTitleActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTitleActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbTitleActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && (obj instanceof zi8)) {
                    fi8.i().n(this.a.mForumName, false);
                    z = true;
                }
                if (!z) {
                    if (this.a.mLikeModel.getErrorCode() != 22) {
                        if (AntiHelper.m(this.a.mLikeModel.getErrorCode(), this.a.mLikeModel.getErrorString())) {
                            AntiHelper.u(this.a.getPageContext().getPageActivity(), this.a.mLikeModel.getErrorString());
                            return;
                        } else {
                            this.a.getPageContext().showToast(this.a.mLikeModel.getErrorString());
                            return;
                        }
                    }
                    this.a.getPageContext().showToast(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f080b));
                    return;
                }
                this.a.getPageContext().showToast(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02b1));
                TbadkCoreApplication.getInst().addLikeForum(this.a.mForumName);
                TbTitleActivity tbTitleActivity = this.a;
                tbTitleActivity.saveAcceptNotify(true, tbTitleActivity.mForumId);
                zi8 zi8Var = (zi8) obj;
                if (zi8Var != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, zi8Var));
                }
                if (this.a.mView.k != null) {
                    this.a.mView.k.setVisibility(8);
                }
                zi8Var.y(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, zi8Var));
            }
        }
    }

    public TbTitleActivity() {
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
            hj8.c(301005, CmdConfigHttp.CMD_GET_LEVLE_INFO, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
            hj8.f(301005, GetLevelInfoSocketResponsedMessage.class, false);
            hj8.b(2003007, db6.class);
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.m(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            eb6 eb6Var = new eb6(this, this.mCommonListener);
            this.mView = eb6Var;
            eb6Var.q(this.mNoNetworkChangeListener);
            initLikeModel();
            this.mGetLevelInfoModel = new bb6<>(this.mLevelInfoModelCallback, this);
            Intent intent = getIntent();
            if (intent != null) {
                this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
                this.mForumName = intent.getStringExtra("forumName");
            }
            if (!TextUtils.isEmpty(this.mForumId) && !TextUtils.isEmpty(this.mForumName)) {
                registerTask();
                this.mView.r();
                this.mGetLevelInfoModel.d(kg.e(this.mForumId, 0));
                return;
            }
            this.mView.s("");
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
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ki.z()) {
            this.mView.r();
            this.mGetLevelInfoModel.d(kg.e(this.mForumId, 0));
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
