package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String hFK;
    private int hFM;
    private int hFN;
    private int hFO;
    private int hFP;
    private String hFQ;
    private String hFR;
    private String hFS;
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
    private List<d> hFT = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hFN = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hFP = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hFO = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hFR = jSONObject.optString("next_level_diff");
        this.hFQ = jSONObject.optString("mark_dir_level");
        this.hFS = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hFT.add(dVar);
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

    public List<d> cjK() {
        if (this.hFT == null) {
            this.hFT = new ArrayList();
        }
        return this.hFT;
    }

    public boolean cjL() {
        return this.hFM == 1;
    }

    public void wy(int i) {
        this.hFM = i;
    }

    public String cjJ() {
        return this.hFK;
    }

    public void IH(String str) {
        this.hFK = str;
    }

    public int cjM() {
        return this.hFN;
    }

    public String cjN() {
        return this.mark_name;
    }

    public String cjO() {
        return this.mark_pic;
    }

    public int cjP() {
        return this.hFP;
    }

    public void wz(int i) {
        this.hFP = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cjQ() {
        return this.hFR;
    }

    public int cjR() {
        return this.hFO;
    }

    public String cjS() {
        return this.hFS;
    }

    public boolean cjT() {
        return this.type == 10;
    }

    public boolean cjU() {
        return this.type == 9;
    }
}
