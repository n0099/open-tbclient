package com.baidu.tieba.home;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bu f1439a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.f1439a = buVar;
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
        scroller = this.f1439a.i;
        if (scroller.computeScrollOffset()) {
            scroller3 = this.f1439a.i;
            int currX = scroller3.getCurrX();
            progressBar3 = this.f1439a.d;
            if (currX >= (progressBar3.getMax() * 9) / 10) {
                i = this.f1439a.f1438a;
                if (i != 2) {
                    scroller4 = this.f1439a.i;
                    scroller4.forceFinished(true);
                    bu buVar = this.f1439a;
                    runnable2 = this.f1439a.l;
                    buVar.postDelayed(runnable2, 2000L);
                    return;
                }
            }
            progressBar4 = this.f1439a.d;
            progressBar4.setProgress(currX);
            bu buVar2 = this.f1439a;
            runnable = this.f1439a.k;
            buVar2.postDelayed(runnable, 16L);
            return;
        }
        progressBar = this.f1439a.d;
        int progress = progressBar.getProgress();
        progressBar2 = this.f1439a.d;
        int max = (progressBar2.getMax() * 9) / 10;
        if (progress < max) {
            scroller2 = this.f1439a.i;
            scroller2.startScroll(progress, 0, max - progress, 0, 5000);
            this.f1439a.post(this);
        }
    }
}
