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
    private int height;
    private String idf;
    private int idh;
    private int idi;
    private int idj;
    private int idk;
    private String idm;
    private String idn;
    private String ido;
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
    private List<d> idp = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.idi = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.idk = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.idj = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.idn = jSONObject.optString("next_level_diff");
        this.idm = jSONObject.optString("mark_dir_level");
        this.ido = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.idp.add(dVar);
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

    public List<d> cnk() {
        if (this.idp == null) {
            this.idp = new ArrayList();
        }
        return this.idp;
    }

    public boolean cnl() {
        return this.idh == 1;
    }

    public void wu(int i) {
        this.idh = i;
    }

    public String cnj() {
        return this.idf;
    }

    public void Ix(String str) {
        this.idf = str;
    }

    public int cnm() {
        return this.idi;
    }

    public String cnn() {
        return this.mark_name;
    }

    public String cno() {
        return this.mark_pic;
    }

    public int cnp() {
        return this.idk;
    }

    public void wv(int i) {
        this.idk = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cnq() {
        return this.idn;
    }

    public int cnr() {
        return this.idj;
    }

    public String cns() {
        return this.ido;
    }

    public boolean cnt() {
        return this.type == 10;
    }

    public boolean cnu() {
        return this.type == 9;
    }
}
