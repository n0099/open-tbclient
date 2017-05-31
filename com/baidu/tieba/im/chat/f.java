package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cOr;
    private final /* synthetic */ c.b cOt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cOr = absMsgImageActivity;
        this.cOt = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cOr.createListMenu(new String[]{this.cOr.getPageContext().getString(w.l.save)}, this.cOt);
        this.cOr.showListMenu();
        return false;
    }
}
