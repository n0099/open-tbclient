package com.baidu.tieba.frs.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Handler.Callback {
    final /* synthetic */ ai ckC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.ckC = aiVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        BdTypeListView bdTypeListView;
        boolean z;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        Handler handler;
        BdTypeListView bdTypeListView4;
        BdTypeListView bdTypeListView5;
        au auVar;
        bdTypeListView = this.ckC.aML;
        if (bdTypeListView != null) {
            if (message.what == 0) {
                z = this.ckC.cky;
                if (z) {
                    bdTypeListView2 = this.ckC.aML;
                    if (bdTypeListView2.getFirstVisiblePosition() != 0) {
                        bdTypeListView3 = this.ckC.aML;
                        if (bdTypeListView3.getFirstVisiblePosition() > 8) {
                            bdTypeListView4 = this.ckC.aML;
                            bdTypeListView4.setSelection(8);
                            bdTypeListView5 = this.ckC.aML;
                            bdTypeListView5.smoothScrollToPosition(0);
                        }
                        handler = this.ckC.mHandler;
                        handler.sendEmptyMessageDelayed(0, 50L);
                    } else {
                        this.ckC.iO(0);
                        auVar = this.ckC.bVA;
                        auVar.dS(false);
                        this.ckC.cky = false;
                    }
                }
            }
            if (message.what == 1) {
                this.ckC.ahM();
            }
        }
        return false;
    }
}
