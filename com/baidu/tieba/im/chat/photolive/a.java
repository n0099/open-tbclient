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
    public static class C0329a {
        public long gvQ;
        public String gvR;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int gvS = 0;
    }

    public static C0329a xJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0329a c0329a = new C0329a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0329a.portrait = optJSONObject.optString("head_url");
                c0329a.userId = optJSONObject.optString("user_id");
                c0329a.userName = optJSONObject.optString("nick_name");
                c0329a.gvQ = optJSONObject.optLong("caller_time");
                c0329a.gvR = optJSONObject.optString("caller_content");
                c0329a.threadId = optJSONObject.optLong("thread_id");
                c0329a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0329a.forumName = optJSONObject.optString("forum_name");
                c0329a.postId = optJSONObject.optLong("post_id");
                c0329a.msgType = optJSONObject.optInt("msg_type");
                c0329a.gvS = optJSONObject.optInt("remind_count");
            }
            return c0329a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
