package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.f1237a = yVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1237a.A = false;
        if (TiebaApplication.g().ap() == 1) {
            this.f1237a.y.setImageResource(R.drawable.btn_allsproutpop_down_1);
        } else {
            this.f1237a.y.setImageResource(R.drawable.btn_allsproutpop_down);
        }
    }
}
