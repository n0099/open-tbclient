package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ e blb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.blb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        HistoryMessage historyMessage;
        com.baidu.tieba.tbadkCore.util.n nVar;
        TextView textView;
        TextView textView2;
        PbHistoryCacheModel pbHistoryCacheModel;
        PbHistoryCacheModel pbHistoryCacheModel2;
        BdUniqueId bdUniqueId;
        PbHistoryCacheModel pbHistoryCacheModel3;
        if ((customResponsedMessage instanceof HistoryMessage) && (historyMessage = (HistoryMessage) customResponsedMessage) != null && historyMessage.Activity != null) {
            com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a();
            aVar.setThreadId(historyMessage.threadId);
            aVar.setForumName(historyMessage.forumName);
            aVar.mU(historyMessage.threadName);
            aVar.mV(historyMessage.postID);
            aVar.hQ(historyMessage.isHostOnly);
            aVar.hR(historyMessage.isSquence);
            aVar.setThreadType(historyMessage.threadType);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
                pbHistoryCacheModel = this.blb.bkV;
                if (pbHistoryCacheModel == null) {
                    this.blb.bkV = new PbHistoryCacheModel(historyMessage.Activity.getPageContext());
                }
                pbHistoryCacheModel2 = this.blb.bkV;
                bdUniqueId = this.blb.aUC;
                pbHistoryCacheModel2.setUniqueId(bdUniqueId);
                pbHistoryCacheModel3 = this.blb.bkV;
                pbHistoryCacheModel3.a((PbHistoryCacheModel) aVar);
            }
            nVar = this.blb.bkW;
            nVar.a(historyMessage.threadId, aVar);
            at.ie(historyMessage.threadId);
            e eVar = this.blb;
            textView = this.blb.aNb;
            eVar.m(textView, r.e.cp_cont_b);
            e eVar2 = this.blb;
            textView2 = this.blb.bkS;
            eVar2.m(textView2, r.e.cp_cont_c);
        }
    }
}
