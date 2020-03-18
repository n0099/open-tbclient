package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private String eAJ;
    private long eAK;
    private long eAL = 5000;
    private long eAM = 15;
    private long eAN;
    private n eAO;
    private long ejE;
    private ArrayList<g> eke;

    public long beD() {
        return this.eAL;
    }

    public long beE() {
        return this.eAM;
    }

    public long beF() {
        return this.eAK;
    }

    public String Bf() {
        return this.eAJ;
    }

    public long beG() {
        return this.eAN;
    }

    public ArrayList<g> getList() {
        return this.eke;
    }

    public n beH() {
        return this.eAO;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.ejE = optJSONObject.optLong("current_time", 0L);
                this.eAJ = optJSONObject.optString("current_hour", "");
                this.eAK = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.eAL = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.eAM = optJSONObject.optLong("verify_notice_interval", 15L);
                this.eAN = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.eke = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.eke.add(gVar);
                }
            }
            this.eAO = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.eAO.parserJson(optJSONObject4);
                if (this.eke != null && this.eke.size() > 0) {
                    this.eAO.eAU = JavaTypesHelper.toLong(this.eke.get(this.eke.size() - 1).point, 0L);
                }
            }
        }
    }
}
