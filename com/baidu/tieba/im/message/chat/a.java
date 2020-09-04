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
    private static Pattern jwt = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: com.baidu.tieba.im.message.chat.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0719a {
        public long createTime;
        public String fid;
        public String jhF;
        public long jwu;
        public String jwv;
        public int jww;
        public long picId;
        public String src;
        public long taskId;
        public String text;
        public String tid;
        public String title;
        public String url;
        public int userType;
    }

    public static List<C0719a> h(String str, String str2, long j) {
        return a(str, str2, null, 0L, j);
    }

    public static List<C0719a> a(String str, String str2, UserData userData, long j, long j2) {
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
                C0719a c0719a = new C0719a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = jwt.matcher(optString2);
                    if (matcher.find()) {
                        c0719a.tid = matcher.group(1);
                    }
                }
                c0719a.url = optString2;
                c0719a.title = optString;
                c0719a.text = optString4;
                c0719a.src = optString3;
                c0719a.fid = str2;
                c0719a.picId = optLong;
                c0719a.taskId = j2;
                c0719a.jhF = optString5;
                if (i > -1) {
                    c0719a.userType = i;
                }
                if (userData != null) {
                    c0719a.jwu = j;
                    c0719a.jwv = userData.getUserId();
                    c0719a.jww = userData.getUserType();
                }
                linkedList.add(c0719a);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
