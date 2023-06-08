package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class al6 extends BdAsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public al6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        String str;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            String modName = TbSingleton.getInstance().getModName();
            if (TextUtils.isEmpty(modName)) {
                return null;
            }
            yk6 d = d(modName);
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
            netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
            netWork.addPostData("mod_name", modName);
            if (d.b()) {
                str = "1";
            } else {
                str = "2";
            }
            netWork.addPostData("status", str);
            if (d.b()) {
                a = "";
            } else {
                a = d.a();
            }
            netWork.addPostData("fail_reason", a);
            netWork.postNetData();
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void c(String str, yk6 yk6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, yk6Var) == null) {
            if (StringUtils.isNull(str)) {
                yk6Var.c("serve return is null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("error_code") == 0) {
                    z = true;
                } else {
                    z = false;
                }
                yk6Var.d(z);
                yk6Var.c(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
            } catch (JSONException e) {
                yk6Var.c("parse json exception");
                BdLog.e(e);
            }
        }
    }

    public final yk6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            yk6 yk6Var = new yk6();
            if (TextUtils.isEmpty(str)) {
                yk6Var.c("module not exit");
                return yk6Var;
            }
            File file = new File(vk6.m().l(), str);
            String o = vk6.m().o(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                yk6Var.d(false);
                if (!file.exists()) {
                    yk6Var.c("bundle not exist");
                    return yk6Var;
                } else if (TextUtils.isEmpty(o)) {
                    yk6Var.c("the local has no valid version name");
                    return yk6Var;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + o + "/";
                    if (!new File(str2).exists()) {
                        yk6Var.c("bundle not exist");
                        return yk6Var;
                    }
                    String str3 = file.getAbsolutePath() + "/" + o + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (v85.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", o);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        c(netWork.uploadFile("offline_pack_file_stream", str3), yk6Var);
                        if (!yk6Var.b()) {
                            return yk6Var;
                        }
                    } else {
                        yk6Var.c("zip bundle error");
                        return yk6Var;
                    }
                }
            } else {
                yk6Var.d(true);
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                vk6.m().g(str);
                if (!TextUtils.isEmpty(o)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", o));
                }
                if (file.exists() && !StringUtils.isNull(o)) {
                    if (!new File(file.getAbsolutePath(), o).exists()) {
                        return yk6Var;
                    }
                    yk6Var.c("delete fail");
                    yk6Var.d(false);
                }
            }
            return yk6Var;
        }
        return (yk6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            dl6.c();
        }
    }
}
