package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p aSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.aSx = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        HistoryMessage historyMessage;
        com.baidu.tieba.tbadkCore.util.o oVar;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.myCollection.baseHistory.a aVar;
        com.baidu.tieba.myCollection.baseHistory.a aVar2;
        BdUniqueId bdUniqueId;
        com.baidu.tieba.myCollection.baseHistory.a aVar3;
        if ((customResponsedMessage instanceof HistoryMessage) && (historyMessage = (HistoryMessage) customResponsedMessage) != null && historyMessage.Activity != null) {
            com.baidu.tieba.myCollection.baseHistory.b bVar = new com.baidu.tieba.myCollection.baseHistory.b();
            bVar.setThreadId(historyMessage.threadId);
            bVar.setForumName(historyMessage.forumName);
            bVar.lh(historyMessage.threadName);
            bVar.li(historyMessage.postID);
            bVar.fE(historyMessage.isHostOnly);
            bVar.fF(historyMessage.isSquence);
            bVar.setThreadType(historyMessage.threadType);
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
                aVar = this.aSx.aSq;
                if (aVar == null) {
                    this.aSx.aSq = new com.baidu.tieba.myCollection.baseHistory.a(historyMessage.Activity.getPageContext());
                }
                aVar2 = this.aSx.aSq;
                bdUniqueId = this.aSx.aSu;
                aVar2.setUniqueId(bdUniqueId);
                aVar3 = this.aSx.aSq;
                aVar3.a((com.baidu.tieba.myCollection.baseHistory.a) bVar);
            }
            oVar = this.aSx.aSr;
            oVar.a(historyMessage.threadId, bVar);
            bc.ha(historyMessage.threadId);
            p pVar = this.aSx;
            textView = this.aSx.aSh;
            pVar.m(textView, t.d.cp_cont_b);
            p pVar2 = this.aSx;
            textView2 = this.aSx.aSn;
            pVar2.m(textView2, t.d.cp_cont_j);
        }
    }
}
