package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ l cmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(l lVar, int i) {
        super(i);
        this.cmT = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (!StringUtils.isNull(str) && this.cmT.cbE.aek() != null) {
                com.baidu.tieba.tbadkCore.n aek = this.cmT.cbE.aek();
                aek.X(aek.rd(str));
                this.cmT.ccj.a(aek.getThreadList(), aek);
                if (com.baidu.tieba.tbadkCore.c.bkt() != null) {
                    com.baidu.tieba.tbadkCore.c.bkt().X(this.cmT.cbE.getForumName(), false);
                }
            }
        }
    }
}
