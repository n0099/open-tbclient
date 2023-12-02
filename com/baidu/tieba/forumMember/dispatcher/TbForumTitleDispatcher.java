package com.baidu.tieba.forumMember.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import com.baidu.tieba.oma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/forumMember/dispatcher/TbForumTitleDispatcher;", "Lcom/baidu/tieba/schema/SchemaDispatcher;", "()V", "dispatch", "", "params", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "forumMember_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbForumTitleDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TbForumTitleDispatcher() {
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

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            Intent intent = new Intent(context, TbTitleActivity.class);
            intent.putExtra("forum_id", jSONObject.optString("forumId"));
            intent.putExtra("forum_name", jSONObject.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME));
            context.startActivity(intent);
        }
    }
}
