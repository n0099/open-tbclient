package com.baidu.tieba.editortool;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements at {
    final /* synthetic */ ar arL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.arL = arVar;
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
        this.arL.hideProgressBar();
        privilegeTabWidgetView = this.arL.arK;
        privilegeTabWidgetView.reset();
        privilegeTabWidgetView2 = this.arL.arK;
        arrayList = this.arL.aew;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.arL.aew;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.arL.aew;
            this.arL.c(((an) arrayList3.get(i3)).Cp());
        }
        i = this.arL.RK;
        if (i < 0) {
            this.arL.setCurrentTab(0);
            return;
        }
        ar arVar = this.arL;
        i2 = this.arL.RK;
        arVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.editortool.at
    public void Cx() {
        this.arL.showProgressBar();
    }

    @Override // com.baidu.tieba.editortool.at
    public void Cy() {
        this.arL.hideProgressBar();
    }
}
