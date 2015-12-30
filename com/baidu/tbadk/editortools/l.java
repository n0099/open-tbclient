package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k asO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.asO = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        j jVar;
        j jVar2;
        Runnable runnable;
        if (view instanceof r) {
            r rVar = (r) view;
            this.asO.b(new a(31, 0, Integer.valueOf(rVar.getToolId())));
            gVar = this.asO.asw;
            gVar.a(this.asO.ec(rVar.getToolId()));
            jVar = this.asO.asJ;
            if (jVar != null) {
                jVar2 = this.asO.asJ;
                jVar2.Bp();
                com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
                runnable = this.asO.asM;
                hj.removeCallbacks(runnable);
            }
            if (rVar.getToolId() == 1) {
                rVar.hide();
                this.asO.ob();
                this.asO.b(new a(1, 3, null));
                return;
            }
            int toolId = rVar.getToolId();
            y ec = this.asO.ec(toolId);
            if (ec.toolView == null) {
                if (ec.toolLaunchAction != null && ec.toolLaunchAction.length > 0) {
                    this.asO.b(new a(ec.toolLaunchAction[0], -1, null));
                    return;
                }
                return;
            }
            this.asO.b(new a(1, toolId, null));
        }
    }
}
