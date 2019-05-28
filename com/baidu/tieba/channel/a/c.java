package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d eDa;
    private e eDb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eDa = new d(context, a.C0295a.eDx);
        this.eDb = new e(context, a.C0295a.eDy);
        this.mAdapters.add(this.eDa);
        this.mAdapters.add(this.eDb);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eDa.a(bVar);
        this.eDb.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eDa.setIsHost(z);
        this.eDb.setIsHost(z);
    }
}
