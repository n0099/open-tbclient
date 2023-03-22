package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cn2 extends nl2<eo2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nl2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "enterRoom" : (String) invokeV.objValue;
    }

    public cn2() {
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

    @Override // com.baidu.tieba.nl2
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                command.ret = new ho2(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString(FileProvider.DISPLAYNAME_FIELD), jSONObject.optString("rtcAppId"), jSONObject.optString("token")).a() ? 1 : 0;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull eo2 eo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, eo2Var) == null) {
            String str = command.what;
            d(eo2Var, str, "" + command.obj, true);
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                ho2 ho2Var = new ho2(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString(FileProvider.DISPLAYNAME_FIELD), jSONObject.optString("rtcAppId"), jSONObject.optString("token"));
                boolean a = ho2Var.a();
                if (a) {
                    eo2Var.u(ho2Var);
                }
                command.ret = a ? 1 : 0;
            }
            String str2 = command.what;
            d(eo2Var, str2, "result: " + command.ret, true);
        }
    }
}
