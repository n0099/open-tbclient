package com.baidu.tieba.guide;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private List<e> f1181a;
    private WeakReference<View> b;

    private d(View view) {
        this.f1181a = new ArrayList(10);
        this.b = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(View view, d dVar) {
        this(view);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        switch (message.what) {
            case 1:
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean z = false;
                for (e eVar : this.f1181a) {
                    if (eVar.b()) {
                        eVar.a();
                        z = true;
                    }
                }
                if (z && (view = this.b.get()) != null) {
                    view.invalidate();
                }
                removeMessages(1);
                sendEmptyMessageAtTime(1, 16 + uptimeMillis);
                return;
            case 2:
                this.f1181a.add((e) message.obj);
                return;
            case 3:
            default:
                return;
            case 4:
                this.f1181a.remove(message.obj);
                return;
        }
    }

    public void a() {
        removeMessages(1);
    }

    public void b() {
        sendEmptyMessageAtTime(1, SystemClock.uptimeMillis() + 16);
    }

    public void a(e eVar) {
        sendMessage(obtainMessage(2, eVar));
    }

    public void b(e eVar) {
        sendMessage(obtainMessage(4, eVar));
    }

    public void c() {
        for (e eVar : this.f1181a) {
            b(eVar);
        }
    }
}
