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
    public static class C0312a {
        public long geD;
        public String geE;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int geF = 0;
    }

    public static C0312a wu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0312a c0312a = new C0312a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0312a.portrait = optJSONObject.optString("head_url");
                c0312a.userId = optJSONObject.optString("user_id");
                c0312a.userName = optJSONObject.optString("nick_name");
                c0312a.geD = optJSONObject.optLong("caller_time");
                c0312a.geE = optJSONObject.optString("caller_content");
                c0312a.threadId = optJSONObject.optLong("thread_id");
                c0312a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0312a.forumName = optJSONObject.optString("forum_name");
                c0312a.postId = optJSONObject.optLong("post_id");
                c0312a.msgType = optJSONObject.optInt("msg_type");
                c0312a.geF = optJSONObject.optInt("remind_count");
            }
            return c0312a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
