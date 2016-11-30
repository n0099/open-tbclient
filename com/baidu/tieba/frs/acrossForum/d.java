package com.baidu.tieba.frs.acrossForum;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bWJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bWJ = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifView gifView;
        GifView gifView2;
        int i;
        gifView = this.bWJ.bWE;
        if (gifView != null) {
            gifView2 = this.bWJ.bWE;
            Property property = View.TRANSLATION_X;
            i = c.bWD;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gifView2, property, 0.0f, i);
            ofFloat.addListener(new e(this));
            ofFloat.setDuration(500L).start();
        }
    }
}
