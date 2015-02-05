package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aRi;
    private final /* synthetic */ DialogInterface.OnClickListener aRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, DialogInterface.OnClickListener onClickListener) {
        this.aRi = absMsgImageActivity;
        this.aRk = onClickListener;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aRi.createListMenu(new String[]{this.aRi.getPageContext().getString(com.baidu.tieba.z.save)}, this.aRk);
        this.aRi.showListMenu();
        return false;
    }
}
