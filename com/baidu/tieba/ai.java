package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.f936a = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ak akVar;
        boolean isChecked = this.f936a.e.isChecked();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f936a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        akVar = this.f936a.h;
        akVar.a(isChecked);
    }
}
