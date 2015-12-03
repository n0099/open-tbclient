package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b atG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.atG = bVar;
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
        this.atG.hideProgressBar();
        commonTabWidgetView = this.atG.atE;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.atG.atE;
        arrayList = this.atG.XX;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.atG.XX;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.atG.XX;
            a.b CE = ((a) arrayList3.get(i3)).CE();
            if (CE != null) {
                z = true;
                this.atG.c(CE);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.atG.atE;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.atG.atv;
        if (i < 0) {
            this.atG.setCurrentTab(0);
            return;
        }
        b bVar = this.atG;
        i2 = this.atG.atv;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void CI() {
        this.atG.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void CJ() {
        this.atG.hideProgressBar();
    }
}
