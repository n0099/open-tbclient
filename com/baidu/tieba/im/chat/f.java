package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bqP;
    private final /* synthetic */ c.b bqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bqP = absMsgImageActivity;
        this.bqR = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bqP.createListMenu(new String[]{this.bqP.getPageContext().getString(i.h.save)}, this.bqR);
        this.bqP.showListMenu();
        return false;
    }
}
