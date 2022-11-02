package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;

    public i95() {
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

    public static i95 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                i95 i95Var = new i95();
                i95Var.a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                i95Var.b = jSONObject.optInt("width");
                i95Var.c = jSONObject.optInt("height");
                i95Var.d = jSONObject.optString("pic_url");
                i95Var.e = jSONObject.optString("thumbnail");
                i95Var.g = jSONObject.optString("origin_url");
                return i95Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (i95) invokeL.objValue;
    }
}
