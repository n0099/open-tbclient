package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.p05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ge9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public n05 b;
    public PermissionJudgePolicy c;
    public final int d;
    public final int e;
    public final int f;
    public c g;

    /* loaded from: classes6.dex */
    public final class a implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ ge9 c;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(ge9 ge9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ge9Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 mPopupDialogView, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, mPopupDialogView, i, view2) == null) {
                Intrinsics.checkNotNullParameter(mPopupDialogView, "mPopupDialogView");
                Intrinsics.checkNotNullParameter(view2, "view");
                if (!(view2 instanceof TextView)) {
                    return;
                }
                String obj = ((TextView) view2).getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                this.c.j(mPopupDialogView, obj, this.a, this.b);
                n05 n05Var = this.c.b;
                if (n05Var != null) {
                    n05Var.dismiss();
                }
            }
        }

        public final void a(String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
                this.a = str;
                this.b = bArr;
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public final /* synthetic */ ge9 d;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(ge9 ge9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ge9Var;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    this.c = new JSONObject(str).optString("pid");
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(String... params) {
            InterceptResult invokeL;
            boolean z;
            HttpNetContext netContext;
            HttpResponse response;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                NetWork netWork = new NetWork(TbConfig.URL_REQUEST_PID);
                this.a = netWork;
                String str = null;
                boolean z2 = false;
                try {
                    String str2 = params[0];
                    this.b = str2;
                    if (netWork != null) {
                        netWork.addPostData("pic_url", str2);
                    }
                    NetWork netWork2 = this.a;
                    if (netWork2 != null) {
                        str = netWork2.postMultiNetData();
                    }
                    NetWork netWork3 = this.a;
                    if (netWork3 != null && (netContext = netWork3.getNetContext()) != null && (response = netContext.getResponse()) != null && response.isRequestSuccess()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (!((str == null || str.length() == 0) ? true : true)) {
                            c(str);
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    Intrinsics.checkNotNull(netWork);
                    netWork.cancelNetConnect();
                }
                this.d.a = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                super.onPostExecute((b) str);
                PersonalMsgImageActivityConfig personalMsgImageActivityConfig = new PersonalMsgImageActivityConfig(TbadkApplication.getInst(), this.b, TbadkCoreApplication.getCurrentAccountId(), "");
                personalMsgImageActivityConfig.isFromGroupChat(true);
                personalMsgImageActivityConfig.setPid(this.c);
                personalMsgImageActivityConfig.isShieldLongClickViewTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalMsgImageActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final byte[] b;
        public final /* synthetic */ ge9 c;

        public c(ge9 ge9Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge9Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ge9Var;
            this.a = str;
            this.b = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(String... arg0) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arg0)) == null) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.a, this.b, TbadkApplication.getInst());
                if (saveImageFileByUser == this.c.d) {
                    String string = TbadkCoreApplication.getInst().getString(R.string.save_image_to_album);
                    Intrinsics.checkNotNullExpressionValue(string, "getInst()\n              …ring.save_image_to_album)");
                    return string;
                } else if (saveImageFileByUser == this.c.f) {
                    String sdErrorString = FileHelper.getSdErrorString();
                    Intrinsics.checkNotNullExpressionValue(sdErrorString, "getSdErrorString()");
                    return sdErrorString;
                } else if (saveImageFileByUser == this.c.e) {
                    String string2 = TbadkCoreApplication.getInst().getString(R.string.save_fail);
                    Intrinsics.checkNotNullExpressionValue(string2, "getInst()\n              …kcore.R.string.save_fail)");
                    return string2;
                } else {
                    String string3 = TbadkCoreApplication.getInst().getString(R.string.save_fail);
                    Intrinsics.checkNotNullExpressionValue(string3, "getInst()\n              …kcore.R.string.save_fail)");
                    return string3;
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.g = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onPostExecute((c) result);
                this.c.g = null;
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), result);
            }
        }
    }

    public ge9() {
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
        this.e = -1;
        this.f = -2;
    }

    public final String[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1328);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(com.….tbadkcore.R.string.save)");
            return new String[]{string};
        }
        return (String[]) invokeV.objValue;
    }

    public final void i(String mImgUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mImgUrl) == null) {
            Intrinsics.checkNotNullParameter(mImgUrl, "mImgUrl");
            b bVar = new b(this);
            this.a = bVar;
            if (bVar != null) {
                bVar.execute(mImgUrl);
            }
        }
    }

    public final void j(p05 p05Var, String str, String str2, byte[] bArr) {
        TbPageContextSupport tbPageContextSupport;
        TbPageContext pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, p05Var, str, str2, bArr) == null) {
            Context d = p05Var.d();
            Activity activity = null;
            if (d instanceof TbPageContextSupport) {
                tbPageContextSupport = (TbPageContextSupport) d;
            } else {
                tbPageContextSupport = null;
            }
            if (Intrinsics.areEqual(str, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1328))) {
                if (tbPageContextSupport != null && (pageContext = tbPageContextSupport.getPageContext()) != null) {
                    activity = pageContext.getPageActivity();
                }
                if (this.c == null) {
                    this.c = new PermissionJudgePolicy();
                }
                PermissionJudgePolicy permissionJudgePolicy = this.c;
                if (permissionJudgePolicy != null) {
                    permissionJudgePolicy.clearRequestPermissionList();
                }
                PermissionJudgePolicy permissionJudgePolicy2 = this.c;
                if (permissionJudgePolicy2 != null) {
                    permissionJudgePolicy2.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                }
                PermissionJudgePolicy permissionJudgePolicy3 = this.c;
                boolean z = true;
                if ((permissionJudgePolicy3 == null || !permissionJudgePolicy3.startRequestPermission(activity)) ? false : false) {
                    return;
                }
                c cVar = new c(this, str2, bArr);
                this.g = cVar;
                if (cVar != null) {
                    cVar.execute(new String[0]);
                }
            }
        }
    }

    public final void k(Context mContext, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mContext, str, bArr) == null) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            TbPageContext currentPageContext = TbadkApplication.getInst().getCurrentPageContext(mContext);
            if (currentPageContext != null) {
                n05 n05Var = new n05(currentPageContext);
                a aVar = new a(this);
                aVar.a(str, bArr);
                n05Var.i(null, h(), aVar);
                this.b = n05Var;
                if (n05Var != null) {
                    n05Var.l();
                }
            }
        }
    }
}
