package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends BaseData {
    private long dHl;
    private String dHm;
    private long dHn;
    private long dHo = 5000;
    private long dHp = 15;
    private long dHq;
    private f dHr;
    private ArrayList<c> dve;

    public long aKB() {
        return this.dHo;
    }

    public long aKC() {
        return this.dHp;
    }

    public long aKD() {
        return this.dHn;
    }

    public String wq() {
        return this.dHm;
    }

    public long aKE() {
        return this.dHq;
    }

    public ArrayList<c> getList() {
        return this.dve;
    }

    public f aKF() {
        return this.dHr;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.dHl = optJSONObject.optLong("current_time", 0L);
                this.dHm = optJSONObject.optString("current_hour", "");
                this.dHn = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.dHo = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.dHp = optJSONObject.optLong("verify_notice_interval", 15L);
                this.dHq = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.dve = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject3);
                    this.dve.add(cVar);
                }
            }
            this.dHr = new f();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.dHr.parserJson(optJSONObject4);
                if (this.dve != null && this.dve.size() > 0) {
                    this.dHr.dHx = JavaTypesHelper.toLong(this.dve.get(this.dve.size() - 1).TS, 0L);
                }
            }
        }
    }
}
