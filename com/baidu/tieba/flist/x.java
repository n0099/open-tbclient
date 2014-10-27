package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements PopupWindow.OnDismissListener {
    final /* synthetic */ u awH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.awH = uVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.awH.iC = false;
        aw.c(this.awH.awF, com.baidu.tieba.u.btn_allsproutpop_down);
    }
}
