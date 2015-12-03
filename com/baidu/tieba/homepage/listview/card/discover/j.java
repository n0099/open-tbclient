package com.baidu.tieba.homepage.listview.card.discover;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.listview.card.discover.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bzn;
    private final /* synthetic */ h.b bzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, h.b bVar) {
        this.bzn = iVar;
        this.bzo = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        tbPageContext = this.bzn.pageContext;
        c.a(tbPageContext, this.bzo);
        this.bzn.b(this.bzo);
    }
}
