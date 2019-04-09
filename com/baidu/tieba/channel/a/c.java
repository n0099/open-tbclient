package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d enp;
    private e enq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.enp = new d(context, a.C0276a.enN);
        this.enq = new e(context, a.C0276a.enO);
        this.mAdapters.add(this.enp);
        this.mAdapters.add(this.enq);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.enp.a(bVar);
        this.enq.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.enp.setIsHost(z);
        this.enq.setIsHost(z);
    }
}
