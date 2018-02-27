package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d dca;
    private e dcb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.dca = new d(context, a.C0138a.dcA);
        this.dcb = new e(context, a.C0138a.dcB);
        this.mAdapters.add(this.dca);
        this.mAdapters.add(this.dcb);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dca.a(bVar);
        this.dcb.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.dca.setIsHost(z);
        this.dcb.setIsHost(z);
    }
}
