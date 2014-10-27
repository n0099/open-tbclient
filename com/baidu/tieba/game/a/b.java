package com.baidu.tieba.game.a;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private static int aJZ = 3000;
    private com.baidu.adp.lib.guide.d aHF;
    private f aKa;
    private Handler mHandler;

    public CustomMessageListener Ik() {
        return new c(this, 2001121);
    }

    public boolean fi(int i) {
        return j.fh() && !j.fi() && (i == 1 || i == 4);
    }

    public void a(Activity activity, View view) {
        if (activity != null && view != null) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(view).A(0).r(false);
            gVar.a(new d(this));
            this.aHF = gVar.dA();
            this.aHF.c(activity);
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(new e(this), aJZ);
        }
    }

    public void a(f fVar) {
        this.aKa = fVar;
    }
}
