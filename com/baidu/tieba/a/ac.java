package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac extends d {
    final /* synthetic */ y a;
    private int b;
    private int c;
    private ArrayList d;
    private ArrayList e;

    public int a() {
        return this.c;
    }

    public ArrayList b() {
        return this.d;
    }

    public ArrayList c() {
        return this.e;
    }

    public ac(y yVar) {
        this.a = yVar;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.b = 0;
        this.c = 0;
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    @Override // com.baidu.tieba.a.d
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
                                aa aaVar = new aa(this.a);
                                aaVar.a(optJSONObject2);
                                this.d.add(aaVar);
                            }
                        } else if (optInt == 0 && (optJSONArray = optJSONObject.optJSONArray("threads")) != null) {
                            int length2 = optJSONArray.length();
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < length2; i2++) {
                                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    ab abVar = new ab(this.a);
                                    abVar.a(optJSONObject3);
                                    arrayList.add(abVar);
                                }
                            }
                            this.e.add(arrayList);
                        }
                    }
                }
            }
            this.b = this.d.size() + this.e.size();
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
