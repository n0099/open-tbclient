package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ e brL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.brL = eVar;
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
            aVar.mA(historyMessage.threadName);
            aVar.mB(historyMessage.postID);
            aVar.hG(historyMessage.isHostOnly);
            aVar.hH(historyMessage.isSquence);
            aVar.setThreadType(historyMessage.threadType);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
                pbHistoryCacheModel = this.brL.brF;
                if (pbHistoryCacheModel == null) {
                    this.brL.brF = new PbHistoryCacheModel(historyMessage.Activity.getPageContext());
                }
                pbHistoryCacheModel2 = this.brL.brF;
                bdUniqueId = this.brL.baI;
                pbHistoryCacheModel2.setUniqueId(bdUniqueId);
                pbHistoryCacheModel3 = this.brL.brF;
                pbHistoryCacheModel3.a((PbHistoryCacheModel) aVar);
            }
            nVar = this.brL.brG;
            nVar.a(historyMessage.threadId, aVar);
            at.hY(historyMessage.threadId);
            e eVar = this.brL;
            textView = this.brL.mTitle;
            eVar.j(textView, w.e.cp_cont_b);
            e eVar2 = this.brL;
            textView2 = this.brL.brC;
            eVar2.j(textView2, w.e.cp_cont_c);
        }
    }
}
