package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ p bYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, int i) {
        super(i);
        this.bYz = pVar;
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
            yVar = this.bYz.bPu;
            if (yVar != null) {
                yVar2 = this.bYz.bPu;
                if (yVar2.YU() != null) {
                    yVar3 = this.bYz.bPu;
                    if (yVar3.YU().abG() != null) {
                        String str = (String) customResponsedMessage.getData();
                        yVar4 = this.bYz.bPu;
                        this.bYz.f(str, yVar4.YU().abG().aHE().getBannerListData().getAllAdvertList());
                        p pVar = this.bYz;
                        yVar5 = this.bYz.bPu;
                        pVar.g(str, yVar5.YZ().getListView().getData());
                        p pVar2 = this.bYz;
                        yVar6 = this.bYz.bPu;
                        pVar2.g(str, yVar6.YV().abL().getDataList());
                        yVar7 = this.bYz.bPu;
                        yVar7.YU().iX(str);
                        yVar8 = this.bYz.bPu;
                        if (yVar8.YZ() != null) {
                            yVar9 = this.bYz.bPu;
                            if (yVar9.YZ().ZO() != null) {
                                yVar10 = this.bYz.bPu;
                                yVar10.YZ().ZO().notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
    }
}
