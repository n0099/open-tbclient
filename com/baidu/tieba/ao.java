package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
final class ao implements View.OnClickListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.a = anVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        aq aqVar;
        boolean isChecked = this.a.e.isChecked();
        cb.a(this.a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        aqVar = this.a.h;
        aqVar.a(isChecked);
    }
}
