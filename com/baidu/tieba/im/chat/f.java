package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    private final /* synthetic */ c.b bGB;
    final /* synthetic */ AbsMsgImageActivity bGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bGz = absMsgImageActivity;
        this.bGB = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bGz.createListMenu(new String[]{this.bGz.getPageContext().getString(n.i.save)}, this.bGB);
        this.bGz.showListMenu();
        return false;
    }
}
