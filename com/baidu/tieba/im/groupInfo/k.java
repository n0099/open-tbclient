package com.baidu.tieba.im.groupInfo;

import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* loaded from: classes.dex */
class k implements ac {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.ac
    public void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        r rVar;
        if (i == 0) {
            if (i2 == 0) {
                this.a.showToast(this.a.getString(com.baidu.tieba.x.has_set_portrait));
                return;
            }
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
            this.a.a(obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.a.showToast(this.a.getString(com.baidu.tieba.x.group_portrait_cant_del));
                return;
            }
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
            if (obj != null && (obj instanceof PhotoUrlData)) {
                this.a.a((PhotoUrlData) obj);
            }
        } else if (i == 2) {
            rVar = this.a.b;
            rVar.u();
        }
    }
}
