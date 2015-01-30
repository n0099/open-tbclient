package com.baidu.tieba.discover.view;

import android.view.View;
import com.baidu.tieba.discover.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ DiscoverHeaderView aws;
    private final /* synthetic */ com.baidu.tieba.discover.data.c awt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DiscoverHeaderView discoverHeaderView, com.baidu.tieba.discover.data.c cVar) {
        this.aws = discoverHeaderView;
        this.awt = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.aws.awr;
        if (zVar != null) {
            zVar2 = this.aws.awr;
            zVar2.g(this.awt);
        }
    }
}
