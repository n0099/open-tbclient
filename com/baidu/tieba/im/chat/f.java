package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aZm;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.h aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, com.baidu.tbadk.core.dialog.h hVar) {
        this.aZm = absMsgImageActivity;
        this.aZo = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aZm.createListMenu(new String[]{this.aZm.getPageContext().getString(com.baidu.tieba.t.save)}, this.aZo);
        this.aZm.showListMenu();
        return false;
    }
}
