package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class an implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.f909a = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ap apVar;
        boolean isChecked = this.f909a.e.isChecked();
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f909a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        apVar = this.f909a.h;
        apVar.a(isChecked);
    }
}
