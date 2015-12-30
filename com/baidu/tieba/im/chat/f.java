package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bKg;
    private final /* synthetic */ c.b bKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bKg = absMsgImageActivity;
        this.bKi = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bKg.createListMenu(new String[]{this.bKg.getPageContext().getString(n.j.save)}, this.bKi);
        this.bKg.showListMenu();
        return false;
    }
}
