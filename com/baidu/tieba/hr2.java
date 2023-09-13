package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hr2 extends bp2<sr2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bp2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setRemoteVideoPlayState" : (String) invokeV.objValue;
    }

    public hr2() {
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
    @Override // com.baidu.tieba.bp2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, sr2Var) == null) {
            String str = command.what;
            d(sr2Var, str, "" + command.obj, true);
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.has("status") && jSONObject.has("userId")) {
                    long optLong = jSONObject.optLong("userId", -1L);
                    boolean optBoolean = jSONObject.optBoolean("status");
                    if (qr2.a(optLong)) {
                        sr2Var.d0(optLong, optBoolean);
                    }
                }
            }
        }
    }
}
