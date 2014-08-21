package com.baidu.tieba.editortool;

import java.util.ArrayList;
/* loaded from: classes.dex */
class am implements an {
    final /* synthetic */ PrivilegeTabHost a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PrivilegeTabHost privilegeTabHost) {
        this.a = privilegeTabHost;
    }

    @Override // com.baidu.tieba.editortool.an
    public void a(ai aiVar) {
        PrivilegeTabWidgetView privilegeTabWidgetView;
        PrivilegeTabWidgetView privilegeTabWidgetView2;
        ArrayList<ai> arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        ArrayList arrayList3;
        this.a.d();
        privilegeTabWidgetView = this.a.b;
        privilegeTabWidgetView.a();
        privilegeTabWidgetView2 = this.a.b;
        arrayList = this.a.d;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.a.d;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.a.d;
            this.a.a(((ai) arrayList3.get(i3)).c());
        }
        i = this.a.e;
        if (i < 0) {
            this.a.setCurrentTab(0);
            return;
        }
        PrivilegeTabHost privilegeTabHost = this.a;
        i2 = this.a.e;
        privilegeTabHost.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.editortool.an
    public void a() {
        this.a.c();
    }

    @Override // com.baidu.tieba.editortool.an
    public void b() {
        this.a.d();
    }
}
