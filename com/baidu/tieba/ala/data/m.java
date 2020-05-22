package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private long eVS;
    private ArrayList<g> eWs;
    private String fsM;
    private long fsN;
    private long fsO = 5000;
    private long fsP = 15;
    private long fsQ;
    private n fsR;

    public long btJ() {
        return this.fsO;
    }

    public long btK() {
        return this.fsP;
    }

    public long btL() {
        return this.fsN;
    }

    public String HV() {
        return this.fsM;
    }

    public long btM() {
        return this.fsQ;
    }

    public ArrayList<g> getList() {
        return this.eWs;
    }

    public n btN() {
        return this.fsR;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.eVS = optJSONObject.optLong("current_time", 0L);
                this.fsM = optJSONObject.optString("current_hour", "");
                this.fsN = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fsO = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fsP = optJSONObject.optLong("verify_notice_interval", 15L);
                this.fsQ = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.eWs = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.eWs.add(gVar);
                }
            }
            this.fsR = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.fsR.parserJson(optJSONObject4);
                if (this.eWs != null && this.eWs.size() > 0) {
                    this.fsR.fsX = JavaTypesHelper.toLong(this.eWs.get(this.eWs.size() - 1).point, 0L);
                }
            }
        }
    }
}
