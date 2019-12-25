package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0515a {
        public long hqa;
        public String hqb;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int hqc = 0;
    }

    public static C0515a BX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0515a c0515a = new C0515a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0515a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0515a.userId = optJSONObject.optString("user_id");
                c0515a.userName = optJSONObject.optString("nick_name");
                c0515a.hqa = optJSONObject.optLong("caller_time");
                c0515a.hqb = optJSONObject.optString("caller_content");
                c0515a.threadId = optJSONObject.optLong("thread_id");
                c0515a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0515a.forumName = optJSONObject.optString("forum_name");
                c0515a.postId = optJSONObject.optLong("post_id");
                c0515a.msgType = optJSONObject.optInt("msg_type");
                c0515a.hqc = optJSONObject.optInt("remind_count");
            }
            return c0515a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
