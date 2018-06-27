package com.baidu.tieba.frs.live;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class b implements CustomMessageTask.CustomRunnable<bc>, ab {
    private com.baidu.tieba.frs.e.a dAq;
    private int drk = 3;

    public b(com.baidu.tieba.frs.e.a aVar) {
        this.dAq = null;
        this.dAq = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bc> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bc)) {
            bc data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.e.b.azw().a(this.dAq, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.e.b.azw().a(this.dAq, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.e.b.azw().a(this.dAq, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.e.b.azw().a(this.dAq, data);
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }
}
