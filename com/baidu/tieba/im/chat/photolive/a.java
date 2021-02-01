package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0755a {
        public long kEn;
        public String kEo;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int kEp = 0;
    }

    public static C0755a Mw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0755a c0755a = new C0755a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0755a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0755a.userId = optJSONObject.optString("user_id");
                c0755a.userName = optJSONObject.optString("nick_name");
                c0755a.kEn = optJSONObject.optLong("caller_time");
                c0755a.kEo = optJSONObject.optString("caller_content");
                c0755a.threadId = optJSONObject.optLong("thread_id");
                c0755a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0755a.forumName = optJSONObject.optString("forum_name");
                c0755a.postId = optJSONObject.optLong("post_id");
                c0755a.msgType = optJSONObject.optInt("msg_type");
                c0755a.kEp = optJSONObject.optInt("remind_count");
            }
            return c0755a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
