package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n extends BaseData {
    private String fUY;
    private long fUZ;
    private long fVa = 5000;
    private long fVb = 15;
    private long fVc;
    private o fVd;
    private long fwQ;
    private ArrayList<h> fxw;

    public long bJb() {
        return this.fVa;
    }

    public long bJc() {
        return this.fVb;
    }

    public long bJd() {
        return this.fUZ;
    }

    public String Ph() {
        return this.fUY;
    }

    public long bJe() {
        return this.fVc;
    }

    public ArrayList<h> getList() {
        return this.fxw;
    }

    public o bJf() {
        return this.fVd;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fwQ = optJSONObject.optLong("current_time", 0L);
                this.fUY = optJSONObject.optString("current_hour", "");
                this.fUZ = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fVa = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fVb = optJSONObject.optLong("verify_notice_interval", 15L);
                this.fVc = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.fxw = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.fxw.add(hVar);
                }
            }
            this.fVd = new o();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.fVd.parserJson(optJSONObject4);
                if (this.fxw != null && this.fxw.size() > 0) {
                    this.fVd.fVj = JavaTypesHelper.toLong(this.fxw.get(this.fxw.size() - 1).point, 0L);
                }
            }
        }
    }
}
