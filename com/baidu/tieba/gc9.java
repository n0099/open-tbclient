package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gc9 extends vr6<fc9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a b;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2, String str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc9(a aVar) {
        super(fc9.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vr6
    public void onEvent(fc9 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!TextUtils.isEmpty(event.a())) {
                try {
                    String a2 = event.a();
                    if (a2 != null) {
                        JSONObject optJSONObject = new JSONObject(a2).optJSONObject("robot_reply_info");
                        if (optJSONObject != null) {
                            String token = optJSONObject.optString("loading_post_token");
                            String content = optJSONObject.optString("content");
                            String postId = optJSONObject.optString("post_id");
                            a aVar = this.b;
                            if (aVar != null) {
                                Intrinsics.checkNotNullExpressionValue(token, "token");
                                Intrinsics.checkNotNullExpressionValue(content, "content");
                                Intrinsics.checkNotNullExpressionValue(postId, "postId");
                                aVar.a(token, content, postId);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
        }
    }
}
