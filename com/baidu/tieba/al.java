package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f694a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        boolean isChecked = this.f694a.e.isChecked();
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f694a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        anVar = this.f694a.h;
        anVar.a(isChecked);
    }
}
