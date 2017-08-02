package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private List<d> aqq = new ArrayList();
    private String aqr;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.parserJson(jSONObject2);
                    this.aqq.add(dVar);
                }
            }
        }
    }

    public String xV() {
        if (TextUtils.isEmpty(this.aqr)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator<d> it = this.aqq.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.xX()) {
                    if (i2 == 0) {
                        sb.append(next.getAppId());
                    } else {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append(next.getAppId());
                    }
                    i = i2 + 1;
                } else {
                    i = i2;
                }
            }
            this.aqr = sb.toString();
        }
        return this.aqr;
    }

    public List<d> xW() {
        return this.aqq;
    }
}
