package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.q.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BannerData extends o implements Serializable {
    public static final long serialVersionUID = -7774063518930689243L;
    public int mOpen = 0;
    public String mUrl = null;
    public String mResultUrl = null;

    public int getOpen() {
        return this.mOpen;
    }

    public String getResultUrl() {
        return this.mResultUrl;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mOpen = jSONObject.optInt("open", 0);
            this.mUrl = jSONObject.optString("message_url", null);
            this.mResultUrl = jSONObject.optString("dest_url", null);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
