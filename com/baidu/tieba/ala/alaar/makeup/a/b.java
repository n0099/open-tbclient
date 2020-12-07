package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String gjH;
    private int gjI;
    private List<d> mData;
    private File mFolder;
    private int mPosition;
    private String mSign;

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        if (i < size()) {
            this.mPosition = i;
        }
    }

    public void setData(List<d> list) {
        this.mData = list;
    }

    public List<d> getData() {
        return this.mData;
    }

    public int size() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    public String getSign() {
        return this.mSign;
    }

    public void W(File file) {
        this.mFolder = file;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean du(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        this.gjI = jSONObject.optInt("ar_version");
        this.gjH = jSONObject.optString("version");
        this.mPosition = jSONObject.optInt("position");
        JSONArray optJSONArray = jSONObject.optJSONArray("makeup_category");
        this.mData = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            d dVar = new d();
            dVar.W(this.mFolder);
            if (dVar.du(optJSONObject)) {
                this.mData.add(dVar);
            }
        }
        return true;
    }

    public JSONObject toJson() {
        JSONObject json;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ar_version", this.gjI);
            jSONObject.put("version", this.gjH);
            jSONObject.put("position", this.mPosition);
            JSONArray jSONArray = new JSONArray();
            if (this.mData != null && this.mData.size() > 0) {
                for (d dVar : this.mData) {
                    if (dVar != null && (json = dVar.toJson()) != null) {
                        jSONArray.put(json);
                    }
                }
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject.put("makeup_category", jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
