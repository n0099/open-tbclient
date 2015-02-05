package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ FrsHeaderView aIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsHeaderView frsHeaderView) {
        this.aIQ = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        TbPageContext tbPageContext;
        popupWindow = this.aIQ.aIh;
        if (popupWindow != null) {
            popupWindow2 = this.aIQ.aIh;
            if (popupWindow2.isShowing()) {
                z = this.aIQ.aIK;
                if (!z) {
                    popupWindow3 = this.aIQ.aIh;
                    tbPageContext = this.aIQ.mContext;
                    com.baidu.adp.lib.g.k.a(popupWindow3, tbPageContext.getPageActivity());
                }
            }
        }
    }
}
