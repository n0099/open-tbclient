package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bv4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bv4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, JSONObject> a;

    public bv4() {
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
        this.a = new HashMap<>();
    }

    public static bv4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (bv4.class) {
                    if (b == null) {
                        b = new bv4();
                    }
                }
            }
            return b;
        }
        return (bv4) invokeV.objValue;
    }

    public void a(String str, String str2, String str3, String str4) {
        HashMap<String, JSONObject> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) && StringUtils.isNotNull(str) && (hashMap = this.a) != null && hashMap.get(str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apkName", str2);
                jSONObject.put("source", str3 + "");
                jSONObject.put("apkUrl", str4);
                this.a.put(str, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            StatisticItem param = new StatisticItem(str).param("obj_source", str2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str3);
            if (StringUtils.isNotNull(str4)) {
                param.param(TiebaStatic.Params.OBJ_URL, str4);
            }
            TiebaStatic.log(param);
        }
    }

    public void d(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            String g = cf5.g(intent);
            HashMap<String, JSONObject> hashMap = this.a;
            if (hashMap != null && hashMap.get(g) != null) {
                JSONObject jSONObject = this.a.get(g);
                if (jSONObject != null) {
                    b(TbadkCoreStatisticKey.INSTALL_APK_COMPLETION, jSONObject.optString("source"), jSONObject.optString("apkName"), jSONObject.optString("apkUrl"));
                }
                this.a.remove(g);
            }
        }
    }
}
