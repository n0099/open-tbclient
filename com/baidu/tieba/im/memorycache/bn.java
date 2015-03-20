package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo D;
        if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (D = c.Sd().D("-1004", -5)) != null) {
            Object data = customResponsedMessage.getData();
            if (data == null) {
                D.setUnread_count(0);
                D.setIs_hidden(1);
                this.this$0.k(D);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                D.setLast_content(imMessageCenterPojo.getLast_content());
                D.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                D.setUnread_count(0);
                D.setIs_hidden(0);
                this.this$0.k(D);
            }
        }
    }
}
