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
    private String gbm;
    private int gbo;
    private int gbp;
    private int gbq;
    private int gbr;
    private String gbs;
    private String gbt;
    private String gbu;
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
    private List<d> gbv = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.gbp = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.gbr = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.gbq = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.gbt = jSONObject.optString("next_level_diff");
        this.gbs = jSONObject.optString("mark_dir_level");
        this.gbu = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.gbv.add(dVar);
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

    public List<d> bCb() {
        if (this.gbv == null) {
            this.gbv = new ArrayList();
        }
        return this.gbv;
    }

    public boolean bCc() {
        return this.gbo == 1;
    }

    public void rj(int i) {
        this.gbo = i;
    }

    public String bCa() {
        return this.gbm;
    }

    public void Bp(String str) {
        this.gbm = str;
    }

    public int bCd() {
        return this.gbp;
    }

    public String bCe() {
        return this.mark_name;
    }

    public String bCf() {
        return this.mark_pic;
    }

    public int bCg() {
        return this.gbr;
    }

    public void rk(int i) {
        this.gbr = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bCh() {
        return this.gbt;
    }

    public int bCi() {
        return this.gbq;
    }

    public String bCj() {
        return this.gbu;
    }

    public boolean bCk() {
        return this.type == 10;
    }

    public boolean bCl() {
        return this.type == 9;
    }
}
