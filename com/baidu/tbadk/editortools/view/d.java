package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.axQ = cVar;
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
        this.axQ.hideProgressBar();
        commonTabWidgetView = this.axQ.axO;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.axQ.axO;
        arrayList = this.axQ.Xb;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.axQ.Xb;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.axQ.Xb;
            b.C0042b DU = ((b) arrayList3.get(i3)).DU();
            if (DU != null) {
                z = true;
                this.axQ.c(DU);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.axQ.axO;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.axQ.axF;
        if (i < 0) {
            this.axQ.setCurrentTab(0);
            return;
        }
        c cVar = this.axQ;
        i2 = this.axQ.axF;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Ea() {
        this.axQ.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Eb() {
        this.axQ.hideProgressBar();
    }
}
