package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.write.bz;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bz.a(this.a);
        } else if (i == 1) {
            bz.b(this.a);
        }
    }
}
