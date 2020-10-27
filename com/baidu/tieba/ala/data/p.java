package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    private long fUB;
    private ArrayList<h> fVg;
    private String guL;
    private long guM;
    private long guN = 5000;
    private long guO = 15;
    private long guP;
    private r guQ;

    public long bPz() {
        return this.guN;
    }

    public long bPA() {
        return this.guO;
    }

    public long bPB() {
        return this.guM;
    }

    public String RV() {
        return this.guL;
    }

    public long bPC() {
        return this.guP;
    }

    public ArrayList<h> getList() {
        return this.fVg;
    }

    public r bPD() {
        return this.guQ;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fUB = optJSONObject.optLong("current_time", 0L);
                this.guL = optJSONObject.optString("current_hour", "");
                this.guM = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.guN = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.guO = optJSONObject.optLong("verify_notice_interval", 15L);
                this.guP = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.fVg = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.fVg.add(hVar);
                }
            }
            this.guQ = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.guQ.parserJson(optJSONObject4);
                if (this.fVg != null && this.fVg.size() > 0) {
                    this.guQ.aHq = JavaTypesHelper.toLong(this.fVg.get(this.fVg.size() - 1).point, 0L);
                }
            }
        }
    }
}
