package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b asK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.asK = bVar;
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
        this.asK.hideProgressBar();
        commonTabWidgetView = this.asK.asI;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.asK.asI;
        arrayList = this.asK.Xe;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.asK.Xe;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.asK.Xe;
            a.b BM = ((a) arrayList3.get(i3)).BM();
            if (BM != null) {
                z = true;
                this.asK.c(BM);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.asK.asI;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.asK.apO;
        if (i < 0) {
            this.asK.setCurrentTab(0);
            return;
        }
        b bVar = this.asK;
        i2 = this.asK.apO;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BQ() {
        this.asK.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BR() {
        this.asK.hideProgressBar();
    }
}
