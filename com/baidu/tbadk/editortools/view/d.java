package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aBQ = cVar;
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
        this.aBQ.hideProgressBar();
        commonTabWidgetView = this.aBQ.aBO;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aBQ.aBO;
        arrayList = this.aBQ.aaI;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aBQ.aaI;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aBQ.aaI;
            b.C0044b Dm = ((b) arrayList3.get(i3)).Dm();
            if (Dm != null) {
                z = true;
                this.aBQ.c(Dm);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aBQ.aBO;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aBQ.aBF;
        if (i < 0) {
            this.aBQ.setCurrentTab(0);
            return;
        }
        c cVar = this.aBQ;
        i2 = this.aBQ.aBF;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Ds() {
        this.aBQ.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Dt() {
        this.aBQ.hideProgressBar();
    }
}
