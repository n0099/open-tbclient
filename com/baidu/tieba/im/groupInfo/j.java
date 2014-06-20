package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bd.a(this.a);
        } else if (i == 1) {
            bd.b(this.a);
        }
    }
}
