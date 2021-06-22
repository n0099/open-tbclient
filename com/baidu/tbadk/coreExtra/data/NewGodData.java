package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import d.a.n0.r.q.o;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes3.dex */
public class NewGodData extends o implements Serializable {
    public int mStatus = 0;
    public String mFieldId = "";
    public String mFieldName = "";
    public int mType = 0;
    public String mTypeName = "";

    public String getFieldId() {
        return this.mFieldId;
    }

    public String getFieldName() {
        return this.mFieldName;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getType() {
        return this.mType;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public boolean hasNewGodInvited() {
        int i2 = this.mStatus;
        return i2 == 2 || i2 == 4;
    }

    public boolean isNewGod() {
        return this.mStatus == 3;
    }

    public boolean isNewGodInvited() {
        return this.mStatus == 2;
    }

    public boolean isVideoGod() {
        return this.mType == 2;
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mStatus = jSONObject.optInt("status", 0);
            this.mFieldId = jSONObject.optString("field_id", "");
            this.mFieldName = jSONObject.optString("field_name", "");
            this.mType = jSONObject.optInt("type", 0);
            this.mFieldName = jSONObject.optString("type_name", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtobuf(NewGodInfo newGodInfo) {
        if (newGodInfo == null) {
            return;
        }
        this.mStatus = newGodInfo.status.intValue();
        this.mFieldId = String.valueOf(newGodInfo.field_id);
        this.mFieldName = newGodInfo.field_name;
        this.mType = newGodInfo.type.intValue();
        this.mTypeName = newGodInfo.type_name;
    }

    public void setFieldId(String str) {
        this.mFieldId = str;
    }

    public void setFieldName(String str) {
        this.mFieldName = str;
    }

    public void setStatus(int i2) {
        this.mStatus = i2;
    }
}
