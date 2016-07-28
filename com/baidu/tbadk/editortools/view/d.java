package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.editortools.view.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.a {
    final /* synthetic */ c aup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aup = cVar;
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
        this.aup.hideProgressBar();
        commonTabWidgetView = this.aup.aun;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.aup.aun;
        arrayList = this.aup.TD;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.aup.TD;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.aup.TD;
            b.C0042b Cu = ((b) arrayList3.get(i3)).Cu();
            if (Cu != null) {
                z = true;
                this.aup.c(Cu);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.aup.aun;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.aup.aue;
        if (i < 0) {
            this.aup.setCurrentTab(0);
            return;
        }
        c cVar = this.aup;
        i2 = this.aup.aue;
        cVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void CA() {
        this.aup.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.c.a
    public void CB() {
        this.aup.hideProgressBar();
    }
}
