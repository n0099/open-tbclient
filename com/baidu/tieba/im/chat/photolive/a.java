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
    public static class C0244a {
        public long eOK;
        public String eOL;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int eOM = 0;
    }

    public static C0244a pR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0244a c0244a = new C0244a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0244a.portrait = optJSONObject.optString("head_url");
                c0244a.userId = optJSONObject.optString("user_id");
                c0244a.userName = optJSONObject.optString("nick_name");
                c0244a.eOK = optJSONObject.optLong("caller_time");
                c0244a.eOL = optJSONObject.optString("caller_content");
                c0244a.threadId = optJSONObject.optLong("thread_id");
                c0244a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0244a.forumName = optJSONObject.optString("forum_name");
                c0244a.postId = optJSONObject.optLong("post_id");
                c0244a.msgType = optJSONObject.optInt("msg_type");
                c0244a.eOM = optJSONObject.optInt("remind_count");
            }
            return c0244a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
