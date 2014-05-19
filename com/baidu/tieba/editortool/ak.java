package com.baidu.tieba.editortool;

import java.util.ArrayList;
/* loaded from: classes.dex */
class ak implements al {
    final /* synthetic */ PrivilegeTabHost a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PrivilegeTabHost privilegeTabHost) {
        this.a = privilegeTabHost;
    }

    @Override // com.baidu.tieba.editortool.al
    public void a(ag agVar) {
        PrivilegeTabWidgetView privilegeTabWidgetView;
        PrivilegeTabWidgetView privilegeTabWidgetView2;
        ArrayList<ag> arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        ArrayList arrayList3;
        this.a.d();
        privilegeTabWidgetView = this.a.c;
        privilegeTabWidgetView.a();
        privilegeTabWidgetView2 = this.a.c;
        arrayList = this.a.e;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.a.e;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.a.e;
            this.a.a(((ag) arrayList3.get(i3)).c());
        }
        i = this.a.f;
        if (i < 0) {
            this.a.setCurrentTab(0);
            return;
        }
        PrivilegeTabHost privilegeTabHost = this.a;
        i2 = this.a.f;
        privilegeTabHost.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.editortool.al
    public void a() {
        this.a.c();
    }

    @Override // com.baidu.tieba.editortool.al
    public void b() {
        this.a.d();
    }
}
