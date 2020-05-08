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
    public static class C0586a {
        public long ihj;
        public String ihk;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int ihl = 0;
    }

    public static C0586a Ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0586a c0586a = new C0586a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0586a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0586a.userId = optJSONObject.optString("user_id");
                c0586a.userName = optJSONObject.optString("nick_name");
                c0586a.ihj = optJSONObject.optLong("caller_time");
                c0586a.ihk = optJSONObject.optString("caller_content");
                c0586a.threadId = optJSONObject.optLong("thread_id");
                c0586a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0586a.forumName = optJSONObject.optString("forum_name");
                c0586a.postId = optJSONObject.optLong("post_id");
                c0586a.msgType = optJSONObject.optInt("msg_type");
                c0586a.ihl = optJSONObject.optInt("remind_count");
            }
            return c0586a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
