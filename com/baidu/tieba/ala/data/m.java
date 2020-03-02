package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private String eAa;
    private long eAb;
    private long eAc = 5000;
    private long eAd = 15;
    private long eAe;
    private n eAf;
    private ArrayList<g> ejB;
    private long ejb;

    public long bex() {
        return this.eAc;
    }

    public long bey() {
        return this.eAd;
    }

    public long bez() {
        return this.eAb;
    }

    public String AY() {
        return this.eAa;
    }

    public long beA() {
        return this.eAe;
    }

    public ArrayList<g> getList() {
        return this.ejB;
    }

    public n beB() {
        return this.eAf;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.ejb = optJSONObject.optLong("current_time", 0L);
                this.eAa = optJSONObject.optString("current_hour", "");
                this.eAb = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.eAc = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.eAd = optJSONObject.optLong("verify_notice_interval", 15L);
                this.eAe = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.ejB = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.ejB.add(gVar);
                }
            }
            this.eAf = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.eAf.parserJson(optJSONObject4);
                if (this.ejB != null && this.ejB.size() > 0) {
                    this.eAf.eAl = JavaTypesHelper.toLong(this.ejB.get(this.ejB.size() - 1).point, 0L);
                }
            }
        }
    }
}
