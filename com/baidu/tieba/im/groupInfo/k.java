package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* loaded from: classes.dex */
final class k implements ad {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.ad
    public final void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        r rVar;
        if (i == 0) {
            if (i2 == 0) {
                this.a.showToast(this.a.getString(com.baidu.tieba.im.j.has_set_portrait));
                return;
            }
            dialogInterface.dismiss();
            GroupInfoActivity.a(this.a, obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.a.showToast(this.a.getString(com.baidu.tieba.im.j.group_portrait_cant_del));
                return;
            }
            dialogInterface.dismiss();
            if (obj != null && (obj instanceof PhotoUrlData)) {
                GroupInfoActivity.a(this.a, (PhotoUrlData) obj);
            }
        } else if (i == 2) {
            rVar = this.a.f;
            rVar.w();
        }
    }
}
