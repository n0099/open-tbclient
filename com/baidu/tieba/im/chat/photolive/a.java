package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0520a {
        public long htD;
        public String htE;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int htF = 0;
    }

    public static C0520a Ch(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0520a c0520a = new C0520a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0520a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0520a.userId = optJSONObject.optString("user_id");
                c0520a.userName = optJSONObject.optString("nick_name");
                c0520a.htD = optJSONObject.optLong("caller_time");
                c0520a.htE = optJSONObject.optString("caller_content");
                c0520a.threadId = optJSONObject.optLong("thread_id");
                c0520a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0520a.forumName = optJSONObject.optString("forum_name");
                c0520a.postId = optJSONObject.optLong("post_id");
                c0520a.msgType = optJSONObject.optInt("msg_type");
                c0520a.htF = optJSONObject.optInt("remind_count");
            }
            return c0520a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
