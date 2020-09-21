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
    public static class C0708a {
        public long jsy;
        public String jsz;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int jsA = 0;
    }

    public static C0708a KD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0708a c0708a = new C0708a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0708a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0708a.userId = optJSONObject.optString("user_id");
                c0708a.userName = optJSONObject.optString("nick_name");
                c0708a.jsy = optJSONObject.optLong("caller_time");
                c0708a.jsz = optJSONObject.optString("caller_content");
                c0708a.threadId = optJSONObject.optLong("thread_id");
                c0708a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0708a.forumName = optJSONObject.optString("forum_name");
                c0708a.postId = optJSONObject.optLong("post_id");
                c0708a.msgType = optJSONObject.optInt("msg_type");
                c0708a.jsA = optJSONObject.optInt("remind_count");
            }
            return c0708a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
