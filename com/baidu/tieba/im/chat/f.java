package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bnF;
    private final /* synthetic */ c.b bnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bnF = absMsgImageActivity;
        this.bnH = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bnF.createListMenu(new String[]{this.bnF.getPageContext().getString(i.h.save)}, this.bnH);
        this.bnF.showListMenu();
        return false;
    }
}
