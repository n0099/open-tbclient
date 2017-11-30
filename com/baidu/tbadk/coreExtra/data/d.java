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
public class d {
    private List<e> arc = new ArrayList();
    private String ard;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    e eVar = new e();
                    eVar.parserJson(jSONObject2);
                    this.arc.add(eVar);
                }
            }
        }
    }

    public String xN() {
        if (TextUtils.isEmpty(this.ard)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator<e> it = this.arc.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.xP()) {
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
            this.ard = sb.toString();
        }
        return this.ard;
    }

    public List<e> xO() {
        return this.arc;
    }
}
