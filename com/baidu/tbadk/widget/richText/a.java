package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a {
    public boolean a;
    public int b;
    private ArrayList<i> c;
    private int d;
    private ArrayList<c> e;
    private Context f;

    public a(Context context, List<PbContent> list, boolean z) {
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = null;
        a(context, jSONArray, i, false);
    }

    public a(Context context, JSONArray jSONArray, boolean z) {
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = null;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        this.f = context;
        a(jSONArray, i, z);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        this.f = context;
        a(list, i, z);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.f = context;
        this.e = arrayList;
    }

    private void a(int i, boolean z) {
        if (this.c != null) {
            this.e = new ArrayList<>();
            this.d = 0;
            Iterator<i> it = this.c.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.a() == 8) {
                    if (cVar != null) {
                        this.e.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.d++;
                    cVar2.a(next.b());
                    this.e.add(cVar2);
                } else if (z && next.a() == 32) {
                    if (cVar != null) {
                        this.e.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.a(next.f());
                    this.e.add(cVar3);
                    cVar = new c(1);
                    CharSequence c = next.c(this.f, cVar.b());
                    if (c != null) {
                        cVar.a(c);
                    }
                } else if (next.a() == 512) {
                    if (cVar != null) {
                        this.e.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.c());
                    this.e.add(cVar4);
                } else if (next.a() == 17) {
                    if (cVar != null) {
                        this.e.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.d());
                    this.e.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence c2 = next.c(this.f, cVar.b());
                    if (c2 != null) {
                        cVar.a(c2);
                    }
                }
            }
            if (cVar != null) {
                this.e.add(cVar);
            }
            this.c.clear();
            this.c = null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.c = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.a(jSONArray.optJSONObject(i2));
                if ((iVar.a() & i) != 0) {
                    this.c.add(iVar);
                }
            }
            a(i, z);
        }
    }

    private void a(List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.c = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.a(pbContent);
                    if ((iVar.a() & i) != 0) {
                        this.c.add(iVar);
                    }
                }
            }
            a(i, z);
        }
    }

    public ArrayList<c> a() {
        return this.e;
    }

    public String toString() {
        if (this.e == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.e.get(i);
            String cVar2 = cVar.toString();
            if (cVar.a() == 1 && cVar.h() > 0) {
                cVar2 = cVar2.substring(cVar.h());
            }
            if (i == size - 1 && cVar.a() == 1 && this.a) {
                sb.append(cVar2.substring(0, cVar2.length() - this.b));
            } else if (cVar.a() == 8) {
                sb.append(this.f.getString(x.pic_str));
            } else if (cVar.a() == 512) {
                sb.append(this.f.getString(x.voice_str));
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
