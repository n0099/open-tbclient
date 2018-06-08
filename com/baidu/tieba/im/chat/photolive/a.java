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
    public static class C0170a {
        public long egj;
        public String egk;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int egl = 0;
    }

    public static C0170a nH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0170a c0170a = new C0170a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0170a.portrait = optJSONObject.optString("head_url");
                c0170a.userId = optJSONObject.optString("user_id");
                c0170a.userName = optJSONObject.optString("nick_name");
                c0170a.egj = optJSONObject.optLong("caller_time");
                c0170a.egk = optJSONObject.optString("caller_content");
                c0170a.threadId = optJSONObject.optLong("thread_id");
                c0170a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0170a.forumName = optJSONObject.optString("forum_name");
                c0170a.postId = optJSONObject.optLong("post_id");
                c0170a.msgType = optJSONObject.optInt("msg_type");
                c0170a.egl = optJSONObject.optInt("remind_count");
            }
            return c0170a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
