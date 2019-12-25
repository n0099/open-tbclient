package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String fqc;
    private int fqe;
    private int fqf;
    private int fqg;
    private int fqh;
    private String fqi;
    private String fqj;
    private String fqk;
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
    private List<d> fql = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.fqf = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.fqh = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.fqg = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.fqj = jSONObject.optString("next_level_diff");
        this.fqi = jSONObject.optString("mark_dir_level");
        this.fqk = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.fql.add(dVar);
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

    public List<d> bpH() {
        if (this.fql == null) {
            this.fql = new ArrayList();
        }
        return this.fql;
    }

    public boolean bpI() {
        return this.fqe == 1;
    }

    public void qC(int i) {
        this.fqe = i;
    }

    public String bpG() {
        return this.fqc;
    }

    public void ze(String str) {
        this.fqc = str;
    }

    public int bpJ() {
        return this.fqf;
    }

    public String bpK() {
        return this.mark_name;
    }

    public String bpL() {
        return this.mark_pic;
    }

    public int bpM() {
        return this.fqh;
    }

    public void qD(int i) {
        this.fqh = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bpN() {
        return this.fqj;
    }

    public int bpO() {
        return this.fqg;
    }

    public String bpP() {
        return this.fqk;
    }

    public boolean bpQ() {
        return this.type == 10;
    }

    public boolean bpR() {
        return this.type == 9;
    }
}
