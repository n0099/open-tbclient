package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bUI = aVar;
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
        tbPageContext = this.bUI.FY;
        if (tbPageContext != null) {
            view = this.bUI.bUF;
            if (view != null) {
                tbPageContext2 = this.bUI.FY;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int e2 = com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds64);
                a aVar = this.bUI;
                i = this.bUI.bUC;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.bUI.bUF;
                view2.getLocationInWindow(iArr);
                int e3 = com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds32);
                int e4 = com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds16) + (iArr[1] - e2);
                this.bUI.bUG = new PopupWindow(e, -2, e2);
                popupWindow = this.bUI.bUG;
                view3 = this.bUI.bUF;
                popupWindow.showAtLocation(view3, 53, e3, e4);
                handler = this.bUI.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
