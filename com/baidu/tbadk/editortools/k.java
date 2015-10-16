package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j apg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.apg = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if (view instanceof p) {
            p pVar = (p) view;
            this.apg.b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            gVar = this.apg.aoR;
            gVar.a(this.apg.dU(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                this.apg.ow();
                this.apg.b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            v dU = this.apg.dU(toolId);
            if (dU.aoJ == null) {
                if (dU.apx != null && dU.apx.length > 0) {
                    this.apg.b(new a(dU.apx[0], -1, null));
                    return;
                }
                return;
            }
            this.apg.b(new a(1, toolId, null));
        }
    }
}
