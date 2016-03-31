package com.baidu.tieba.card;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ p aSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, int i) {
        super(i);
        this.aSx = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        int fansNum;
        com.baidu.tbadk.core.data.as asVar7;
        com.baidu.tbadk.core.data.as asVar8;
        com.baidu.tbadk.core.data.as asVar9;
        if (this.aSx.aSd && (customResponsedMessage instanceof UpdateAttentionMessage)) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            asVar = this.aSx.aeC;
            if (asVar != null) {
                asVar2 = this.aSx.aeC;
                if (asVar2.getAuthor() != null) {
                    asVar3 = this.aSx.aeC;
                    if (!StringUtils.isNull(asVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        asVar4 = this.aSx.aeC;
                        if (str.equals(asVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().CK) {
                                tbPageContext = this.aSx.ND;
                                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().akM) {
                                asVar8 = this.aSx.aeC;
                                asVar8.getAuthor().getGodUserData().setFollowed(1);
                                asVar9 = this.aSx.aeC;
                                fansNum = asVar9.getAuthor().getFansNum() + 1;
                            } else {
                                asVar5 = this.aSx.aeC;
                                asVar5.getAuthor().getGodUserData().setFollowed(0);
                                asVar6 = this.aSx.aeC;
                                fansNum = asVar6.getAuthor().getFansNum() - 1;
                            }
                            asVar7 = this.aSx.aeC;
                            asVar7.getAuthor().setFansNum(fansNum);
                            this.aSx.fL(fansNum);
                            this.aSx.aD(false);
                        }
                    }
                }
            }
        }
    }
}
