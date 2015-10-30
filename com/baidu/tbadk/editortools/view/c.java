package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b asS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.asS = bVar;
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
        this.asS.hideProgressBar();
        commonTabWidgetView = this.asS.asQ;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.asS.asQ;
        arrayList = this.asS.Xh;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.asS.Xh;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.asS.Xh;
            a.b BK = ((a) arrayList3.get(i3)).BK();
            if (BK != null) {
                z = true;
                this.asS.c(BK);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.asS.asQ;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.asS.apZ;
        if (i < 0) {
            this.asS.setCurrentTab(0);
            return;
        }
        b bVar = this.asS;
        i2 = this.asS.apZ;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BO() {
        this.asS.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void BP() {
        this.asS.hideProgressBar();
    }
}
