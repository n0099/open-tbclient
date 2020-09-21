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
    private static Pattern jEV = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: com.baidu.tieba.im.message.chat.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0716a {
        public long createTime;
        public String fid;
        public long jEW;
        public String jEX;
        public int jEY;
        public String jql;
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

    public static List<C0716a> b(String str, String str2, long j, long j2) {
        return a(str, str2, null, 0L, j, j2);
    }

    public static List<C0716a> a(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                C0716a c0716a = new C0716a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = jEV.matcher(optString2);
                    if (matcher.find()) {
                        c0716a.tid = matcher.group(1);
                    }
                }
                c0716a.url = optString2;
                c0716a.title = optString;
                c0716a.text = optString4;
                c0716a.src = optString3;
                c0716a.fid = str2;
                c0716a.picId = optLong;
                c0716a.taskId = j2;
                c0716a.serviceId = j3;
                c0716a.jql = optString5;
                if (i > -1) {
                    c0716a.userType = i;
                }
                if (userData != null) {
                    c0716a.jEW = j;
                    c0716a.jEX = userData.getUserId();
                    c0716a.jEY = userData.getUserType();
                }
                linkedList.add(c0716a);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
