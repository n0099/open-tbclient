package com.baidu.tieba.ala.data;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m {
    public String errorNo;
    public String message;

    public void parserJson(JSONObject jSONObject) {
        this.errorNo = jSONObject.optString(BaseJsonData.TAG_ERRNO);
        this.message = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
    }
}
