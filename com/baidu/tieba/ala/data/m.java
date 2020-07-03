package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private String fEi;
    private long fEj;
    private long fEk = 5000;
    private long fEl = 15;
    private long fEm;
    private n fEn;
    private ArrayList<g> fgO;
    private long fgo;

    public long bwG() {
        return this.fEk;
    }

    public long bwH() {
        return this.fEl;
    }

    public long bwI() {
        return this.fEj;
    }

    public String Ji() {
        return this.fEi;
    }

    public long bwJ() {
        return this.fEm;
    }

    public ArrayList<g> getList() {
        return this.fgO;
    }

    public n bwK() {
        return this.fEn;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fgo = optJSONObject.optLong("current_time", 0L);
                this.fEi = optJSONObject.optString("current_hour", "");
                this.fEj = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fEk = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fEl = optJSONObject.optLong("verify_notice_interval", 15L);
                this.fEm = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.fgO = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.fgO.add(gVar);
                }
            }
            this.fEn = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.fEn.parserJson(optJSONObject4);
                if (this.fgO != null && this.fgO.size() > 0) {
                    this.fEn.fEt = JavaTypesHelper.toLong(this.fgO.get(this.fgO.size() - 1).point, 0L);
                }
            }
        }
    }
}
