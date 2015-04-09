package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aWF;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.h aWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, com.baidu.tbadk.core.dialog.h hVar) {
        this.aWF = absMsgImageActivity;
        this.aWH = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aWF.createListMenu(new String[]{this.aWF.getPageContext().getString(com.baidu.tieba.y.save)}, this.aWH);
        this.aWF.showListMenu();
        return false;
    }
}
