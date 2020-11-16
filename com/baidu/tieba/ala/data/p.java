package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    private long fZY;
    private String gAg;
    private long gAh;
    private long gAi = 5000;
    private long gAj = 15;
    private long gAk;
    private r gAl;
    private ArrayList<h> gaE;

    public long bRs() {
        return this.gAi;
    }

    public long bRt() {
        return this.gAj;
    }

    public long bRu() {
        return this.gAh;
    }

    public String TU() {
        return this.gAg;
    }

    public long bRv() {
        return this.gAk;
    }

    public ArrayList<h> getList() {
        return this.gaE;
    }

    public r bRw() {
        return this.gAl;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fZY = optJSONObject.optLong("current_time", 0L);
                this.gAg = optJSONObject.optString("current_hour", "");
                this.gAh = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gAi = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gAj = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gAk = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.gaE = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.gaE.add(hVar);
                }
            }
            this.gAl = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gAl.parserJson(optJSONObject4);
                if (this.gaE != null && this.gaE.size() > 0) {
                    this.gAl.aGw = JavaTypesHelper.toLong(this.gaE.get(this.gaE.size() - 1).point, 0L);
                }
            }
        }
    }
}
