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
    public static class C0345a {
        public long gEM;
        public String gEN;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int gEO = 0;
    }

    public static C0345a yV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0345a c0345a = new C0345a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0345a.portrait = optJSONObject.optString("head_url");
                c0345a.userId = optJSONObject.optString("user_id");
                c0345a.userName = optJSONObject.optString("nick_name");
                c0345a.gEM = optJSONObject.optLong("caller_time");
                c0345a.gEN = optJSONObject.optString("caller_content");
                c0345a.threadId = optJSONObject.optLong("thread_id");
                c0345a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0345a.forumName = optJSONObject.optString("forum_name");
                c0345a.postId = optJSONObject.optLong("post_id");
                c0345a.msgType = optJSONObject.optInt("msg_type");
                c0345a.gEO = optJSONObject.optInt("remind_count");
            }
            return c0345a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
