package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.write.by;
/* loaded from: classes.dex */
final class i implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            by.a(this.a);
        } else if (i == 1) {
            by.b(this.a);
        }
    }
}
