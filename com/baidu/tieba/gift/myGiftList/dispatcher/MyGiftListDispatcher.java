package com.baidu.tieba.gift.myGiftList.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.kf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MyGiftListDispatcher implements kf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MyGiftListDispatcher() {
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

    @Override // com.baidu.tieba.kf8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) || jSONObject == null || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, MyGiftListActivity.class);
        intent.putExtra("id", jSONObject.optString("uid"));
        intent.putExtra("sex", jSONObject.optString("sexId"));
        intent.putExtra("st_type", jSONObject.optString("stType"));
        intent.putExtra("user_name", jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        intent.putExtra("name_show", jSONObject.optString("nameShow"));
        context.startActivity(intent);
    }
}
