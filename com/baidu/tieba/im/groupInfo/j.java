package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ GroupImageActivity baw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupImageActivity groupImageActivity) {
        this.baw = groupImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        view2 = this.baw.bav;
        view2.setVisibility(8);
    }
}
