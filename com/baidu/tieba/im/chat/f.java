package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bnh;
    private final /* synthetic */ c.b bnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bnh = absMsgImageActivity;
        this.bnj = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bnh.createListMenu(new String[]{this.bnh.getPageContext().getString(i.C0057i.save)}, this.bnj);
        this.bnh.showListMenu();
        return false;
    }
}
