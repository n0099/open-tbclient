package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ q cmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, int i) {
        super(i);
        this.cmZ = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        ab abVar8;
        ab abVar9;
        ab abVar10;
        if (customResponsedMessage != null) {
            abVar = this.cmZ.cdt;
            if (abVar != null) {
                abVar2 = this.cmZ.cdt;
                if (abVar2.adP() != null) {
                    abVar3 = this.cmZ.cdt;
                    if (abVar3.adP().agC() != null) {
                        String str = (String) customResponsedMessage.getData();
                        abVar4 = this.cmZ.cdt;
                        this.cmZ.f(str, abVar4.adP().agC().aMt().getBannerListData().getAllAdvertList());
                        q qVar = this.cmZ;
                        abVar5 = this.cmZ.cdt;
                        qVar.g(str, abVar5.adU().getListView().getData());
                        q qVar2 = this.cmZ;
                        abVar6 = this.cmZ.cdt;
                        qVar2.g(str, abVar6.adQ().agH().getDataList());
                        abVar7 = this.cmZ.cdt;
                        abVar7.adP().kc(str);
                        abVar8 = this.cmZ.cdt;
                        if (abVar8.adU() != null) {
                            abVar9 = this.cmZ.cdt;
                            if (abVar9.adU().aeI() != null) {
                                abVar10 = this.cmZ.cdt;
                                abVar10.adU().aeI().notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
    }
}
