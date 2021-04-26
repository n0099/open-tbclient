package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WriteVoteItemData extends OrmObject implements Serializable {
    public int id;
    public String text;

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.id = jSONObject.optInt("id");
        this.text = jSONObject.optString("text");
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setText(String str) {
        this.text = str;
    }
}
