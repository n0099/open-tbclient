package com.baidu.tieba.home;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements Runnable {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scroller scroller;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        Scroller scroller2;
        Scroller scroller3;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        Runnable runnable;
        int i;
        Scroller scroller4;
        Runnable runnable2;
        scroller = this.a.i;
        if (scroller.computeScrollOffset()) {
            scroller3 = this.a.i;
            int currX = scroller3.getCurrX();
            progressBar3 = this.a.d;
            if (currX >= (progressBar3.getMax() * 9) / 10) {
                i = this.a.a;
                if (i != 2) {
                    scroller4 = this.a.i;
                    scroller4.forceFinished(true);
                    bq bqVar = this.a;
                    runnable2 = this.a.l;
                    bqVar.postDelayed(runnable2, 2000L);
                    return;
                }
            }
            progressBar4 = this.a.d;
            progressBar4.setProgress(currX);
            bq bqVar2 = this.a;
            runnable = this.a.k;
            bqVar2.postDelayed(runnable, 16L);
            return;
        }
        progressBar = this.a.d;
        int progress = progressBar.getProgress();
        progressBar2 = this.a.d;
        int max = (progressBar2.getMax() * 9) / 10;
        if (progress < max) {
            scroller2 = this.a.i;
            scroller2.startScroll(progress, 0, max - progress, 0, 5000);
            this.a.post(this);
        }
    }
}
