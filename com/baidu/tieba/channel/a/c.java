package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d cSm;
    private e cSn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.cSm = new d(context, a.C0173a.cSK);
        this.cSn = new e(context, a.C0173a.cSL);
        this.mAdapters.add(this.cSm);
        this.mAdapters.add(this.cSn);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cSm.a(bVar);
        this.cSn.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.cSm.setIsHost(z);
        this.cSn.setIsHost(z);
    }
}
