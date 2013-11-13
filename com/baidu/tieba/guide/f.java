package com.baidu.tieba.guide;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private List<g> f1384a;
    private WeakReference<View> b;

    private f(View view) {
        this.f1384a = new ArrayList(10);
        this.b = new WeakReference<>(view);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        switch (message.what) {
            case 1:
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean z = false;
                Iterator<g> it = this.f1384a.iterator();
                while (true) {
                    boolean z2 = z;
                    if (it.hasNext()) {
                        g next = it.next();
                        if (next.b()) {
                            next.a();
                            z = true;
                        } else {
                            z = z2;
                        }
                    } else {
                        if (z2 && (view = this.b.get()) != null) {
                            view.invalidate();
                        }
                        removeMessages(1);
                        sendEmptyMessageAtTime(1, 16 + uptimeMillis);
                        return;
                    }
                }
                break;
            case 2:
                this.f1384a.add((g) message.obj);
                return;
            case 3:
            default:
                return;
            case 4:
                this.f1384a.remove(message.obj);
                return;
        }
    }

    public void a() {
        removeMessages(1);
    }

    public void b() {
        sendEmptyMessageAtTime(1, SystemClock.uptimeMillis() + 16);
    }

    public void a(g gVar) {
        sendMessage(obtainMessage(2, gVar));
    }

    public void b(g gVar) {
        sendMessage(obtainMessage(4, gVar));
    }

    public void c() {
        for (g gVar : this.f1384a) {
            b(gVar);
        }
    }
}
