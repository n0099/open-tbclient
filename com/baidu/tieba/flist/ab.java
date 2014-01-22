package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements PopupWindow.OnDismissListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.a = yVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.a.B = false;
        if (TiebaApplication.h().al() == 1) {
            this.a.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
        } else {
            this.a.z.setImageResource(R.drawable.btn_allsproutpop_down);
        }
    }
}
