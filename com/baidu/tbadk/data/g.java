package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class g {
    private String lat;
    private String lng;
    private String name = null;

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getName() {
        return this.name;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.name = jSONObject.optString("name");
                this.lat = jSONObject.optString("lat");
                this.lng = jSONObject.optString("lng");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Lbs lbs) {
        if (lbs != null) {
            try {
                this.name = lbs.name;
                this.lat = lbs.lat;
                this.lng = lbs.lng;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
