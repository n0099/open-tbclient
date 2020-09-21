package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n extends BaseData {
    private ArrayList<h> fAI;
    private long fAb;
    private String fYm;
    private long fYn;
    private long fYo = 5000;
    private long fYp = 15;
    private long fYq;
    private p fYr;

    public long bKk() {
        return this.fYo;
    }

    public long bKl() {
        return this.fYp;
    }

    public long bKm() {
        return this.fYn;
    }

    public String PK() {
        return this.fYm;
    }

    public long bKn() {
        return this.fYq;
    }

    public ArrayList<h> getList() {
        return this.fAI;
    }

    public p bKo() {
        return this.fYr;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fAb = optJSONObject.optLong("current_time", 0L);
                this.fYm = optJSONObject.optString("current_hour", "");
                this.fYn = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fYo = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fYp = optJSONObject.optLong("verify_notice_interval", 15L);
                this.fYq = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.fAI = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.fAI.add(hVar);
                }
            }
            this.fYr = new p();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.fYr.parserJson(optJSONObject4);
                if (this.fAI != null && this.fAI.size() > 0) {
                    this.fYr.fYw = JavaTypesHelper.toLong(this.fAI.get(this.fAI.size() - 1).point, 0L);
                }
            }
        }
    }
}
