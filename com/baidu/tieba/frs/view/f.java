package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ FrsHeaderView aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsHeaderView frsHeaderView) {
        this.aHJ = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        TbPageContext tbPageContext;
        popupWindow = this.aHJ.aHa;
        if (popupWindow != null) {
            popupWindow2 = this.aHJ.aHa;
            if (popupWindow2.isShowing()) {
                z = this.aHJ.aHD;
                if (!z) {
                    popupWindow3 = this.aHJ.aHa;
                    tbPageContext = this.aHJ.mContext;
                    com.baidu.adp.lib.g.k.a(popupWindow3, tbPageContext.getPageActivity());
                }
            }
        }
    }
}
