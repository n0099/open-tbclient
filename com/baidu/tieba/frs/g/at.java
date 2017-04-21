package com.baidu.tieba.frs.g;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements Handler.Callback {
    final /* synthetic */ as ceD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.ceD = asVar;
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
        az azVar;
        bdTypeListView = this.ceD.mListView;
        if (bdTypeListView != null) {
            if (message.what == 0) {
                z = this.ceD.cey;
                if (z) {
                    bdTypeListView2 = this.ceD.mListView;
                    if (bdTypeListView2.getFirstVisiblePosition() != 0) {
                        bdTypeListView3 = this.ceD.mListView;
                        if (bdTypeListView3.getFirstVisiblePosition() > 8) {
                            bdTypeListView4 = this.ceD.mListView;
                            bdTypeListView4.setSelection(8);
                            bdTypeListView5 = this.ceD.mListView;
                            bdTypeListView5.smoothScrollToPosition(0);
                        }
                        handler = this.ceD.mHandler;
                        handler.sendEmptyMessageDelayed(0, 50L);
                    } else {
                        this.ceD.iP(0);
                        azVar = this.ceD.bSr;
                        azVar.dS(false);
                        this.ceD.cey = false;
                    }
                }
            }
            if (message.what == 1) {
                this.ceD.afo();
            }
        }
        return false;
    }
}
