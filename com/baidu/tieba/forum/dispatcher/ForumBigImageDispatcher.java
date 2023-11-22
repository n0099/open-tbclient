package com.baidu.tieba.forum.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.rha;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/forum/dispatcher/ForumBigImageDispatcher;", "Lcom/baidu/tieba/schema/SchemaDispatcher;", "()V", "dispatch", "", "params", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumBigImageDispatcher implements rha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ForumBigImageDispatcher() {
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
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) {
            HashMap hashMap = new HashMap();
            String str3 = null;
            if (jSONObject != null) {
                str = jSONObject.optString("forumId");
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("forum_id", str);
            if (jSONObject != null) {
                str2 = jSONObject.optString("heroTag");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("heroTag", str2);
            if (jSONObject != null) {
                str3 = jSONObject.optString("imageUrl");
            }
            if (str3 != null) {
                str4 = str3;
            }
            hashMap.put("imageUrl", str4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(context, "PhotoViewSimpleScreenPage", hashMap)));
        }
    }
}
