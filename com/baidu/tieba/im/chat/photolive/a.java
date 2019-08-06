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
    public static class C0334a {
        public long gCV;
        public String gCW;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int gCX = 0;
    }

    public static C0334a yw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0334a c0334a = new C0334a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0334a.portrait = optJSONObject.optString("head_url");
                c0334a.userId = optJSONObject.optString("user_id");
                c0334a.userName = optJSONObject.optString("nick_name");
                c0334a.gCV = optJSONObject.optLong("caller_time");
                c0334a.gCW = optJSONObject.optString("caller_content");
                c0334a.threadId = optJSONObject.optLong("thread_id");
                c0334a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0334a.forumName = optJSONObject.optString("forum_name");
                c0334a.postId = optJSONObject.optLong("post_id");
                c0334a.msgType = optJSONObject.optInt("msg_type");
                c0334a.gCX = optJSONObject.optInt("remind_count");
            }
            return c0334a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
