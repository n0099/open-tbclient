package com.baidu.tieba.i;

import android.content.Context;
import android.view.WindowManager;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d dUt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dUt = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        relativeLayout = this.dUt.dUp;
        if (relativeLayout != null) {
            context = this.dUt.mContext;
            relativeLayout2 = this.dUt.dUp;
            ((WindowManager) context.getSystemService("window")).removeViewImmediate(relativeLayout2);
            this.dUt.clean();
        }
    }
}
