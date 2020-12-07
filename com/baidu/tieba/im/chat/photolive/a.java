package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0774a {
        public long kof;
        public String kog;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int koh = 0;
    }

    public static C0774a MQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0774a c0774a = new C0774a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0774a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0774a.userId = optJSONObject.optString("user_id");
                c0774a.userName = optJSONObject.optString("nick_name");
                c0774a.kof = optJSONObject.optLong("caller_time");
                c0774a.kog = optJSONObject.optString("caller_content");
                c0774a.threadId = optJSONObject.optLong("thread_id");
                c0774a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0774a.forumName = optJSONObject.optString("forum_name");
                c0774a.postId = optJSONObject.optLong("post_id");
                c0774a.msgType = optJSONObject.optInt("msg_type");
                c0774a.koh = optJSONObject.optInt("remind_count");
            }
            return c0774a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
