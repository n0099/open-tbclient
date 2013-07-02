package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.a.d {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FrsActivity frsActivity;
        az azVar;
        if (bVar != null) {
            frsActivity = this.a.a;
            azVar = frsActivity.l;
            View d = azVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
