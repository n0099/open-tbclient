package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aDp;
    public BdUniqueId aDx;
    private boolean eud;
    protected boolean fVQ;
    private boolean fWa;
    private boolean fWb;
    protected b fWc;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.fWc.getSign();
    }

    public int getPosition() {
        return this.fWc.getPosition();
    }

    public void setPosition(int i) {
        this.fWc.setPosition(i);
    }

    public void setData(List<d> list) {
        this.fWc.setData(list);
    }

    public b bKD() {
        return this.fWc;
    }

    public boolean bKE() {
        return this.fWa;
    }

    public boolean Ca() {
        return this.eud;
    }

    public int size() {
        if (this.fWc == null) {
            return 0;
        }
        return this.fWc.size();
    }

    public boolean bKF() {
        return this.fWb;
    }

    public void lj(boolean z) {
        this.fWb = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dt(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eud = jSONObject.optInt("switch", 0) == 1;
        this.fWa = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.fWb = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.fVQ = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.fWc = new b();
        this.fWc.X(this.mFolder);
        return optJSONObject != null && this.fWc.dt(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eud ? 1 : 0);
            jSONObject.put("red_dot_switch", this.fWa ? 1 : 0);
            jSONObject.put("is_user_clicked", this.fWb ? 1 : 0);
            jSONObject.put("is_male", this.fVQ ? 1 : 0);
            jSONObject.put("beauty_conf", this.fWc != null ? this.fWc.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
