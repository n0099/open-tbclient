package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class p implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int a = com.baidu.adp.lib.f.b.a(customMessage.getData(), 0);
        if (!com.baidu.tieba.im.db.n.d().e(String.valueOf(a))) {
            return null;
        }
        ImMessageCenterPojo a2 = com.baidu.tieba.im.b.j.a().a(String.valueOf(a));
        if (a2 != null) {
            a2.setLast_content(" ");
        }
        return new CustomResponsedMessage<>(MessageTypes.CMD_DEL_OFFICIAL_DB, String.valueOf(a));
    }
}
