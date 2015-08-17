package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j aoU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aoU = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if (view instanceof p) {
            p pVar = (p) view;
            gVar = this.aoU.aoF;
            gVar.a(this.aoU.dL(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                this.aoU.oy();
                this.aoU.b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            v dL = this.aoU.dL(toolId);
            if (dL.aox == null) {
                if (dL.apk != null && dL.apk.length > 0) {
                    this.aoU.b(new a(dL.apk[0], -1, null));
                    return;
                }
                return;
            }
            this.aoU.b(new a(1, toolId, null));
        }
    }
}
