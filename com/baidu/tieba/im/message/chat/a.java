package com.baidu.tieba.im.message.chat;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static Pattern jhl = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: com.baidu.tieba.im.message.chat.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0667a {
        public long createTime;
        public String fid;
        public String iSA;
        public long jhm;
        public String jhn;
        public int jho;
        public long picId;
        public String src;
        public long taskId;
        public String text;
        public String tid;
        public String title;
        public String url;
        public int userType;
    }

    public static List<C0667a> i(String str, String str2, long j) {
        return a(str, str2, null, 0L, j);
    }

    public static List<C0667a> a(String str, String str2, UserData userData, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        if (userData != null) {
            i = userData.getUserType();
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("url");
                String optString3 = optJSONObject.optString(UserAccountActionItem.KEY_SRC);
                String optString4 = optJSONObject.optString("text");
                long optLong = optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("msg_src");
                C0667a c0667a = new C0667a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = jhl.matcher(optString2);
                    if (matcher.find()) {
                        c0667a.tid = matcher.group(1);
                    }
                }
                c0667a.url = optString2;
                c0667a.title = optString;
                c0667a.text = optString4;
                c0667a.src = optString3;
                c0667a.fid = str2;
                c0667a.picId = optLong;
                c0667a.taskId = j2;
                c0667a.iSA = optString5;
                if (i > -1) {
                    c0667a.userType = i;
                }
                if (userData != null) {
                    c0667a.jhm = j;
                    c0667a.jhn = userData.getUserId();
                    c0667a.jho = userData.getUserType();
                }
                linkedList.add(c0667a);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
