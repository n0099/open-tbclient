package com.baidu.tieba.enterForum.hotuserrank.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity;
import com.baidu.tieba.xk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HotUserRankListDispatcher implements xk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HotUserRankListDispatcher() {
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

    @Override // com.baidu.tieba.xk8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            Intent intent = new Intent();
            intent.setClass(context, HotUserRankActivity.class);
            intent.putExtra(HotUserRankActivityConfig.KEY_FORUM_ID, jSONObject.optLong("forumId"));
            context.startActivity(intent);
        }
    }
}
