package com.baidu.tieba.frs.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.s1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FrsDispatcher implements s1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FrsDispatcher() {
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
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
            frsActivityConfig.createNormalCfg(jSONObject.optString("forumName"), null);
            int i = JavaTypesHelper.toInt(jSONObject.optString("callFrom"), -1);
            long optLong = jSONObject.optLong("roomId");
            if (optLong != 0) {
                frsActivityConfig.setRoomId(optLong);
                frsActivityConfig.setIsShowImGroupList(1);
            }
            if (i >= 0) {
                frsActivityConfig.setCallFrom(i);
            }
            int optInt = jSONObject.optInt("tab_id");
            if (optInt != 0) {
                frsActivityConfig.setJumpTabId(optInt);
            }
            frsActivityConfig.setToastData(jSONObject.optString("toast"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, frsActivityConfig));
        }
    }
}
