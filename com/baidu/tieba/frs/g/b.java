package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a ccS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ccS = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        View view;
        TbPageContext tbPageContext2;
        int i;
        View e;
        View view2;
        PopupWindow popupWindow;
        View view3;
        Handler handler;
        tbPageContext = this.ccS.ajU;
        if (tbPageContext != null) {
            view = this.ccS.ccP;
            if (view != null) {
                tbPageContext2 = this.ccS.ajU;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int g = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds64);
                a aVar = this.ccS;
                i = this.ccS.ccM;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.ccS.ccP;
                view2.getLocationInWindow(iArr);
                int g2 = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds32);
                int g3 = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds16) + (iArr[1] - g);
                this.ccS.ccQ = new PopupWindow(e, -2, g);
                popupWindow = this.ccS.ccQ;
                view3 = this.ccS.ccP;
                popupWindow.showAtLocation(view3, 53, g2, g3);
                handler = this.ccS.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
