package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.message.bt;
import com.baidu.tieba.im.message.da;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ CreateGroupActivityActivity a;

    private c(CreateGroupActivityActivity createGroupActivityActivity) {
        this.a = createGroupActivityActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(CreateGroupActivityActivity createGroupActivityActivity, byte b) {
        this(createGroupActivityActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        boolean z;
        this.a.d();
        if (sVar == null) {
            this.a.c(R.string.neterror);
        } else if (sVar.w() == 103120) {
            if (sVar instanceof bt) {
                bt btVar = (bt) sVar;
                if (btVar.m() == 0) {
                    z = this.a.g;
                    if (z) {
                        this.a.c(R.string.group_activity_edit_succ);
                    } else {
                        this.a.c(R.string.group_activity_create_succ);
                    }
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                this.a.a(btVar.n());
            } else if (sVar instanceof da) {
                da daVar = (da) sVar;
                if (daVar.m() != 0) {
                    this.a.a(daVar.n());
                }
            }
        }
    }
}
