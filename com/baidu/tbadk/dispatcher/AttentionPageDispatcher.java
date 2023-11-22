package com.baidu.tbadk.dispatcher;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tieba.rha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AttentionPageDispatcher implements rha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AttentionPageDispatcher() {
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

    @Override // com.baidu.tieba.rha
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            int optInt = jSONObject.optInt("sex");
            String optString = jSONObject.optString("uid");
            if (TextUtils.isEmpty(optString)) {
                optString = TbadkCoreApplication.getCurrentAccount();
            }
            String optString2 = jSONObject.optString("portrait");
            String optString3 = jSONObject.optString(ReplyMeActivityConfig.KEY_FROM);
            if (!TextUtils.isEmpty(optString)) {
                PersonListActivityConfig personListActivityConfig = new PersonListActivityConfig(context, false, optString, optInt);
                Intent intent = personListActivityConfig.getIntent();
                intent.putExtra("key_portrait_url", optString2);
                intent.putExtra("key_call_from", optString3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personListActivityConfig));
            }
        }
    }
}
