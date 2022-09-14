package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final String b;
        public final String c;
        public final String d;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                Boolean bool = Boolean.FALSE;
                try {
                    NetWork netWork = new NetWork(this.b);
                    this.a = netWork;
                    bool = Boolean.valueOf(netWork.downloadFile(this.c + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
                    if (bool != null && bool.booleanValue()) {
                        if (!StringUtils.isNull(FileHelper.renameTo(null, this.c + ".tmp", null, this.c)) && !TextUtils.isEmpty(this.b) && !this.b.equals(this.d)) {
                            FileHelper.DelFile(TbMd5.getNameMd5FromUrl(this.d));
                        }
                    } else {
                        FileHelper.DelFile(this.c + ".tmp");
                    }
                } catch (Exception unused) {
                }
                return bool;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                super.onPostExecute((a) bool);
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                new d25().g();
            }
        }
    }

    public d25() {
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

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkSettings.getInst().loadString("launch_config_local_url", "") : (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject optJSONObject;
        String str;
        String str2;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONArray = jSONObject.getJSONArray("APP_INDEX_START");
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        if (jSONArray == null || jSONArray.length() == 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return;
        }
        int optInt = optJSONObject.optInt("url_type");
        String optString = optJSONObject.optString("url");
        String optString2 = optJSONObject.optString("apk_url");
        String optString3 = optJSONObject.optString("apk_name");
        String optString4 = optJSONObject.optString("app_name");
        inst.saveString("url", optString);
        inst.saveInt("url_type", optInt);
        inst.saveString("apk_url", optString2);
        inst.saveString("apk_name", optString3);
        inst.saveString("app_name", optString4);
        JSONArray optJSONArray = optJSONObject.optJSONArray("goods_info");
        if (optJSONArray == null || optJSONArray.length() == 0 || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
            str = null;
            str2 = null;
        } else {
            str = optJSONObject2.optString("thread_pic");
            str2 = optJSONObject2.optString("thread_pic_md5");
            inst.saveString("apk_size", optJSONObject2.optString("apk_size"));
        }
        if (StringUtils.isNull(str2) || StringUtils.isNull(str)) {
            return;
        }
        String loadString = inst.loadString("launch_config_md5", null);
        if (StringUtils.isNull(loadString)) {
            inst.saveString("launch_config_md5", str2);
            inst.saveString("launch_config_remote_url", str);
            d(str);
        } else if (TextUtils.equals(loadString, str2)) {
        } else {
            inst.saveString("launch_config_md5", str2);
            inst.saveString("launch_config_remote_url", str);
            d(str);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            String b = b();
            if (TextUtils.equals(b, str) && e(b)) {
                return;
            }
            f(str, b);
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            File GetFile = FileHelper.GetFile(TbMd5.getNameMd5FromUrl(str));
            return GetFile != null && GetFile.exists() && GetFile.isFile();
        }
        return invokeL.booleanValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && BdNetTypeUtil.isWifiNet()) {
            new a(str, TbMd5.getNameMd5FromUrl(str), str2).execute(new String[0]);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
            if (StringUtils.isNull(loadString)) {
                return;
            }
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }
}
