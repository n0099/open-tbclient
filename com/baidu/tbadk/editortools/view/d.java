package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c asK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.asK = cVar;
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
        this.asK.hideProgressBar();
        commonTabWidgetView = this.asK.asI;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.asK.asI;
        arrayList = this.asK.SE;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.asK.SE;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.asK.SE;
            b.C0041b Cm = ((b) arrayList3.get(i3)).Cm();
            if (Cm != null) {
                z = true;
                this.asK.c(Cm);
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
        i = this.asK.asz;
        if (i < 0) {
            this.asK.setCurrentTab(0);
            return;
        }
        c cVar = this.asK;
        i2 = this.asK.asz;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Cs() {
        this.asK.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void Ct() {
        this.asK.hideProgressBar();
    }
}
