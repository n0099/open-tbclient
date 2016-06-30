package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bRz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bRz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        View view;
        TbPageContext tbPageContext2;
        View d;
        View view2;
        PopupWindow popupWindow;
        View view3;
        Handler handler;
        tbPageContext = this.bRz.Ea;
        if (tbPageContext != null) {
            view = this.bRz.bRw;
            if (view != null) {
                tbPageContext2 = this.bRz.Ea;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int c = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds20);
                int c2 = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds64);
                d = this.bRz.d(pageActivity, c);
                int[] iArr = new int[2];
                view2 = this.bRz.bRw;
                view2.getLocationInWindow(iArr);
                int c3 = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds32);
                int c4 = com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds16) + (iArr[1] - c2);
                this.bRz.bRx = new PopupWindow(d, -2, c2);
                popupWindow = this.bRz.bRx;
                view3 = this.bRz.bRw;
                popupWindow.showAtLocation(view3, 53, c3, c4);
                handler = this.bRz.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
