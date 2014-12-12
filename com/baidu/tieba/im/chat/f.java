package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aQe;
    private final /* synthetic */ DialogInterface.OnClickListener aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, DialogInterface.OnClickListener onClickListener) {
        this.aQe = absMsgImageActivity;
        this.aQg = onClickListener;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aQe.createListMenu(new String[]{this.aQe.getPageContext().getString(com.baidu.tieba.z.save)}, this.aQg);
        this.aQe.showListMenu();
        return false;
    }
}
