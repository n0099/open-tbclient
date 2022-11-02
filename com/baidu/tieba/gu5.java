package com.baidu.tieba;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gu5 extends ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gu5() {
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

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.C0;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.B0;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.A0;
        }
        return (String) invokeV.objValue;
    }

    public JSONArray o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.D0;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void p(JSONObject jSONObject) throws JSONException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            int i = 1;
            this.t0 = true;
            this.v = jSONObject.getString("title");
            this.x = jSONObject.getString("linkUrl");
            this.w = jSONObject.optString("content");
            this.A = jSONObject.optString("imageUrl");
            this.A0 = jSONObject.optString("mediaType");
            if (StringUtils.isNull(this.A)) {
                str = jSONObject.optString("iconUrl");
            } else {
                str = this.A;
            }
            this.A = str;
            this.z = Uri.parse(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                this.u0 = optJSONObject.optString("source2");
                this.w0 = optJSONObject.optString("source3");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
            if (optJSONObject2 != null) {
                this.v0 = 2;
                this.D0 = optJSONObject2.optJSONArray("cmd_pannel");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("info");
                this.E0 = optJSONObject3;
                if (optJSONObject3 != null) {
                    this.B0 = optJSONObject3.optString("key");
                    this.C0 = this.E0.optString("content");
                    return;
                }
                return;
            }
            if (!"url".equals(jSONObject.optString("type"))) {
                i = 3;
            }
            this.v0 = i;
        }
    }
}
