package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d ctT;
    private e ctU;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.ctT = new d(context, a.C0123a.cut);
        this.ctU = new e(context, a.C0123a.cuu);
        this.mAdapters.add(this.ctT);
        this.mAdapters.add(this.ctU);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.ctT.a(bVar);
        this.ctU.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.ctT.setIsHost(z);
        this.ctU.setIsHost(z);
    }
}
