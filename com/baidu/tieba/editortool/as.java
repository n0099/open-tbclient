package com.baidu.tieba.editortool;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements at {
    final /* synthetic */ ar arU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.arU = arVar;
    }

    @Override // com.baidu.tieba.editortool.at
    public void b(an anVar) {
        PrivilegeTabWidgetView privilegeTabWidgetView;
        PrivilegeTabWidgetView privilegeTabWidgetView2;
        ArrayList<an> arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        ArrayList arrayList3;
        this.arU.hideProgressBar();
        privilegeTabWidgetView = this.arU.arT;
        privilegeTabWidgetView.reset();
        privilegeTabWidgetView2 = this.arU.arT;
        arrayList = this.arU.aeE;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.arU.aeE;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.arU.aeE;
            this.arU.c(((an) arrayList3.get(i3)).Cr());
        }
        i = this.arU.RO;
        if (i < 0) {
            this.arU.setCurrentTab(0);
            return;
        }
        ar arVar = this.arU;
        i2 = this.arU.RO;
        arVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.editortool.at
    public void Cz() {
        this.arU.showProgressBar();
    }

    @Override // com.baidu.tieba.editortool.at
    public void CA() {
        this.arU.hideProgressBar();
    }
}
