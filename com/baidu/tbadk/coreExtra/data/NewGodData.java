package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes.dex */
public class NewGodData extends com.baidu.tbadk.core.data.n implements Serializable {
    private int mStatus = 0;
    private String mFieldId = "";
    private String mFieldName = "";
    private int mType = 0;
    private String mTypeName = "";

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStatus = jSONObject.optInt("status", 0);
                this.mFieldId = jSONObject.optString("field_id", "");
                this.mFieldName = jSONObject.optString("field_name", "");
                this.mType = jSONObject.optInt("type", 0);
                this.mFieldName = jSONObject.optString("type_name", "");
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
            this.mType = newGodInfo.type.intValue();
            this.mTypeName = newGodInfo.type_name;
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

    public String getTypeName() {
        return this.mTypeName;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isVideoGod() {
        return this.mType == 2;
    }
}
