package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aCb;
    public BdUniqueId aCj;
    private boolean eMD;
    protected boolean gsc;
    private boolean gsm;
    private boolean gsn;
    protected b gso;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gso.getSign();
    }

    public int getPosition() {
        return this.gso.getPosition();
    }

    public void setPosition(int i) {
        this.gso.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gso.setData(list);
    }

    public b bPu() {
        return this.gso;
    }

    public boolean bPv() {
        return this.gsm;
    }

    public boolean zv() {
        return this.eMD;
    }

    public int size() {
        if (this.gso == null) {
            return 0;
        }
        return this.gso.size();
    }

    public boolean bPw() {
        return this.gsn;
    }

    public void ml(boolean z) {
        this.gsn = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dE(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eMD = jSONObject.optInt("switch", 0) == 1;
        this.gsm = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gsn = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gsc = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gso = new b();
        this.gso.V(this.mFolder);
        return optJSONObject != null && this.gso.dE(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eMD ? 1 : 0);
            jSONObject.put("red_dot_switch", this.gsm ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gsn ? 1 : 0);
            jSONObject.put("is_male", this.gsc ? 1 : 0);
            jSONObject.put("beauty_conf", this.gso != null ? this.gso.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
