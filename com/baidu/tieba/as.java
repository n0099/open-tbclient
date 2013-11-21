package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.f1110a = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        au auVar;
        boolean isChecked = this.f1110a.e.isChecked();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1110a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        auVar = this.f1110a.h;
        auVar.a(isChecked);
    }
}
