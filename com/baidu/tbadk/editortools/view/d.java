package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c axn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.axn = cVar;
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
        this.axn.hideProgressBar();
        commonTabWidgetView = this.axn.axl;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.axn.axl;
        arrayList = this.axn.Wv;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.axn.Wv;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.axn.Wv;
            b.C0042b DC = ((b) arrayList3.get(i3)).DC();
            if (DC != null) {
                z = true;
                this.axn.c(DC);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.axn.axl;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.axn.axc;
        if (i < 0) {
            this.axn.setCurrentTab(0);
            return;
        }
        c cVar = this.axn;
        i2 = this.axn.axc;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DI() {
        this.axn.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void DJ() {
        this.axn.hideProgressBar();
    }
}
