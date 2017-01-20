package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c awr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.awr = cVar;
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
        this.awr.hideProgressBar();
        commonTabWidgetView = this.awr.awp;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.awr.awp;
        arrayList = this.awr.VL;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.awr.VL;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.awr.VL;
            b.C0042b Dx = ((b) arrayList3.get(i3)).Dx();
            if (Dx != null) {
                z = true;
                this.awr.c(Dx);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.awr.awp;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.awr.awg;
        if (i < 0) {
            this.awr.setCurrentTab(0);
            return;
        }
        c cVar = this.awr;
        i2 = this.awr.awg;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DD() {
        this.awr.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DE() {
        this.awr.hideProgressBar();
    }
}
