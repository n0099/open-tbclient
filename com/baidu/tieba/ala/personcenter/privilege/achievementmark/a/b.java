package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private int height;
    private String ibi;
    private int ibk;
    private int ibl;
    private int ibm;
    private int ibn;
    private String ibo;
    private String ibp;
    private String ibq;
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
    private List<d> ibr = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.ibl = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.ibn = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.ibm = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.ibp = jSONObject.optString("next_level_diff");
        this.ibo = jSONObject.optString("mark_dir_level");
        this.ibq = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.ibr.add(dVar);
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
        if (this.ibr == null) {
            this.ibr = new ArrayList();
        }
        return this.ibr;
    }

    public boolean cmY() {
        return this.ibk == 1;
    }

    public void wt(int i) {
        this.ibk = i;
    }

    public String cmW() {
        return this.ibi;
    }

    public void In(String str) {
        this.ibi = str;
    }

    public int cmZ() {
        return this.ibl;
    }

    public String cna() {
        return this.mark_name;
    }

    public String cnb() {
        return this.mark_pic;
    }

    public int cnc() {
        return this.ibn;
    }

    public void wu(int i) {
        this.ibn = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cnd() {
        return this.ibp;
    }

    public int cne() {
        return this.ibm;
    }

    public String cnf() {
        return this.ibq;
    }

    public boolean cng() {
        return this.type == 10;
    }

    public boolean cnh() {
        return this.type == 9;
    }
}
