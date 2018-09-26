package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private List<g> aEM = new ArrayList();
    private String aEN;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    g gVar = new g();
                    gVar.parserJson(jSONObject2);
                    this.aEM.add(gVar);
                }
            }
        }
    }

    public String Di() {
        if (TextUtils.isEmpty(this.aEN)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator<g> it = this.aEM.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                if (next.Dk()) {
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
            this.aEN = sb.toString();
        }
        return this.aEN;
    }

    public List<g> Dj() {
        return this.aEM;
    }
}
