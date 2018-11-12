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
    public static class C0233a {
        public long eEs;
        public String eEt;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int eEu = 0;
    }

    public static C0233a oW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0233a c0233a = new C0233a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0233a.portrait = optJSONObject.optString("head_url");
                c0233a.userId = optJSONObject.optString("user_id");
                c0233a.userName = optJSONObject.optString("nick_name");
                c0233a.eEs = optJSONObject.optLong("caller_time");
                c0233a.eEt = optJSONObject.optString("caller_content");
                c0233a.threadId = optJSONObject.optLong("thread_id");
                c0233a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0233a.forumName = optJSONObject.optString("forum_name");
                c0233a.postId = optJSONObject.optLong("post_id");
                c0233a.msgType = optJSONObject.optInt("msg_type");
                c0233a.eEu = optJSONObject.optInt("remind_count");
            }
            return c0233a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
