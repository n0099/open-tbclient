package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IconStampData implements Serializable {
    public static final int ADVANCED_USER_POST = 3;
    public static final int ADVANCED_USER_REPLY = 4;
    public static final int NEW_USER_POST = 1;
    public static final int NEW_USER_REPLY = 2;
    public String stampText;
    public String stampTitle;
    public int stampType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.stampTitle = jSONObject.optString("stamp_title", "");
            this.stampText = jSONObject.optString("stamp_text", "");
            this.stampType = jSONObject.optInt("stamp_type", 1);
        }
    }
}
