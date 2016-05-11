package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bYM;
    private final /* synthetic */ c.b bYO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bYM = absMsgImageActivity;
        this.bYO = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bYM.createListMenu(new String[]{this.bYM.getPageContext().getString(t.j.save)}, this.bYO);
        this.bYM.showListMenu();
        return false;
    }
}
