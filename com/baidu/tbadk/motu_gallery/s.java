package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ n a;
    private volatile boolean b;
    private Thread c;

    public s(n nVar) {
        this.a = nVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x0047 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        int i2;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap2;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap3;
        Handler handler;
        int i10;
        this.c = Thread.currentThread();
        this.b = false;
        while (!this.b) {
            i = n.j;
            if (i + 20 > this.a.a.b()) {
                int b = this.a.a.b();
                i10 = n.j;
                i2 = b - i10;
            } else {
                i2 = 20;
            }
            viewphotoLinkedHashMap = this.a.h;
            if (viewphotoLinkedHashMap.size() != 0) {
                i3 = n.j;
                n.k = i3;
                for (i4 = n.k; i4 < i5 + i2; i4++) {
                    i8 = n.k;
                    i9 = n.j;
                    if (i8 != i9) {
                        break;
                    }
                    try {
                        viewphotoLinkedHashMap2 = this.a.h;
                        if (viewphotoLinkedHashMap2.containsKey(Integer.valueOf(i4))) {
                            viewphotoLinkedHashMap3 = this.a.h;
                            if (!viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i4)).getTag().toString().equals("bitmap")) {
                                try {
                                    Bitmap a = this.a.a.a(this.a, this.a.a.a(i4), this.a.d);
                                    if (a != null) {
                                        Message message = new Message();
                                        message.obj = a;
                                        message.arg1 = i4;
                                        message.what = 0;
                                        handler = this.a.s;
                                        handler.sendMessage(message);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                i6 = n.k;
                i7 = n.j;
                if (i6 == i7) {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e3) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void a() {
        this.b = true;
        if (this.c != null) {
            this.c.interrupt();
        }
    }
}
