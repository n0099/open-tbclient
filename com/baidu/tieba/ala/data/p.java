package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p extends BaseData {
    private String gSW;
    private long gSX;
    private long gSY = 5000;
    private long gSZ = 15;
    private long gTa;
    private r gTb;
    private ArrayList<h> grq;
    private long mCurrentTime;

    public long bUw() {
        return this.gSY;
    }

    public long bUx() {
        return this.gSZ;
    }

    public long bUy() {
        return this.gSX;
    }

    public String Vn() {
        return this.gSW;
    }

    public long bUz() {
        return this.gTa;
    }

    public ArrayList<h> getList() {
        return this.grq;
    }

    public r bUA() {
        return this.gTb;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.mCurrentTime = optJSONObject.optLong("current_time", 0L);
                this.gSW = optJSONObject.optString("current_hour", "");
                this.gSX = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gSY = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gSZ = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gTa = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.grq = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.grq.add(hVar);
                }
            }
            this.gTb = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gTb.parserJson(optJSONObject4);
                if (this.grq != null && this.grq.size() > 0) {
                    this.gTb.aGD = JavaTypesHelper.toLong(this.grq.get(this.grq.size() - 1).gSE, 0L);
                }
            }
        }
    }
}
