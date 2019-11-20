package com.baidu.tieba.channel.a;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.channel.config.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private d eRA;
    private e eRB;

    public c(Context context, BdTypeListView bdTypeListView) {
        a(context, bdTypeListView);
    }

    private void a(Context context, BdTypeListView bdTypeListView) {
        this.eRA = new d(context, a.C0396a.eRX);
        this.eRB = new e(context, a.C0396a.eRY);
        this.agy.add(this.eRA);
        this.agy.add(this.eRB);
        bdTypeListView.addAdapters(this.agy);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eRA.a(bVar);
        this.eRB.a(bVar);
    }

    public void setIsHost(boolean z) {
        this.eRA.setIsHost(z);
        this.eRB.setIsHost(z);
    }
}
