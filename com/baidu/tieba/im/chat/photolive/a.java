package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0154a {
        public long dTP;
        public String dTQ;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int dTR = 0;
    }

    public static C0154a mS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0154a c0154a = new C0154a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0154a.portrait = optJSONObject.optString("head_url");
                c0154a.userId = optJSONObject.optString("user_id");
                c0154a.userName = optJSONObject.optString("nick_name");
                c0154a.dTP = optJSONObject.optLong("caller_time");
                c0154a.dTQ = optJSONObject.optString("caller_content");
                c0154a.threadId = optJSONObject.optLong("thread_id");
                c0154a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0154a.forumName = optJSONObject.optString("forum_name");
                c0154a.postId = optJSONObject.optLong("post_id");
                c0154a.msgType = optJSONObject.optInt("msg_type");
                c0154a.dTR = optJSONObject.optInt("remind_count");
            }
            return c0154a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
