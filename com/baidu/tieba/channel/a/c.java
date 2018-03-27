package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d dcd;
    private e dce;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.dcd = new d(context, a.C0138a.dcD);
        this.dce = new e(context, a.C0138a.dcE);
        this.mAdapters.add(this.dcd);
        this.mAdapters.add(this.dce);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcd.a(bVar);
        this.dce.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.dcd.setIsHost(z);
        this.dce.setIsHost(z);
    }
}
