package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    private long gAA;
    private long gAB = 5000;
    private long gAC = 15;
    private long gAD;
    private r gAE;
    private String gAz;
    private ArrayList<h> gaX;
    private long gas;

    public long bRZ() {
        return this.gAB;
    }

    public long bSa() {
        return this.gAC;
    }

    public long bSb() {
        return this.gAA;
    }

    public String UD() {
        return this.gAz;
    }

    public long bSc() {
        return this.gAD;
    }

    public ArrayList<h> getList() {
        return this.gaX;
    }

    public r bSd() {
        return this.gAE;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.gas = optJSONObject.optLong("current_time", 0L);
                this.gAz = optJSONObject.optString("current_hour", "");
                this.gAA = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gAB = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gAC = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gAD = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.gaX = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.gaX.add(hVar);
                }
            }
            this.gAE = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gAE.parserJson(optJSONObject4);
                if (this.gaX != null && this.gaX.size() > 0) {
                    this.gAE.aIh = JavaTypesHelper.toLong(this.gaX.get(this.gaX.size() - 1).point, 0L);
                }
            }
        }
    }
}
