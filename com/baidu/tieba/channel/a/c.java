package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d ddF;
    private e ddG;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.ddF = new d(context, a.C0208a.ded);
        this.ddG = new e(context, a.C0208a.dee);
        this.mAdapters.add(this.ddF);
        this.mAdapters.add(this.ddG);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.ddF.a(bVar);
        this.ddG.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.ddF.setIsHost(z);
        this.ddG.setIsHost(z);
    }
}
