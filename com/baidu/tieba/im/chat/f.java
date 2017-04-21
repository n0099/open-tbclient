package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cOQ;
    private final /* synthetic */ c.b cOS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cOQ = absMsgImageActivity;
        this.cOS = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cOQ.createListMenu(new String[]{this.cOQ.getPageContext().getString(w.l.save)}, this.cOS);
        this.cOQ.showListMenu();
        return false;
    }
}
