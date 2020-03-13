package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private String eAn;
    private long eAo;
    private long eAp = 5000;
    private long eAq = 15;
    private long eAr;
    private n eAs;
    private ArrayList<g> ejO;
    private long ejo;

    public long bey() {
        return this.eAp;
    }

    public long bez() {
        return this.eAq;
    }

    public long beA() {
        return this.eAo;
    }

    public String AY() {
        return this.eAn;
    }

    public long beB() {
        return this.eAr;
    }

    public ArrayList<g> getList() {
        return this.ejO;
    }

    public n beC() {
        return this.eAs;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.ejo = optJSONObject.optLong("current_time", 0L);
                this.eAn = optJSONObject.optString("current_hour", "");
                this.eAo = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.eAp = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.eAq = optJSONObject.optLong("verify_notice_interval", 15L);
                this.eAr = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.ejO = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.ejO.add(gVar);
                }
            }
            this.eAs = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.eAs.parserJson(optJSONObject4);
                if (this.ejO != null && this.ejO.size() > 0) {
                    this.eAs.eAy = JavaTypesHelper.toLong(this.ejO.get(this.ejO.size() - 1).point, 0L);
                }
            }
        }
    }
}
