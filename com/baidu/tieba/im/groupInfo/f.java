package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ GroupImageActivity bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GroupImageActivity groupImageActivity) {
        this.bah = groupImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.bah.getString(com.baidu.tieba.y.save)};
        GroupImageActivity groupImageActivity = this.bah;
        onClickListener = this.bah.aNs;
        groupImageActivity.createListMenu(strArr, onClickListener);
        this.bah.showListMenu();
        return false;
    }
}
