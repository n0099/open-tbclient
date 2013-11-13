package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f1104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.f1104a = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar;
        boolean isChecked = this.f1104a.e.isChecked();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1104a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        arVar = this.f1104a.h;
        arVar.a(isChecked);
    }
}
