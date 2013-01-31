package com.baidu.tieba.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends AsyncTask {
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
    /* JADX WARN: Incorrect condition in loop: B:34:0x010e */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap doInBackground(String... strArr) {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        Context context;
        ArrayList arrayList;
        ab ak;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        boolean z3;
        Context context2;
        Context context3;
        ab ak2;
        String str4;
        int i7 = 0;
        try {
            byte[] bArr = null;
            String h = ae.h(this.d);
            str = this.a.h;
            if (str != null) {
                StringBuilder sb = new StringBuilder(String.valueOf(h));
                str4 = this.a.h;
                str2 = sb.append(str4).toString();
            } else {
                str2 = h;
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
                } else if (this.e == 0 && str2 != null) {
                    if (o.a("image", str2) && (ak2 = TiebaApplication.b().ak()) != null) {
                        ak2.a(com.baidu.tieba.a.i.i());
                    }
                    this.f = o.c("image", str2);
                    if (this.f != null) {
                        this.j = o.b("image", str2);
                    }
                }
            }
            if (this.f == null) {
                this.g = false;
                if (this.e == 0) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("http://c.tieba.baidu.com/c/p/img?");
                    stringBuffer.append("src=");
                    stringBuffer.append(ae.f(this.d));
                    stringBuffer.append("&width=");
                    i3 = this.a.b;
                    if (i3 == 0) {
                        context3 = this.a.a;
                        i4 = ah.a(context3, 105.0f);
                    } else {
                        i4 = this.a.b;
                    }
                    stringBuffer.append(String.valueOf(i4));
                    stringBuffer.append("&height=");
                    i5 = this.a.c;
                    if (i5 == 0) {
                        context2 = this.a.a;
                        i6 = ah.a(context2, 105.0f);
                    } else {
                        i6 = this.a.c;
                    }
                    stringBuffer.append(String.valueOf(i6));
                    stringBuffer.append("&imgtype=0");
                    z = this.a.i;
                    if (z) {
                        stringBuffer.append("&qulity=" + String.valueOf(45));
                    } else if (TiebaApplication.b().ab() == 1) {
                        stringBuffer.append("&qulity=" + String.valueOf(80));
                    } else {
                        stringBuffer.append("&qulity=" + String.valueOf(45));
                    }
                    stringBuffer.append("&first_gif=1");
                    z2 = this.a.g;
                    if (z2) {
                        stringBuffer.append("&ispv=1");
                    }
                    z3 = this.a.j;
                    if (z3) {
                        stringBuffer.append("&no_prefix=1");
                    }
                    int i8 = i6;
                    str3 = stringBuffer.toString();
                    i2 = i4;
                    i = i8;
                } else if (this.e == 3) {
                    str3 = this.d;
                    i = 0;
                    i2 = 0;
                } else {
                    str3 = String.valueOf(com.baidu.tieba.a.i.c()) + this.d;
                    i = 0;
                    i2 = 0;
                }
                context = this.a.a;
                this.b = new t(context, str3);
                arrayList = this.a.k;
                if (arrayList != null) {
                    while (i7 < arrayList2.size()) {
                        t tVar = this.b;
                        arrayList3 = this.a.k;
                        tVar.a((BasicNameValuePair) arrayList3.get(i7));
                        i7++;
                    }
                }
                if (this.e == 0) {
                    this.b.c(true);
                }
                bArr = this.b.h();
                if (this.b.b()) {
                    if (this.e == 0 && (ak = TiebaApplication.b().ak()) != null) {
                        ak.a(com.baidu.tieba.a.i.i());
                    }
                    this.f = e.a(bArr);
                    this.j = ah.a(bArr);
                    if (this.f != null) {
                        if (this.e == 0) {
                            if (this.f.getWidth() > i2 || this.f.getHeight() > i) {
                                af.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(this.f.getWidth()) + "*" + String.valueOf(this.f.getHeight())));
                                this.f = e.a(this.f, i2, i);
                                i7 = 1;
                            }
                        } else if (this.e != 3 && (this.f.getWidth() > 80 || this.f.getHeight() > 80)) {
                            af.a(1, getClass().getName(), "doInBackground", "Pb_photo_too_big:" + String.valueOf(String.valueOf(this.f.getWidth()) + "*" + String.valueOf(this.f.getHeight())));
                            this.f = e.a(this.f, 80);
                        }
                    }
                }
                i7 = 1;
            }
            publishProgress(new Integer[0]);
            if (i7 != 0 && this.f != null) {
                if (this.e == 1) {
                    k.b(this.i, this.f);
                } else if (this.e == 2) {
                    k.a(this.i, this.f);
                } else if (this.e == 3) {
                    if (this.f != null && this.d != null && str2 != null) {
                        o.a("hotspot", str2, this.f, 100);
                    }
                } else if (str2 != null && this.f != null && bArr != null) {
                    o.a("image", str2, bArr);
                }
            }
        } catch (Exception e) {
            af.b("ImageAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return this.f;
    }

    public String a() {
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        ab ak = TiebaApplication.b().ak();
        if (ak != null && this.f != null) {
            if (this.e == 0) {
                ak.a(this.i, this.f, this.j);
            } else if (this.e == 1 || this.e == 2) {
                ak.a(this.i, this.f);
            }
        }
        if (this.c != null) {
            this.c.a(this.f, this.d, this.g);
        }
        super.onProgressUpdate(numArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
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

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    public void b() {
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
