package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.awc = bVar;
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
        this.awc.hideProgressBar();
        commonTabWidgetView = this.awc.awa;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.awc.awa;
        arrayList = this.awc.YX;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.awc.YX;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.awc.YX;
            a.b DJ = ((a) arrayList3.get(i3)).DJ();
            if (DJ != null) {
                z = true;
                this.awc.c(DJ);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.awc.awa;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.awc.avR;
        if (i < 0) {
            this.awc.setCurrentTab(0);
            return;
        }
        b bVar = this.awc;
        i2 = this.awc.avR;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void DN() {
        this.awc.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void DO() {
        this.awc.hideProgressBar();
    }
}
