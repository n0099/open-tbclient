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
    public static class C0434a {
        public long gCM;
        public String gCN;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int gCO = 0;
    }

    public static C0434a xo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0434a c0434a = new C0434a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0434a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0434a.userId = optJSONObject.optString("user_id");
                c0434a.userName = optJSONObject.optString("nick_name");
                c0434a.gCM = optJSONObject.optLong("caller_time");
                c0434a.gCN = optJSONObject.optString("caller_content");
                c0434a.threadId = optJSONObject.optLong("thread_id");
                c0434a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0434a.forumName = optJSONObject.optString("forum_name");
                c0434a.postId = optJSONObject.optLong("post_id");
                c0434a.msgType = optJSONObject.optInt("msg_type");
                c0434a.gCO = optJSONObject.optInt("remind_count");
            }
            return c0434a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
