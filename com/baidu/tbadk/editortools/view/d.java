package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c axw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.axw = cVar;
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
        this.axw.hideProgressBar();
        commonTabWidgetView = this.axw.axu;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.axw.axu;
        arrayList = this.axw.Wt;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.axw.Wt;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.axw.Wt;
            b.C0042b DP = ((b) arrayList3.get(i3)).DP();
            if (DP != null) {
                z = true;
                this.axw.c(DP);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.axw.axu;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.axw.axl;
        if (i < 0) {
            this.axw.setCurrentTab(0);
            return;
        }
        c cVar = this.axw;
        i2 = this.axw.axl;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DV() {
        this.axw.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DW() {
        this.axw.hideProgressBar();
    }
}
