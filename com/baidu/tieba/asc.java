package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Agree;
import tbclient.FeedAuthorSocial;
import tbclient.FeedHeadImg;
import tbclient.FeedHeadSymbol;
/* loaded from: classes5.dex */
public class asc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedAuthorSocial feedAuthorSocial) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedAuthorSocial)) == null) {
            JSONObject jSONObject = new JSONObject();
            FeedHeadImg feedHeadImg = feedAuthorSocial.image_data;
            if (feedHeadImg != null) {
                poc.a(jSONObject, "image_data", psc.b(feedHeadImg));
            }
            if (feedAuthorSocial.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedAuthorSocial.main_data) {
                    jSONArray.put(qsc.b(feedHeadSymbol));
                }
                poc.a(jSONObject, "main_data", jSONArray);
            }
            Agree agree = feedAuthorSocial.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            poc.a(jSONObject, "comment_num", feedAuthorSocial.comment_num);
            poc.a(jSONObject, "share_num", feedAuthorSocial.share_num);
            poc.a(jSONObject, "tid", feedAuthorSocial.tid);
            poc.a(jSONObject, "fid", feedAuthorSocial.fid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
