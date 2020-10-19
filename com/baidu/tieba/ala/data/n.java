package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n extends BaseData {
    private ArrayList<h> fMR;
    private long fMk;
    private String gkE;
    private long gkF;
    private long gkG = 5000;
    private long gkH = 15;
    private long gkI;
    private p gkJ;

    public long bMU() {
        return this.gkG;
    }

    public long bMV() {
        return this.gkH;
    }

    public long bMW() {
        return this.gkF;
    }

    public String QP() {
        return this.gkE;
    }

    public long bMX() {
        return this.gkI;
    }

    public ArrayList<h> getList() {
        return this.fMR;
    }

    public p bMY() {
        return this.gkJ;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.fMk = optJSONObject.optLong("current_time", 0L);
                this.gkE = optJSONObject.optString("current_hour", "");
                this.gkF = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gkG = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gkH = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gkI = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.fMR = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.fMR.add(hVar);
                }
            }
            this.gkJ = new p();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gkJ.parserJson(optJSONObject4);
                if (this.fMR != null && this.fMR.size() > 0) {
                    this.gkJ.gkO = JavaTypesHelper.toLong(this.fMR.get(this.fMR.size() - 1).point, 0L);
                }
            }
        }
    }
}
