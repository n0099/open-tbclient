package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d eCZ;
    private e eDa;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eCZ = new d(context, a.C0295a.eDw);
        this.eDa = new e(context, a.C0295a.eDx);
        this.mAdapters.add(this.eCZ);
        this.mAdapters.add(this.eDa);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eCZ.a(bVar);
        this.eDa.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eCZ.setIsHost(z);
        this.eDa.setIsHost(z);
    }
}
