package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b asR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.asR = bVar;
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
        this.asR.hideProgressBar();
        commonTabWidgetView = this.asR.asP;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.asR.asP;
        arrayList = this.asR.Xf;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.asR.Xf;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.asR.Xf;
            a.b BN = ((a) arrayList3.get(i3)).BN();
            if (BN != null) {
                z = true;
                this.asR.c(BN);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.asR.asP;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.asR.apY;
        if (i < 0) {
            this.asR.setCurrentTab(0);
            return;
        }
        b bVar = this.asR;
        i2 = this.asR.apY;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BR() {
        this.asR.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BS() {
        this.asR.hideProgressBar();
    }
}
