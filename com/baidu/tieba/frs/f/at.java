package com.baidu.tieba.frs.f;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements Handler.Callback {
    final /* synthetic */ as cdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.cdL = asVar;
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
        bdTypeListView = this.cdL.mListView;
        if (bdTypeListView != null) {
            if (message.what == 0) {
                z = this.cdL.cdG;
                if (z) {
                    bdTypeListView2 = this.cdL.mListView;
                    if (bdTypeListView2.getFirstVisiblePosition() != 0) {
                        bdTypeListView3 = this.cdL.mListView;
                        if (bdTypeListView3.getFirstVisiblePosition() > 8) {
                            bdTypeListView4 = this.cdL.mListView;
                            bdTypeListView4.setSelection(8);
                            bdTypeListView5 = this.cdL.mListView;
                            bdTypeListView5.smoothScrollToPosition(0);
                        }
                        handler = this.cdL.mHandler;
                        handler.sendEmptyMessageDelayed(0, 50L);
                    } else {
                        this.cdL.iI(0);
                        axVar = this.cdL.bQl;
                        axVar.dG(false);
                        this.cdL.cdG = false;
                    }
                }
            }
            if (message.what == 1) {
                this.cdL.aes();
            }
        }
        return false;
    }
}
