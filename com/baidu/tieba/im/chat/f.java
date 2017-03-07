package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cOc;
    private final /* synthetic */ c.b cOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cOc = absMsgImageActivity;
        this.cOe = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cOc.createListMenu(new String[]{this.cOc.getPageContext().getString(w.l.save)}, this.cOe);
        this.cOc.showListMenu();
        return false;
    }
}
