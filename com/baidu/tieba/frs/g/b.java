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
    final /* synthetic */ a caB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.caB = aVar;
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
        tbPageContext = this.caB.ajT;
        if (tbPageContext != null) {
            view = this.caB.cay;
            if (view != null) {
                tbPageContext2 = this.caB.ajT;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int g = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds64);
                a aVar = this.caB;
                i = this.caB.cav;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.caB.cay;
                view2.getLocationInWindow(iArr);
                int g2 = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds32);
                int g3 = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds16) + (iArr[1] - g);
                this.caB.caz = new PopupWindow(e, -2, g);
                popupWindow = this.caB.caz;
                view3 = this.caB.cay;
                popupWindow.showAtLocation(view3, 53, g2, g3);
                handler = this.caB.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
