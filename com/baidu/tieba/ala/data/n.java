package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n extends BaseData {
    private String fUU;
    private long fUV;
    private long fUW = 5000;
    private long fUX = 15;
    private long fUY;
    private o fUZ;
    private long fwM;
    private ArrayList<h> fxs;

    public long bJa() {
        return this.fUW;
    }

    public long bJb() {
        return this.fUX;
    }

    public long bJc() {
        return this.fUV;
    }

    public String Ph() {
        return this.fUU;
    }

    public long bJd() {
        return this.fUY;
    }

    public ArrayList<h> getList() {
        return this.fxs;
    }

    public o bJe() {
        return this.fUZ;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fwM = optJSONObject.optLong("current_time", 0L);
                this.fUU = optJSONObject.optString("current_hour", "");
                this.fUV = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fUW = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fUX = optJSONObject.optLong("verify_notice_interval", 15L);
                this.fUY = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.fxs = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.fxs.add(hVar);
                }
            }
            this.fUZ = new o();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.fUZ.parserJson(optJSONObject4);
                if (this.fxs != null && this.fxs.size() > 0) {
                    this.fUZ.fVf = JavaTypesHelper.toLong(this.fxs.get(this.fxs.size() - 1).point, 0L);
                }
            }
        }
    }
}
