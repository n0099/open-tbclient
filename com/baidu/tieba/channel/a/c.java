package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d eJM;
    private e eJN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eJM = new d(context, a.C0307a.eKj);
        this.eJN = new e(context, a.C0307a.eKk);
        this.mAdapters.add(this.eJM);
        this.mAdapters.add(this.eJN);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eJM.a(bVar);
        this.eJN.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eJM.setIsHost(z);
        this.eJN.setIsHost(z);
    }
}
