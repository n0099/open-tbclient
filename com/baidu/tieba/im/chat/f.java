package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aZl;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.h aZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, com.baidu.tbadk.core.dialog.h hVar) {
        this.aZl = absMsgImageActivity;
        this.aZn = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aZl.createListMenu(new String[]{this.aZl.getPageContext().getString(com.baidu.tieba.t.save)}, this.aZn);
        this.aZl.showListMenu();
        return false;
    }
}
