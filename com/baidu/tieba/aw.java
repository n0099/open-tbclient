package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f1124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.f1124a = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ay ayVar;
        boolean isChecked = this.f1124a.e.isChecked();
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.f1124a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        ayVar = this.f1124a.h;
        ayVar.a(isChecked);
    }
}
