package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.f1242a = yVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1242a.A = false;
        if (TiebaApplication.g().ap() == 1) {
            this.f1242a.y.setImageResource(R.drawable.btn_allsproutpop_down_1);
        } else {
            this.f1242a.y.setImageResource(R.drawable.btn_allsproutpop_down);
        }
    }
}
