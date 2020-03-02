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
    public static class C0527a {
        public long hvE;
        public String hvF;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int hvG = 0;
    }

    public static C0527a Cx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0527a c0527a = new C0527a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0527a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0527a.userId = optJSONObject.optString("user_id");
                c0527a.userName = optJSONObject.optString("nick_name");
                c0527a.hvE = optJSONObject.optLong("caller_time");
                c0527a.hvF = optJSONObject.optString("caller_content");
                c0527a.threadId = optJSONObject.optLong("thread_id");
                c0527a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0527a.forumName = optJSONObject.optString("forum_name");
                c0527a.postId = optJSONObject.optLong("post_id");
                c0527a.msgType = optJSONObject.optInt("msg_type");
                c0527a.hvG = optJSONObject.optInt("remind_count");
            }
            return c0527a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
