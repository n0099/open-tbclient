package com.baidu.tieba.album;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements o {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tieba.album.o
    public void a() {
    }

    @Override // com.baidu.tieba.album.o
    public void a(List<a> list) {
        BdListView bdListView;
        RelativeLayout relativeLayout;
        BdListView bdListView2;
        RelativeLayout relativeLayout2;
        if (list == null || list.size() == 0) {
            bdListView = this.a.c;
            bdListView.setVisibility(8);
            relativeLayout = this.a.f;
            relativeLayout.setVisibility(0);
            return;
        }
        bdListView2 = this.a.c;
        bdListView2.setVisibility(0);
        relativeLayout2 = this.a.f;
        relativeLayout2.setVisibility(8);
        this.a.a(list);
    }
}
