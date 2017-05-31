package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ p ceL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, int i) {
        super(i);
        this.ceL = pVar;
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
            yVar = this.ceL.bVk;
            if (yVar != null) {
                yVar2 = this.ceL.bVk;
                if (yVar2.ZY() != null) {
                    yVar3 = this.ceL.bVk;
                    if (yVar3.ZY().acK() != null) {
                        String str = (String) customResponsedMessage.getData();
                        yVar4 = this.ceL.bVk;
                        this.ceL.f(str, yVar4.ZY().acK().aIz().getBannerListData().getAllAdvertList());
                        p pVar = this.ceL;
                        yVar5 = this.ceL.bVk;
                        pVar.g(str, yVar5.aad().getListView().getData());
                        p pVar2 = this.ceL;
                        yVar6 = this.ceL.bVk;
                        pVar2.g(str, yVar6.ZZ().acP().getDataList());
                        yVar7 = this.ceL.bVk;
                        yVar7.ZY().jf(str);
                        yVar8 = this.ceL.bVk;
                        if (yVar8.aad() != null) {
                            yVar9 = this.ceL.bVk;
                            if (yVar9.aad().aaR() != null) {
                                yVar10 = this.ceL.bVk;
                                yVar10.aad().aaR().notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
    }
}
