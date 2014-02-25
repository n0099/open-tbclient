package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.im.message.s;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ AddGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddGroupActivity addGroupActivity) {
        this.a = addGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        b bVar;
        bVar = this.a.a;
        bVar.a(false);
        if (sVar != null && sVar.w() == 103007) {
            if (sVar instanceof ct) {
                ct ctVar = (ct) sVar;
                if (!ctVar.l()) {
                    List<BaseGroupData> a = ctVar.a();
                    if (a == null || a.size() <= 0) {
                        this.a.a();
                        return;
                    } else {
                        this.a.a(a.get(0));
                        return;
                    }
                }
                this.a.a(ctVar.n(), ctVar.m());
                return;
            }
            this.a.a();
            return;
        }
        this.a.a();
    }
}
