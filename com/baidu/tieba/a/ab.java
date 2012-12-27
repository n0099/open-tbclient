package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab extends c {
    final /* synthetic */ x a;
    private int b;
    private int c;
    private ArrayList d;
    private ArrayList e;

    public ab(x xVar) {
        this.a = xVar;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.b = 0;
        this.c = 0;
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public int a() {
        return this.c;
    }

    @Override // com.baidu.tieba.a.c
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        try {
            this.c = jSONObject.optInt("distance", 0);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("points");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                    if (optJSONObject != null) {
                        int optInt = optJSONObject.optInt("type");
                        if (optInt == 1) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("forum");
                            if (optJSONObject2 != null) {
                                z zVar = new z(this.a);
                                zVar.a(optJSONObject2);
                                this.d.add(zVar);
                            }
                        } else if (optInt == 0 && (optJSONArray = optJSONObject.optJSONArray("threads")) != null) {
                            int length2 = optJSONArray.length();
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < length2; i2++) {
                                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    aa aaVar = new aa(this.a);
                                    aaVar.a(optJSONObject3);
                                    arrayList.add(aaVar);
                                }
                            }
                            this.e.add(arrayList);
                        }
                    }
                }
            }
            this.b = this.d.size() + this.e.size();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public ArrayList b() {
        return this.d;
    }

    public ArrayList c() {
        return this.e;
    }
}
