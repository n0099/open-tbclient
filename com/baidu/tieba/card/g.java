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
public class g extends CustomMessageListener {
    final /* synthetic */ e aYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.aYx = eVar;
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
            bVar.nA(historyMessage.threadName);
            bVar.nB(historyMessage.postID);
            bVar.hv(historyMessage.isHostOnly);
            bVar.hw(historyMessage.isSquence);
            bVar.setThreadType(historyMessage.threadType);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
                aVar = this.aYx.aYq;
                if (aVar == null) {
                    this.aYx.aYq = new com.baidu.tieba.myCollection.baseHistory.a(historyMessage.Activity.getPageContext());
                }
                aVar2 = this.aYx.aYq;
                bdUniqueId = this.aYx.aYu;
                aVar2.setUniqueId(bdUniqueId);
                aVar3 = this.aYx.aYq;
                aVar3.a((com.baidu.tieba.myCollection.baseHistory.a) bVar);
            }
            oVar = this.aYx.aYr;
            oVar.a(historyMessage.threadId, bVar);
            ap.hG(historyMessage.threadId);
            e eVar = this.aYx;
            textView = this.aYx.aYh;
            eVar.m(textView, t.d.cp_cont_b);
            e eVar2 = this.aYx;
            textView2 = this.aYx.aYn;
            eVar2.m(textView2, t.d.cp_cont_j);
        }
    }
}
