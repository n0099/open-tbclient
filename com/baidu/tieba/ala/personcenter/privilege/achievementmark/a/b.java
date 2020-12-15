package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String hPa;
    private int hPc;
    private int hPd;
    private int hPe;
    private int hPf;
    private String hPg;
    private String hPh;
    private String hPi;
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
    private List<d> hPj = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hPd = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hPf = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hPe = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hPh = jSONObject.optString("next_level_diff");
        this.hPg = jSONObject.optString("mark_dir_level");
        this.hPi = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hPj.add(dVar);
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

    public List<d> cmY() {
        if (this.hPj == null) {
            this.hPj = new ArrayList();
        }
        return this.hPj;
    }

    public boolean cmZ() {
        return this.hPc == 1;
    }

    public void xB(int i) {
        this.hPc = i;
    }

    public String cmX() {
        return this.hPa;
    }

    public void IX(String str) {
        this.hPa = str;
    }

    public int cna() {
        return this.hPd;
    }

    public String cnb() {
        return this.mark_name;
    }

    public String cnc() {
        return this.mark_pic;
    }

    public int cnd() {
        return this.hPf;
    }

    public void xC(int i) {
        this.hPf = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cne() {
        return this.hPh;
    }

    public int cnf() {
        return this.hPe;
    }

    public String cng() {
        return this.hPi;
    }

    public boolean cnh() {
        return this.type == 10;
    }

    public boolean cni() {
        return this.type == 9;
    }
}
