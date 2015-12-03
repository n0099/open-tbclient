package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k ark;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ark = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        j jVar;
        j jVar2;
        Runnable runnable;
        if (view instanceof r) {
            r rVar = (r) view;
            this.ark.b(new a(31, 0, Integer.valueOf(rVar.getToolId())));
            gVar = this.ark.aqS;
            gVar.a(this.ark.ei(rVar.getToolId()));
            jVar = this.ark.arf;
            if (jVar != null) {
                jVar2 = this.ark.arf;
                jVar2.BA();
                com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
                runnable = this.ark.ari;
                hj.removeCallbacks(runnable);
            }
            if (rVar.getToolId() == 1) {
                rVar.hide();
                this.ark.oD();
                this.ark.b(new a(1, 3, null));
                return;
            }
            int toolId = rVar.getToolId();
            y ei = this.ark.ei(toolId);
            if (ei.toolView == null) {
                if (ei.toolLaunchAction != null && ei.toolLaunchAction.length > 0) {
                    this.ark.b(new a(ei.toolLaunchAction[0], -1, null));
                    return;
                }
                return;
            }
            this.ark.b(new a(1, toolId, null));
        }
    }
}
