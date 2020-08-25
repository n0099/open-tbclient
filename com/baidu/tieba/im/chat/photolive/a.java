package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0711a {
        public long jjO;
        public String jjP;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int jjQ = 0;
    }

    public static C0711a Ka(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0711a c0711a = new C0711a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0711a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0711a.userId = optJSONObject.optString("user_id");
                c0711a.userName = optJSONObject.optString("nick_name");
                c0711a.jjO = optJSONObject.optLong("caller_time");
                c0711a.jjP = optJSONObject.optString("caller_content");
                c0711a.threadId = optJSONObject.optLong("thread_id");
                c0711a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0711a.forumName = optJSONObject.optString("forum_name");
                c0711a.postId = optJSONObject.optLong("post_id");
                c0711a.msgType = optJSONObject.optInt("msg_type");
                c0711a.jjQ = optJSONObject.optInt("remind_count");
            }
            return c0711a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
