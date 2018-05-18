package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cvd;
    private e cve;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cvd = new d(context, a.C0123a.cvC);
        this.cve = new e(context, a.C0123a.cvD);
        this.mAdapters.add(this.cvd);
        this.mAdapters.add(this.cve);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cvd.a(bVar);
        this.cve.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cvd.setIsHost(z);
        this.cve.setIsHost(z);
    }
}
