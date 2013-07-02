package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        boolean isChecked = this.a.e.isChecked();
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        anVar = this.a.h;
        anVar.a(isChecked);
    }
}
