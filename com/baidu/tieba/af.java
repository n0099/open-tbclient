package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.f919a = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        boolean isChecked = this.f919a.e.isChecked();
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f919a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        ahVar = this.f919a.h;
        ahVar.a(isChecked);
    }
}
