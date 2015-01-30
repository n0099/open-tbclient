package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ o aJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aJb = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        TbPageContext tbPageContext;
        popupWindow = this.aJb.aIk;
        if (popupWindow != null) {
            popupWindow2 = this.aJb.aIk;
            if (popupWindow2.isShowing()) {
                z = this.aJb.aIN;
                if (!z) {
                    popupWindow3 = this.aJb.aIk;
                    tbPageContext = this.aJb.mContext;
                    com.baidu.adp.lib.g.k.a(popupWindow3, tbPageContext.getPageActivity());
                }
            }
        }
    }
}
