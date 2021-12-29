package com.baidu.tieba.flutter.plugin.passprovider;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.s0.i0.d;
import c.a.s0.s.l.a;
import c.a.s0.s.l.c;
import c.a.s0.s.q.t0;
import c.a.t0.z0.a.g.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.passprovider.PassProviderAuto;
import com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class PassProviderPlugin implements FlutterPlugin, PassProviderAuto.PassProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long INFO_TYPE_NONE = 0;
    public static final long INFO_TYPE_PHONE = 2;
    public static final long INFO_TYPE_SHARE = 1;
    public static final String LOCATE_LOGIN_AREA = "1";
    public static final String LOGIN_TYPE_MORE = "more";
    public static final String LOGIN_TYPE_QQ = "qq";
    public static final String LOGIN_TYPE_WECHAT = "wechat";
    public static final String LOGIN_TYPE_WEIBO = "weibo";
    public static final String LOGIN_TYPE_YY = "yy";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasSendResult;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public PassProviderAuto.Result<PassProviderAuto.LoginResult> mLoginResult;
    public final a.InterfaceC0864a mReLoginCallback;
    public WeakReference<Activity> mWeakActivity;

    public PassProviderPlugin() {
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
        this.mReLoginCallback = new a.InterfaceC0864a(this) { // from class: com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PassProviderPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.s0.s.l.a.InterfaceC0864a
            public void onBeforeLogin(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    this.this$0.showLoginLoading();
                }
            }

            @Override // c.a.s0.s.l.a.InterfaceC0864a
            public void onFailure(String str, int i4, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i4, str2) == null) {
                    this.this$0.closeLoginLoading();
                    this.this$0.showToast(str2);
                }
            }

            @Override // c.a.s0.s.l.a.InterfaceC0864a
            public void onSuccess(AccountData accountData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                    this.this$0.closeLoginLoading();
                    this.this$0.onLoginSuccess(accountData);
                }
            }
        };
        this.hasSendResult = false;
    }

    public static /* synthetic */ CustomResponsedMessage a(AccountData accountData, CustomMessage customMessage) {
        c.g(accountData);
        c.a.s0.s.b0.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
        return null;
    }

    private void addMinePageLoginStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MINE_PAGE_LOGIN_DIALOG_SUCCESS);
            statisticItem.param("obj_locate", "1");
            TiebaStatic.log(statisticItem);
        }
    }

    private boolean checkActivityIsValid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, context)) == null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                return (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) && !activity.isFinishing();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeLoginLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity) && (findCurrentActivity instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) findCurrentActivity).closeLoadingDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PassProviderAuto.PassResult convertLoginPhonePass(OneKeyLoginResult oneKeyLoginResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, oneKeyLoginResult)) == null) {
            PassProviderAuto.PassResult passResult = new PassProviderAuto.PassResult();
            passResult.setType(2L);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encryptPhoneNum", oneKeyLoginResult.encryptPhoneNum);
                jSONObject.put("operator", oneKeyLoginResult.operator);
                jSONObject.put("sign", oneKeyLoginResult.sign);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            passResult.setPhoneLoginJSON(jSONObject.toString());
            return passResult;
        }
        return (PassProviderAuto.PassResult) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PassProviderAuto.PassResult convertShareModelPass(ShareStorage.StorageModel storageModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, storageModel)) == null) {
            PassProviderAuto.PassResult passResult = new PassProviderAuto.PassResult();
            passResult.setType(1L);
            passResult.setShareModelJSON(new Gson().toJson(storageModel));
            return passResult;
        }
        return (PassProviderAuto.PassResult) invokeL.objValue;
    }

    @Nullable
    private Activity findCurrentActivity() {
        InterceptResult invokeV;
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            return (currentActivity != null || (weakReference = this.mWeakActivity) == null) ? currentActivity : weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goLoginPageWhenFail() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (weakReference = this.mWeakActivity) == null || weakReference.get() == null) {
            return;
        }
        Activity activity = this.mWeakActivity.get();
        if (checkActivityIsValid(activity)) {
            new LoginActivityConfig((Context) activity, true).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleThirdLoginResult(PassProviderAuto.Result<PassProviderAuto.PassResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, result) == null) {
            try {
                PassProviderAuto.PassResult passResult = new PassProviderAuto.PassResult();
                passResult.setType(0L);
                result.success(passResult);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void loginWithPhone(String str, PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, this, str, result) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                this.mWeakActivity = new WeakReference<>(findCurrentActivity);
                showLoginLoading();
                try {
                    PassportSDK.getInstance().loadOneKeyLogin(findCurrentActivity, machiningSignWithCuid(findCurrentActivity, new JSONObject(str).optString("sign")), new OneKeyLoginCallback(this, result) { // from class: com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PassProviderPlugin this$0;
                        public final /* synthetic */ PassProviderAuto.Result val$result;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, result};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$result = result;
                        }

                        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, oneKeyLoginResult) == null) {
                                this.this$0.closeLoginLoading();
                                this.this$0.onLoginFail(this.val$result);
                                this.this$0.goLoginPageWhenFail();
                            }
                        }

                        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                            }
                        }

                        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                                this.this$0.passLoginSuccess(this.val$result);
                            }
                        }
                    });
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void loginWithShareModel(String str, PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, str, result) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                this.mWeakActivity = new WeakReference<>(findCurrentActivity);
                PassportSDK.getInstance().invokeV2ShareLogin(findCurrentActivity, new WebAuthListener(this, result) { // from class: com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PassProviderPlugin this$0;
                    public final /* synthetic */ PassProviderAuto.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, result};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$result = result;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(WebAuthResult webAuthResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                            this.this$0.onLoginFail(this.val$result);
                            this.this$0.goLoginPageWhenFail();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(WebAuthResult webAuthResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, webAuthResult) == null) {
                            this.this$0.passLoginSuccess(this.val$result);
                        }
                    }
                }, (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class));
            }
        }
    }

    private String machiningSignWithCuid(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, this, activity, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(activity).toUpperCase();
            return substring + MD5Util.toMd5((substring2 + MD5Util.toMd5(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    private void notifyMainTab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new d(findCurrentActivity)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginFail(PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, result) == null) {
            PassProviderAuto.LoginResult loginResult = new PassProviderAuto.LoginResult();
            loginResult.setSuccess(Boolean.FALSE);
            result.success(loginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginSuccess(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, accountData) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                saveAccountInfo(accountData);
                c.a.s0.s.b0.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
                TbadkCoreApplication.getInst().onUserChanged(findCurrentActivity.getIntent());
                if (c.a.s0.b.d.f()) {
                    c.a.s0.a.d.y().r();
                }
                if (this.mLoginResult != null) {
                    PassProviderAuto.LoginResult loginResult = new PassProviderAuto.LoginResult();
                    loginResult.setSuccess(Boolean.TRUE);
                    this.mLoginResult.success(loginResult);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passLoginSuccess(PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, result) == null) {
            this.mLoginResult = result;
            addMinePageLoginStatistic();
            MessageManager.getInstance().dispatchResponsedMessage(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.mAccountLoginTask = a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
            } else {
                closeLoginLoading();
            }
            notifyMainTab();
        }
    }

    private void saveAccountInfo(final AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, accountData) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2921643, new CustomMessageTask.CustomRunnable() { // from class: c.a.t0.z0.a.g.i
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public final CustomResponsedMessage run(CustomMessage customMessage) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) ? PassProviderPlugin.a(AccountData.this, customMessage) : (CustomResponsedMessage) invokeL.objValue;
                    }
                });
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921643), customMessageTask);
                c.a.s0.s.b0.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(accountData, findCurrentActivity);
                c.a.s0.m.a.f(TbadkCoreApplication.getInst());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoginLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity) && (findCurrentActivity instanceof BaseFragmentActivity)) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) findCurrentActivity;
                c.a.s0.s.i0.a loadingDialog = baseFragmentActivity.getLoadingDialog();
                if (loadingDialog == null || !loadingDialog.c()) {
                    baseFragmentActivity.showLoadingDialog(findCurrentActivity.getString(R.string.sapi_logining));
                    c.a.s0.s.i0.a loadingDialog2 = baseFragmentActivity.getLoadingDialog();
                    if (loadingDialog2 != null) {
                        loadingDialog2.f(false);
                        loadingDialog2.g(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, str) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                n.M(findCurrentActivity, str);
            }
        }
    }

    private void thirdLogin(SocialType socialType, PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65568, this, socialType, result) == null) || socialType == null) {
            return;
        }
        Activity findCurrentActivity = findCurrentActivity();
        if (checkActivityIsValid(findCurrentActivity)) {
            this.mWeakActivity = new WeakReference<>(findCurrentActivity);
            PassportSDK.getInstance().loadThirdPartyLogin(new WebAuthListener(this, result, findCurrentActivity) { // from class: com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PassProviderPlugin this$0;
                public final /* synthetic */ Activity val$activity;
                public final /* synthetic */ PassProviderAuto.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, result, findCurrentActivity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = result;
                    this.val$activity = findCurrentActivity;
                }

                @Override // com.baidu.sapi2.shell.listener.WebAuthListener
                public void beforeSuccess(SapiAccount sapiAccount) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, sapiAccount) == null) {
                        this.this$0.showLoginLoading();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                        this.this$0.closeLoginLoading();
                        this.this$0.showToast(String.format(this.val$activity.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, webAuthResult) == null) {
                        this.this$0.closeLoginLoading();
                        this.this$0.passLoginSuccess(this.val$result);
                    }
                }
            }, socialType);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.passprovider.PassProviderAuto.PassProvider
    public void getPassResult(PassProviderAuto.Result<PassProviderAuto.PassResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
            SapiAccountManager.getInstance().getShareModels(1500L, new ShareModelCallback(this, result) { // from class: com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PassProviderPlugin this$0;
                public final /* synthetic */ PassProviderAuto.Result val$passResult;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, result};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$passResult = result;
                }

                @Override // com.baidu.sapi2.callback.ShareModelCallback
                public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) || this.this$0.hasSendResult) {
                        return;
                    }
                    if (!list.isEmpty()) {
                        this.val$passResult.success(this.this$0.convertShareModelPass(list.get(0)));
                    } else {
                        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new OneKeyLoginCallback(this) { // from class: com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                            public void available(OneKeyLoginResult oneKeyLoginResult) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, oneKeyLoginResult) == null) {
                                    if (oneKeyLoginResult.enable) {
                                        AnonymousClass2 anonymousClass2 = this.this$1;
                                        anonymousClass2.val$passResult.success(anonymousClass2.this$0.convertLoginPhonePass(oneKeyLoginResult));
                                        return;
                                    }
                                    AnonymousClass2 anonymousClass22 = this.this$1;
                                    anonymousClass22.this$0.handleThirdLoginResult(anonymousClass22.val$passResult);
                                }
                            }

                            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                            public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                                    AnonymousClass2 anonymousClass2 = this.this$1;
                                    anonymousClass2.this$0.handleThirdLoginResult(anonymousClass2.val$passResult);
                                }
                            }
                        });
                    }
                    this.this$0.hasSendResult = true;
                }
            });
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.passprovider.PassProviderAuto.PassProvider
    public void loginWithPass(PassProviderAuto.PassResult passResult, PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passResult, result) == null) {
            if (passResult.getType().longValue() == 1 && !StringUtils.isNull(passResult.getShareModelJSON())) {
                loginWithShareModel(passResult.getShareModelJSON(), result);
            } else if (passResult.getType().longValue() == 2 && !StringUtils.isNull(passResult.getPhoneLoginJSON())) {
                loginWithPhone(passResult.getPhoneLoginJSON(), result);
            } else {
                onLoginFail(result);
                openLoginPage(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        if (r0 == 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (r0 == 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        if (r0 == 3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
        r7 = com.baidu.sapi2.utils.enums.SocialType.YY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r7 = com.baidu.sapi2.utils.enums.SocialType.SINA_WEIBO_SSO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
        r7 = com.baidu.sapi2.utils.enums.SocialType.WEIXIN;
     */
    @Override // com.baidu.tieba.flutter.plugin.passprovider.PassProviderAuto.PassProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loginWithThirdPlatform(PassProviderAuto.LoginParams loginParams, PassProviderAuto.Result<PassProviderAuto.LoginResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, loginParams, result) == null) {
            try {
                String optString = new JSONObject(loginParams.getJson()).optString(com.tencent.connect.common.Constants.PARAM_PLATFORM);
                if ("more".equals(optString)) {
                    Activity findCurrentActivity = findCurrentActivity();
                    if (checkActivityIsValid(findCurrentActivity)) {
                        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) findCurrentActivity, true);
                        loginActivityConfig.setMinePageStatisticParams(CommonStatisticKey.KEY_MINE_PAGE_LOGIN_DIALOG_SUCCESS, "1");
                        loginActivityConfig.start();
                    }
                    onLoginFail(result);
                    return;
                }
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -791770330) {
                    if (hashCode != 3616) {
                        if (hashCode != 3872) {
                            if (hashCode == 113011944 && optString.equals(LOGIN_TYPE_WEIBO)) {
                                c2 = 2;
                            }
                        } else if (optString.equals("yy")) {
                            c2 = 3;
                        }
                    } else if (optString.equals("qq")) {
                        c2 = 0;
                    }
                } else if (optString.equals("wechat")) {
                    c2 = 1;
                }
                SocialType socialType = SocialType.QQ_SSO;
                thirdLogin(socialType, result);
            } catch (JSONException e2) {
                e2.printStackTrace();
                Activity findCurrentActivity2 = findCurrentActivity();
                if (checkActivityIsValid(findCurrentActivity2)) {
                    showToast(findCurrentActivity2.getString(R.string.parse_json_fail));
                    PassProviderAuto.LoginResult loginResult = new PassProviderAuto.LoginResult();
                    loginResult.setSuccess(Boolean.FALSE);
                    result.success(loginResult);
                }
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flutterPluginBinding) == null) {
            j.i(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterPluginBinding) == null) {
            j.i(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.passprovider.PassProviderAuto.PassProvider
    public void openLoginPage(PassProviderAuto.StatisticParams statisticParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, statisticParams) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) findCurrentActivity, true);
                if (statisticParams != null) {
                    loginActivityConfig.setMinePageStatisticParams(statisticParams.getKey(), statisticParams.getLocate());
                }
                loginActivityConfig.start();
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.passprovider.PassProviderAuto.PassProvider
    public void showLoginDialog(PassProviderAuto.StatisticParams statisticParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, statisticParams) == null) {
            Activity findCurrentActivity = findCurrentActivity();
            if (checkActivityIsValid(findCurrentActivity)) {
                FlutterBoost.instance().isCoverWithTransparentActivity = statisticParams.getIsCoverWithTransparentActivity();
                t0 t0Var = new t0(findCurrentActivity, "mine_page");
                if (statisticParams != null) {
                    t0Var.g(statisticParams.getKey());
                    t0Var.h(statisticParams.getLocate());
                }
                DialogLoginHelper.checkUpIsLogin(t0Var);
            }
        }
    }
}
