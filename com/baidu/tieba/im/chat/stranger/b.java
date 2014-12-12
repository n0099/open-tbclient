package com.baidu.tieba.im.chat.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static c ga(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                cVar.aUq = optJSONObject.optString("title");
                cVar.replyContent = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                cVar.aUt = optJSONObject.optString("quote_content");
                cVar.aUv = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                cVar.threadId = optJSONObject.optString("thread_id");
                cVar.postId = optJSONObject.optString("post_id");
                cVar.type = optJSONObject.optInt("type");
                cVar.title = optJSONObject.optString("title");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    cVar.aUr = optJSONObject2.optString("id");
                    cVar.aUu = optJSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                    cVar.aUs = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    cVar.aUo = optJSONObject3.optString("id");
                    cVar.aUp = optJSONObject3.optInt("gender");
                }
            }
            return cVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
