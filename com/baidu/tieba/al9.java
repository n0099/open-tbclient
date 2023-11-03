package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.CheckShowNameDialogSwitch;
import com.baidu.tieba.pv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class al9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public final String b;
        public final String c;
        public final String d;
        public String e;
        public final AccountLoginCoreHelper.IReLoginCallback f;
        public final boolean g;

        /* loaded from: classes5.dex */
        public class a implements AccountLoginCoreHelper.IReLoginCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
            public void onBeforeLogin(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                }
            }

            @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
            public void onFailure(String str, int i, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) {
                }
            }

            @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
            public void onSuccess(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public b(String str, String str2, String str3, AccountLoginCoreHelper.IReLoginCallback iReLoginCallback, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, iReLoginCallback, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.g = z;
            this.f = iReLoginCallback == null ? new a(this) : iReLoginCallback;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01ca  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            InterceptResult invokeL;
            AccountData accountData;
            int i;
            int i2;
            AccountLoginCoreHelper.a d;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                boolean z = false;
                this.a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.a.addPostData("bdusstoken", this.c + "|" + this.d);
                if (!StringUtils.isNull(this.e)) {
                    this.a.addPostData("stoken", this.e);
                }
                this.a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.a.addPostData("first_login", TbadkCoreApplication.getInst().getDeviceIsFirstLogin());
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    xx4 xx4Var = new xx4();
                    xx4Var.d(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(xx4Var.c().getUserName());
                    accountData.setPassword("");
                    accountData.setID(xx4Var.c().getUserId());
                    String str = this.c;
                    if (this.g && (d = dl9.d(AccountLoginCoreHelper.getInstance().parseBDUSS(str))) != null) {
                        str = d.a + "|" + d.b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(xx4Var.c().getPortrait());
                    accountData.setStoken(this.e);
                    accountData.setIsActive(1);
                    if (xx4Var.a() != null) {
                        accountData.setTbs(xx4Var.a().getTbs());
                    }
                    accountData.setGrowthSwitch(xx4Var.b());
                } else {
                    accountData = null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                if (accountData != null) {
                    netWork.addPostData(HttpRequest.BDUSS, accountData.getBDUSS());
                    netWork.addPostData("stoken", pv4.a(accountData));
                }
                String postNetData2 = netWork.postNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess() && postNetData2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(postNetData2);
                        JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i3 = 0; i3 < length; i3++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                                if (optJSONObject != null && CheckShowNameDialogSwitch.KEY.equals(optJSONObject.optString("name"))) {
                                    i = optJSONObject.optInt("type", 0);
                                    break;
                                }
                            }
                        }
                        i = 0;
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(SourceConstant.SOURCE_USER_INFO);
                            if (accountData != null && jSONObject2 != null) {
                                accountData.setNameShow(jSONObject2.optString("name_show"));
                            }
                        } catch (JSONException e) {
                            i2 = i;
                            e = e;
                            e.printStackTrace();
                            i = i2;
                            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                            if (i == 1) {
                            }
                            inst.setNeedCheckUserNameDialog(z);
                            return accountData;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        i2 = 0;
                    }
                } else {
                    i = 0;
                }
                TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
                if (i == 1) {
                    z = true;
                }
                inst2.setNeedCheckUserNameDialog(z);
                return accountData;
            }
            return (AccountData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
                super.onPostExecute(accountData);
                int i = 0;
                ReloginManager.g().o(false);
                Logger.addLog("account", -1L, 0, "cslogin_result", this.a.getServerErrorCode(), this.a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f.onSuccess(accountData);
                    return;
                }
                String str = null;
                if (this.a != null) {
                    str = this.a.getErrorString();
                    i = this.a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
                }
                this.f.onFailure(this.b, i, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f.onBeforeLogin(this.b);
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.e = str;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements pv4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ AccountLoginCoreHelper.IReLoginCallback b;
        public final /* synthetic */ String c;

        public a(b bVar, AccountLoginCoreHelper.IReLoginCallback iReLoginCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, iReLoginCallback, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = iReLoginCallback;
            this.c = str;
        }

        @Override // com.baidu.tieba.pv4.b
        public void onFailed() {
            AccountLoginCoreHelper.IReLoginCallback iReLoginCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iReLoginCallback = this.b) != null) {
                iReLoginCallback.onFailure(this.c, 1, null);
            }
        }

        @Override // com.baidu.tieba.pv4.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d(str);
                this.a.execute(new String[0]);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, AccountLoginCoreHelper.IReLoginCallback iReLoginCallback) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, iReLoginCallback)) == null) {
            pv4 pv4Var = new pv4();
            b bVar = new b(str, str2, str3, iReLoginCallback, false);
            if (pv4.b() && StringUtils.isNull(str4)) {
                pv4Var.c(str2, new a(bVar, iReLoginCallback, str));
            } else {
                if (pv4.b()) {
                    bVar.d(str4);
                }
                bVar.execute(new String[0]);
            }
            return bVar;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
