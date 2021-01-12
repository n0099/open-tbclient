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
    private static Pattern kBg = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: com.baidu.tieba.im.message.chat.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0758a {
        public long createTime;
        public String fid;
        public long kBh;
        public String kBi;
        public int kBj;
        public String ktW;
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

    public static List<C0758a> c(String str, String str2, long j, long j2) {
        return a(str, str2, null, 0L, j, j2);
    }

    public static List<C0758a> a(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                C0758a c0758a = new C0758a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = kBg.matcher(optString2);
                    if (matcher.find()) {
                        c0758a.tid = matcher.group(1);
                    }
                }
                c0758a.url = optString2;
                c0758a.title = optString;
                c0758a.text = optString4;
                c0758a.src = optString3;
                c0758a.fid = str2;
                c0758a.picId = optLong;
                c0758a.taskId = j2;
                c0758a.serviceId = j3;
                c0758a.ktW = optString5;
                if (i > -1) {
                    c0758a.userType = i;
                }
                if (userData != null) {
                    c0758a.kBh = j;
                    c0758a.kBi = userData.getUserId();
                    c0758a.kBj = userData.getUserType();
                }
                linkedList.add(c0758a);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
