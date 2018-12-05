package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cZZ;
    private e daa;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cZZ = new d(context, a.C0208a.daz);
        this.daa = new e(context, a.C0208a.daA);
        this.mAdapters.add(this.cZZ);
        this.mAdapters.add(this.daa);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cZZ.a(bVar);
        this.daa.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cZZ.setIsHost(z);
        this.daa.setIsHost(z);
    }
}
