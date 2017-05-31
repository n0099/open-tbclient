package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cgR = aVar;
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
        tbPageContext = this.cgR.ajh;
        if (tbPageContext != null) {
            view = this.cgR.cgO;
            if (view != null) {
                tbPageContext2 = this.cgR.ajh;
                Activity pageActivity = tbPageContext2.getPageActivity();
                int g = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds64);
                a aVar = this.cgR;
                i = this.cgR.cgL;
                e = aVar.e(pageActivity, i);
                int[] iArr = new int[2];
                view2 = this.cgR.cgO;
                view2.getLocationInWindow(iArr);
                int g2 = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds32);
                int g3 = com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds16) + (iArr[1] - g);
                this.cgR.cgP = new PopupWindow(e, -2, g);
                popupWindow = this.cgR.cgP;
                view3 = this.cgR.cgO;
                popupWindow.showAtLocation(view3, 53, g2, g3);
                handler = this.cgR.mHandler;
                handler.postDelayed(new c(this), 3000L);
            }
        }
    }
}
