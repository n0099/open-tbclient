package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class k implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1606a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GroupInfoActivity groupInfoActivity) {
        this.f1606a = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.y
    public void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        n nVar;
        if (i == 0) {
            if (i2 == 0) {
                this.f1606a.a(this.f1606a.getString(R.string.has_set_portrait));
                return;
            }
            dialogInterface.dismiss();
            this.f1606a.a(obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.f1606a.a(this.f1606a.getString(R.string.group_portrait_cant_del));
                return;
            }
            dialogInterface.dismiss();
            if (obj != null && (obj instanceof PhotoUrlData)) {
                this.f1606a.a((PhotoUrlData) obj);
            }
        } else if (i == 2) {
            nVar = this.f1606a.f;
            nVar.u();
        }
    }
}
