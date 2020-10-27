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
    public static class C0742a {
        public long jTU;
        public String jTV;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int jTW = 0;
    }

    public static C0742a LQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0742a c0742a = new C0742a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0742a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0742a.userId = optJSONObject.optString("user_id");
                c0742a.userName = optJSONObject.optString("nick_name");
                c0742a.jTU = optJSONObject.optLong("caller_time");
                c0742a.jTV = optJSONObject.optString("caller_content");
                c0742a.threadId = optJSONObject.optLong("thread_id");
                c0742a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0742a.forumName = optJSONObject.optString("forum_name");
                c0742a.postId = optJSONObject.optLong("post_id");
                c0742a.msgType = optJSONObject.optInt("msg_type");
                c0742a.jTW = optJSONObject.optInt("remind_count");
            }
            return c0742a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
