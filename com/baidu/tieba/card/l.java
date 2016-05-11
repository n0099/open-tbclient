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
public class l extends CustomMessageListener {
    final /* synthetic */ k aOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, int i) {
        super(i);
        this.aOW = kVar;
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
            bVar.ll(historyMessage.threadName);
            bVar.lm(historyMessage.postID);
            bVar.ge(historyMessage.isHostOnly);
            bVar.gf(historyMessage.isSquence);
            bVar.setThreadType(historyMessage.threadType);
            if (!TbadkCoreApplication.m11getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
                aVar = this.aOW.aOP;
                if (aVar == null) {
                    this.aOW.aOP = new com.baidu.tieba.myCollection.baseHistory.a(historyMessage.Activity.getPageContext());
                }
                aVar2 = this.aOW.aOP;
                bdUniqueId = this.aOW.aOT;
                aVar2.setUniqueId(bdUniqueId);
                aVar3 = this.aOW.aOP;
                aVar3.a((com.baidu.tieba.myCollection.baseHistory.a) bVar);
            }
            oVar = this.aOW.aOQ;
            oVar.a(historyMessage.threadId, bVar);
            au.hb(historyMessage.threadId);
            k kVar = this.aOW;
            textView = this.aOW.aOG;
            kVar.m(textView, t.d.cp_cont_b);
            k kVar2 = this.aOW;
            textView2 = this.aOW.aOM;
            kVar2.m(textView2, t.d.cp_cont_j);
        }
    }
}
