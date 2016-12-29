package com.baidu.tieba.frs.h;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bOl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bOl = aVar;
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
        tbPageContext = this.bOl.GO;
        if (tbPageContext != null) {
            view = this.bOl.bOi;
            if (view != null) {
                tbPageContext2 = this.bOl.GO;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int e2 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds64);
                a aVar = this.bOl;
                i = this.bOl.bOf;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.bOl.bOi;
                view2.getLocationInWindow(iArr);
                int e3 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds32);
                int e4 = com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds16) + (iArr[1] - e2);
                this.bOl.bOj = new PopupWindow(e, -2, e2);
                popupWindow = this.bOl.bOj;
                view3 = this.bOl.bOi;
                popupWindow.showAtLocation(view3, 53, e3, e4);
                handler = this.bOl.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
