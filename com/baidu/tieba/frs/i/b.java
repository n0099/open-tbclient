package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a ceG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ceG = aVar;
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
        tbPageContext = this.ceG.GM;
        if (tbPageContext != null) {
            view = this.ceG.ceD;
            if (view != null) {
                tbPageContext2 = this.ceG.GM;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int e2 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds64);
                a aVar = this.ceG;
                i = this.ceG.ceA;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.ceG.ceD;
                view2.getLocationInWindow(iArr);
                int e3 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds32);
                int e4 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds16) + (iArr[1] - e2);
                this.ceG.ceE = new PopupWindow(e, -2, e2);
                popupWindow = this.ceG.ceE;
                view3 = this.ceG.ceD;
                popupWindow.showAtLocation(view3, 53, e3, e4);
                handler = this.ceG.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
