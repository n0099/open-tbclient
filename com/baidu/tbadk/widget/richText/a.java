package com.baidu.tbadk.widget.richText;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<g> f838a = null;
    private int b = 0;
    private ArrayList<c> c = null;
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
            com.baidu.adp.lib.f.d.a(e.getMessage());
            return null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.f838a = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                g gVar = new g();
                gVar.a(jSONArray.optJSONObject(i2));
                if ((gVar.a() & i) != 0) {
                    this.f838a.add(gVar);
                }
            }
            this.c = new ArrayList<>();
            this.b = 0;
            Iterator<g> it = this.f838a.iterator();
            c cVar = null;
            while (it.hasNext()) {
                g next = it.next();
                if (next.a() == 8) {
                    if (cVar != null) {
                        this.c.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.b++;
                    cVar2.a(next.b());
                    this.c.add(cVar2);
                } else if (z && next.a() == 32) {
                    if (cVar != null) {
                        this.c.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.a(next.e());
                    this.c.add(cVar3);
                    cVar = new c(1);
                    CharSequence c = next.c(this.d, cVar.b());
                    if (c != null) {
                        cVar.a(c);
                    }
                } else if (next.a() == 512) {
                    if (cVar != null) {
                        this.c.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.c());
                    this.c.add(cVar4);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence c2 = next.c(this.d, cVar.b());
                    if (c2 != null) {
                        cVar.a(c2);
                    }
                }
            }
            if (cVar != null) {
                this.c.add(cVar);
            }
            this.f838a.clear();
            this.f838a = null;
        }
    }

    public ArrayList<c> a() {
        return this.c;
    }

    public String toString() {
        if (this.c == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(100);
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
