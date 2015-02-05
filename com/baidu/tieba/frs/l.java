package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.aDT = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        bp bpVar;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        String str2;
        com.baidu.tieba.tbadkCore.e eVar3;
        String str3;
        String str4;
        bp bpVar2;
        bp bpVar3;
        String str5;
        bp bpVar4;
        String str6;
        String str7;
        bp bpVar5;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        bp bpVar6;
        String str8;
        bp bpVar7;
        com.baidu.tieba.tbadkCore.e eVar6;
        com.baidu.tieba.tbadkCore.e eVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            str = this.aDT.mPageType;
            if (str != null) {
                bpVar = this.aDT.aCV;
                if (bpVar != null) {
                    eVar = this.aDT.aDf;
                    if (eVar != null) {
                        eVar2 = this.aDT.aDf;
                        if (eVar2.aeI() != null) {
                            if (booleanValue) {
                                str6 = this.aDT.mPageType;
                                if (str6.equals("normal_page")) {
                                    bpVar7 = this.aDT.aCV;
                                    eVar6 = this.aDT.aDf;
                                    ForumData aeI = eVar6.aeI();
                                    eVar7 = this.aDT.aDf;
                                    bpVar7.b(1, aeI, eVar7, false);
                                } else {
                                    str7 = this.aDT.mPageType;
                                    if (str7.equals("frs_page")) {
                                        bpVar5 = this.aDT.aCV;
                                        eVar4 = this.aDT.aDf;
                                        ForumData aeI2 = eVar4.aeI();
                                        eVar5 = this.aDT.aDf;
                                        bpVar5.a(1, aeI2, eVar5, false);
                                    }
                                }
                                bpVar6 = this.aDT.aCV;
                                bpVar6.bU(true);
                                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                                str8 = this.aDT.aCN;
                                m255getInst.addLikeForum(str8);
                                return;
                            }
                            com.baidu.tieba.tbadkCore.d aeC = com.baidu.tieba.tbadkCore.d.aeC();
                            str2 = this.aDT.aCN;
                            aeC.B(str2, false);
                            eVar3 = this.aDT.aDf;
                            eVar3.aeI().setLike(0);
                            str3 = this.aDT.mPageType;
                            if (str3.equals("normal_page")) {
                                bpVar4 = this.aDT.aCV;
                                bpVar4.eX(0);
                            } else {
                                str4 = this.aDT.mPageType;
                                if (str4.equals("frs_page")) {
                                    bpVar2 = this.aDT.aCV;
                                    bpVar2.eY(0);
                                }
                            }
                            bpVar3 = this.aDT.aCV;
                            bpVar3.bU(false);
                            TbadkCoreApplication m255getInst2 = TbadkCoreApplication.m255getInst();
                            str5 = this.aDT.aCN;
                            m255getInst2.delLikeForum(str5);
                        }
                    }
                }
            }
        }
    }
}
