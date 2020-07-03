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
    public static class C0649a {
        public long iNK;
        public String iNL;
        public String portrait = null;
        public String userId = null;
        public String userName = null;
        public long threadId = 0;
        public String threadTitle = null;
        public String forumName = null;
        public long postId = 0;
        public int msgType = 0;
        public int iNM = 0;
    }

    public static C0649a Gu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0649a c0649a = new C0649a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0649a.portrait = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c0649a.userId = optJSONObject.optString("user_id");
                c0649a.userName = optJSONObject.optString("nick_name");
                c0649a.iNK = optJSONObject.optLong("caller_time");
                c0649a.iNL = optJSONObject.optString("caller_content");
                c0649a.threadId = optJSONObject.optLong("thread_id");
                c0649a.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                c0649a.forumName = optJSONObject.optString("forum_name");
                c0649a.postId = optJSONObject.optLong("post_id");
                c0649a.msgType = optJSONObject.optInt("msg_type");
                c0649a.iNM = optJSONObject.optInt("remind_count");
            }
            return c0649a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
