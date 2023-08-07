package com.baidu.tbadk.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tieba.s1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BarDetailDispatcher implements s1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BarDetailDispatcher() {
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

    @Override // com.baidu.tieba.s1a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) {
            ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(context, jSONObject.optString("forumId"), ForumDetailActivityConfig.FromType.BLUEV_SETTLE);
            int intValue = Integer.valueOf(jSONObject.optString("selectHostTab")).intValue();
            if (intValue == 1 || intValue == 2 || intValue == 3) {
                forumDetailActivityConfig.setSelectHostTab(intValue);
            }
            forumDetailActivityConfig.setRequestCode(25070);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
        }
    }
}
