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
    public static class C0762a {
        public long kGD;
        public String kGE;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int kGF = 0;
    }

    public static C0762a MD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0762a c0762a = new C0762a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0762a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0762a.userId = optJSONObject.optString("user_id");
                c0762a.userName = optJSONObject.optString("nick_name");
                c0762a.kGD = optJSONObject.optLong("caller_time");
                c0762a.kGE = optJSONObject.optString("caller_content");
                c0762a.threadId = optJSONObject.optLong("thread_id");
                c0762a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0762a.forumName = optJSONObject.optString("forum_name");
                c0762a.postId = optJSONObject.optLong("post_id");
                c0762a.msgType = optJSONObject.optInt("msg_type");
                c0762a.kGF = optJSONObject.optInt("remind_count");
            }
            return c0762a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
