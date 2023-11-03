package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedAuthorSocial;
import tbclient.FeedContentResource;
import tbclient.FeedKV;
import tbclient.FeedPicAbstract;
import tbclient.FrsTopThreadComponent;
/* loaded from: classes6.dex */
public class gyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsTopThreadComponent frsTopThreadComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsTopThreadComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (frsTopThreadComponent.title != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : frsTopThreadComponent.title) {
                    jSONArray.put(fsc.b(feedContentResource));
                }
                poc.a(jSONObject, "title", jSONArray);
            }
            FeedPicAbstract feedPicAbstract = frsTopThreadComponent.pic_abstract;
            if (feedPicAbstract != null) {
                poc.a(jSONObject, "pic_abstract", atc.b(feedPicAbstract));
            }
            FeedAuthorSocial feedAuthorSocial = frsTopThreadComponent.author_social;
            if (feedAuthorSocial != null) {
                poc.a(jSONObject, "author_social", asc.b(feedAuthorSocial));
            }
            if (frsTopThreadComponent.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : frsTopThreadComponent.business_info) {
                    jSONArray2.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "business_info", jSONArray2);
            }
            poc.a(jSONObject, "scheme", frsTopThreadComponent.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
