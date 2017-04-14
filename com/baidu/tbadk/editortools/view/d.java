package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aCc = cVar;
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
        this.aCc.hideProgressBar();
        commonTabWidgetView = this.aCc.aCa;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aCc.aCa;
        arrayList = this.aCc.abn;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aCc.abn;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aCc.abn;
            b.C0040b Eo = ((b) arrayList3.get(i3)).Eo();
            if (Eo != null) {
                z = true;
                this.aCc.c(Eo);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aCc.aCa;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aCc.aBR;
        if (i < 0) {
            this.aCc.setCurrentTab(0);
            return;
        }
        c cVar = this.aCc;
        i2 = this.aCc.aBR;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Eu() {
        this.aCc.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Ev() {
        this.aCc.hideProgressBar();
    }
}
