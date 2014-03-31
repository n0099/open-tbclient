package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ProgressCountDownView extends FrameLayout {
    private View a;
    private TextView b;
    private ProgressBar c;
    private String d;
    private String e;
    private com.baidu.tbadk.coreExtra.c.b f;
    private ac g;
    private long h;
    private long i;
    private boolean j;

    public ProgressCountDownView(Context context) {
        super(context);
        this.h = 1L;
        this.i = 0L;
        this.j = true;
        a(context);
    }

    public ProgressCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 1L;
        this.i = 0L;
        this.j = true;
        a(context);
    }

    private void a(Context context) {
        this.a = LayoutInflater.from(context).inflate(com.baidu.tbadk.k.progress_count_down_view, this);
        this.b = (TextView) this.a.findViewById(com.baidu.tbadk.j.progress_count_down_text);
        this.c = (ProgressBar) this.a.findViewById(com.baidu.tbadk.j.progress_count_down_progress);
    }

    public void setFinalText(String str) {
        this.d = String.valueOf(str) + "： ";
    }

    public final void a(long j, long j2, long j3) {
        this.h = j;
        this.i = 60000L;
        this.f = new ab(this, j, 500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ProgressCountDownView progressCountDownView, long j) {
        long max = (progressCountDownView.c.getMax() * j) / progressCountDownView.h;
        if (j > progressCountDownView.i) {
            progressCountDownView.c.setProgress((int) max);
            return;
        }
        if (progressCountDownView.j) {
            progressCountDownView.c.setSecondaryProgress((int) max);
            progressCountDownView.j = false;
        } else {
            progressCountDownView.c.setSecondaryProgress(0);
            progressCountDownView.j = true;
        }
        progressCountDownView.c.setProgress(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ProgressCountDownView progressCountDownView, long j) {
        long j2;
        long j3;
        StringBuilder sb = new StringBuilder(String.valueOf(progressCountDownView.d));
        String str = String.valueOf(j / 60000 < 10 ? String.valueOf("") + "0" : "") + String.valueOf(j2) + "'";
        if ((j % 60000) / 1000 < 10) {
            str = String.valueOf(str) + "0";
        }
        progressCountDownView.e = sb.append(String.valueOf(str) + String.valueOf(j3) + "\"").toString();
        progressCountDownView.b.setText(progressCountDownView.e);
    }

    public final void a() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public final void b() {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void setOnFinishlistener(ac acVar) {
        this.g = acVar;
    }
}
