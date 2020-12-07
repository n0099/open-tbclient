package com.baidu.tieba.im.message.chat;

import android.text.TextUtils;
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
    private static Pattern kAv = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: com.baidu.tieba.im.message.chat.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0782a {
        public long createTime;
        public String fid;
        public long kAw;
        public String kAx;
        public int kAy;
        public String klT;
        public long picId;
        public long serviceId;
        public String src;
        public long taskId;
        public String text;
        public String tid;
        public String title;
        public String url;
        public int userType;
    }

    public static List<C0782a> c(String str, String str2, long j, long j2) {
        return a(str, str2, null, 0L, j, j2);
    }

    public static List<C0782a> a(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                String optString3 = optJSONObject.optString("src");
                String optString4 = optJSONObject.optString("text");
                long optLong = optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("msg_src");
                C0782a c0782a = new C0782a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = kAv.matcher(optString2);
                    if (matcher.find()) {
                        c0782a.tid = matcher.group(1);
                    }
                }
                c0782a.url = optString2;
                c0782a.title = optString;
                c0782a.text = optString4;
                c0782a.src = optString3;
                c0782a.fid = str2;
                c0782a.picId = optLong;
                c0782a.taskId = j2;
                c0782a.serviceId = j3;
                c0782a.klT = optString5;
                if (i > -1) {
                    c0782a.userType = i;
                }
                if (userData != null) {
                    c0782a.kAw = j;
                    c0782a.kAx = userData.getUserId();
                    c0782a.kAy = userData.getUserType();
                }
                linkedList.add(c0782a);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
