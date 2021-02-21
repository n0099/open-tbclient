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
    private boolean gsA;
    private boolean gsB;
    protected b gsC;
    protected boolean gsq;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gsC.getSign();
    }

    public int getPosition() {
        return this.gsC.getPosition();
    }

    public void setPosition(int i) {
        this.gsC.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gsC.setData(list);
    }

    public b bPB() {
        return this.gsC;
    }

    public boolean bPC() {
        return this.gsA;
    }

    public boolean zv() {
        return this.eMD;
    }

    public int size() {
        if (this.gsC == null) {
            return 0;
        }
        return this.gsC.size();
    }

    public boolean bPD() {
        return this.gsB;
    }

    public void ml(boolean z) {
        this.gsB = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dE(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eMD = jSONObject.optInt("switch", 0) == 1;
        this.gsA = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gsB = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gsq = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gsC = new b();
        this.gsC.V(this.mFolder);
        return optJSONObject != null && this.gsC.dE(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eMD ? 1 : 0);
            jSONObject.put("red_dot_switch", this.gsA ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gsB ? 1 : 0);
            jSONObject.put("is_male", this.gsq ? 1 : 0);
            jSONObject.put("beauty_conf", this.gsC != null ? this.gsC.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
