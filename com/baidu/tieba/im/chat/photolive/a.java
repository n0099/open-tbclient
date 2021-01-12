package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0753a {
        public long kwh;
        public String kwi;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int kwj = 0;
    }

    public static C0753a LH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0753a c0753a = new C0753a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0753a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0753a.userId = optJSONObject.optString("user_id");
                c0753a.userName = optJSONObject.optString("nick_name");
                c0753a.kwh = optJSONObject.optLong("caller_time");
                c0753a.kwi = optJSONObject.optString("caller_content");
                c0753a.threadId = optJSONObject.optLong("thread_id");
                c0753a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0753a.forumName = optJSONObject.optString("forum_name");
                c0753a.postId = optJSONObject.optLong("post_id");
                c0753a.msgType = optJSONObject.optInt("msg_type");
                c0753a.kwj = optJSONObject.optInt("remind_count");
            }
            return c0753a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
