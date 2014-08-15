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
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        t tVar;
        p pVar;
        t tVar2;
        t tVar3;
        p pVar2;
        List<UpdatesItemData> a = p.a(linkedList);
        tVar = this.a.b;
        tVar.a(a);
        pVar = this.a.i;
        pVar.a(a);
        tVar2 = this.a.b;
        tVar2.a(false);
        tVar3 = this.a.b;
        pVar2 = this.a.i;
        tVar3.a(pVar2.d());
        this.a.e();
        ImMessageCenterPojo imMessageCenterPojo = null;
        if (a != null && a.size() > 0) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setLast_content(a.get(0).getContent());
            imMessageCenterPojo2.setLast_content_time(a.get(0).getTime());
            imMessageCenterPojo = imMessageCenterPojo2;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001216, imMessageCenterPojo));
        if (a != null && a.size() == 0) {
            this.a.finish();
        }
    }
}
