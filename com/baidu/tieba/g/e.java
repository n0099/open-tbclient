package com.baidu.tieba.g;

import android.content.Context;
import android.view.WindowManager;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d dOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dOW = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        relativeLayout = this.dOW.dOS;
        if (relativeLayout != null) {
            context = this.dOW.mContext;
            relativeLayout2 = this.dOW.dOS;
            ((WindowManager) context.getSystemService("window")).removeViewImmediate(relativeLayout2);
            this.dOW.clean();
        }
    }
}
