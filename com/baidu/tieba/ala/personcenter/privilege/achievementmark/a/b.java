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
    private String hOY;
    private int hPa;
    private int hPb;
    private int hPc;
    private int hPd;
    private String hPe;
    private String hPf;
    private String hPg;
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
    private List<d> hPh = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hPb = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hPd = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hPc = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hPf = jSONObject.optString("next_level_diff");
        this.hPe = jSONObject.optString("mark_dir_level");
        this.hPg = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hPh.add(dVar);
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

    public List<d> cmX() {
        if (this.hPh == null) {
            this.hPh = new ArrayList();
        }
        return this.hPh;
    }

    public boolean cmY() {
        return this.hPa == 1;
    }

    public void xB(int i) {
        this.hPa = i;
    }

    public String cmW() {
        return this.hOY;
    }

    public void IX(String str) {
        this.hOY = str;
    }

    public int cmZ() {
        return this.hPb;
    }

    public String cna() {
        return this.mark_name;
    }

    public String cnb() {
        return this.mark_pic;
    }

    public int cnc() {
        return this.hPd;
    }

    public void xC(int i) {
        this.hPd = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cnd() {
        return this.hPf;
    }

    public int cne() {
        return this.hPc;
    }

    public String cnf() {
        return this.hPg;
    }

    public boolean cng() {
        return this.type == 10;
    }

    public boolean cnh() {
        return this.type == 9;
    }
}
