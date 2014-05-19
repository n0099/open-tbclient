package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BannerData extends com.baidu.tbadk.core.data.d implements Serializable {
    private static final long serialVersionUID = -7774063518930689243L;
    private int mOpen = 0;
    private String mUrl = null;
    private String mResultUrl = null;

    @Override // com.baidu.tbadk.core.data.d
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mOpen = jSONObject.optInt(TbConfig.ST_TYPE_OPEN, 0);
                this.mUrl = jSONObject.optString("message_url", null);
                this.mResultUrl = jSONObject.optString("dest_url", null);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public int getOpen() {
        return this.mOpen;
    }

    public void setOpen(int i) {
        this.mOpen = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getResultUrl() {
        return this.mResultUrl;
    }

    public void setResultUrl(String str) {
        this.mResultUrl = str;
    }
}
