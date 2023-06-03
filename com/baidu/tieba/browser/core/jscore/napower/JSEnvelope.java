package com.baidu.tieba.browser.core.jscore.napower;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.fm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes5.dex */
public class JSEnvelope {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callback;
    public final String cmd;
    public final String method;
    public final Map<String, Object> requestData;
    public final Map<String, Object> responseData;
    public final String type;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    private boolean isSendMessagePackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public JSEnvelope(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, map, map2, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = str2;
        this.method = str3;
        this.requestData = map;
        this.responseData = map2;
        this.type = str;
        this.callback = str4;
    }

    public /* synthetic */ JSEnvelope(String str, String str2, String str3, Map map, Map map2, String str4, a aVar) {
        this(str, str2, str3, map, map2, str4);
    }

    private String encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String replace = str.replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029");
            return "javascript:__tb_js_bridge.send('" + replace + "');";
        }
        return (String) invokeL.objValue;
    }

    private <T> JSONObject map2Json(Map<String, T> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    fm6.b("newHybrid", "Map 转 json 非法json字符串:" + e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public String encode() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isSendMessagePackage()) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(this.cmd)) {
                    jSONObject.put("cmd", this.cmd);
                }
                if (!TextUtils.isEmpty(this.method)) {
                    jSONObject.put("method", this.method);
                }
                Map<String, Object> map = this.requestData;
                if (map != null && !map.isEmpty()) {
                    jSONObject.put("inputData", map2Json(this.requestData));
                }
                Map<String, Object> map2 = this.responseData;
                if (map2 != null && !map2.isEmpty()) {
                    jSONObject.put("outputData", map2Json(this.responseData));
                }
                jSONObject.put("messageType", this.type);
                if (!TextUtils.isEmpty(this.callback)) {
                    jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.callback);
                }
                return encode(jSONObject.toString());
            }
            StringBuilder sb = new StringBuilder("javascript:");
            sb.append(this.method);
            Map<String, Object> map3 = this.requestData;
            if (map3 != null && !map3.isEmpty()) {
                sb.append("(");
                sb.append(map2Json(this.responseData));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            } else {
                sb.append("()");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
