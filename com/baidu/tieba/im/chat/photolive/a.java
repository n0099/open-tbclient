package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0636a {
        public long ivS;
        public String ivT;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int ivU = 0;
    }

    public static C0636a FS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0636a c0636a = new C0636a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0636a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0636a.userId = optJSONObject.optString("user_id");
                c0636a.userName = optJSONObject.optString("nick_name");
                c0636a.ivS = optJSONObject.optLong("caller_time");
                c0636a.ivT = optJSONObject.optString("caller_content");
                c0636a.threadId = optJSONObject.optLong("thread_id");
                c0636a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0636a.forumName = optJSONObject.optString("forum_name");
                c0636a.postId = optJSONObject.optLong("post_id");
                c0636a.msgType = optJSONObject.optInt("msg_type");
                c0636a.ivU = optJSONObject.optInt("remind_count");
            }
            return c0636a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
