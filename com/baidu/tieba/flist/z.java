package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1077a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.f1077a = wVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1077a.B = false;
        if (TiebaApplication.g().ap() == 1) {
            this.f1077a.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
        } else {
            this.f1077a.z.setImageResource(R.drawable.btn_allsproutpop_down);
        }
    }
}
