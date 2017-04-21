package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ p caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, int i) {
        super(i);
        this.caH = pVar;
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
            yVar = this.caH.bQu;
            if (yVar != null) {
                yVar2 = this.caH.bQu;
                if (yVar2.ZU() != null) {
                    yVar3 = this.caH.bQu;
                    if (yVar3.ZU().adz() != null) {
                        String str = (String) customResponsedMessage.getData();
                        yVar4 = this.caH.bQu;
                        this.caH.f(str, yVar4.ZU().adz().aKx().getBannerListData().getAllAdvertList());
                        p pVar = this.caH;
                        yVar5 = this.caH.bQu;
                        pVar.g(str, yVar5.aab().getListView().getData());
                        p pVar2 = this.caH;
                        yVar6 = this.caH.bQu;
                        pVar2.g(str, yVar6.ZX().adH().getDataList());
                        yVar7 = this.caH.bQu;
                        yVar7.ZU().iQ(str);
                        yVar8 = this.caH.bQu;
                        if (yVar8.aab() != null) {
                            yVar9 = this.caH.bQu;
                            if (yVar9.aab().abf() != null) {
                                yVar10 = this.caH.bQu;
                                yVar10.aab().abf().notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
    }
}
