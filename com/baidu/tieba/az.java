package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.a = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bb bbVar;
        boolean isChecked = this.a.e.isChecked();
        by.a(this.a.getContext(), "upgrade_channel", isChecked ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        bbVar = this.a.h;
        bbVar.a(isChecked);
    }
}
