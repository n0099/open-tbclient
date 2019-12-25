package com.baidu.tieba.ala.data;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public String errorNo;
    public String message;

    public void parserJson(JSONObject jSONObject) {
        this.errorNo = jSONObject.optString("errno");
        this.message = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
    }
}
