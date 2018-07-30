package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cEf;
    private e cEg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cEf = new d(context, a.C0139a.cED);
        this.cEg = new e(context, a.C0139a.cEE);
        this.mAdapters.add(this.cEf);
        this.mAdapters.add(this.cEg);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cEf.a(bVar);
        this.cEg.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cEf.setIsHost(z);
        this.cEg.setIsHost(z);
    }
}
