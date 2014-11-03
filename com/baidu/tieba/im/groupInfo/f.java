package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ GroupImageActivity baw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GroupImageActivity groupImageActivity) {
        this.baw = groupImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.baw.getString(com.baidu.tieba.y.save)};
        GroupImageActivity groupImageActivity = this.baw;
        onClickListener = this.baw.aNG;
        groupImageActivity.createListMenu(strArr, onClickListener);
        this.baw.showListMenu();
        return false;
    }
}
