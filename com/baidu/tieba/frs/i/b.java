package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a ceH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ceH = aVar;
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
        tbPageContext = this.ceH.GM;
        if (tbPageContext != null) {
            view = this.ceH.ceE;
            if (view != null) {
                tbPageContext2 = this.ceH.GM;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int e2 = com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds64);
                a aVar = this.ceH;
                i = this.ceH.ceB;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.ceH.ceE;
                view2.getLocationInWindow(iArr);
                int e3 = com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds32);
                int e4 = com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds16) + (iArr[1] - e2);
                this.ceH.ceF = new PopupWindow(e, -2, e2);
                popupWindow = this.ceH.ceF;
                view3 = this.ceH.ceE;
                popupWindow.showAtLocation(view3, 53, e3, e4);
                handler = this.ceH.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
