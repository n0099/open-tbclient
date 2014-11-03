package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsMsgImageActivity absMsgImageActivity) {
        this.aNO = absMsgImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z;
        DialogInterface.OnClickListener onClickListener;
        z = this.aNO.aNN;
        if (!z) {
            String[] strArr = {this.aNO.getString(com.baidu.tieba.y.save)};
            AbsMsgImageActivity absMsgImageActivity = this.aNO;
            onClickListener = this.aNO.aNG;
            absMsgImageActivity.createListMenu(strArr, onClickListener);
            this.aNO.showListMenu();
        }
        return false;
    }
}
