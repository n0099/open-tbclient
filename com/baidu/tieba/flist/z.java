package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements PopupWindow.OnDismissListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.a = wVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.a.C = false;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.a.A.setImageResource(com.baidu.tieba.u.btn_allsproutpop_down_1);
        } else {
            this.a.A.setImageResource(com.baidu.tieba.u.btn_allsproutpop_down);
        }
    }
}
