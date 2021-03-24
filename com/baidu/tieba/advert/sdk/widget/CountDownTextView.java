package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f14669e;

    /* renamed from: f  reason: collision with root package name */
    public String f14670f;

    /* renamed from: g  reason: collision with root package name */
    public b f14671g;

    /* renamed from: h  reason: collision with root package name */
    public d f14672h;
    public Handler i;
    public final Runnable j;
    public boolean k;

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f14673e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f14673e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public c(CountDownTextView countDownTextView) {
            this.f14673e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f14669e = 0;
        this.f14670f = "";
        this.f14671g = null;
        this.f14672h = null;
        this.i = new Handler();
        this.k = false;
        this.j = new c();
    }

    public final void b(int i) {
        int i2 = this.f14669e - i;
        this.f14669e = i2;
        b bVar = this.f14671g;
        if (bVar != null && i != 0) {
            bVar.a(i2);
        }
        int i3 = this.f14669e;
        if (i3 == 0) {
            d dVar = this.f14672h;
            if (dVar != null) {
                dVar.a(this);
            }
            this.i.removeCallbacksAndMessages(null);
            return;
        }
        if (i3 > 0) {
            if (this.k) {
                setText(String.format("%s 0%s", this.f14670f, Integer.valueOf(i3)));
            } else {
                setText(String.format("%s %s", this.f14670f, Integer.valueOf(i3)));
            }
        }
        this.i.removeCallbacks(this.j);
        this.i.postDelayed(this.j, 1000L);
    }

    public final void c() {
        this.i.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i) {
        this.f14670f = str;
        if (i > 0) {
            this.f14669e = i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b(0);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            b(0);
        } else {
            c();
        }
    }

    public void setNumTypeFromBes(boolean z) {
        this.k = z;
    }

    public void setTimeoutListener(d dVar) {
        this.f14672h = dVar;
    }

    public void setTimerChangedListener(b bVar) {
        this.f14671g = bVar;
    }
}
