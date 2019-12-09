package com.baidu.tieba.im.chat.photolive;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.im.chat.photolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0429a {
        public long gBV;
        public String gBW;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int gBX = 0;
    }

    public static C0429a xo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0429a c0429a = new C0429a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0429a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0429a.userId = optJSONObject.optString("user_id");
                c0429a.userName = optJSONObject.optString("nick_name");
                c0429a.gBV = optJSONObject.optLong("caller_time");
                c0429a.gBW = optJSONObject.optString("caller_content");
                c0429a.threadId = optJSONObject.optLong("thread_id");
                c0429a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0429a.forumName = optJSONObject.optString("forum_name");
                c0429a.postId = optJSONObject.optLong("post_id");
                c0429a.msgType = optJSONObject.optInt("msg_type");
                c0429a.gBX = optJSONObject.optInt("remind_count");
            }
            return c0429a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
