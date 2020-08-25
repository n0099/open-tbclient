package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes2.dex */
public class NewGodData extends com.baidu.tbadk.core.data.m implements Serializable {
    private int mStatus = 0;
    private String mFieldId = "";
    private String mFieldName = "";

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStatus = jSONObject.optInt("status", 0);
                this.mFieldId = jSONObject.optString("field_id", "");
                this.mFieldName = jSONObject.optString("field_name", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtobuf(NewGodInfo newGodInfo) {
        if (newGodInfo != null) {
            this.mStatus = newGodInfo.status.intValue();
            this.mFieldId = String.valueOf(newGodInfo.field_id);
            this.mFieldName = newGodInfo.field_name;
        }
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public String getFieldId() {
        return this.mFieldId;
    }

    public void setFieldId(String str) {
        this.mFieldId = str;
    }

    public String getFieldName() {
        return this.mFieldName;
    }

    public void setFieldName(String str) {
        this.mFieldName = str;
    }

    public boolean isNewGodInvited() {
        return this.mStatus == 2;
    }

    public boolean isNewGod() {
        return this.mStatus == 3;
    }

    public boolean hasNewGodInvited() {
        return this.mStatus == 2 || this.mStatus == 4;
    }
}
