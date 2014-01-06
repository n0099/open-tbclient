package com.baidu.tieba;

import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.a = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ay ayVar;
        boolean isChecked = this.a.e.isChecked();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1);
        }
        ayVar = this.a.h;
        ayVar.a(isChecked);
    }
}
