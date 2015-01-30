package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.aDW = frsActivity;
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
            str = this.aDW.mPageType;
            if (str != null) {
                bpVar = this.aDW.aCY;
                if (bpVar != null) {
                    eVar = this.aDW.aDi;
                    if (eVar != null) {
                        eVar2 = this.aDW.aDi;
                        if (eVar2.aeN() != null) {
                            if (booleanValue) {
                                str6 = this.aDW.mPageType;
                                if (str6.equals("normal_page")) {
                                    bpVar7 = this.aDW.aCY;
                                    eVar6 = this.aDW.aDi;
                                    ForumData aeN = eVar6.aeN();
                                    eVar7 = this.aDW.aDi;
                                    bpVar7.b(1, aeN, eVar7, false);
                                } else {
                                    str7 = this.aDW.mPageType;
                                    if (str7.equals("frs_page")) {
                                        bpVar5 = this.aDW.aCY;
                                        eVar4 = this.aDW.aDi;
                                        ForumData aeN2 = eVar4.aeN();
                                        eVar5 = this.aDW.aDi;
                                        bpVar5.a(1, aeN2, eVar5, false);
                                    }
                                }
                                bpVar6 = this.aDW.aCY;
                                bpVar6.bU(true);
                                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                                str8 = this.aDW.aCQ;
                                m255getInst.addLikeForum(str8);
                                return;
                            }
                            com.baidu.tieba.tbadkCore.d aeH = com.baidu.tieba.tbadkCore.d.aeH();
                            str2 = this.aDW.aCQ;
                            aeH.B(str2, false);
                            eVar3 = this.aDW.aDi;
                            eVar3.aeN().setLike(0);
                            str3 = this.aDW.mPageType;
                            if (str3.equals("normal_page")) {
                                bpVar4 = this.aDW.aCY;
                                bpVar4.eX(0);
                            } else {
                                str4 = this.aDW.mPageType;
                                if (str4.equals("frs_page")) {
                                    bpVar2 = this.aDW.aCY;
                                    bpVar2.eY(0);
                                }
                            }
                            bpVar3 = this.aDW.aCY;
                            bpVar3.bU(false);
                            TbadkCoreApplication m255getInst2 = TbadkCoreApplication.m255getInst();
                            str5 = this.aDW.aCQ;
                            m255getInst2.delLikeForum(str5);
                        }
                    }
                }
            }
        }
    }
}
