package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.n;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ AddGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddGroupActivity addGroupActivity) {
        this.a = addGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(n nVar) {
        b bVar;
        bVar = this.a.a;
        bVar.a(false);
        if (nVar == null || nVar.t() != 103007) {
            this.a.a();
        } else if (!(nVar instanceof bv)) {
            this.a.a();
        } else {
            bv bvVar = (bv) nVar;
            if (bvVar.i()) {
                this.a.a(bvVar.k(), bvVar.j());
                return;
            }
            List<BaseGroupData> a = bvVar.a();
            if (a == null || a.size() <= 0) {
                this.a.a();
            } else {
                this.a.a(a.get(0));
            }
        }
    }
}
