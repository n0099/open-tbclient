package com.baidu.tbadk.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.y5a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AuthenticationCenterDispatcher implements y5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AuthenticationCenterDispatcher() {
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

    @Override // com.baidu.tieba.y5a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            HashMap hashMap = new HashMap();
            String optString = jSONObject.optString("portrait");
            String optString2 = jSONObject.optString("entryType");
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put("portrait", optString);
                hashMap.put("entryType", optString2);
            } else {
                hashMap.put("uid", Long.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                hashMap.put("entryType", "1");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), "AuthenticationCenterPage", hashMap)));
        }
    }
}
