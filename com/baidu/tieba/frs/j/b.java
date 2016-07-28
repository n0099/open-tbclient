package com.baidu.tieba.frs.j;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bTz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        View view;
        TbPageContext tbPageContext2;
        int i;
        View d;
        View view2;
        PopupWindow popupWindow;
        View view3;
        Handler handler;
        tbPageContext = this.bTz.EA;
        if (tbPageContext != null) {
            view = this.bTz.bTw;
            if (view != null) {
                tbPageContext2 = this.bTz.EA;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int c = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds64);
                a aVar = this.bTz;
                i = this.bTz.bTt;
                d = aVar.d(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.bTz.bTw;
                view2.getLocationInWindow(iArr);
                int c2 = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds32);
                int c3 = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds16) + (iArr[1] - c);
                this.bTz.bTx = new PopupWindow(d, -2, c);
                popupWindow = this.bTz.bTx;
                view3 = this.bTz.bTw;
                popupWindow.showAtLocation(view3, 53, c2, c3);
                handler = this.bTz.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
