package com.baidu.tbadk.img.effect;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ImageOperation extends OrmObject implements Serializable {
    public String actionName;
    public String actionParam;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.actionName = jSONObject.optString("actionName");
        this.actionParam = jSONObject.optString("actionParam");
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionName", this.actionName);
            jSONObject.put("actionParam", this.actionParam);
            return jSONObject;
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }
}
