package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String gqg;
    private int gqi;
    private int gqj;
    private int gqk;
    private int gql;
    private String gqm;
    private String gqn;
    private String gqo;
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
    private List<d> gqp = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.gqj = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.gql = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.gqk = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.gqn = jSONObject.optString("next_level_diff");
        this.gqm = jSONObject.optString("mark_dir_level");
        this.gqo = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.gqp.add(dVar);
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

    public List<d> bIv() {
        if (this.gqp == null) {
            this.gqp = new ArrayList();
        }
        return this.gqp;
    }

    public boolean bIw() {
        return this.gqi == 1;
    }

    public void rM(int i) {
        this.gqi = i;
    }

    public String bIu() {
        return this.gqg;
    }

    public void CY(String str) {
        this.gqg = str;
    }

    public int bIx() {
        return this.gqj;
    }

    public String bIy() {
        return this.mark_name;
    }

    public String bIz() {
        return this.mark_pic;
    }

    public int bIA() {
        return this.gql;
    }

    public void rN(int i) {
        this.gql = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bIB() {
        return this.gqn;
    }

    public int bIC() {
        return this.gqk;
    }

    public String bID() {
        return this.gqo;
    }

    public boolean bIE() {
        return this.type == 10;
    }

    public boolean bIF() {
        return this.type == 9;
    }
}
