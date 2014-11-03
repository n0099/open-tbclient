package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements PopupWindow.OnDismissListener {
    final /* synthetic */ u awQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.awQ = uVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.awQ.iC = false;
        aw.c(this.awQ.awO, com.baidu.tieba.u.btn_allsproutpop_down);
    }
}
