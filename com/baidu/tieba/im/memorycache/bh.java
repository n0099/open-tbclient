package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegister;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo Y;
        if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (Y = b.asc().Y("-1002", -3)) != null) {
            Object data = customResponsedMessage.getData();
            if (data == null) {
                Y.setUnread_count(0);
                Y.setIs_hidden(1);
                this.this$0.m(Y);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                Y.setLast_content(imMessageCenterPojo.getLast_content());
                Y.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                Y.setUnread_count(0);
                Y.setIs_hidden(0);
                this.this$0.m(Y);
            }
        }
    }
}
