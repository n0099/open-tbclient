package com.baidu.tieba.frs.h;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Handler.Callback {
    final /* synthetic */ an bPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.bPL = anVar;
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
        ax axVar;
        bdTypeListView = this.bPL.aMc;
        if (bdTypeListView != null) {
            if (message.what == 0) {
                z = this.bPL.bPH;
                if (z) {
                    bdTypeListView2 = this.bPL.aMc;
                    if (bdTypeListView2.getFirstVisiblePosition() != 0) {
                        bdTypeListView3 = this.bPL.aMc;
                        if (bdTypeListView3.getFirstVisiblePosition() > 8) {
                            bdTypeListView4 = this.bPL.aMc;
                            bdTypeListView4.setSelection(8);
                            bdTypeListView5 = this.bPL.aMc;
                            bdTypeListView5.smoothScrollToPosition(0);
                        }
                        handler = this.bPL.mHandler;
                        handler.sendEmptyMessageDelayed(0, 50L);
                    } else {
                        this.bPL.hY(0);
                        axVar = this.bPL.bBI;
                        axVar.dA(false);
                        this.bPL.bPH = false;
                    }
                }
            }
            if (message.what == 1) {
                this.bPL.acj();
            }
        }
        return false;
    }
}
