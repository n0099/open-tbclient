package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    private String gJf;
    private long gJg;
    private long gJh = 5000;
    private long gJi = 15;
    private long gJj;
    private r gJk;
    private ArrayList<h> giR;
    private long gim;

    public long bVd() {
        return this.gJh;
    }

    public long bVe() {
        return this.gJi;
    }

    public long bVf() {
        return this.gJg;
    }

    public String Wu() {
        return this.gJf;
    }

    public long bVg() {
        return this.gJj;
    }

    public ArrayList<h> getList() {
        return this.giR;
    }

    public r bVh() {
        return this.gJk;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.gim = optJSONObject.optLong("current_time", 0L);
                this.gJf = optJSONObject.optString("current_hour", "");
                this.gJg = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gJh = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gJi = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gJj = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.giR = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.giR.add(hVar);
                }
            }
            this.gJk = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gJk.parserJson(optJSONObject4);
                if (this.giR != null && this.giR.size() > 0) {
                    this.gJk.aJf = JavaTypesHelper.toLong(this.giR.get(this.giR.size() - 1).gIO, 0L);
                }
            }
        }
    }
}
