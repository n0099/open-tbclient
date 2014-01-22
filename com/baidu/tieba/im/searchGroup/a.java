package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.ck;
import com.baidu.tieba.im.message.q;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ AddGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddGroupActivity addGroupActivity) {
        this.a = addGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        b bVar;
        bVar = this.a.a;
        bVar.a(false);
        if (qVar == null || qVar.w() != 103007) {
            this.a.a();
        } else if (!(qVar instanceof ck)) {
            this.a.a();
        } else {
            ck ckVar = (ck) qVar;
            if (ckVar.k()) {
                this.a.a(ckVar.m(), ckVar.l());
                return;
            }
            List<BaseGroupData> a = ckVar.a();
            if (a == null || a.size() <= 0) {
                this.a.a();
            } else {
                this.a.a(a.get(0));
            }
        }
    }
}
