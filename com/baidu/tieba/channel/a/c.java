package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d dcS;
    private e dcT;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.dcS = new d(context, a.C0208a.ddq);
        this.dcT = new e(context, a.C0208a.ddr);
        this.mAdapters.add(this.dcS);
        this.mAdapters.add(this.dcT);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcS.a(bVar);
        this.dcT.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.dcS.setIsHost(z);
        this.dcT.setIsHost(z);
    }
}
