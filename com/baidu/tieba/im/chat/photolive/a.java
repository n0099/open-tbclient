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
    public static class C0328a {
        public long gCd;
        public String gCe;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int gCf = 0;
    }

    public static C0328a yv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0328a c0328a = new C0328a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0328a.portrait = optJSONObject.optString("head_url");
                c0328a.userId = optJSONObject.optString("user_id");
                c0328a.userName = optJSONObject.optString("nick_name");
                c0328a.gCd = optJSONObject.optLong("caller_time");
                c0328a.gCe = optJSONObject.optString("caller_content");
                c0328a.threadId = optJSONObject.optLong("thread_id");
                c0328a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0328a.forumName = optJSONObject.optString("forum_name");
                c0328a.postId = optJSONObject.optLong("post_id");
                c0328a.msgType = optJSONObject.optInt("msg_type");
                c0328a.gCf = optJSONObject.optInt("remind_count");
            }
            return c0328a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
