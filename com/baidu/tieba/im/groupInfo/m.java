package com.baidu.tieba.im.groupInfo;

import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* loaded from: classes.dex */
class m implements ae {
    final /* synthetic */ GroupInfoActivity baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(GroupInfoActivity groupInfoActivity) {
        this.baC = groupInfoActivity;
    }

    @Override // com.baidu.tieba.im.groupInfo.ae
    public void a(DialogInterface dialogInterface, int i, Object obj, int i2) {
        t tVar;
        if (i == 0) {
            if (i2 == 0) {
                this.baC.showToast(this.baC.getString(com.baidu.tieba.y.has_set_portrait));
                return;
            }
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.baC);
            this.baC.w(obj);
        } else if (i == 1) {
            if (i2 == 0) {
                this.baC.showToast(this.baC.getString(com.baidu.tieba.y.group_portrait_cant_del));
                return;
            }
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.baC);
            if (obj != null && (obj instanceof PhotoUrlData)) {
                this.baC.a((PhotoUrlData) obj);
            }
        } else if (i == 2) {
            tVar = this.baC.bax;
            tVar.Pc();
        }
    }
}
