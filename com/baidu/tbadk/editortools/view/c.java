package com.baidu.tbadk.editortools.view;

import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.editortools.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a {
    final /* synthetic */ b auu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.auu = bVar;
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
        this.auu.hideProgressBar();
        commonTabWidgetView = this.auu.aus;
        commonTabWidgetView.reset();
        commonTabWidgetView2 = this.auu.aus;
        arrayList = this.auu.Xn;
        commonTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.auu.Xn;
        int size = arrayList2.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            arrayList3 = this.auu.Xn;
            a.b Ca = ((a) arrayList3.get(i3)).Ca();
            if (Ca != null) {
                z = true;
                this.auu.c(Ca);
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        if (!z2) {
            commonTabWidgetView3 = this.auu.aus;
            commonTabWidgetView3.setVisibility(8);
        }
        i = this.auu.ary;
        if (i < 0) {
            this.auu.setCurrentTab(0);
            return;
        }
        b bVar = this.auu;
        i2 = this.auu.ary;
        bVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void Ce() {
        this.auu.showProgressBar();
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public void Cf() {
        this.auu.hideProgressBar();
    }
}
