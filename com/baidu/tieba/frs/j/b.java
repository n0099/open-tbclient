package com.baidu.tieba.frs.j;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a cjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cjf = aVar;
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
        tbPageContext = this.cjf.GO;
        if (tbPageContext != null) {
            view = this.cjf.cjc;
            if (view != null) {
                tbPageContext2 = this.cjf.GO;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int e2 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds64);
                a aVar = this.cjf;
                i = this.cjf.ciZ;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.cjf.cjc;
                view2.getLocationInWindow(iArr);
                int e3 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds32);
                int e4 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds16) + (iArr[1] - e2);
                this.cjf.cjd = new PopupWindow(e, -2, e2);
                popupWindow = this.cjf.cjd;
                view3 = this.cjf.cjc;
                popupWindow.showAtLocation(view3, 53, e3, e4);
                handler = this.cjf.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
