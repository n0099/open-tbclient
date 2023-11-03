package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedContentResource;
import tbclient.FeedPicAbstract;
import tbclient.PicInfo;
/* loaded from: classes5.dex */
public class atc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedPicAbstract feedPicAbstract) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedPicAbstract)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedPicAbstract.pics != null) {
                JSONArray jSONArray = new JSONArray();
                for (PicInfo picInfo : feedPicAbstract.pics) {
                    jSONArray.put(f1d.b(picInfo));
                }
                poc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            poc.a(jSONObject, "pic_scheme", feedPicAbstract.pic_scheme);
            if (feedPicAbstract._abstract != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedContentResource feedContentResource : feedPicAbstract._abstract) {
                    jSONArray2.put(fsc.b(feedContentResource));
                }
                poc.a(jSONObject, "abstract", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
