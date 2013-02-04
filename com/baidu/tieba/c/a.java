package com.baidu.tieba.c;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a {
    private Context a;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private ArrayList k = null;
    private int b = 0;
    private int c = 0;
    private LinkedList d = new LinkedList();
    private LinkedList e = new LinkedList();

    public a(Context context) {
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = false;
        this.j = false;
        this.a = context;
        this.f = true;
        this.h = null;
        this.g = false;
        this.i = false;
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(String str, d dVar, Integer num, boolean z) {
        if (str == null) {
            return null;
        }
        String str2 = this.h != null ? String.valueOf(str) + this.h : str;
        ab ah = TiebaApplication.a().ah();
        if (ah != null) {
            Bitmap c = num.intValue() == 0 ? ah.c(str2) : num.intValue() != 3 ? ah.b(str2) : null;
            if (c != null) {
                return c;
            }
        }
        try {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                if (((c) this.d.get(i)).a().equals(str)) {
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
            if (this.d.size() < 5) {
                c cVar = new c(this, str, num.intValue(), dVar, z);
                this.d.add(cVar);
                cVar.execute(new String[0]);
            } else if (!this.f) {
                ((c) this.d.get(0)).b();
                this.d.remove(0);
                c cVar2 = new c(this, str, num.intValue(), dVar, z);
                this.d.add(cVar2);
                cVar2.execute(new String[0]);
            } else if (this.e != null) {
                b bVar = new b(this, null);
                bVar.c = dVar;
                bVar.a = str;
                bVar.b = num.intValue();
                bVar.d = z;
                this.e.add(bVar);
            }
        } catch (Exception e) {
            ae.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
        }
        return null;
    }

    public Bitmap a(String str, d dVar) {
        return a(str, dVar, 0, true);
    }

    public void a() {
        this.e.clear();
    }

    public void a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(ArrayList arrayList) {
        this.k = arrayList;
    }

    public void a(boolean z) {
    }

    public Bitmap b(String str) {
        ab ah = TiebaApplication.a().ah();
        if (ah != null) {
            return ah.b(str);
        }
        return null;
    }

    public Bitmap b(String str, d dVar) {
        return a(str, dVar, 1, true);
    }

    public void b() {
        this.e.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                this.d.clear();
                return;
            }
            c cVar = (c) this.d.get(i2);
            if (cVar != null) {
                cVar.b();
            }
            i = i2 + 1;
        }
    }

    public void b(boolean z) {
        this.g = z;
    }

    public Bitmap c(String str) {
        ab ah = TiebaApplication.a().ah();
        if (ah != null) {
            return ah.c(str);
        }
        return null;
    }

    public Bitmap c(String str, d dVar) {
        return a(str, dVar, 1, false);
    }

    public void c(boolean z) {
        this.i = z;
    }

    public Bitmap d(String str, d dVar) {
        return a(str, dVar, 2, true);
    }

    public void d(String str) {
        ab ah = TiebaApplication.a().ah();
        if (ah != null) {
            ah.a(str);
        }
    }

    public void d(boolean z) {
        this.j = z;
    }
}
