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
    private String ftl;
    private int ftn;
    private int fto;
    private int ftp;
    private int ftq;
    private String ftr;
    private String fts;
    private String ftt;
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
    private List<d> ftu = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.fto = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.ftq = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.ftp = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.fts = jSONObject.optString("next_level_diff");
        this.ftr = jSONObject.optString("mark_dir_level");
        this.ftt = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.ftu.add(dVar);
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

    public List<d> bqI() {
        if (this.ftu == null) {
            this.ftu = new ArrayList();
        }
        return this.ftu;
    }

    public boolean bqJ() {
        return this.ftn == 1;
    }

    public void qH(int i) {
        this.ftn = i;
    }

    public String bqH() {
        return this.ftl;
    }

    public void zn(String str) {
        this.ftl = str;
    }

    public int bqK() {
        return this.fto;
    }

    public String bqL() {
        return this.mark_name;
    }

    public String bqM() {
        return this.mark_pic;
    }

    public int bqN() {
        return this.ftq;
    }

    public void qI(int i) {
        this.ftq = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bqO() {
        return this.fts;
    }

    public int bqP() {
        return this.ftp;
    }

    public String bqQ() {
        return this.ftt;
    }

    public boolean bqR() {
        return this.type == 10;
    }

    public boolean bqS() {
        return this.type == 9;
    }
}
