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
    public static class C0171a {
        public long enQ;
        public String enR;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int enS = 0;
    }

    public static C0171a nM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0171a c0171a = new C0171a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0171a.portrait = optJSONObject.optString("head_url");
                c0171a.userId = optJSONObject.optString("user_id");
                c0171a.userName = optJSONObject.optString("nick_name");
                c0171a.enQ = optJSONObject.optLong("caller_time");
                c0171a.enR = optJSONObject.optString("caller_content");
                c0171a.threadId = optJSONObject.optLong("thread_id");
                c0171a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0171a.forumName = optJSONObject.optString("forum_name");
                c0171a.postId = optJSONObject.optLong("post_id");
                c0171a.msgType = optJSONObject.optInt("msg_type");
                c0171a.enS = optJSONObject.optInt("remind_count");
            }
            return c0171a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
