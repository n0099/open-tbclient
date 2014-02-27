package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements PopupWindow.OnDismissListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.a = wVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.a.B = false;
        if (TiebaApplication.g().ae() == 1) {
            this.a.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
        } else {
            this.a.z.setImageResource(R.drawable.btn_allsproutpop_down);
        }
    }
}
