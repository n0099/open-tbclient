package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aRj;
    private final /* synthetic */ DialogInterface.OnClickListener aRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, DialogInterface.OnClickListener onClickListener) {
        this.aRj = absMsgImageActivity;
        this.aRl = onClickListener;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aRj.createListMenu(new String[]{this.aRj.getPageContext().getString(com.baidu.tieba.z.save)}, this.aRl);
        this.aRj.showListMenu();
        return false;
    }
}
