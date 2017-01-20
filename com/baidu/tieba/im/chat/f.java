package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cLO;
    private final /* synthetic */ c.b cLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cLO = absMsgImageActivity;
        this.cLQ = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cLO.createListMenu(new String[]{this.cLO.getPageContext().getString(r.l.save)}, this.cLQ);
        this.cLO.showListMenu();
        return false;
    }
}
