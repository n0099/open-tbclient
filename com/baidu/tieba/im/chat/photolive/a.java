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
    public static class C0528a {
        public long hxq;
        public String hxr;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int hxs = 0;
    }

    public static C0528a Cy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0528a c0528a = new C0528a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0528a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0528a.userId = optJSONObject.optString("user_id");
                c0528a.userName = optJSONObject.optString("nick_name");
                c0528a.hxq = optJSONObject.optLong("caller_time");
                c0528a.hxr = optJSONObject.optString("caller_content");
                c0528a.threadId = optJSONObject.optLong("thread_id");
                c0528a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0528a.forumName = optJSONObject.optString("forum_name");
                c0528a.postId = optJSONObject.optLong("post_id");
                c0528a.msgType = optJSONObject.optInt("msg_type");
                c0528a.hxs = optJSONObject.optInt("remind_count");
            }
            return c0528a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
