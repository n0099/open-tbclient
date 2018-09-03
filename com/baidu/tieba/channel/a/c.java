package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cEc;
    private e cEd;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cEc = new d(context, a.C0139a.cEA);
        this.cEd = new e(context, a.C0139a.cEB);
        this.mAdapters.add(this.cEc);
        this.mAdapters.add(this.cEd);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cEc.a(bVar);
        this.cEd.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cEc.setIsHost(z);
        this.cEd.setIsHost(z);
    }
}
