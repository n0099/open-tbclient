package com.baidu.tieba.aiapps;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TbAiappsLaunchUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TbAiappsLaunchUtil() {
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

    public static String getSmartLink(String str, String str2, String str3, Integer num) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, str3, num)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("tiebaclient://");
            if (num.intValue() > 0) {
                sb.append("swangame/");
            } else {
                sb.append("swan/");
            }
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                if (!str2.startsWith("/")) {
                    sb.append("/");
                }
                sb.append(str2);
            } else {
                sb.append("/");
            }
            if (!TextUtils.isEmpty(Uri.parse(sb.toString()).getQuery())) {
                sb.append("&");
            } else {
                if (!sb.toString().endsWith("/")) {
                    sb.append("/");
                }
                sb.append("?");
            }
            sb.append("_baiduboxapp=");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sb.append(URLEncoder.encode(jSONObject.toString()));
            sb.append("&callback=_bdbox_js_275&upgrade=0");
            return sb.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static final boolean launch(String str, String str2, String str3, Integer num) {
        InterceptResult invokeLLLL;
        String smartLink;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, str2, str3, num)) == null) {
            if (TextUtils.isEmpty(str) || (smartLink = getSmartLink(str, str2, str3, num)) == null || !smartLink.startsWith("tiebaclient://")) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, smartLink));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
