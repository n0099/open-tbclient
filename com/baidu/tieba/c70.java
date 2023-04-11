package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray a;
    public String b;
    public boolean c;
    public JSONObject d;

    public c70(boolean z, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = jSONArray;
        this.b = String.valueOf(System.currentTimeMillis());
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uploadtime", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.d = jSONObject;
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray jSONArray = this.a;
            if (jSONArray != null && jSONArray.length() >= 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TtmlNode.TAG_METADATA, a());
                    if (this.c) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    jSONObject.put(Constant.IS_REAL, str);
                    jSONObject.put("data", this.a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                f70.a("UploadData", "uploadJson:" + jSONObject.toString());
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
