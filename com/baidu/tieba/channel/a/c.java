package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private d ddG;
    private e ddH;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.ddG = new d(context, a.C0208a.dee);
        this.ddH = new e(context, a.C0208a.def);
        this.mAdapters.add(this.ddG);
        this.mAdapters.add(this.ddH);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.ddG.a(bVar);
        this.ddH.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.ddG.setIsHost(z);
        this.ddH.setIsHost(z);
    }
}
