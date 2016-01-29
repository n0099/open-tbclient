package com.baidu.tieba.card;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ p aPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, int i) {
        super(i);
        this.aPL = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ah ahVar5;
        com.baidu.tbadk.core.data.ah ahVar6;
        int fansNum;
        com.baidu.tbadk.core.data.ah ahVar7;
        com.baidu.tbadk.core.data.ah ahVar8;
        com.baidu.tbadk.core.data.ah ahVar9;
        if (this.aPL.aPn && (customResponsedMessage instanceof UpdateAttentionMessage)) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            ahVar = this.aPL.afg;
            if (ahVar != null) {
                ahVar2 = this.aPL.afg;
                if (ahVar2.getAuthor() != null) {
                    ahVar3 = this.aPL.afg;
                    if (!StringUtils.isNull(ahVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        ahVar4 = this.aPL.afg;
                        if (str.equals(ahVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().CF) {
                                tbPageContext = this.aPL.Nw;
                                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().akv) {
                                ahVar8 = this.aPL.afg;
                                ahVar8.getAuthor().getGodUserData().setFollowed(1);
                                ahVar9 = this.aPL.afg;
                                fansNum = ahVar9.getAuthor().getFansNum() + 1;
                            } else {
                                ahVar5 = this.aPL.afg;
                                ahVar5.getAuthor().getGodUserData().setFollowed(0);
                                ahVar6 = this.aPL.afg;
                                fansNum = ahVar6.getAuthor().getFansNum() - 1;
                            }
                            ahVar7 = this.aPL.afg;
                            ahVar7.getAuthor().setFansNum(fansNum);
                            this.aPL.fy(fansNum);
                            this.aPL.bQ(false);
                        }
                    }
                }
            }
        }
    }
}
