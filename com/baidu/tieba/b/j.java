package com.baidu.tieba.b;

import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private ArrayList a;
    private ArrayList b;
    private k c;

    public j() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new k(this);
    }

    public ArrayList a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ae.b("NearbyListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        int i;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forums");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    l lVar = new l(this);
                    lVar.c = optJSONArray.optJSONObject(i2).optString("name");
                    lVar.b = optJSONArray.optJSONObject(i2).optString("id");
                    lVar.d = optJSONArray.optJSONObject(i2).optString("level");
                    this.a.add(lVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threads");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                    m mVar = new m(this);
                    mVar.b = optJSONObject.optString("tid");
                    mVar.c = optJSONObject.optString("title");
                    mVar.d = optJSONObject.optString("reply_num");
                    mVar.e = optJSONObject.optLong("time", 0L) * 1000;
                    mVar.f = optJSONObject.optInt("distance", 0);
                    mVar.h = optJSONObject.optInt("type", 0);
                    i = mVar.h;
                    if (i == 1) {
                        mVar.g = optJSONObject.optString("pic_url", "");
                    }
                    this.b.add(mVar);
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
            ae.b("NearbyListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList b() {
        return this.b;
    }

    public k c() {
        return this.c;
    }
}
