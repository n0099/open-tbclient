package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aCd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aCd = cVar;
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
        this.aCd.hideProgressBar();
        commonTabWidgetView = this.aCd.aCb;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aCd.aCb;
        arrayList = this.aCd.aaJ;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aCd.aaJ;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aCd.aaJ;
            b.C0044b Ds = ((b) arrayList3.get(i3)).Ds();
            if (Ds != null) {
                z = true;
                this.aCd.c(Ds);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aCd.aCb;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aCd.aBS;
        if (i < 0) {
            this.aCd.setCurrentTab(0);
            return;
        }
        c cVar = this.aCd;
        i2 = this.aCd.aBS;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Dy() {
        this.aCd.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Dz() {
        this.aCd.hideProgressBar();
    }
}
