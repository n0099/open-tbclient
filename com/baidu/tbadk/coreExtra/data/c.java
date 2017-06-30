package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String apA;
    private List<d> apz = new ArrayList();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.parserJson(jSONObject2);
                    this.apz.add(dVar);
                }
            }
        }
    }

    public String xK() {
        if (TextUtils.isEmpty(this.apA)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (d dVar : this.apz) {
                if (dVar.xM()) {
                    if (i == 0) {
                        sb.append(dVar.getAppId());
                    } else {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append(dVar.getAppId());
                    }
                    i++;
                }
            }
            this.apA = sb.toString();
        }
        return this.apA;
    }

    public List<d> xL() {
        return this.apz;
    }
}
