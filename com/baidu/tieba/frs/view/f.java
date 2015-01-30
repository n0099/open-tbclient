package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ FrsHeaderView aIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsHeaderView frsHeaderView) {
        this.aIT = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        TbPageContext tbPageContext;
        popupWindow = this.aIT.aIk;
        if (popupWindow != null) {
            popupWindow2 = this.aIT.aIk;
            if (popupWindow2.isShowing()) {
                z = this.aIT.aIN;
                if (!z) {
                    popupWindow3 = this.aIT.aIk;
                    tbPageContext = this.aIT.mContext;
                    com.baidu.adp.lib.g.k.a(popupWindow3, tbPageContext.getPageActivity());
                }
            }
        }
    }
}
