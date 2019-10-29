package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private d eSr;
    private e eSs;

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eSr = new d(context, a.C0396a.eSO);
        this.eSs = new e(context, a.C0396a.eSP);
        this.agQ.add(this.eSr);
        this.agQ.add(this.eSs);
        bdTypeListView.addAdapters(this.agQ);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eSr.a(bVar);
        this.eSs.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eSr.setIsHost(z);
        this.eSs.setIsHost(z);
    }
}
