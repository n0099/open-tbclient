package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.write.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1750a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GroupInfoActivity groupInfoActivity) {
        this.f1750a = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bd.a(this.f1750a);
        } else if (i == 1) {
            bd.b(this.f1750a);
        }
    }
}
