package com.baidu.tieba.card;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ k aOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, int i) {
        super(i);
        this.aOW = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ax axVar;
        com.baidu.tbadk.core.data.ax axVar2;
        com.baidu.tbadk.core.data.ax axVar3;
        com.baidu.tbadk.core.data.ax axVar4;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ax axVar5;
        com.baidu.tbadk.core.data.ax axVar6;
        int fansNum;
        com.baidu.tbadk.core.data.ax axVar7;
        com.baidu.tbadk.core.data.ax axVar8;
        com.baidu.tbadk.core.data.ax axVar9;
        com.baidu.tbadk.core.data.ax axVar10;
        if (this.aOW.aOC && (customResponsedMessage instanceof UpdateAttentionMessage)) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            axVar = this.aOW.aab;
            if (axVar != null) {
                axVar2 = this.aOW.aab;
                if (axVar2.getAuthor() != null) {
                    axVar3 = this.aOW.aab;
                    if (!StringUtils.isNull(axVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        axVar4 = this.aOW.aab;
                        if (str.equals(axVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().sZ) {
                                tbPageContext = this.aOW.DV;
                                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().agz) {
                                axVar9 = this.aOW.aab;
                                axVar9.getAuthor().getGodUserData().setFollowed(1);
                                axVar10 = this.aOW.aab;
                                fansNum = axVar10.getAuthor().getFansNum() + 1;
                            } else {
                                axVar5 = this.aOW.aab;
                                axVar5.getAuthor().getGodUserData().setFollowed(0);
                                axVar6 = this.aOW.aab;
                                fansNum = axVar6.getAuthor().getFansNum() - 1;
                            }
                            axVar7 = this.aOW.aab;
                            axVar7.getAuthor().setFansNum(fansNum);
                            axVar8 = this.aOW.aab;
                            axVar8.getAuthor().getGodUserData().setIsFromNetWork(false);
                            this.aOW.fu(fansNum);
                            this.aOW.aI(false);
                        }
                    }
                }
            }
        }
    }
}
