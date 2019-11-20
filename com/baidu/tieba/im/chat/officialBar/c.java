package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a {
        public String fid;
        public long gAA;
        public String gAB;
        public int gAC;
        public String gAs;
        public long picId;
        public String src;
        public long taskId;
        public String text;
        public String title;
        public String url;
        public int userType;
    }

    public static List<a> g(String str, String str2, long j) {
        return a(str, str2, null, 0L, j);
    }

    public static List<a> a(String str, String str2, UserData userData, long j, long j2) {
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
                a aVar = new a();
                aVar.url = optString2;
                aVar.title = optString;
                aVar.text = optString4;
                aVar.src = optString3;
                aVar.fid = str2;
                aVar.picId = optLong;
                aVar.taskId = j2;
                aVar.gAs = optString5;
                if (i > -1) {
                    aVar.userType = i;
                }
                if (userData != null) {
                    aVar.gAA = j;
                    aVar.gAB = userData.getUserId();
                    aVar.gAC = userData.getUserType();
                }
                linkedList.add(aVar);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
