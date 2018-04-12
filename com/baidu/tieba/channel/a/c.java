package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d ctW;
    private e ctX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.ctW = new d(context, a.C0123a.cuw);
        this.ctX = new e(context, a.C0123a.cux);
        this.mAdapters.add(this.ctW);
        this.mAdapters.add(this.ctX);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.ctW.a(bVar);
        this.ctX.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.ctW.setIsHost(z);
        this.ctX.setIsHost(z);
    }
}
