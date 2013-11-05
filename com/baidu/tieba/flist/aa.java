package com.baidu.tieba.flist;

import android.widget.PopupWindow;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.f1187a = xVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1187a.B = false;
        if (TiebaApplication.g().as() == 1) {
            this.f1187a.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
        } else {
            this.f1187a.z.setImageResource(R.drawable.btn_allsproutpop_down);
        }
    }
}
