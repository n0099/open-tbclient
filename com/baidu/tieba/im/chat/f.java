package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bqE;
    private final /* synthetic */ c.b bqG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bqE = absMsgImageActivity;
        this.bqG = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bqE.createListMenu(new String[]{this.bqE.getPageContext().getString(i.h.save)}, this.bqG);
        this.bqE.showListMenu();
        return false;
    }
}
