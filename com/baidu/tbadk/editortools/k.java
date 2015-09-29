package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j apf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.apf = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if (view instanceof p) {
            p pVar = (p) view;
            this.apf.b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            gVar = this.apf.aoQ;
            gVar.a(this.apf.dU(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                this.apf.ow();
                this.apf.b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            v dU = this.apf.dU(toolId);
            if (dU.aoI == null) {
                if (dU.apw != null && dU.apw.length > 0) {
                    this.apf.b(new a(dU.apw[0], -1, null));
                    return;
                }
                return;
            }
            this.apf.b(new a(1, toolId, null));
        }
    }
}
