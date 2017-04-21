package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aCe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aCe = cVar;
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
        this.aCe.hideProgressBar();
        commonTabWidgetView = this.aCe.aCc;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aCe.aCc;
        arrayList = this.aCe.abo;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aCe.abo;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aCe.abo;
            b.C0040b Eo = ((b) arrayList3.get(i3)).Eo();
            if (Eo != null) {
                z = true;
                this.aCe.c(Eo);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aCe.aCc;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aCe.aBT;
        if (i < 0) {
            this.aCe.setCurrentTab(0);
            return;
        }
        c cVar = this.aCe;
        i2 = this.aCe.aBT;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Eu() {
        this.aCe.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Ev() {
        this.aCe.hideProgressBar();
    }
}
