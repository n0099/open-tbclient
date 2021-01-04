package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.BazhuSign;
/* loaded from: classes.dex */
public class BazhuGradeData extends com.baidu.tbadk.core.data.n implements Serializable {
    private String mDesc = "";
    private String mLevel = "";

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mDesc = jSONObject.optString("desc", "");
                this.mLevel = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_LEVEL, "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtobuf(BazhuSign bazhuSign) {
        if (bazhuSign != null) {
            this.mDesc = bazhuSign.desc;
            this.mLevel = bazhuSign.level;
        }
    }

    public String getDesc() {
        return this.mDesc;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public String getLevel() {
        return this.mLevel;
    }

    public void setLevel(String str) {
        this.mLevel = str;
    }
}
