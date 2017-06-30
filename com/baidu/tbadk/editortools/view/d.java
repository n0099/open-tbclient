package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aCT = cVar;
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
        this.aCT.hideProgressBar();
        commonTabWidgetView = this.aCT.aCR;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aCT.aCR;
        arrayList = this.aCT.aaJ;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aCT.aaJ;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aCT.aaJ;
            b.C0046b DG = ((b) arrayList3.get(i3)).DG();
            if (DG != null) {
                z = true;
                this.aCT.c(DG);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aCT.aCR;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aCT.aCI;
        if (i < 0) {
            this.aCT.setCurrentTab(0);
            return;
        }
        c cVar = this.aCT;
        i2 = this.aCT.aCI;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DM() {
        this.aCT.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DN() {
        this.aCT.hideProgressBar();
    }
}
