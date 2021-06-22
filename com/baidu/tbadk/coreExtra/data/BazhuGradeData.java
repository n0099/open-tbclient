package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import d.a.n0.r.q.o;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.BazhuSign;
/* loaded from: classes3.dex */
public class BazhuGradeData extends o implements Serializable {
    public String mDesc = "";
    public String mLevel = "";

    public String getDesc() {
        return this.mDesc;
    }

    public String getLevel() {
        return this.mLevel;
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mDesc = jSONObject.optString("desc", "");
            this.mLevel = jSONObject.optString("level", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtobuf(BazhuSign bazhuSign) {
        if (bazhuSign == null) {
            return;
        }
        this.mDesc = bazhuSign.desc;
        this.mLevel = bazhuSign.level;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setLevel(String str) {
        this.mLevel = str;
    }
}
