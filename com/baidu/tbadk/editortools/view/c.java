package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b arF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.arF = bVar;
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void c(a aVar) {
        CommonTabWidgetView commonTabWidgetView;
        CommonTabWidgetView commonTabWidgetView2;
        ArrayList<a> arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        CommonTabWidgetView commonTabWidgetView3;
        ArrayList arrayList3;
        boolean z;
        this.arF.hideProgressBar();
        commonTabWidgetView = this.arF.arD;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.arF.arD;
        arrayList = this.arF.Xk;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.arF.Xk;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.arF.Xk;
            a.b BD = ((a) arrayList3.get(i3)).BD();
            if (BD != null) {
                z = true;
                this.arF.c(BD);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.arF.arD;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.arF.aru;
        if (i < 0) {
            this.arF.setCurrentTab(0);
            return;
        }
        b bVar = this.arF;
        i2 = this.arF.aru;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BH() {
        this.arF.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BI() {
        this.arF.hideProgressBar();
    }
}
