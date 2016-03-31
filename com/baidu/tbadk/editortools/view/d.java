package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c awJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.awJ = cVar;
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
        this.awJ.hideProgressBar();
        commonTabWidgetView = this.awJ.awH;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.awJ.awH;
        arrayList = this.awJ.Xq;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.awJ.Xq;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.awJ.Xq;
            b.C0050b Et = ((b) arrayList3.get(i3)).Et();
            if (Et != null) {
                z = true;
                this.awJ.c(Et);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.awJ.awH;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.awJ.awy;
        if (i < 0) {
            this.awJ.setCurrentTab(0);
            return;
        }
        c cVar = this.awJ;
        i2 = this.awJ.awy;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Ez() {
        this.awJ.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void EA() {
        this.awJ.hideProgressBar();
    }
}
