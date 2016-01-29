package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k atH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.atH = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        j jVar;
        j jVar2;
        Runnable runnable;
        if (view instanceof r) {
            r rVar = (r) view;
            this.atH.b(new a(31, 0, Integer.valueOf(rVar.getToolId())));
            gVar = this.atH.atp;
            gVar.a(this.atH.ex(rVar.getToolId()));
            jVar = this.atH.atC;
            if (jVar != null) {
                jVar2 = this.atH.atC;
                jVar2.CF();
                com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
                runnable = this.atH.atF;
                hr.removeCallbacks(runnable);
            }
            if (rVar.getToolId() == 1) {
                rVar.hide();
                this.atH.ow();
                this.atH.b(new a(1, 3, null));
                return;
            }
            int toolId = rVar.getToolId();
            y ex = this.atH.ex(toolId);
            if (ex.toolView == null) {
                if (ex.toolLaunchAction != null && ex.toolLaunchAction.length > 0) {
                    this.atH.b(new a(ex.toolLaunchAction[0], -1, null));
                    return;
                }
                return;
            }
            this.atH.b(new a(1, toolId, null));
        }
    }
}
