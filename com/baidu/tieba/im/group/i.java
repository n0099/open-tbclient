package com.baidu.tieba.im.group;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ g aYw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.aYw = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        DiscoverMoreActivity discoverMoreActivity;
        discoverMoreActivity = this.aYw.aYt;
        discoverMoreActivity.NT().update();
    }
}
