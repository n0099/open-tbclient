package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0758a {
        public long kaB;
        public String kaC;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int kaD = 0;
    }

    public static C0758a LI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0758a c0758a = new C0758a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0758a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0758a.userId = optJSONObject.optString("user_id");
                c0758a.userName = optJSONObject.optString("nick_name");
                c0758a.kaB = optJSONObject.optLong("caller_time");
                c0758a.kaC = optJSONObject.optString("caller_content");
                c0758a.threadId = optJSONObject.optLong("thread_id");
                c0758a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0758a.forumName = optJSONObject.optString("forum_name");
                c0758a.postId = optJSONObject.optLong("post_id");
                c0758a.msgType = optJSONObject.optInt("msg_type");
                c0758a.kaD = optJSONObject.optInt("remind_count");
            }
            return c0758a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
