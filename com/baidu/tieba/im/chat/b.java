package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aNA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsMsgImageActivity absMsgImageActivity) {
        this.aNA = absMsgImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z;
        DialogInterface.OnClickListener onClickListener;
        z = this.aNA.aNz;
        if (!z) {
            String[] strArr = {this.aNA.getString(com.baidu.tieba.y.save)};
            AbsMsgImageActivity absMsgImageActivity = this.aNA;
            onClickListener = this.aNA.aNs;
            absMsgImageActivity.createListMenu(strArr, onClickListener);
            this.aNA.showListMenu();
        }
        return false;
    }
}
