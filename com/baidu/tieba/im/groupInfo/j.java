package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class j implements y {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.y
    public void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        m mVar;
        if (i == 0) {
            if (i2 == 0) {
                this.a.showToast(this.a.getString(R.string.has_set_portrait));
                return;
            }
            dialogInterface.dismiss();
            this.a.a(obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.a.showToast(this.a.getString(R.string.group_portrait_cant_del));
                return;
            }
            dialogInterface.dismiss();
            if (obj != null && (obj instanceof PhotoUrlData)) {
                this.a.a((PhotoUrlData) obj);
            }
        } else if (i == 2) {
            mVar = this.a.f;
            mVar.w();
        }
    }
}
