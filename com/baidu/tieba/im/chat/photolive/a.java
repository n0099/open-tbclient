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
    public static class C0172a {
        public long ekc;
        public String ekd;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int eke = 0;
    }

    public static C0172a nI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0172a c0172a = new C0172a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0172a.portrait = optJSONObject.optString("head_url");
                c0172a.userId = optJSONObject.optString("user_id");
                c0172a.userName = optJSONObject.optString("nick_name");
                c0172a.ekc = optJSONObject.optLong("caller_time");
                c0172a.ekd = optJSONObject.optString("caller_content");
                c0172a.threadId = optJSONObject.optLong("thread_id");
                c0172a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0172a.forumName = optJSONObject.optString("forum_name");
                c0172a.postId = optJSONObject.optLong("post_id");
                c0172a.msgType = optJSONObject.optInt("msg_type");
                c0172a.eke = optJSONObject.optInt("remind_count");
            }
            return c0172a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
