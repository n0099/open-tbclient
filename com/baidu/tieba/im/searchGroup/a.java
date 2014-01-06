package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.o;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ AddGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddGroupActivity addGroupActivity) {
        this.a = addGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(o oVar) {
        b bVar;
        bVar = this.a.a;
        bVar.a(false);
        if (oVar == null || oVar.u() != 103007) {
            this.a.a();
        } else if (!(oVar instanceof by)) {
            this.a.a();
        } else {
            by byVar = (by) oVar;
            if (byVar.i()) {
                this.a.a(byVar.k(), byVar.j());
                return;
            }
            List<BaseGroupData> a = byVar.a();
            if (a == null || a.size() <= 0) {
                this.a.a();
            } else {
                this.a.a(a.get(0));
            }
        }
    }
}
