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
    public static class C0565a {
        public long ihd;
        public String ihe;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int ihf = 0;
    }

    public static C0565a Eg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0565a c0565a = new C0565a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0565a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0565a.userId = optJSONObject.optString("user_id");
                c0565a.userName = optJSONObject.optString("nick_name");
                c0565a.ihd = optJSONObject.optLong("caller_time");
                c0565a.ihe = optJSONObject.optString("caller_content");
                c0565a.threadId = optJSONObject.optLong("thread_id");
                c0565a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0565a.forumName = optJSONObject.optString("forum_name");
                c0565a.postId = optJSONObject.optLong("post_id");
                c0565a.msgType = optJSONObject.optInt("msg_type");
                c0565a.ihf = optJSONObject.optInt("remind_count");
            }
            return c0565a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
