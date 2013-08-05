package com.baidu.tbadk.widget.richText;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f805a = null;
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
            com.baidu.adp.lib.e.d.a(e.getMessage());
            return null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.f805a = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                g gVar = new g();
                gVar.a(jSONArray.optJSONObject(i2));
                if ((gVar.a() & i) != 0) {
                    this.f805a.add(gVar);
                }
            }
            this.c = new ArrayList();
            this.b = 0;
            Iterator it = this.f805a.iterator();
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
                    CharSequence c = gVar2.c(this.d, cVar.b());
                    if (c != null) {
                        cVar.a(c);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence c2 = gVar2.c(this.d, cVar.b());
                    if (c2 != null) {
                        cVar.a(c2);
                    }
                }
            }
            if (cVar != null) {
                this.c.add(cVar);
            }
            this.f805a.clear();
            this.f805a = null;
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
