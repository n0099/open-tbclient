package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.tieba.mention.FeedData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {

    /* loaded from: classes.dex */
    public static class a {
        public String bsR;
        public String btc;
        public long btd;
        public String bte;
        public long btf;
        public String fid;
        public long picId;
        public String src;
        public String text;
        public String title;
        public String url;
    }

    public static List<a> aD(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("url");
                String optString3 = optJSONObject.optString("src");
                String optString4 = optJSONObject.optString("text");
                long optLong = optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("pv_pre");
                long optLong2 = optJSONObject.optLong("pv");
                String optString6 = optJSONObject.optString("pv_suf");
                long optLong3 = optJSONObject.optLong(FeedData.TYPE_ZAN);
                String optString7 = optJSONObject.optString("msg_src");
                a aVar = new a();
                aVar.url = optString2;
                aVar.title = optString;
                aVar.text = optString4;
                aVar.src = optString3;
                aVar.fid = str2;
                aVar.picId = optLong;
                aVar.btd = optLong2;
                aVar.btc = optString5;
                aVar.bte = optString6;
                aVar.btf = optLong3;
                aVar.bsR = optString7;
                linkedList.add(aVar);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
