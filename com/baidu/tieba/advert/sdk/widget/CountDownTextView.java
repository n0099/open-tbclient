package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f13636e;

    /* renamed from: f  reason: collision with root package name */
    public String f13637f;

    /* renamed from: g  reason: collision with root package name */
    public b f13638g;

    /* renamed from: h  reason: collision with root package name */
    public d f13639h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f13640i;
    public final Runnable j;
    public boolean k;

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f13641e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f13641e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public c(CountDownTextView countDownTextView) {
            this.f13641e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f13636e = 0;
        this.f13637f = "";
        this.f13638g = null;
        this.f13639h = null;
        this.f13640i = new Handler();
        this.k = false;
        this.j = new c();
    }

    public final void b(int i2) {
        int i3 = this.f13636e - i2;
        this.f13636e = i3;
        b bVar = this.f13638g;
        if (bVar != null && i2 != 0) {
            bVar.a(i3);
        }
        int i4 = this.f13636e;
        if (i4 == 0) {
            d dVar = this.f13639h;
            if (dVar != null) {
                dVar.a(this);
            }
            this.f13640i.removeCallbacksAndMessages(null);
            return;
        }
        if (i4 > 0) {
            if (this.k) {
                setText(String.format("%s 0%s", this.f13637f, Integer.valueOf(i4)));
            } else {
                setText(String.format("%s %s", this.f13637f, Integer.valueOf(i4)));
            }
        }
        this.f13640i.removeCallbacks(this.j);
        this.f13640i.postDelayed(this.j, 1000L);
    }

    public final void c() {
        this.f13640i.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i2) {
        this.f13637f = str;
        if (i2 > 0) {
            this.f13636e = i2;
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
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            b(0);
        } else {
            c();
        }
    }

    public void setNumTypeFromBes(boolean z) {
        this.k = z;
    }

    public void setTimeoutListener(d dVar) {
        this.f13639h = dVar;
    }

    public void setTimerChangedListener(b bVar) {
        this.f13638g = bVar;
    }
}
