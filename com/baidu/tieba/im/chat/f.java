package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bYh;
    private final /* synthetic */ c.b bYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bYh = absMsgImageActivity;
        this.bYj = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bYh.createListMenu(new String[]{this.bYh.getPageContext().getString(t.j.save)}, this.bYj);
        this.bYh.showListMenu();
        return false;
    }
}
