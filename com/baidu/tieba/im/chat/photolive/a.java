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
    public static class C0770a {
        public long kAM;
        public String kAN;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int kAO = 0;
    }

    public static C0770a MP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0770a c0770a = new C0770a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0770a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0770a.userId = optJSONObject.optString("user_id");
                c0770a.userName = optJSONObject.optString("nick_name");
                c0770a.kAM = optJSONObject.optLong("caller_time");
                c0770a.kAN = optJSONObject.optString("caller_content");
                c0770a.threadId = optJSONObject.optLong("thread_id");
                c0770a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0770a.forumName = optJSONObject.optString("forum_name");
                c0770a.postId = optJSONObject.optLong("post_id");
                c0770a.msgType = optJSONObject.optInt("msg_type");
                c0770a.kAO = optJSONObject.optInt("remind_count");
            }
            return c0770a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
