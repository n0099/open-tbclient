package com.baidu.tieba.discover.view;

import android.view.View;
import com.baidu.tieba.discover.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ DiscoverHeaderView awp;
    private final /* synthetic */ com.baidu.tieba.discover.data.c awq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DiscoverHeaderView discoverHeaderView, com.baidu.tieba.discover.data.c cVar) {
        this.awp = discoverHeaderView;
        this.awq = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.awp.awo;
        if (zVar != null) {
            zVar2 = this.awp.awo;
            zVar2.g(this.awq);
        }
    }
}
