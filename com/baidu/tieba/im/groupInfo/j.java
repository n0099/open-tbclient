package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.write.bc;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1692a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupInfoActivity groupInfoActivity) {
        this.f1692a = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bc.a(this.f1692a);
        } else if (i == 1) {
            bc.b(this.f1692a);
        }
    }
}
