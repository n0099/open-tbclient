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
    public static class C0173a {
        public long evk;
        public String evl;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int evm = 0;
    }

    public static C0173a ot(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0173a c0173a = new C0173a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0173a.portrait = optJSONObject.optString("head_url");
                c0173a.userId = optJSONObject.optString("user_id");
                c0173a.userName = optJSONObject.optString("nick_name");
                c0173a.evk = optJSONObject.optLong("caller_time");
                c0173a.evl = optJSONObject.optString("caller_content");
                c0173a.threadId = optJSONObject.optLong("thread_id");
                c0173a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0173a.forumName = optJSONObject.optString("forum_name");
                c0173a.postId = optJSONObject.optLong("post_id");
                c0173a.msgType = optJSONObject.optInt("msg_type");
                c0173a.evm = optJSONObject.optInt("remind_count");
            }
            return c0173a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
