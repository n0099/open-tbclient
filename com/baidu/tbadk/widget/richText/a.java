package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.SpannableString;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {
    private ArrayList a = null;
    private int b = 0;
    private ArrayList c = null;
    private Context d = null;

    public a(Context context, String str) {
        a(context, a(str), -1, false);
    }

    public a(Context context, JSONArray jSONArray, boolean z) {
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        this.d = context;
        a(jSONArray, i, z);
    }

    private JSONArray a(String str) {
        try {
            return new JSONArray(str);
        } catch (Exception e) {
            com.baidu.adp.lib.e.b.a(e.getMessage());
            return null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        SpannableString e;
        SpannableString e2;
        if (jSONArray != null) {
            this.a = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                g gVar = new g();
                gVar.a(jSONArray.optJSONObject(i2));
                if ((gVar.a() & i) != 0) {
                    this.a.add(gVar);
                }
            }
            this.c = new ArrayList();
            this.b = 0;
            Iterator it = this.a.iterator();
            c cVar = null;
            while (it.hasNext()) {
                g gVar2 = (g) it.next();
                if (gVar2.a() == 8) {
                    if (cVar != null) {
                        this.c.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.b++;
                    cVar2.a(gVar2.b());
                    this.c.add(cVar2);
                } else if (z && gVar2.a() == 32) {
                    if (cVar != null) {
                        this.c.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.a(gVar2.d());
                    this.c.add(cVar3);
                    cVar = new c(1);
                    if (gVar2.a() == 4) {
                        e2 = gVar2.a(this.d, cVar.b());
                    } else {
                        e2 = gVar2.e(this.d);
                    }
                    cVar.a(e2);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (gVar2.a() == 4) {
                        e = gVar2.a(this.d, cVar.b());
                    } else {
                        e = gVar2.e(this.d);
                    }
                    cVar.a(e);
                }
            }
            if (cVar != null) {
                this.c.add(cVar);
            }
            this.a.clear();
            this.a = null;
        }
    }

    public ArrayList a() {
        return this.c;
    }

    public String toString() {
        if (this.c == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(100);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            sb.append(((c) it.next()).toString());
        }
        return sb.toString();
    }
}
