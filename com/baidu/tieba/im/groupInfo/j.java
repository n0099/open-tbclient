package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class j implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1750a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupInfoActivity groupInfoActivity) {
        this.f1750a = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.x
    public void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        m mVar;
        if (i == 0) {
            if (i2 == 0) {
                this.f1750a.showToast(this.f1750a.getString(R.string.has_set_portrait));
                return;
            }
            dialogInterface.dismiss();
            this.f1750a.a(obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.f1750a.showToast(this.f1750a.getString(R.string.group_portrait_cant_del));
                return;
            }
            dialogInterface.dismiss();
            if (obj != null && (obj instanceof PhotoUrlData)) {
                this.f1750a.a((PhotoUrlData) obj);
            }
        } else if (i == 2) {
            mVar = this.f1750a.f;
            mVar.u();
        }
    }
}
