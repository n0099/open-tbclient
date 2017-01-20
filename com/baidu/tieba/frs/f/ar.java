package com.baidu.tieba.frs.f;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements Handler.Callback {
    final /* synthetic */ aq bWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.bWq = aqVar;
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
        bdTypeListView = this.bWq.mListView;
        if (bdTypeListView != null) {
            if (message.what == 0) {
                z = this.bWq.bWl;
                if (z) {
                    bdTypeListView2 = this.bWq.mListView;
                    if (bdTypeListView2.getFirstVisiblePosition() != 0) {
                        bdTypeListView3 = this.bWq.mListView;
                        if (bdTypeListView3.getFirstVisiblePosition() > 8) {
                            bdTypeListView4 = this.bWq.mListView;
                            bdTypeListView4.setSelection(8);
                            bdTypeListView5 = this.bWq.mListView;
                            bdTypeListView5.smoothScrollToPosition(0);
                        }
                        handler = this.bWq.mHandler;
                        handler.sendEmptyMessageDelayed(0, 50L);
                    } else {
                        this.bWq.iM(0);
                        axVar = this.bWq.bJc;
                        axVar.dG(false);
                        this.bWq.bWl = false;
                    }
                }
            }
            if (message.what == 1) {
                this.bWq.ads();
            }
        }
        return false;
    }
}
