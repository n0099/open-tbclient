package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cTs;
    private e cTt;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cTs = new d(context, a.C0198a.cTQ);
        this.cTt = new e(context, a.C0198a.cTR);
        this.mAdapters.add(this.cTs);
        this.mAdapters.add(this.cTt);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cTs.a(bVar);
        this.cTt.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cTs.setIsHost(z);
        this.cTt.setIsHost(z);
    }
}
