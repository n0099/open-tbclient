package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity bci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UpdatesActivity updatesActivity) {
        this.bci = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: m */
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        t tVar;
        p pVar;
        t tVar2;
        t tVar3;
        p pVar2;
        List<UpdatesItemData> n = p.n(linkedList);
        tVar = this.bci.bca;
        tVar.setData(n);
        pVar = this.bci.bch;
        pVar.X(n);
        tVar2 = this.bci.bca;
        tVar2.dg(false);
        tVar3 = this.bci.bca;
        pVar2 = this.bci.bch;
        tVar3.fT(pVar2.Pk());
        this.bci.Dg();
    }
}
