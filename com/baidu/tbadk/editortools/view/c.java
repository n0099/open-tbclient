package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b avk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.avk = bVar;
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
        this.avk.hideProgressBar();
        commonTabWidgetView = this.avk.avi;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.avk.avi;
        arrayList = this.avk.YA;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.avk.YA;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.avk.YA;
            a.b Ct = ((a) arrayList3.get(i3)).Ct();
            if (Ct != null) {
                z = true;
                this.avk.c(Ct);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.avk.avi;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.avk.auZ;
        if (i < 0) {
            this.avk.setCurrentTab(0);
            return;
        }
        b bVar = this.avk;
        i2 = this.avk.auZ;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void Cx() {
        this.avk.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void Cy() {
        this.avk.hideProgressBar();
    }
}
