package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
class av implements View.OnClickListener {
    final /* synthetic */ au a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.a = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        boolean isChecked = this.a.e.isChecked();
        by.a(this.a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        axVar = this.a.h;
        axVar.a(isChecked);
    }
}
