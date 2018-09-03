package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private List<f> aBH = new ArrayList();
    private String aBI;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    f fVar = new f();
                    fVar.parserJson(jSONObject2);
                    this.aBH.add(fVar);
                }
            }
        }
    }

    public String BU() {
        if (TextUtils.isEmpty(this.aBI)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator<f> it = this.aBH.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if (next.BW()) {
                    if (i2 == 0) {
                        sb.append(next.getAppId());
                    } else {
                        sb.append(",");
                        sb.append(next.getAppId());
                    }
                    i = i2 + 1;
                } else {
                    i = i2;
                }
            }
            this.aBI = sb.toString();
        }
        return this.aBI;
    }

    public List<f> BV() {
        return this.aBH;
    }
}
