package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity bbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.bbU = updatesActivity;
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
        tVar = this.bbU.bbM;
        tVar.setData(n);
        pVar = this.bbU.bbT;
        pVar.X(n);
        tVar2 = this.bbU.bbM;
        tVar2.dg(false);
        tVar3 = this.bbU.bbM;
        pVar2 = this.bbU.bbT;
        tVar3.fT(pVar2.Ph());
        this.bbU.De();
        ImMessageCenterPojo imMessageCenterPojo = null;
        if (n != null && n.size() > 0) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setLast_content(n.get(0).getContent());
            imMessageCenterPojo2.setLast_content_time(n.get(0).getTime());
            imMessageCenterPojo = imMessageCenterPojo2;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001216, imMessageCenterPojo));
        if (n != null && n.size() == 0) {
            this.bbU.finish();
        }
    }
}
