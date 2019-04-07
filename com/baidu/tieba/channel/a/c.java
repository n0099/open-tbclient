package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d eno;
    private e enp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eno = new d(context, a.C0276a.enM);
        this.enp = new e(context, a.C0276a.enN);
        this.mAdapters.add(this.eno);
        this.mAdapters.add(this.enp);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eno.a(bVar);
        this.enp.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eno.setIsHost(z);
        this.enp.setIsHost(z);
    }
}
