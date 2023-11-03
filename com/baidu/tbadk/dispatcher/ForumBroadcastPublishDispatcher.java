package com.baidu.tbadk.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.qha;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ForumBroadcastPublishDispatcher implements qha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ForumBroadcastPublishDispatcher() {
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

    @Override // com.baidu.tieba.qha
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_ID, jSONObject.optString("forumId"));
            hashMap.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, jSONObject.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME));
            hashMap.put("obj_source", jSONObject.optString("objSource"));
            hashMap.put("swipeback", Boolean.valueOf(jSONObject.optBoolean("swipeback")));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(context, "BarBroadcastEditPage", hashMap)));
        }
    }
}
