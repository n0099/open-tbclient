package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ k aTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, int i) {
        super(i);
        this.aTp = kVar;
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
            bVar.mR(historyMessage.threadName);
            bVar.mS(historyMessage.postID);
            bVar.gZ(historyMessage.isHostOnly);
            bVar.ha(historyMessage.isSquence);
            bVar.setThreadType(historyMessage.threadType);
            if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
                aVar = this.aTp.aTi;
                if (aVar == null) {
                    this.aTp.aTi = new com.baidu.tieba.myCollection.baseHistory.a(historyMessage.Activity.getPageContext());
                }
                aVar2 = this.aTp.aTi;
                bdUniqueId = this.aTp.aTm;
                aVar2.setUniqueId(bdUniqueId);
                aVar3 = this.aTp.aTi;
                aVar3.a((com.baidu.tieba.myCollection.baseHistory.a) bVar);
            }
            oVar = this.aTp.aTj;
            oVar.a(historyMessage.threadId, bVar);
            at.hb(historyMessage.threadId);
            k kVar = this.aTp;
            textView = this.aTp.aSZ;
            kVar.m(textView, u.d.cp_cont_b);
            k kVar2 = this.aTp;
            textView2 = this.aTp.aTf;
            kVar2.m(textView2, u.d.cp_cont_j);
        }
    }
}
