package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String fvN;
    private int fvP;
    private int fvQ;
    private int fvR;
    private int fvS;
    private String fvT;
    private String fvU;
    private String fvV;
    private int height;
    private String mark_name;
    private String mark_pic;
    public String nobilityName;
    public int nobilityType;
    public long price;
    private String start_time;
    public String time;
    private int type;
    private int weight;
    private int width;
    public int propId = -1;
    private List<d> fvW = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.fvQ = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.fvS = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.fvR = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.fvU = jSONObject.optString("next_level_diff");
        this.fvT = jSONObject.optString("mark_dir_level");
        this.fvV = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.fvW.add(dVar);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
        if (optJSONObject != null) {
            this.propId = com.baidu.adp.lib.f.b.toInt(optJSONObject.optString("props_id"), -1);
            this.price = com.baidu.adp.lib.f.b.toLong(optJSONObject.optString("price"), 0L);
            this.time = optJSONObject.optString("buy_cycle");
            this.buy_staus = optJSONObject.optInt("buy_staus");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("nobility_info");
        if (optJSONObject2 != null) {
            this.nobilityType = optJSONObject2.optInt("nobility_type");
            this.nobilityName = optJSONObject2.optString("nobility_type_name");
        }
    }

    public List<d> bsm() {
        if (this.fvW == null) {
            this.fvW = new ArrayList();
        }
        return this.fvW;
    }

    public boolean bsn() {
        return this.fvP == 1;
    }

    public void qO(int i) {
        this.fvP = i;
    }

    public String bsl() {
        return this.fvN;
    }

    public void zE(String str) {
        this.fvN = str;
    }

    public int bso() {
        return this.fvQ;
    }

    public String bsp() {
        return this.mark_name;
    }

    public String bsq() {
        return this.mark_pic;
    }

    public int bsr() {
        return this.fvS;
    }

    public void qP(int i) {
        this.fvS = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bss() {
        return this.fvU;
    }

    public int bst() {
        return this.fvR;
    }

    public String bsu() {
        return this.fvV;
    }

    public boolean bsv() {
        return this.type == 10;
    }

    public boolean bsw() {
        return this.type == 9;
    }
}
