package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends c {
    public List<c> gjr;
    public int gjs;
    public boolean gjt;
    private int mPosition = 0;

    public List<c> bPU() {
        return this.gjr;
    }

    public void bY(List<c> list) {
        this.gjr = list;
    }

    public c bPV() {
        if (this.gjr == null || this.mPosition < 0 || this.mPosition >= this.gjr.size()) {
            return null;
        }
        return this.gjr.get(this.mPosition);
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.c
    public JSONObject toJson() {
        return lN(true);
    }

    public JSONObject lN(boolean z) {
        JSONObject json = super.toJson();
        try {
            json.put("category_id", getId());
            json.put("position", this.mPosition);
            JSONArray jSONArray = new JSONArray();
            if (this.gjr != null) {
                for (c cVar : this.gjr) {
                    if (cVar != null) {
                        jSONArray.put(cVar.toJson());
                    }
                }
            }
            json.put("data", jSONArray);
            json.put("independent", this.gjt ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyGroupEntity", "tojson 1:" + e.getMessage());
            }
        }
        return json;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.c, com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean du(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        super.du(jSONObject);
        setId(jSONObject.optString("category_id"));
        this.mPosition = jSONObject.optInt("position", 0);
        this.gjr = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null) {
            optJSONArray = jSONObject.optJSONArray("value");
        }
        this.gjt = jSONObject.optInt("independent", 0) == 1;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c cVar = new c();
                    cVar.setTypeName(getTypeName());
                    cVar.W(bPR());
                    if (cVar.du(optJSONObject)) {
                        this.gjr.add(cVar);
                    }
                }
            }
            if (this.gjt) {
                super.du(optJSONArray.optJSONObject(0));
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.c
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(dVar.name) || !this.name.equals(dVar.name)) ? false : true;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public boolean aBy() {
        return this.gjt;
    }
}
