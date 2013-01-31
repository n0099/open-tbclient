package com.baidu.tieba.b;

import com.baidu.tieba.c.af;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private ArrayList a;
    private ArrayList b;
    private m c;

    public l() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new m(this);
    }

    public ArrayList a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public m c() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            af.b("NearbyListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        int i;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forums");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    n nVar = new n(this);
                    nVar.c = optJSONArray.optJSONObject(i2).optString("name");
                    nVar.b = optJSONArray.optJSONObject(i2).optString("id");
                    nVar.d = optJSONArray.optJSONObject(i2).optString("level");
                    this.a.add(nVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threads");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                    o oVar = new o(this);
                    oVar.b = optJSONObject.optString("tid");
                    oVar.c = optJSONObject.optString("title");
                    oVar.d = optJSONObject.optString("reply_num");
                    oVar.e = optJSONObject.optLong("time", 0L) * 1000;
                    oVar.f = optJSONObject.optInt("distance", 0);
                    oVar.h = optJSONObject.optInt("type", 0);
                    i = oVar.h;
                    if (i == 1) {
                        oVar.g = optJSONObject.optString("pic_url", "");
                    }
                    this.b.add(oVar);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("area");
            if (optJSONObject2 != null) {
                this.c.b = optJSONObject2.optString("provice", "");
                this.c.c = optJSONObject2.optString("city", "");
                this.c.d = optJSONObject2.optString("district", "");
                this.c.e = optJSONObject2.optString("street", "");
            }
        } catch (Exception e) {
            af.b("NearbyListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
