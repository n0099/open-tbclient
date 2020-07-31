package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n extends BaseData {
    private String fJD;
    private long fJE;
    private long fJF = 5000;
    private long fJG = 15;
    private long fJH;
    private o fJI;
    private ArrayList<h> flW;
    private long flq;

    public long bzX() {
        return this.fJF;
    }

    public long bzY() {
        return this.fJG;
    }

    public long bzZ() {
        return this.fJE;
    }

    public String Jp() {
        return this.fJD;
    }

    public long bAa() {
        return this.fJH;
    }

    public ArrayList<h> getList() {
        return this.flW;
    }

    public o bAb() {
        return this.fJI;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.flq = optJSONObject.optLong("current_time", 0L);
                this.fJD = optJSONObject.optString("current_hour", "");
                this.fJE = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fJF = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fJG = optJSONObject.optLong("verify_notice_interval", 15L);
                this.fJH = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.flW = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.flW.add(hVar);
                }
            }
            this.fJI = new o();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.fJI.parserJson(optJSONObject4);
                if (this.flW != null && this.flW.size() > 0) {
                    this.fJI.fJO = JavaTypesHelper.toLong(this.flW.get(this.flW.size() - 1).point, 0L);
                }
            }
        }
    }
}
