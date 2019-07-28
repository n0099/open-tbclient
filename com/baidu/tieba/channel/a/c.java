package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private d eHW;
    private e eHX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eHW = new d(context, a.C0298a.eIt);
        this.eHX = new e(context, a.C0298a.eIu);
        this.mAdapters.add(this.eHW);
        this.mAdapters.add(this.eHX);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eHW.a(bVar);
        this.eHX.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eHW.setIsHost(z);
        this.eHX.setIsHost(z);
    }
}
