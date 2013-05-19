package com.baidu.tieba.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.a {
    final /* synthetic */ a a;
    private d c;
    private String d;
    private volatile int e;
    private volatile Bitmap f;
    private boolean h;
    private String i;
    private volatile t b = null;
    private boolean g = true;
    private volatile boolean j = false;

    public c(a aVar, String str, int i, d dVar, boolean z) {
        String str2;
        String str3;
        this.a = aVar;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = null;
        this.h = false;
        this.i = null;
        this.d = str;
        this.e = i;
        this.c = dVar;
        this.f = null;
        this.h = z;
        str2 = aVar.h;
        if (str2 != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str));
            str3 = aVar.h;
            this.i = sb.append(str3).toString();
            return;
        }
        this.i = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:38:0x011c */
    @Override // com.baidu.adp.lib.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap a(String... strArr) {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        int i6;
        int i7;
        int i8;
        Context context;
        Context context2;
        Context context3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str3;
        int i9 = 0;
        try {
            byte[] bArr = null;
            String f = ad.f(this.d);
            str = this.a.h;
            if (str != null) {
                StringBuilder sb = new StringBuilder(String.valueOf(f));
                str3 = this.a.h;
                str2 = sb.append(str3).toString();
            } else {
                str2 = f;
            }
            if (this.h) {
                if (this.e == 1) {
                    this.f = k.c(this.i);
                } else if (this.e == 2) {
                    this.f = k.b(this.i);
                } else if (this.e == 3) {
                    if (str2 != null) {
                        this.f = o.c("hotspot", str2);
                    }
                } else if ((this.e == 0 || this.e == 4) && str2 != null) {
                    if (o.a("image", str2)) {
                        com.baidu.tbadk.a.d.a().c(com.baidu.tieba.a.i.d() - com.baidu.tieba.a.i.i());
                    }
                    this.f = o.c("image", str2);
                    if (this.f != null) {
                        this.j = o.b("image", str2);
                    }
                }
            }
            if (this.f == null) {
                this.g = false;
                String str4 = null;
                if (this.e == 0 || this.e == 4) {
                    StringBuilder sb2 = new StringBuilder(100);
                    sb2.append(com.baidu.tieba.a.i.j);
                    sb2.append("src=");
                    sb2.append(ad.d(this.d));
                    sb2.append("&width=");
                    i = this.a.b;
                    if (i == 0) {
                        context2 = this.a.a;
                        i2 = ag.a(context2, 105.0f);
                    } else {
                        i2 = this.a.b;
                    }
                    sb2.append(String.valueOf(i2));
                    sb2.append("&height=");
                    i3 = this.a.c;
                    if (i3 == 0) {
                        context = this.a.a;
                        i4 = ag.a(context, 105.0f);
                    } else {
                        i4 = this.a.c;
                    }
                    sb2.append(String.valueOf(i4));
                    sb2.append("&imgtype=0");
                    i5 = this.a.k;
                    if (i5 != 0) {
                        i8 = this.a.k;
                        if (i8 == 1) {
                            sb2.append("&qulity=" + String.valueOf(80));
                        } else {
                            sb2.append("&qulity=" + String.valueOf(45));
                        }
                    } else if (TiebaApplication.d().ae() == 1) {
                        sb2.append("&qulity=" + String.valueOf(80));
                    } else {
                        sb2.append("&qulity=" + String.valueOf(45));
                    }
                    sb2.append("&first_gif=1");
                    z = this.a.g;
                    if (z) {
                        sb2.append("&ispv=1");
                    }
                    z2 = this.a.i;
                    if (z2) {
                        sb2.append("&no_prefix=1");
                    }
                    int i10 = i4;
                    str4 = sb2.toString();
                    i6 = i2;
                    i7 = i10;
                } else if (this.e == 3) {
                    str4 = this.d;
                    i7 = 0;
                    i6 = 0;
                } else if (this.e == 2) {
                    str4 = String.valueOf(com.baidu.tieba.a.i.c()) + this.d;
                    i7 = 0;
                    i6 = 0;
                } else if (this.e == 1) {
                    str4 = String.valueOf(com.baidu.tieba.a.i.j()) + this.d;
                    i7 = 0;
                    i6 = 0;
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                context3 = this.a.a;
                this.b = new t(context3, str4);
                arrayList = this.a.j;
                if (arrayList != null) {
                    while (i9 < arrayList2.size()) {
                        t tVar = this.b;
                        arrayList3 = this.a.j;
                        tVar.a((BasicNameValuePair) arrayList3.get(i9));
                        i9++;
                    }
                }
                if (this.e == 0 || this.e == 4) {
                    this.b.c(true);
                }
                bArr = this.b.h();
                if (this.b.b()) {
                    if (this.e == 0 || this.e == 4) {
                        com.baidu.tbadk.a.d.a().c(com.baidu.tieba.a.i.d() - com.baidu.tieba.a.i.i());
                    }
                    this.f = e.a(bArr);
                    this.j = ag.a(bArr);
                    if (this.f != null) {
                        if (this.e == 0 || this.e == 4) {
                            if (this.f.getWidth() > i6 || this.f.getHeight() > i7) {
                                ae.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(this.f.getWidth()) + "*" + String.valueOf(this.f.getHeight())));
                                this.f = e.a(this.f, i6, i7);
                            }
                        } else if (this.e != 3) {
                            int k = this.e == 1 ? com.baidu.tieba.a.i.k() : 80;
                            if (this.f.getWidth() > k || this.f.getHeight() > k) {
                                ae.a(1, getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(String.valueOf(this.f.getWidth()) + "*" + String.valueOf(this.f.getHeight())));
                                this.f = e.a(this.f, k);
                            }
                        }
                    }
                }
                if (this.e != 0) {
                    this.f = e.a(this.f, 7.0f);
                }
                i9 = 1;
            }
            c((Object[]) new Integer[0]);
            if (i9 != 0 && this.f != null) {
                if (this.e == 1) {
                    k.b(this.i, this.f);
                } else if (this.e == 2) {
                    k.a(this.i, this.f);
                } else if (this.e == 3) {
                    if (this.f != null && this.d != null && str2 != null) {
                        o.a("hotspot", str2, this.f, 100);
                    }
                } else if (this.e == 4) {
                    if (str2 != null && this.f != null && bArr != null) {
                        o.a("image", str2, e.c(this.f, 80));
                    }
                } else if (str2 != null && this.f != null && bArr != null) {
                    o.a("image", str2, bArr);
                }
            }
        } catch (Exception e) {
            ae.b("ImageAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return this.f;
    }

    public String e() {
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: a */
    public void b(Integer... numArr) {
        if (this.f != null) {
            if (this.e == 0 || this.e == 4) {
                com.baidu.tbadk.a.d.a().a(this.i, this.f, this.j);
            } else if (this.e == 1 || this.e == 2) {
                com.baidu.tbadk.a.d.a().a(this.i, this.f);
            }
        }
        if (this.c != null) {
            this.c.a(this.f, this.d, this.g);
        }
        super.b((Object[]) numArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        LinkedList linkedList;
        boolean z;
        LinkedList linkedList2;
        LinkedList linkedList3;
        linkedList = this.a.d;
        linkedList.remove(this);
        z = this.a.f;
        if (z) {
            linkedList2 = this.a.e;
            if (linkedList2.size() > 0) {
                linkedList3 = this.a.e;
                b bVar = (b) linkedList3.remove(0);
                this.a.a(bVar.a, bVar.c, Integer.valueOf(bVar.b), bVar.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        boolean z;
        LinkedList linkedList;
        LinkedList linkedList2;
        if (this.b != null) {
            this.b.g();
        }
        z = this.a.f;
        if (z) {
            linkedList = this.a.e;
            if (linkedList.size() > 0) {
                linkedList2 = this.a.e;
                b bVar = (b) linkedList2.remove(0);
                if (bVar != null) {
                    this.a.a(bVar.a, bVar.c, Integer.valueOf(bVar.b), bVar.d);
                }
            }
        }
        super.cancel(true);
    }
}
