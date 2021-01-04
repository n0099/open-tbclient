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
    public static class C0761a {
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

    public static C0761a MQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0761a c0761a = new C0761a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0761a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0761a.userId = optJSONObject.optString("user_id");
                c0761a.userName = optJSONObject.optString("nick_name");
                c0761a.kAM = optJSONObject.optLong("caller_time");
                c0761a.kAN = optJSONObject.optString("caller_content");
                c0761a.threadId = optJSONObject.optLong("thread_id");
                c0761a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0761a.forumName = optJSONObject.optString("forum_name");
                c0761a.postId = optJSONObject.optLong("post_id");
                c0761a.msgType = optJSONObject.optInt("msg_type");
                c0761a.kAO = optJSONObject.optInt("remind_count");
            }
            return c0761a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
