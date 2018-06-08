package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cDG;
    private e cDH;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cDG = new d(context, a.C0140a.cEf);
        this.cDH = new e(context, a.C0140a.cEg);
        this.mAdapters.add(this.cDG);
        this.mAdapters.add(this.cDH);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cDG.a(bVar);
        this.cDH.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cDG.setIsHost(z);
        this.cDH.setIsHost(z);
    }
}
