package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j apm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.apm = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if (view instanceof p) {
            p pVar = (p) view;
            this.apm.b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            gVar = this.apm.aoW;
            gVar.a(this.apm.dU(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                this.apm.ox();
                this.apm.b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            w dU = this.apm.dU(toolId);
            if (dU.toolView == null) {
                if (dU.toolLaunchAction != null && dU.toolLaunchAction.length > 0) {
                    this.apm.b(new a(dU.toolLaunchAction[0], -1, null));
                    return;
                }
                return;
            }
            this.apm.b(new a(1, toolId, null));
        }
    }
}
