package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aWp;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.h aWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, com.baidu.tbadk.core.dialog.h hVar) {
        this.aWp = absMsgImageActivity;
        this.aWr = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aWp.createListMenu(new String[]{this.aWp.getPageContext().getString(com.baidu.tieba.y.save)}, this.aWr);
        this.aWp.showListMenu();
        return false;
    }
}
