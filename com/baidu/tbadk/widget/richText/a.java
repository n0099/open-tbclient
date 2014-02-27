package com.baidu.tbadk.widget.richText;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class a {
    private ArrayList<i> a;
    private int b;
    private ArrayList<c> c;
    private Context d;

    public a(Context context, JSONArray jSONArray, int i) {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        a(context, jSONArray, i, false);
    }

    public a(Context context, JSONArray jSONArray, boolean z) {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        this.d = context;
        if (jSONArray != null) {
            this.a = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.a(jSONArray.optJSONObject(i2));
                if ((iVar.a() & i) != 0) {
                    this.a.add(iVar);
                }
            }
            this.c = new ArrayList<>();
            this.b = 0;
            Iterator<i> it = this.a.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
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
                    CharSequence a = next.a(this.d, cVar.b());
                    if (a != null) {
                        cVar.a(a);
                    }
                } else if (next.a() == 512) {
                    if (cVar != null) {
                        this.c.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.c());
                    this.c.add(cVar4);
                } else if (next.a() == 17) {
                    if (cVar != null) {
                        this.c.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.d());
                    this.c.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence a2 = next.a(this.d, cVar.b());
                    if (a2 != null) {
                        cVar.a(a2);
                    }
                }
            }
            if (cVar != null) {
                this.c.add(cVar);
            }
            this.a.clear();
            this.a = null;
        }
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.d = context;
        this.c = arrayList;
    }

    public final ArrayList<c> a() {
        return this.c;
    }

    public final String toString() {
        if (this.c == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            sb.append(next.toString());
            if (next.a() == 8) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
