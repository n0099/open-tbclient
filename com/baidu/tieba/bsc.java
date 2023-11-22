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
public class bsc extends qoc {
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
                qoc.a(jSONObject, "image_data", qsc.b(feedHeadImg));
            }
            if (feedAuthorSocial.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedAuthorSocial.main_data) {
                    jSONArray.put(rsc.b(feedHeadSymbol));
                }
                qoc.a(jSONObject, "main_data", jSONArray);
            }
            Agree agree = feedAuthorSocial.agree;
            if (agree != null) {
                qoc.a(jSONObject, "agree", hpc.b(agree));
            }
            qoc.a(jSONObject, "comment_num", feedAuthorSocial.comment_num);
            qoc.a(jSONObject, "share_num", feedAuthorSocial.share_num);
            qoc.a(jSONObject, "tid", feedAuthorSocial.tid);
            qoc.a(jSONObject, "fid", feedAuthorSocial.fid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
