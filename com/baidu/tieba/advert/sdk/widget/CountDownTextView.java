package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f13701e;

    /* renamed from: f  reason: collision with root package name */
    public String f13702f;

    /* renamed from: g  reason: collision with root package name */
    public b f13703g;

    /* renamed from: h  reason: collision with root package name */
    public d f13704h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f13705i;
    public final Runnable j;
    public boolean k;

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f13706e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f13706e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public c(CountDownTextView countDownTextView) {
            this.f13706e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f13701e = 0;
        this.f13702f = "";
        this.f13703g = null;
        this.f13704h = null;
        this.f13705i = new Handler();
        this.k = false;
        this.j = new c();
    }

    public final void b(int i2) {
        int i3 = this.f13701e - i2;
        this.f13701e = i3;
        b bVar = this.f13703g;
        if (bVar != null && i2 != 0) {
            bVar.a(i3);
        }
        int i4 = this.f13701e;
        if (i4 == 0) {
            d dVar = this.f13704h;
            if (dVar != null) {
                dVar.a(this);
            }
            this.f13705i.removeCallbacksAndMessages(null);
            return;
        }
        if (i4 > 0) {
            if (this.k) {
                setText(String.format("%s 0%s", this.f13702f, Integer.valueOf(i4)));
            } else {
                setText(String.format("%s %s", this.f13702f, Integer.valueOf(i4)));
            }
        }
        this.f13705i.removeCallbacks(this.j);
        this.f13705i.postDelayed(this.j, 1000L);
    }

    public final void c() {
        this.f13705i.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i2) {
        this.f13702f = str;
        if (i2 > 0) {
            this.f13701e = i2;
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
        this.f13704h = dVar;
    }

    public void setTimerChangedListener(b bVar) {
        this.f13703g = bVar;
    }
}
