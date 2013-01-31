package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((FrsActivity) this.a.a).i();
    }
}
