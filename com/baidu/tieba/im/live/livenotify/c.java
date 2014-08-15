package com.baidu.tieba.im.live.livenotify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ LiveNotifyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LiveNotifyActivity liveNotifyActivity) {
        this.a = liveNotifyActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        s sVar;
        s sVar2;
        List<UpdatesItemData> a = o.a(linkedList);
        sVar = this.a.b;
        sVar.a(o.a(linkedList));
        sVar2 = this.a.b;
        sVar2.a(false);
        ImMessageCenterPojo imMessageCenterPojo = null;
        if (a != null && a.size() > 0) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setLast_content(a.get(0).getContent());
            imMessageCenterPojo2.setLast_content_time(a.get(0).getTime());
            imMessageCenterPojo = imMessageCenterPojo2;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001218, imMessageCenterPojo));
        if (a != null && a.size() == 0) {
            this.a.finish();
        }
    }
}
