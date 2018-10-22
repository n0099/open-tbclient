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
    public static class C0207a {
        public long eCZ;
        public String eDa;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int eDb = 0;
    }

    public static C0207a oV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0207a c0207a = new C0207a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0207a.portrait = optJSONObject.optString("head_url");
                c0207a.userId = optJSONObject.optString("user_id");
                c0207a.userName = optJSONObject.optString("nick_name");
                c0207a.eCZ = optJSONObject.optLong("caller_time");
                c0207a.eDa = optJSONObject.optString("caller_content");
                c0207a.threadId = optJSONObject.optLong("thread_id");
                c0207a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0207a.forumName = optJSONObject.optString("forum_name");
                c0207a.postId = optJSONObject.optLong("post_id");
                c0207a.msgType = optJSONObject.optInt("msg_type");
                c0207a.eDb = optJSONObject.optInt("remind_count");
            }
            return c0207a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
