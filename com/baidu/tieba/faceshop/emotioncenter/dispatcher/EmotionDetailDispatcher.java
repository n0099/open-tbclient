package com.baidu.tieba.faceshop.emotioncenter.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity;
import com.baidu.tieba.t1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EmotionDetailDispatcher implements t1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EmotionDetailDispatcher() {
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

    @Override // com.baidu.tieba.t1a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            int optInt = jSONObject.optInt("pckId");
            Long valueOf = Long.valueOf(jSONObject.optLong("picId"));
            Intent intent = new Intent();
            intent.putExtra("pck_id", optInt);
            intent.putExtra(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, valueOf);
            intent.setClass(context, EmotionDetailActivity.class);
            context.startActivity(intent);
        }
    }
}
