package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d enD;
    private e enE;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.enD = new d(context, a.C0276a.eoa);
        this.enE = new e(context, a.C0276a.eob);
        this.mAdapters.add(this.enD);
        this.mAdapters.add(this.enE);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.enD.a(bVar);
        this.enE.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.enD.setIsHost(z);
        this.enE.setIsHost(z);
    }
}
