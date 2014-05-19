package com.baidu.tieba.im.live.mylive;

import com.baidu.tieba.im.model.bc;
/* loaded from: classes.dex */
class f implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        bc bcVar;
        MyLiveNoDataView myLiveNoDataView;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        MyLiveNoDataView myLiveNoDataView2;
        MyLiveListAdapter myLiveListAdapter;
        bc bcVar5;
        bc bcVar6;
        bcVar = this.a.c;
        if (!bcVar.a()) {
            myLiveNoDataView2 = this.a.g;
            myLiveNoDataView2.a();
            myLiveListAdapter = this.a.h;
            myLiveListAdapter.b(true);
            bcVar5 = this.a.c;
            bcVar5.a(0);
            bcVar6 = this.a.c;
            bcVar6.c(0);
            this.a.a(false);
            return;
        }
        myLiveNoDataView = this.a.g;
        myLiveNoDataView.a();
        bcVar2 = this.a.c;
        bcVar2.a(0);
        bcVar3 = this.a.c;
        bcVar3.c(0);
        bcVar4 = this.a.c;
        bcVar4.a(false);
        this.a.a(true);
    }
}
