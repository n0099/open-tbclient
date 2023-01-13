package com.baidu.tbadk.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pp8;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PeiWanPageDispatcher implements pp8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_HALF = "1";
    public transient /* synthetic */ FieldHolder $fh;

    public PeiWanPageDispatcher() {
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

    @Override // com.baidu.tieba.pp8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            String obj = Objects.requireNonNull(hashMap.get("pageKey")).toString();
            if (hashMap.containsKey("isHalf")) {
                String obj2 = Objects.requireNonNull(hashMap.get("isHalf")).toString();
                if (!obj2.isEmpty() && obj2.equals("1")) {
                    hashMap.put("animated", Boolean.FALSE);
                    hashMap.put("swipeback", Boolean.FALSE);
                    hashMap.put("present", Boolean.TRUE);
                    hashMap.put("isFromNative", "1");
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), obj, hashMap)));
        }
    }
}
