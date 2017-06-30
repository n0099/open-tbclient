package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cWn;
    private final /* synthetic */ c.b cWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cWn = absMsgImageActivity;
        this.cWp = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cWn.createListMenu(new String[]{this.cWn.getPageContext().getString(w.l.save)}, this.cWp);
        this.cWn.showListMenu();
        return false;
    }
}
