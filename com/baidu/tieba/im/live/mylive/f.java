package com.baidu.tieba.im.live.mylive;

import com.baidu.tieba.im.model.am;
/* loaded from: classes.dex */
class f implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        am amVar6;
        MyLiveListAdapter myLiveListAdapter;
        am amVar7;
        am amVar8;
        amVar = this.a.c;
        if (amVar.b()) {
            amVar2 = this.a.c;
            amVar2.a(0);
            amVar3 = this.a.c;
            amVar3.c(0);
            amVar4 = this.a.c;
            amVar4.b(false);
            this.a.a(true);
        } else {
            myLiveListAdapter = this.a.h;
            myLiveListAdapter.b(true);
            amVar7 = this.a.c;
            amVar7.a(0);
            amVar8 = this.a.c;
            amVar8.c(0);
            this.a.a(false);
        }
        amVar5 = this.a.c;
        if (amVar5.a()) {
            amVar6 = this.a.c;
            amVar6.a(false);
        }
    }
}
