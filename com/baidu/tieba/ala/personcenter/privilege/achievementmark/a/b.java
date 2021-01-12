package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String hWO;
    private int hWQ;
    private int hWR;
    private int hWS;
    private int hWT;
    private String hWU;
    private String hWV;
    private String hWW;
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
    private List<d> hWX = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hWR = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hWT = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hWS = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hWV = jSONObject.optString("next_level_diff");
        this.hWU = jSONObject.optString("mark_dir_level");
        this.hWW = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hWX.add(dVar);
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

    public List<d> clZ() {
        if (this.hWX == null) {
            this.hWX = new ArrayList();
        }
        return this.hWX;
    }

    public boolean cma() {
        return this.hWQ == 1;
    }

    public void wi(int i) {
        this.hWQ = i;
    }

    public String clY() {
        return this.hWO;
    }

    public void HJ(String str) {
        this.hWO = str;
    }

    public int cmb() {
        return this.hWR;
    }

    public String cmc() {
        return this.mark_name;
    }

    public String cmd() {
        return this.mark_pic;
    }

    public int cme() {
        return this.hWT;
    }

    public void wj(int i) {
        this.hWT = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cmf() {
        return this.hWV;
    }

    public int cmg() {
        return this.hWS;
    }

    public String cmh() {
        return this.hWW;
    }

    public boolean cmi() {
        return this.type == 10;
    }

    public boolean cmj() {
        return this.type == 9;
    }
}
