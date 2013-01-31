package com.baidu.tieba.c;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ab {
    private volatile HashMap b = new HashMap();
    private volatile HashMap c = new HashMap();
    private volatile int a = 0;
    private volatile int d = 0;

    public void a(String str, Bitmap bitmap) {
        synchronized (this) {
            try {
                this.a++;
                if (this.b.size() >= 50) {
                    a();
                }
                ac acVar = new ac(this, null);
                acVar.a = bitmap;
                acVar.b = Integer.valueOf(this.a);
                this.b.put(str, acVar);
            } catch (Exception e) {
                af.b(getClass().getName(), "addPhoto", e.getMessage());
            }
        }
    }

    public void a(String str, Bitmap bitmap, boolean z) {
        synchronized (this) {
            if (bitmap != null) {
                try {
                    this.a++;
                    int width = bitmap.getWidth() * bitmap.getHeight() * 2;
                    if (this.d + width > com.baidu.tieba.a.i.d()) {
                        a((this.d + width) - com.baidu.tieba.a.i.d());
                    }
                    ac acVar = new ac(this, null);
                    acVar.a = bitmap;
                    acVar.b = Integer.valueOf(this.a);
                    acVar.c = z;
                    this.c.put(str, acVar);
                    this.d = width + this.d;
                } catch (Exception e) {
                    af.b(getClass().getName(), "addPic", e.getMessage());
                }
            }
        }
    }

    public void a() {
        synchronized (this) {
            int i = 134217727;
            String str = null;
            for (Map.Entry entry : this.b.entrySet()) {
                if (((ac) entry.getValue()).b.intValue() < i) {
                    i = ((ac) entry.getValue()).b.intValue();
                    str = (String) entry.getKey();
                }
            }
            if (str != null) {
                this.b.remove(str);
            } else {
                this.b.clear();
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            this.b.remove(str);
        }
    }

    public void a(int i) {
        int i2;
        int i3;
        synchronized (this) {
            if (this.d + i > com.baidu.tieba.a.i.d()) {
                int i4 = i;
                while (i4 > 0) {
                    int i5 = 134217727;
                    String str = null;
                    for (Map.Entry entry : this.c.entrySet()) {
                        if (((ac) entry.getValue()).b.intValue() < i5) {
                            i5 = ((ac) entry.getValue()).b.intValue();
                            str = (String) entry.getKey();
                        }
                    }
                    if (str != null) {
                        ac acVar = (ac) this.c.remove(str);
                        if (this.c == null || acVar.a == null) {
                            i2 = 0;
                            i3 = i4;
                        } else {
                            i2 = acVar.a.getHeight() * acVar.a.getWidth() * 2;
                            this.d -= i2;
                            i3 = i4 - i2;
                        }
                    } else {
                        this.c.clear();
                        this.d = 0;
                        i2 = 0;
                        i3 = 0;
                    }
                    i4 = i3 - i2;
                }
            }
        }
    }

    public Bitmap b(String str) {
        Bitmap bitmap;
        synchronized (this) {
            ac acVar = (ac) this.b.get(str);
            if (acVar == null) {
                bitmap = null;
            } else {
                this.a++;
                Bitmap bitmap2 = acVar.a;
                acVar.b = Integer.valueOf(this.a);
                bitmap = bitmap2;
            }
        }
        return bitmap;
    }

    public Bitmap c(String str) {
        Bitmap bitmap;
        synchronized (this) {
            ac acVar = (ac) this.c.get(str);
            if (acVar == null) {
                bitmap = null;
            } else {
                this.a++;
                Bitmap bitmap2 = acVar.a;
                acVar.b = Integer.valueOf(this.a);
                bitmap = bitmap2;
            }
        }
        return bitmap;
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this) {
            ac acVar = (ac) this.c.get(str);
            if (acVar == null) {
                z = false;
            } else {
                z = acVar.c;
            }
        }
        return z;
    }

    public void b() {
        synchronized (this) {
            this.b.clear();
            this.c.clear();
            this.d = 0;
        }
    }
}
