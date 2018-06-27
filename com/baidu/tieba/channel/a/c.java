package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cBA;
    private e cBB;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cBA = new d(context, a.C0141a.cBY);
        this.cBB = new e(context, a.C0141a.cBZ);
        this.mAdapters.add(this.cBA);
        this.mAdapters.add(this.cBB);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cBA.a(bVar);
        this.cBB.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cBA.setIsHost(z);
        this.cBB.setIsHost(z);
    }
}
