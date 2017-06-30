package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ e cIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.cIE = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e.a aVar;
        e.a aVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
            PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
            long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (c != 0 && c2 != 0) {
                com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
                aVar = this.cIE.cIC;
                fR.removeCallbacks(aVar);
                this.cIE.cIC = new e.a(c2, c);
                com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
                aVar2 = this.cIE.cIC;
                fR2.postDelayed(aVar2, 500L);
            }
        }
    }
}
