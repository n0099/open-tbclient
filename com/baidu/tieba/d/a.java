package com.baidu.tieba.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a {
    private Context a;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private int k;
    private ArrayList j = null;
    private int b = 0;
    private int c = 0;
    private LinkedList d = new LinkedList();
    private LinkedList e = new LinkedList();

    public a(Context context) {
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = false;
        this.k = 0;
        this.a = context;
        this.f = true;
        this.h = null;
        this.g = false;
        this.k = 0;
        this.i = false;
    }

    public void a(boolean z) {
    }

    public void a(ArrayList arrayList) {
        this.j = arrayList;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a() {
        this.e.clear();
    }

    public com.baidu.adp.widget.a.b b(String str) {
        return com.baidu.tbadk.a.e.a().b(str);
    }

    public com.baidu.adp.widget.a.b c(String str) {
        return com.baidu.tbadk.a.e.a().c(str);
    }

    public void d(String str) {
        com.baidu.tbadk.a.e.a().a(str);
    }

    public com.baidu.adp.widget.a.b a(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 0, true);
    }

    public com.baidu.adp.widget.a.b b(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 1, true);
    }

    public com.baidu.adp.widget.a.b c(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 1, false);
    }

    public com.baidu.adp.widget.a.b d(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 2, true);
    }

    public com.baidu.adp.widget.a.b e(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 4, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.widget.a.b a(String str, com.baidu.tbadk.a.d dVar, Integer num, boolean z) {
        com.baidu.adp.widget.a.b c;
        if (str == null) {
            return null;
        }
        String str2 = this.h != null ? String.valueOf(str) + this.h : str;
        if (num.intValue() == 0 || num.intValue() == 4) {
            c = com.baidu.tbadk.a.e.a().c(str2);
        } else {
            c = num.intValue() != 3 ? com.baidu.tbadk.a.e.a().b(str2) : null;
        }
        if (c == null) {
            try {
                int size = this.d.size();
                for (int i = 0; i < size; i++) {
                    if (((c) this.d.get(i)).e().equals(str)) {
                        return null;
                    }
                }
                if (this.f && this.e != null) {
                    int size2 = this.e.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (((b) this.e.get(i2)).a != null && ((b) this.e.get(i2)).a.equals(str)) {
                            return null;
                        }
                    }
                }
                if (this.d.size() >= 5) {
                    if (!this.f) {
                        ((c) this.d.get(0)).cancel();
                        this.d.remove(0);
                        c cVar = new c(this, str, num.intValue(), dVar, z);
                        this.d.add(cVar);
                        cVar.execute(new String[0]);
                    } else if (this.e != null) {
                        b bVar = new b(this, null);
                        bVar.c = dVar;
                        bVar.a = str;
                        bVar.b = num.intValue();
                        bVar.d = z;
                        this.e.add(bVar);
                    }
                } else {
                    c cVar2 = new c(this, str, num.intValue(), dVar, z);
                    this.d.add(cVar2);
                    cVar2.execute(new String[0]);
                }
            } catch (Exception e) {
                ae.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
            }
            return null;
        }
        return c;
    }

    public void b() {
        this.e.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.d.size()) {
                c cVar = (c) this.d.get(i2);
                if (cVar != null) {
                    cVar.cancel();
                }
                i = i2 + 1;
            } else {
                this.d.clear();
                return;
            }
        }
    }

    public void a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public void c(boolean z) {
        this.i = z;
    }
}
