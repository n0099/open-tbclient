package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aER;
    public BdUniqueId aEZ;
    private boolean eFm;
    protected boolean gjB;
    private boolean gjL;
    private boolean gjM;
    protected b gjN;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gjN.getSign();
    }

    public int getPosition() {
        return this.gjN.getPosition();
    }

    public void setPosition(int i) {
        this.gjN.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gjN.setData(list);
    }

    public b bQh() {
        return this.gjN;
    }

    public boolean bQi() {
        return this.gjL;
    }

    public boolean Dt() {
        return this.eFm;
    }

    public int size() {
        if (this.gjN == null) {
            return 0;
        }
        return this.gjN.size();
    }

    public boolean bQj() {
        return this.gjM;
    }

    public void lO(boolean z) {
        this.gjM = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean du(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eFm = jSONObject.optInt("switch", 0) == 1;
        this.gjL = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gjM = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gjB = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gjN = new b();
        this.gjN.W(this.mFolder);
        return optJSONObject != null && this.gjN.du(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eFm ? 1 : 0);
            jSONObject.put("red_dot_switch", this.gjL ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gjM ? 1 : 0);
            jSONObject.put("is_male", this.gjB ? 1 : 0);
            jSONObject.put("beauty_conf", this.gjN != null ? this.gjN.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
