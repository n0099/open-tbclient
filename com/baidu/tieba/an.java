package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ap apVar;
        boolean isChecked = this.a.e.isChecked();
        if (TiebaApplication.f().s()) {
            StatService.onEvent(this.a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        apVar = this.a.h;
        apVar.a(isChecked);
    }
}
