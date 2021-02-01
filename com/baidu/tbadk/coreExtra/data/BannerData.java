package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BannerData extends com.baidu.tbadk.core.data.o implements Serializable {
    private static final long serialVersionUID = -7774063518930689243L;
    private int mOpen = 0;
    private String mUrl = null;
    private String mResultUrl = null;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mOpen = jSONObject.optInt("open", 0);
                this.mUrl = jSONObject.optString("message_url", null);
                this.mResultUrl = jSONObject.optString("dest_url", null);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getOpen() {
        return this.mOpen;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getResultUrl() {
        return this.mResultUrl;
    }
}
