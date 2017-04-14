package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ p bYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, int i) {
        super(i);
        this.bYq = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        y yVar6;
        y yVar7;
        y yVar8;
        y yVar9;
        y yVar10;
        if (customResponsedMessage != null) {
            yVar = this.bYq.bOd;
            if (yVar != null) {
                yVar2 = this.bYq.bOd;
                if (yVar2.YT() != null) {
                    yVar3 = this.bYq.bOd;
                    if (yVar3.YT().acy() != null) {
                        String str = (String) customResponsedMessage.getData();
                        yVar4 = this.bYq.bOd;
                        this.bYq.f(str, yVar4.YT().acy().aJw().getBannerListData().getAllAdvertList());
                        p pVar = this.bYq;
                        yVar5 = this.bYq.bOd;
                        pVar.g(str, yVar5.Za().getListView().getData());
                        p pVar2 = this.bYq;
                        yVar6 = this.bYq.bOd;
                        pVar2.g(str, yVar6.YW().acG().getDataList());
                        yVar7 = this.bYq.bOd;
                        yVar7.YT().iP(str);
                        yVar8 = this.bYq.bOd;
                        if (yVar8.Za() != null) {
                            yVar9 = this.bYq.bOd;
                            if (yVar9.Za().aae() != null) {
                                yVar10 = this.bYq.bOd;
                                yVar10.Za().aae().notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
    }
}
