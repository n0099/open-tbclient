package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j aqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aqF = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if (view instanceof p) {
            p pVar = (p) view;
            this.aqF.b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            gVar = this.aqF.aqq;
            gVar.a(this.aqF.dT(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                this.aqF.ov();
                this.aqF.b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            v dT = this.aqF.dT(toolId);
            if (dT.aqi == null) {
                if (dT.aqV != null && dT.aqV.length > 0) {
                    this.aqF.b(new a(dT.aqV[0], -1, null));
                    return;
                }
                return;
            }
            this.aqF.b(new a(1, toolId, null));
        }
    }
}
