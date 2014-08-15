package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements PopupWindow.OnDismissListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.a = uVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.a.C = false;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.a.A.setImageResource(com.baidu.tieba.t.btn_allsproutpop_down_1);
        } else {
            this.a.A.setImageResource(com.baidu.tieba.t.btn_allsproutpop_down);
        }
    }
}
