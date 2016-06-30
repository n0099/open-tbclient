package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c atA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.atA = cVar;
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void c(b bVar) {
        CommonTabWidgetView commonTabWidgetView;
        CommonTabWidgetView commonTabWidgetView2;
        ArrayList<b> arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        CommonTabWidgetView commonTabWidgetView3;
        ArrayList arrayList3;
        boolean z;
        this.atA.hideProgressBar();
        commonTabWidgetView = this.atA.aty;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.atA.aty;
        arrayList = this.atA.SV;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.atA.SV;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.atA.SV;
            b.C0041b Cv = ((b) arrayList3.get(i3)).Cv();
            if (Cv != null) {
                z = true;
                this.atA.c(Cv);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.atA.aty;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.atA.atp;
        if (i < 0) {
            this.atA.setCurrentTab(0);
            return;
        }
        c cVar = this.atA;
        i2 = this.atA.atp;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void CB() {
        this.atA.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void CC() {
        this.atA.hideProgressBar();
    }
}
