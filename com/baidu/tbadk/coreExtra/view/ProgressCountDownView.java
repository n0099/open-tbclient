package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ProgressCountDownView extends FrameLayout {
    private View a;
    private TextView b;
    private ProgressBar c;
    private String d;
    private String e;
    private com.baidu.tbadk.coreExtra.c.c f;
    private ap g;
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
        this.a = LayoutInflater.from(context).inflate(com.baidu.tieba.w.progress_count_down_view, this);
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.v.progress_count_down_text);
        this.c = (ProgressBar) this.a.findViewById(com.baidu.tieba.v.progress_count_down_progress);
    }

    public void setFinalText(String str) {
        this.d = String.valueOf(str) + "： ";
    }

    public void a(long j, long j2, long j3) {
        this.h = j;
        this.i = j3;
        this.f = new ao(this, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        long max = (this.c.getMax() * j) / this.h;
        if (j <= this.i) {
            if (this.j) {
                this.c.setSecondaryProgress((int) max);
                this.j = false;
            } else {
                this.c.setSecondaryProgress(0);
                this.j = true;
            }
            this.c.setProgress(0);
            return;
        }
        this.c.setProgress((int) max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        this.e = String.valueOf(this.d) + c(j);
        this.b.setText(this.e);
    }

    private String c(long j) {
        long j2;
        long j3;
        String str = "";
        if (j / TbConfig.USE_TIME_INTERVAL < 10) {
            str = String.valueOf("") + "0";
        }
        String str2 = String.valueOf(str) + String.valueOf(j2) + "'";
        if ((j % TbConfig.USE_TIME_INTERVAL) / 1000 < 10) {
            str2 = String.valueOf(str2) + "0";
        }
        return String.valueOf(str2) + String.valueOf(j3) + "\"";
    }

    public void a() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void setOnFinishlistener(ap apVar) {
        this.g = apVar;
    }
}
