package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d dcm;
    private e dcn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.dcm = new d(context, a.C0137a.dcM);
        this.dcn = new e(context, a.C0137a.dcN);
        this.mAdapters.add(this.dcm);
        this.mAdapters.add(this.dcn);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcm.a(bVar);
        this.dcn.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.dcm.setIsHost(z);
        this.dcn.setIsHost(z);
    }
}
