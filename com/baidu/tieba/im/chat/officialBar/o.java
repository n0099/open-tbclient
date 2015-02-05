package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.mention.FeedData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    public static List<p> ax(String str, String str2) {
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
                String optString2 = optJSONObject.optString(ImageViewerConfig.URL);
                String optString3 = optJSONObject.optString("src");
                String optString4 = optJSONObject.optString("text");
                long optLong = optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("pv_pre");
                long optLong2 = optJSONObject.optLong("pv");
                String optString6 = optJSONObject.optString("pv_suf");
                long optLong3 = optJSONObject.optLong(FeedData.TYPE_ZAN);
                String optString7 = optJSONObject.optString("msg_src");
                p pVar = new p();
                pVar.url = optString2;
                pVar.title = optString;
                pVar.text = optString4;
                pVar.src = optString3;
                pVar.fid = str2;
                pVar.picId = optLong;
                pVar.aUe = optLong2;
                pVar.aUd = optString5;
                pVar.aUf = optString6;
                pVar.aUg = optLong3;
                pVar.aTS = optString7;
                linkedList.add(pVar);
            }
            return linkedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
