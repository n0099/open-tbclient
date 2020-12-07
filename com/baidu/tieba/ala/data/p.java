package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    private String gJd;
    private long gJe;
    private long gJf = 5000;
    private long gJg = 15;
    private long gJh;
    private r gJi;
    private ArrayList<h> giP;
    private long gik;

    public long bVc() {
        return this.gJf;
    }

    public long bVd() {
        return this.gJg;
    }

    public long bVe() {
        return this.gJe;
    }

    public String Wu() {
        return this.gJd;
    }

    public long bVf() {
        return this.gJh;
    }

    public ArrayList<h> getList() {
        return this.giP;
    }

    public r bVg() {
        return this.gJi;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.gik = optJSONObject.optLong("current_time", 0L);
                this.gJd = optJSONObject.optString("current_hour", "");
                this.gJe = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gJf = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gJg = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gJh = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.giP = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.giP.add(hVar);
                }
            }
            this.gJi = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gJi.parserJson(optJSONObject4);
                if (this.giP != null && this.giP.size() > 0) {
                    this.gJi.aJf = JavaTypesHelper.toLong(this.giP.get(this.giP.size() - 1).gIM, 0L);
                }
            }
        }
    }
}
