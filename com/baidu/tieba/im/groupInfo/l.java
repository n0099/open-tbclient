package com.baidu.tieba.im.groupInfo;

import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* loaded from: classes.dex */
class l implements ad {
    final /* synthetic */ GroupInfoActivity ban;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupInfoActivity groupInfoActivity) {
        this.ban = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.ad
    public void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        s sVar;
        if (i == 0) {
            if (i2 == 0) {
                this.ban.showToast(this.ban.getString(com.baidu.tieba.y.has_set_portrait));
                return;
            }
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.ban);
            this.ban.w(obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.ban.showToast(this.ban.getString(com.baidu.tieba.y.group_portrait_cant_del));
                return;
            }
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.ban);
            if (obj != null && (obj instanceof PhotoUrlData)) {
                this.ban.a((PhotoUrlData) obj);
            }
        } else if (i == 2) {
            sVar = this.ban.bai;
            sVar.OZ();
        }
    }
}
