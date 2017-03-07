package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aBM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aBM = cVar;
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
        this.aBM.hideProgressBar();
        commonTabWidgetView = this.aBM.aBK;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aBM.aBK;
        arrayList = this.aBM.aaY;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aBM.aaY;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aBM.aaY;
            b.C0041b DQ = ((b) arrayList3.get(i3)).DQ();
            if (DQ != null) {
                z = true;
                this.aBM.c(DQ);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aBM.aBK;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aBM.aBB;
        if (i < 0) {
            this.aBM.setCurrentTab(0);
            return;
        }
        c cVar = this.aBM;
        i2 = this.aBM.aBB;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DW() {
        this.aBM.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DX() {
        this.aBM.hideProgressBar();
    }
}
