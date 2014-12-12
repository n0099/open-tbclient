package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ o aHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aHR = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        TbPageContext tbPageContext;
        popupWindow = this.aHR.aHa;
        if (popupWindow != null) {
            popupWindow2 = this.aHR.aHa;
            if (popupWindow2.isShowing()) {
                z = this.aHR.aHD;
                if (!z) {
                    popupWindow3 = this.aHR.aHa;
                    tbPageContext = this.aHR.mContext;
                    com.baidu.adp.lib.g.k.a(popupWindow3, tbPageContext.getPageActivity());
                }
            }
        }
    }
}
