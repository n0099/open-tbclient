package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p extends BaseData {
    private String gUS;
    private long gUT;
    private long gUU = 5000;
    private long gUV = 15;
    private long gUW;
    private r gUX;
    private long gsJ;
    private ArrayList<h> gto;

    public long bXI() {
        return this.gUU;
    }

    public long bXJ() {
        return this.gUV;
    }

    public long bXK() {
        return this.gUT;
    }

    public String Xy() {
        return this.gUS;
    }

    public long bXL() {
        return this.gUW;
    }

    public ArrayList<h> getList() {
        return this.gto;
    }

    public r bXM() {
        return this.gUX;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.gsJ = optJSONObject.optLong("current_time", 0L);
                this.gUS = optJSONObject.optString("current_hour", "");
                this.gUT = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gUU = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gUV = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gUW = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.gto = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.gto.add(hVar);
                }
            }
            this.gUX = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gUX.parserJson(optJSONObject4);
                if (this.gto != null && this.gto.size() > 0) {
                    this.gUX.aJD = JavaTypesHelper.toLong(this.gto.get(this.gto.size() - 1).gUA, 0L);
                }
            }
        }
    }
}
