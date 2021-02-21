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
    public static class C0756a {
        public long kEB;
        public String kEC;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int kED = 0;
    }

    public static C0756a Mx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0756a c0756a = new C0756a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0756a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0756a.userId = optJSONObject.optString("user_id");
                c0756a.userName = optJSONObject.optString("nick_name");
                c0756a.kEB = optJSONObject.optLong("caller_time");
                c0756a.kEC = optJSONObject.optString("caller_content");
                c0756a.threadId = optJSONObject.optLong("thread_id");
                c0756a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0756a.forumName = optJSONObject.optString("forum_name");
                c0756a.postId = optJSONObject.optLong("post_id");
                c0756a.msgType = optJSONObject.optInt("msg_type");
                c0756a.kED = optJSONObject.optInt("remind_count");
            }
            return c0756a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
