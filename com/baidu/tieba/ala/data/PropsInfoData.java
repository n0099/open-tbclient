package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PropsInfoData extends BaseData implements Serializable {
    public long endTime;
    public long nowTime;
    public long propsID;
    public String propsType;
    public ArrayList<a> propsUserDataList;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.propsID = jSONObject.optLong("props_id");
        this.propsType = jSONObject.optString("props_type");
        this.nowTime = jSONObject.optLong("now_time");
        this.endTime = jSONObject.optLong("end_time");
        setPropsInfoData(jSONObject);
    }

    private void setPropsInfoData(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("send_list") && (optJSONArray = jSONObject.optJSONArray("send_list")) != null && optJSONArray.length() > 0) {
            if (this.propsUserDataList == null) {
                this.propsUserDataList = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.parserJson(optJSONObject);
                    this.propsUserDataList.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public long endTime;
        public long gVb;
        public long startTime;
        public long userId;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) {
            this.userId = jSONObject.optLong("anchor_id");
            this.gVb = jSONObject.optLong("pay_userid");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
        }
    }
}
