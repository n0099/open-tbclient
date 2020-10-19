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
    public static class C0726a {
        public long jHv;
        public String jHw;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int jHx = 0;
    }

    public static C0726a Ls(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0726a c0726a = new C0726a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0726a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0726a.userId = optJSONObject.optString("user_id");
                c0726a.userName = optJSONObject.optString("nick_name");
                c0726a.jHv = optJSONObject.optLong("caller_time");
                c0726a.jHw = optJSONObject.optString("caller_content");
                c0726a.threadId = optJSONObject.optLong("thread_id");
                c0726a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0726a.forumName = optJSONObject.optString("forum_name");
                c0726a.postId = optJSONObject.optLong("post_id");
                c0726a.msgType = optJSONObject.optInt("msg_type");
                c0726a.jHx = optJSONObject.optInt("remind_count");
            }
            return c0726a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
