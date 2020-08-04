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
    public static class C0659a {
        public long iUP;
        public String iUQ;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int iUR = 0;
    }

    public static C0659a Hi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0659a c0659a = new C0659a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0659a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0659a.userId = optJSONObject.optString("user_id");
                c0659a.userName = optJSONObject.optString("nick_name");
                c0659a.iUP = optJSONObject.optLong("caller_time");
                c0659a.iUQ = optJSONObject.optString("caller_content");
                c0659a.threadId = optJSONObject.optLong("thread_id");
                c0659a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0659a.forumName = optJSONObject.optString("forum_name");
                c0659a.postId = optJSONObject.optLong("post_id");
                c0659a.msgType = optJSONObject.optInt("msg_type");
                c0659a.iUR = optJSONObject.optInt("remind_count");
            }
            return c0659a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
