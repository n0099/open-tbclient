package com.baidu.tieba.barcode.a;

import android.content.Context;
import android.hardware.Camera;
import com.baidu.tieba.util.bd;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: a */
    private static final Collection<String> f1135a = new ArrayList(2);
    private boolean b;
    private final boolean c;
    private final Camera d;
    private c e;
    private final com.baidu.tieba.barcode.b.a.a f = new com.baidu.tieba.barcode.b.a.b().a();

    static {
        f1135a.add("auto");
        f1135a.add("macro");
    }

    public a(Context context, Camera camera) {
        this.d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.c = f1135a.contains(focusMode);
        bd.a(getClass().getName(), "AutoFocusManager", "Current focus mode '" + focusMode + "'; use auto focus? " + this.c);
        a();
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.b) {
            this.e = new c(this);
            this.f.a(this.e, new Object[0]);
        }
    }

    public synchronized void a() {
        if (this.c) {
            this.b = true;
            try {
                this.d.autoFocus(this);
            } catch (RuntimeException e) {
                bd.c(getClass().getName(), "start", "Unexpected exception while focusing" + e.toString());
            }
        }
    }

    public synchronized void b() {
        if (this.c) {
            try {
                this.d.cancelAutoFocus();
            } catch (RuntimeException e) {
                bd.c(getClass().getName(), "stop", "Unexpected exception while cancelling focusing" + e.toString());
            }
        }
        if (this.e != null) {
            this.e.cancel(true);
            this.e = null;
        }
        this.b = false;
    }
}
