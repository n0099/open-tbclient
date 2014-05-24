package com.baidu.tieba.im.live.mylive;

import com.baidu.tieba.im.model.bd;
/* loaded from: classes.dex */
class f implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        bd bdVar;
        MyLiveNoDataView myLiveNoDataView;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        MyLiveNoDataView myLiveNoDataView2;
        MyLiveListAdapter myLiveListAdapter;
        bd bdVar5;
        bd bdVar6;
        bdVar = this.a.c;
        if (!bdVar.a()) {
            myLiveNoDataView2 = this.a.g;
            myLiveNoDataView2.a();
            myLiveListAdapter = this.a.h;
            myLiveListAdapter.b(true);
            bdVar5 = this.a.c;
            bdVar5.a(0);
            bdVar6 = this.a.c;
            bdVar6.c(0);
            this.a.a(false);
            return;
        }
        myLiveNoDataView = this.a.g;
        myLiveNoDataView.a();
        bdVar2 = this.a.c;
        bdVar2.a(0);
        bdVar3 = this.a.c;
        bdVar3.c(0);
        bdVar4 = this.a.c;
        bdVar4.a(false);
        this.a.a(true);
    }
}
