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
public class e {
    private List<f> bfy = new ArrayList();
    private String bfz;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    f fVar = new f();
                    fVar.parserJson(jSONObject2);
                    this.bfy.add(fVar);
                }
            }
        }
    }

    public String Fg() {
        if (TextUtils.isEmpty(this.bfz)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator<f> it = this.bfy.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if (next.Fi()) {
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
            this.bfz = sb.toString();
        }
        return this.bfz;
    }

    public List<f> Fh() {
        return this.bfy;
    }
}
