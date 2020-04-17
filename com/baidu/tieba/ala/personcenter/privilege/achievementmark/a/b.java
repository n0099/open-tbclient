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
    private String gbh;
    private int gbj;
    private int gbk;
    private int gbl;
    private int gbm;
    private String gbn;
    private String gbo;
    private String gbp;
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
    private List<d> gbq = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.gbk = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.gbm = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.gbl = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.gbo = jSONObject.optString("next_level_diff");
        this.gbn = jSONObject.optString("mark_dir_level");
        this.gbp = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.gbq.add(dVar);
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

    public List<d> bCd() {
        if (this.gbq == null) {
            this.gbq = new ArrayList();
        }
        return this.gbq;
    }

    public boolean bCe() {
        return this.gbj == 1;
    }

    public void rj(int i) {
        this.gbj = i;
    }

    public String bCc() {
        return this.gbh;
    }

    public void Bm(String str) {
        this.gbh = str;
    }

    public int bCf() {
        return this.gbk;
    }

    public String bCg() {
        return this.mark_name;
    }

    public String bCh() {
        return this.mark_pic;
    }

    public int bCi() {
        return this.gbm;
    }

    public void rk(int i) {
        this.gbm = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bCj() {
        return this.gbo;
    }

    public int bCk() {
        return this.gbl;
    }

    public String bCl() {
        return this.gbp;
    }

    public boolean bCm() {
        return this.type == 10;
    }

    public boolean bCn() {
        return this.type == 9;
    }
}
