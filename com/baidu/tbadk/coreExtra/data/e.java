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
    private List<f> aBK = new ArrayList();
    private String aBL;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    f fVar = new f();
                    fVar.parserJson(jSONObject2);
                    this.aBK.add(fVar);
                }
            }
        }
    }

    public String BX() {
        if (TextUtils.isEmpty(this.aBL)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator<f> it = this.aBK.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if (next.BZ()) {
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
            this.aBL = sb.toString();
        }
        return this.aBL;
    }

    public List<f> BY() {
        return this.aBK;
    }
}
